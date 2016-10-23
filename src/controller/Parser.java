package controller;

import controller.CommandParser;
import controller.ParamParser;
import model.Model;
import model.commands.Constant;
import model.commands.variables.Variable;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * The purpose of this class is to take the string from the controller and
 * create an expression tree to be sent to the interpreter.
 *
 * @author Soravit
 */
public class Parser {

	public static final String RESOURCE_PACKAGE = "resources/languages";
	public static final String PARAMS = "Params";
	public static final String SYNTAX = "Syntax";
	public static final String LIST_START = "ListStart";
	public static final String LIST_END = "ListEnd";
	public static final String CONTROL_STRUCTURES = "Control";
	public static final String DEFAULT_LANGUAGE = "English";
	public static final String VARIABLE = "Variable";
	public static final String CONSTANT = "Constant";

	private String language = DEFAULT_LANGUAGE;
	private CommandParser commandParser;
	private ParamParser paramParser;
	private CommandParser syntaxParser;
	private ArrayList<String> controlStructures;
	private Model model;

	public Parser(Model model){
		this.model = model;
		commandParser = new CommandParser();
		paramParser = new ParamParser();
		syntaxParser = new CommandParser();
		commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
		paramParser.addMappings(RESOURCE_PACKAGE + File.separator + PARAMS);
		syntaxParser.addPatterns(RESOURCE_PACKAGE + File.separator + SYNTAX);
		controlStructures = getControlStructures(RESOURCE_PACKAGE + File.separator + CONTROL_STRUCTURES);
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public void parseString(String s) throws Exception{
		ArrayList<String> tokens = new ArrayList<String>();
		Scanner inputScanner = new Scanner(s);
		while(inputScanner.hasNextLine()){
			String line = inputScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			if(line.charAt(0) == '#'){
				continue;
			}else{
				while(lineScanner.hasNext()){
					tokens.add(lineScanner.next());
				}
			}
			lineScanner.close();
		}
		inputScanner.close();
		ArrayList<Node> trees = formExpressionTrees(tokens);
		for(Node n:trees){
			printTree(n);
			executeTree(n);
		}
	}

	public double executeTree(Node root) throws Exception{
		String value = root.getValue();
		if(controlStructures.contains(value)) {
			Class<?> command = Class.forName("model.commands.turtle" + value);
			Constructor<?> constructor = command.getDeclaredConstructor();
			constructor.newInstance(command, this, model);
			Method execute = command.getMethod("execute");
			return (double) execute.invoke(this);
		}else if(syntaxParser.getSymbol(value).equals(VARIABLE)){
			Variable var = new Variable(value.substring(1), model);
			return var.execute();
		}else if(syntaxParser.getSymbol(value).equals(CONSTANT)){
			Constant constant = new Constant(Double.parseDouble(value), model);
			return constant.execute();
		}
		else{
			double[] doubles = new double[root.getChildren().size()];
			for (int i = 0; i < root.getChildren().size(); i++) {
				Node currNode = root.getChildren().get(i);
				doubles[i] = executeTree(currNode);
			}
			Class<?>[] classes = new Class[root.getChildren().size()+1];
			for (int i = 0; i < root.getChildren().size(); i++) {
				classes[i] = double.class;
			}
			classes[root.getChildren().size()] = Model.class;
			Class<?> command = Class.forName("model.commands.turtle." + value);
			Constructor<?> constructor = command.getDeclaredConstructor(classes);
			Object t = constructor.newInstance(doubles[0], model);
			Method execute = command.getMethod("execute");
			return (double) execute.invoke(t);
		}
	}

	public void printTree(Node root){
		System.out.print("Node: " + root.getValue() + " Children: ");
		for(int i = 0; i<root.getChildren().size(); i++){
			System.out.print(root.getChildren().get(i).getValue() + " ");
		}
		if(root.getChildren().size() == 0){
			System.out.print("None");
		}
		System.out.println();
		for(int i = 0; i<root.getChildren().size(); i++){
			printTree(root.getChildren().get(i));
		}
	}

	private ArrayList<Node> formExpressionTrees(ArrayList<String> predicates){
		ArrayList<Node> trees = new ArrayList<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		for(int i = 0; i < predicates.size(); i++){
			Node node = new Node(predicates.get(i));
			queue.add(node);
		}
		while(!queue.isEmpty()){
			trees.add(visitNode(queue, queue.poll()));
		}
		return trees;
	}

	private Node visitNode(Queue<Node> queue, Node root){
		String predicate = root.getValue();
		String commandName = commandParser.getSymbol(predicate);
		if(commandName.equals(CommandParser.ERROR)){
			return root;
		}else if(commandName.equals(LIST_START)){
			Node node = new Node(CONTROL_STRUCTURES);
			Queue<Node> tempQueue = new LinkedList<Node>();
			while(!commandParser.getSymbol(queue.peek().getValue()).equals(LIST_END)){
				tempQueue.add(queue.poll());
			}
			queue.poll();
			while(!tempQueue.isEmpty()){
			node.addChild(visitNode(tempQueue, tempQueue.poll()));
			}
			return node;
		}else{
			int numParams = paramParser.getNumParams(commandName);
			for(int i = 0; i < numParams; i++){
				Node child = visitNode(queue, queue.poll());
				root.addChild(child);
			}
			root.setValue(commandName);
		}
		return root;
	}

	private ArrayList<String> getControlStructures(String syntax) {
		ArrayList<String> controlStructures = new ArrayList<String>();
		ResourceBundle resources = ResourceBundle.getBundle(syntax);
		Enumeration<String> iter = resources.getKeys();
		while (iter.hasMoreElements()) {
			controlStructures.add(iter.nextElement());
		}
		return controlStructures;
	}
}