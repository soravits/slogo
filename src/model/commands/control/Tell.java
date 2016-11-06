package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implement the Tell command that sets the turtles for which subsequent commands are run.
 * @author Soravit Sophastienphong and Brian Keohane
 */
public class Tell extends ControlCommand {

    /**
     * Executes the command represented by the expression tree rooted at this control structure command.
     * @param root The root of the tree.
     * @return The double returned by the command.
     * @throws Exception If any error occurs as a result of the execution of the command.
     */
    public Tell(Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        Node commandsRoot = getRoot().getChildren().get(0);
        double ID = 0;
        getModel().clearTellTurtles();
        for(int i = 0; i < commandsRoot.getChildren().size(); i++){
            ID = Double.parseDouble(commandsRoot.getChildren().get(i).getValue());
            getModel().addTurtle(ID);
        }
        return ID;
    }
}
