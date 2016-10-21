package controller;

import controller.CommandParser;
import controller.ParamParser;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

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
    private String language = "English";
    private CommandParser commandParser;
    private CommandParser typeParser;
    private ParamParser paramParser;

    public Parser(){
        commandParser = new CommandParser();
        typeParser = new CommandParser();
        paramParser = new ParamParser();
        commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
        paramParser.addMappings(RESOURCE_PACKAGE + File.separator + PARAMS);
        typeParser.addPatterns(RESOURCE_PACKAGE + File.separator + SYNTAX);
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void parseString(String s){
        ArrayList<Node> trees = formExpressionTrees(s.split(" "));
    }

    public Node executeTree(Node root){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node currNode = root.getChildren().get(i);
        }
        try {
            Class<?> command = Class.forName(root.getValue());
            Constructor<?> constructor = command.getDeclaredConstructor();
            Object commandClass = constructor.newInstance();
        }catch(Exception e){

        }
        return root;
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

    private ArrayList<Node> formExpressionTrees(String[] predicates){
        ArrayList<Node> trees = new ArrayList<Node>();
        Node root = new Node(predicates[0]);
        Queue<Node> queue = new LinkedList<Node>();
        for(int i = 0; i < predicates.length; i++){
            Node node = new Node(predicates[i]);
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
        }else{
            int numParams = paramParser.getNumParams(commandName);
            for(int i = 0; i < numParams; i++){
                Node child = visitNode(queue, queue.poll());
                root.addChild(child);
            }
        }
        return root;
    }
}