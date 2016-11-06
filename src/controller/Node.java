package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a node that makes up the expression trees created by the Interpreters. Each node has a value,
 * a list of children, and a boolean specifying whether a turtle command exists higher up in the tree.
 * @author Soravit Sophastienphong
 */
public class Node {
    private String value;
    private ArrayList<Node> children = new ArrayList<Node>();
    private boolean foundTurtleCommand;

    /**
     * @param value The value of the node to be instantiated.
     */
    public Node(String value){
        this.value = value;
    }

    /**
     * Adds the specified node as a child of this node.
     * @param child The node to be added.
     */
    public void addChild(Node child){
        children.add(child);
    }

    /**
     * @return The value of the node.
     */
    public String getValue(){
        return value;
    }

    /**
     * Sets the value of the node.
     * @param value The value to be set.
     */
    public void setValue(String value){
        this.value = value;
    }

    /**
     * @return A list containing the children of this node.
     */
    public List<Node> getChildren(){
        return children;
    }

    /**
     * Sets foundTurtleCommand to true or false.
     * @param foundTurtleCommand The value to be set.
     */
    public void setFoundTurtleCommand(boolean foundTurtleCommand){
        this.foundTurtleCommand = foundTurtleCommand;
    }

    /**
     * @return True if a turtle command exists higher up in the tree and false otherwise.
     */
    public boolean getIsFoundTurtleCommand(){
        return foundTurtleCommand;
    }
}
