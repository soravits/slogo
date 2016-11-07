package controller;

import error.InvalidCommandException;
import error.InvalidParametersException;
import error.InvalidSyntaxException;
import model.Model;

import java.io.*;
import java.util.*;

/**
 * The class is responsible for parsing user input from the front-end, creating expression trees of commands, and
 * executing the commands by instantiating classes in the back-end.
 * @author Soravit Sophastienphong
 */
public class Interpreter {

    public static final String RESOURCE_PACKAGE = "resources/languages";
    public static final String PARAMS = "Params";
    public static final String SYNTAX = "Syntax";
    public static final String GROUP_START = "(";
    public static final String GROUP_END = ")";
    public static final String LIST_START = "[";
    public static final String LIST_END = "]";
    public static final String DEFAULT_LANGUAGE = "English";
    public static final String CONTROL_STRUCTURES = "Control";
    public static final String TURTLE_COMMANDS = "TurtleCommands";
    public static final String DISPLAY_COMMANDS = "Display";

    public static final char HASH = '#';

    private String language = DEFAULT_LANGUAGE;
    private CommandParser commandParser;
    private ParamParser paramParser;
    private CommandParser syntaxParser;
    private Model model;
    private CommandController commandController;
    private CommandManager commandManager;

    /**
     * @param model A reference to the view's version of the model.
     */
    public Interpreter(Model model){
        this.model = model;
        commandParser = new CommandParser();
        paramParser = new ParamParser();
        syntaxParser = new CommandParser();
        commandController = new CommandController();
        commandManager = new CommandManager(syntaxParser, commandController, model);
        commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
        paramParser.addMappings(RESOURCE_PACKAGE + File.separator + PARAMS);
        syntaxParser.addPatterns(RESOURCE_PACKAGE + File.separator + SYNTAX);
    }

    /**
     * Sets the language used to interpret commands.
     * @param language The name of the language.
     */
    public void setLanguage(String language){
        this.language = language;
        commandParser.addPatterns(RESOURCE_PACKAGE + File.separator + language);
    }

    /**
     * @param s The string of command(s)
     * @throws InvalidSyntaxException If the syntax of a command is incorrect.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     * @throws InvalidParametersException If there is an error with passing invalid parameters to a command.
     */
    public void parseString(String s) throws InvalidSyntaxException, InvalidCommandException, InvalidParametersException {
        s = s.toLowerCase();
        List<String> tokens = new ArrayList<String>();
        Scanner inputScanner = new Scanner(s);
        while(inputScanner.hasNextLine()){
            String line = inputScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            if(!line.isEmpty() && line.charAt(0) == HASH){
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
        List<Node> trees = interpretString(tokens);
    }

    /**
     * @param s The string to be validated.
     * @return True if the string could be a command based on its syntax.
     */
    public boolean isValidCommandName(String s){
        return syntaxParser.getSymbol(s).equals(CommandManager.COMMAND);
    }

    /**
     * Reads a file and converts its contents to a string.
     * @param fileName The name of the file.
     * @return A string containing the contents of the file.
     * @throws IOException If there is an error with reading the file.
     */
    public String readFileToString(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while ((line = bufferedReader.readLine()) != null)
        {
            sb.append(line + System.lineSeparator());
        }

        // close the BufferedReader when we're done
        bufferedReader.close();
        return sb.toString();
    }

    private void printTree(Node root){
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

    private List<Node> interpretString(List<String> predicates) throws InvalidCommandException, InvalidSyntaxException, InvalidParametersException {
        List<Node> trees = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        for(int i = 0; i < predicates.size(); i++){
            Node node = new Node(predicates.get(i));
            queue.add(node);
        }
        while(!queue.isEmpty()){
            Node tree = queue.poll();
            trees.add(visitNode(queue, tree));
            //printTree(tree);
            commandManager.executeTree(tree);
        }
        return trees;
    }

    private Node interpretBracketCommands(Queue<Node> queue) throws InvalidSyntaxException, InvalidParametersException {
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
    }

    private Node interpretGroupCommand(Queue<Node> queue) throws InvalidSyntaxException, InvalidParametersException {
        double openBracketCount = 1;
        double closedBracketCount = 0;
        Node node = new Node(CONTROL_STRUCTURES);
        Queue<Node> tempQueue = new LinkedList<Node>();
        while(!queue.peek().getValue().equals(GROUP_END) || openBracketCount != closedBracketCount+1){
            Node nextNode = queue.poll();
            if(nextNode.getValue().equals(GROUP_START)){
                openBracketCount++;
            }else if(nextNode.getValue().equals(GROUP_END)){
                closedBracketCount++;
            }
            tempQueue.add(nextNode);
        }
        queue.poll();
        while(!tempQueue.isEmpty()){
            node.addChild(visitNode(tempQueue, tempQueue.poll()));
        }
        return node;
    }

    private Node visitNode(Queue<Node> queue, Node root) throws InvalidSyntaxException, InvalidParametersException {
        String value = root.getValue();
        if(syntaxParser.getSymbol(value).equals(CommandParser.ERROR)){
            throw new InvalidSyntaxException(value);
        }
        try {
            if (value.equals(LIST_START)) {
                return interpretBracketCommands(queue);
            }else if(value.equals(GROUP_START)){
                return interpretGroupCommand(queue);
            } else if (commandManager.existsUserInstruction(value)) {
                int numParams = commandManager.getUserInstructions().get(value).getChildren().get(1).getChildren().size();
                for (int i = 0; i < numParams; i++) {
                    Node child = visitNode(queue, queue.poll());
                    root.addChild(child);
                }
            } else if (commandParser.isValid(value)) {
                String commandName = commandParser.getSymbol(value);
                int numParams;
                if(queue.peek() != null && queue.peek().getValue().equals(GROUP_START)){
                    numParams = 1;
                }else{
                    numParams = paramParser.getNumParams(commandName);
                }
                for (int i = 0; i < numParams; i++) {
                    Node child = visitNode(queue, queue.poll());
                    root.addChild(child);
                }
                root.setValue(commandName);
            }
            return root;
        }catch(Exception e){
            e.printStackTrace();
            throw new InvalidParametersException(value);
        }
    }
}