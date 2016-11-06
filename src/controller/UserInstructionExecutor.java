package controller;

import error.InvalidCommandException;
import model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for executing instructions defined previously defined by the user.
 * @author Soravit Sophastienphong
 */
public class UserInstructionExecutor extends Executor{

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        try {
            Map<String, Double> variables = new HashMap<String, Double>();
            Node instruction = commandManager.getUserInstructions().get(root.getValue());
            Node params = instruction.getChildren().get(1);
            double ret = 0;
            for (int i = 0; i < root.getChildren().size(); i++) {
                String variableName = params.getChildren().get(i).getValue();
                if(model.getWorkspace().variableExists(variableName)){
                    variables.put(variableName, model.getWorkspace().getVariableValue(variableName));
                }else{
                    variables.put(variableName, null);
                }
                double value = commandManager.executeTree(root.getChildren().get(i));
                model.getWorkspace().addVariable(variableName, value);
            }
            Node commandRoot = instruction.getChildren().get(2);
            for (int i = 0; i < commandRoot.getChildren().size(); i++) {
                ret = commandManager.executeTree(commandRoot.getChildren().get(i));
            }
            for(Map.Entry<String, Double> entry : variables.entrySet()){
                if(entry.getValue() == null){
                    model.getWorkspace().removeVariable(entry.getKey());
                }else{
                    model.getWorkspace().addVariable(entry.getKey(), entry.getValue());
                }
            }
            return ret;
        }catch(Exception e){
            throw new InvalidCommandException(root.getValue());
        }
    }
}
