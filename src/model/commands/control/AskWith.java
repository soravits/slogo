package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.TurtlePair;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

import javax.sound.sampled.Control;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class implements the AskWith command that runs a set of commands on turtles meeting the specified condition.
 * @author Soravit Sophastienphong
 */
public class AskWith extends ControlCommand {

    /**
     * Executes the command represented by the expression tree rooted at this control structure command.
     * @param root The root of the tree.
     * @return The double returned by the command.
     * @throws Exception If any error occurs as a result of the execution of the command.
     */
    public AskWith(Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        Node conditionRoot = getRoot().getChildren().get(0);
        Node commandRoot = getRoot().getChildren().get(1);
        Collection<Double> trueTurtles = new ArrayList<>();
        for(double turtle : getModel().getIDs()){
                getModel().clearTellTurtles();
                getModel().addTurtle(turtle);
            double x = executeTree(conditionRoot.getChildren().get(0));
//            System.out.println("turtle ID = " + turtle);
//            System.out.println("x" + x);
            if(x != 0){
                    trueTurtles.add(turtle);
                }
         }
        getModel().clearTellTurtles();
        for(double turtle : trueTurtles){
            getModel().addTurtle(turtle);
        }
        double ret = 0;
        for(int j = 0; j < commandRoot.getChildren().size(); j++){
            ret = executeTree(commandRoot.getChildren().get(j));
        }
        getModel().clearTellTurtles();
        for(double turtle : trueTurtles){
            getModel().addTurtle(turtle);
        }
        return ret;
    }
}
