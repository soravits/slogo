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
 * Created by Soravit on 10/31/2016.
 */
public class AskWith extends ControlCommand {

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
