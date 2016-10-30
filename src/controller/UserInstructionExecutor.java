package controller;

import model.Model;

/**
 * Created by Soravit on 10/29/2016.
 */
public class UserInstructionExecutor implements Executor{
    @Override
    public double execute(Node root, CommandManager executor, CommandController commandController, Model model) throws Exception {
        Node instruction = executor.getUserInstructions().get(root.getValue());
        Node params = instruction.getChildren().get(1);
        double ret = 0;
        if(root.getChildren().size() == params.getChildren().size()){
            for(int i = 0; i < root.getChildren().size(); i++){
                String variableName = params.getChildren().get(i).getValue();
                double value = executor.executeNode(root.getChildren().get(i));
                model.getWorkspace().addVariable(variableName, value);
            }
            Node commandRoot = instruction.getChildren().get(2);
            for(int i = 0; i < commandRoot.getChildren().size(); i++){
                ret = executor.executeNode(commandRoot.getChildren().get(i));
            }
        }else{
            throw new NullPointerException();
        }
        return ret;
    }
}
