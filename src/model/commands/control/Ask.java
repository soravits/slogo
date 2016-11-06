package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implements the Ask command that runs a set of commands on a specified list of turtles.
 * @author Soravit Sophastienphong and Brian Keohane
 */
public class Ask extends ControlCommand{

    /**
     * Executes the command represented by the expression tree rooted at this control structure command.
     * @param root The root of the tree.
     * @return The double returned by the command.
     * @throws Exception If any error occurs as a result of the execution of the command.
     */
    public Ask(Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        Node turtleRoot = getRoot().getChildren().get(0);
        Node commandRoot = getRoot().getChildren().get(1);
        double ret = 0;
        getModel().addNestedAsk();
        for(int i = 0 ; i < turtleRoot.getChildren().size(); i++){
            getModel().addTurtle(Double.parseDouble(turtleRoot.getChildren().get(i).getValue()));
        }
        for(int j = 0 ; j < commandRoot.getChildren().size(); j++) {
            ret = executeTree(commandRoot.getChildren().get(j));
        }
        getModel().subtractNestedAsk();
        return ret;
    }
}
