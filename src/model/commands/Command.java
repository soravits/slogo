package model.commands;

import model.Model;

public abstract class Command implements CommandInterface{
    
    Model slogoModel;
        
    public Command(Model model){
        slogoModel = model;
    }
    
    public abstract double execute();
    
}
