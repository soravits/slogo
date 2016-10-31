package model.abstractcommands;

import error.InvalidCommandException;
import model.Model;

public abstract class Command implements CommandInterface{
    
    private Model slogoModel;
    
    public Command(Model model){
        slogoModel = model;
    }

    public abstract double execute() throws Exception;
    
    public Model getModel(){
        return slogoModel;
    } 
    
}
