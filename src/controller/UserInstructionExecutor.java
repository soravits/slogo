package controller;

import error.InvalidCommandException;
import model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Soravit on 10/29/2016.
 */
public class UserInstructionExecutor extends Executor{
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
            e.printStackTrace();
            throw new InvalidCommandException(root.getValue());
        }
    }
}
