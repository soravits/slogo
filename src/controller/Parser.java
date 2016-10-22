package controller;

import controller.CommandParser;
import controller.ParamParser;
import model.State;

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

    private String language = "English";
    private CommandParser commandParser;
    //private CommandParser typeParser;
    private ParamParser paramParser;
    private ArrayList controlStructures;
    private State state;

    public Parser(State state){
        this.state = state;
        commandParser = new CommandParser();
        //typeParser = new CommandParser();
        paramParser = new ParamParser();
        commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
        paramParser.addMappings(RESOURCE_PACKAGE + File.separator + PARAMS);
        commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + SYNTAX);
        controlStructures = getControlStructures(RESOURCE_PACKAGE + File.separator + CONTROL_STRUCTURES);
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void parseString(String s){
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
        }
        ArrayList<Node> trees = formExpressionTrees(tokens);
    }

    public double executeTree(Node root) throws Exception{
            double[] params = new double[root.getChildren().size()];
            for (int i = 0; i < root.getChildren().size(); i++) {
                Node currNode = root.getChildren().get(i);
                params[i] = executeTree(currNode);
            }
            Class command = Class.forName(root.getValue());
            Constructor<?> constructor = command.getDeclaredConstructor();
            if(controlStructures.contains(root.getValue())){
                constructor.newInstance(root, state);
            }
            else {
                constructor.newInstance(params, state);
            }
            Method execute = command.getMethod("execute");
            return (double) execute.invoke(this);
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
        Node root = new Node(predicates.get(0));
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
            Queue<Node> tempQueue = new LinkedList<Node>();
            while(!commandParser.getSymbol(queue.peek().getValue()).equals(LIST_END)){
                tempQueue.add(queue.poll());
            }
            Node command = visitNode(tempQueue, tempQueue.poll());
            return command;
        }else{
            int numParams = paramParser.getNumParams(commandName);
            for(int i = 0; i < numParams; i++){
                Node child = visitNode(queue, queue.poll());
                root.addChild(child);
            }
        }
        root.setValue(commandName);
        return root;
    }

    public ArrayList<String> getControlStructures(String syntax) {
        ArrayList<String> controlStructures = new ArrayList<String>();
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            controlStructures.add(iter.nextElement());
        }
        return controlStructures;
    }
}