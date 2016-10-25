package controller;

import controller.CommandParser;
import controller.ParamParser;
import model.Model;
import model.commands.Constant;
import model.commands.Variable;

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
	public static final String LIST_START = "[";
	public static final String LIST_END = "]";
	public static final String CONTROL_STRUCTURES = "Control";
	public static final String DEFAULT_LANGUAGE = "English";
	public static final String COMMAND = "Command";
	public static final String VARIABLE = "Variable";
	public static final String CONSTANT = "Constant";
	public static final String COMMAND_PACKAGE = "model.commands.";

	private String language = DEFAULT_LANGUAGE;
	private CommandParser commandParser;
	private ParamParser paramParser;
	private CommandParser syntaxParser;
	private ArrayList<String> controlStructures;
	private Model model;
	private CommandController commandController;
	private Map<String, Node> userInstructions;

	public Parser(Model model){
		this.model = model;
		commandParser = new CommandParser();
		paramParser = new ParamParser();
		syntaxParser = new CommandParser();
		commandController = new CommandController();
		userInstructions = new HashMap<String, Node>();
		commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
		paramParser.addMappings(RESOURCE_PACKAGE + File.separator + PARAMS);
		syntaxParser.addPatterns(RESOURCE_PACKAGE + File.separator + SYNTAX);
		controlStructures = getControlStructures(RESOURCE_PACKAGE + File.separator + CONTROL_STRUCTURES);
	}

	public void setLanguage(String language){
		this.language = language;
		commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
	}

	public void parseString(String s) throws Exception{
		s = s.toLowerCase();
		ArrayList<String> tokens = new ArrayList<String>();
		Scanner inputScanner = new Scanner(s);
		while(inputScanner.hasNextLine()){
			String line = inputScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			if(!line.isEmpty() && line.charAt(0) == '#'){
				continue;
			}
			else{
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
			System.out.println();
		}
	}

	public double executeTree(Node root) throws Exception{
		String value = root.getValue();
		if(controlStructures.contains(value)) {
			Class<?> command = Class.forName("model.commands." + value);
			Constructor<?> constructor = command.getDeclaredConstructor(Node.class, Parser.class, Model.class);
			Object t = constructor.newInstance(root, this, model);
			commandController.setCommand(t);
			double x = commandController.execute();
			model.updateConsoleReturn(x);
			return x;
		}
		else if(syntaxParser.getSymbol(value).equals(VARIABLE)){
			Variable var = new Variable(value.substring(1), model);
			return var.execute();
		}
		else if(syntaxParser.getSymbol(value).equals(CONSTANT)){
			double[] constantDouble = {Double.parseDouble(value)};
			Constant constant = new Constant(constantDouble, model);
			return constant.execute();
		}
		else if(userInstructions.containsKey(value)){
			return runInstruction(root);
		}else{
			double[] doubles = new double[root.getChildren().size()];
			for (int i = 0; i < root.getChildren().size(); i++) {
				Node currNode = root.getChildren().get(i);
				doubles[i] = executeTree(currNode);
			}
			Class<?> command = Class.forName(COMMAND_PACKAGE + value);
			Constructor<?> constructor = command.getDeclaredConstructor(double[].class, Model.class);
			Object t = constructor.newInstance(doubles, model);
			commandController.setCommand(t);
			double x = commandController.execute();
			model.updateConsoleReturn(x);
			return x;
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

	private ArrayList<Node> formExpressionTrees(ArrayList<String> predicates) throws Exception{
		ArrayList<Node> trees = new ArrayList<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		for(int i = 0; i < predicates.size(); i++){
			Node node = new Node(predicates.get(i));
			queue.add(node);
		}
		while(!queue.isEmpty()){
			Node tree = queue.poll();
			trees.add(visitNode(queue, tree));
			executeTree(tree);
		}
		return trees;
	}

	private Node visitNode(Queue<Node> queue, Node root){
		String predicate = root.getValue();
		String commandName = commandParser.getSymbol(predicate);
		if(predicate.equals(LIST_START)){
			double openBracketCount = 1;
			double closedBracketCount = 0;
			Node node = new Node(CONTROL_STRUCTURES);
			Queue<Node> tempQueue = new LinkedList<Node>();
			while(!queue.peek().getValue().equals(LIST_END) || openBracketCount != closedBracketCount+1){
				Node nextNode = queue.poll();
				if(nextNode.getValue().equals(LIST_START)){
					openBracketCount++;
				}else if(nextNode.getValue().equals(LIST_END)){
					closedBracketCount++;
				}
				tempQueue.add(nextNode);
			}
			queue.poll();
			while(!tempQueue.isEmpty()){
				node.addChild(visitNode(tempQueue, tempQueue.poll()));
			}
			return node;
		}else if(userInstructions.containsKey(predicate)){
			int numParams = userInstructions.get(predicate).getChildren().get(1).getChildren().size();
			for(int i = 0; i < numParams; i++){
				Node child = visitNode(queue, queue.poll());
				root.addChild(child);
			}
		}else if(commandName.equals(CommandParser.ERROR)){
			return root;
		} else{
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

	public void addInstruction(String commandName, Node root){
		userInstructions.put(commandName, root);
	}

	public boolean isValidCommandName(String s){
		return syntaxParser.getSymbol(s).equals(COMMAND);
	}
	
	private double runInstruction(Node n) throws Exception{
		Node instruction = userInstructions.get(n.getValue());
		Node params = instruction.getChildren().get(1);
		double ret = 0;
		if(n.getChildren().size() == params.getChildren().size()){
			for(int i = 0; i < n.getChildren().size(); i++){
				String variableName = params.getChildren().get(i).getValue().substring(1);
				double value = executeTree(n.getChildren().get(i));
				System.out.println(variableName);
				model.getWorkspace().addVariable(variableName, value);
			}
			Node commandRoot = instruction.getChildren().get(2);
			for(int i = 0; i < commandRoot.getChildren().size(); i++){
				ret = executeTree(commandRoot.getChildren().get(i));
			}
		}else{
			throw new NullPointerException();
		}
		return ret;
	}
}