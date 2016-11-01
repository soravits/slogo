package controller;

import java.util.ArrayList;

/**
 * Created by Soravit on 10/20/2016.
 */
public class Node {
    private String value;
    private ArrayList<Node> children = new ArrayList<Node>();
    private boolean foundTurtleCommand;

    public Node(String value){
        this.value = value;
    }

    public void addChild(Node child){
        children.add(child);
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public ArrayList<Node> getChildren(){
        return children;
    }

    public void setFoundTurtleCommand(boolean foundTurtleCommand){
        this.foundTurtleCommand = foundTurtleCommand;
    }

    public boolean getIsFoundTurtleCommand(){
        return foundTurtleCommand;
    }
}
