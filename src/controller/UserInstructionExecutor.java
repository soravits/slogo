package controller;

import error.InvalidCommandException;
import model.Model;

/**
 * Created by Soravit on 10/29/2016.
 */
public class UserInstructionExecutor implements Executor{
    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        try {
            Node instruction = commandManager.getUserInstructions().get(root.getValue());
            Node params = instruction.getChildren().get(1);
            double ret = 0;
            for (int i = 0; i < root.getChildren().size(); i++) {
                String variableName = params.getChildren().get(i).getValue();
                double value = commandManager.executeTree(root.getChildren().get(i));
                model.getWorkspace().addVariable(variableName, value);
            }
            Node commandRoot = instruction.getChildren().get(2);
            for (int i = 0; i < commandRoot.getChildren().size(); i++) {
                ret = commandManager.executeTree(commandRoot.getChildren().get(i));
            }
            return ret;
        }catch(Exception e){
            throw new InvalidCommandException(root.getValue());
        }
    }
}
