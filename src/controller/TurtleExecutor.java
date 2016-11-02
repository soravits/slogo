package controller;

import error.InvalidCommandException;
import model.Model;
import model.interfaces.TurtleCommandInterface;

/**
 * Created by Soravit on 10/31/2016.
 */

public class TurtleExecutor extends Executor{

    public static final String TURTLE_COMMAND_PACKAGE = "model.commands.turtle.";

    @Override
    public double execute(Node root, CommandManager executor, Model model) throws InvalidCommandException {
        setPackage(TURTLE_COMMAND_PACKAGE);
        setCommandInterface(TurtleCommandInterface.class);
        System.out.println("Command being run is: " + root.getValue());
        System.out.println("IsFoundTurtleCommand = " + root.getIsFoundTurtleCommand());
        double ret = 0;
        if(!root.getIsFoundTurtleCommand()) {
            setFoundTurtle(root);
            for(double d : model.getTurtlesToModify()){
                System.out.println("Current Model is : " + d);
                model.setTurtle(d);
                System.out.println(model.getID());
                ret = super.execute(root, executor, model);
                System.out.println(model.getID());
            }
        }else{
            ret = super.execute(root, executor, model);
        }
        return ret;
    }
    
    private void setFoundTurtle(Node root){
        if (root.getChildren() == null){
            return;
        }
        for (int i = 0; i < root.getChildren().size(); i++) {
            root.getChildren().get(i).setFoundTurtleCommand(true);
            setFoundTurtle(root.getChildren().get(i));
        }
    }
}
