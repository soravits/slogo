package model;

import java.util.ArrayList;
import java.util.Collection;

public class CommandHistory {
    
    private Collection<String> commandHistory;
    
    public CommandHistory(){
        commandHistory = new ArrayList<String>();
    }
    
    public void addCommand(String command){
        commandHistory.add(command);
    }
    
    public void clearHistory(String command){
        commandHistory.clear();
    }
    
    public Collection<String> getCommandHistory(){
        return commandHistory;
    } 
    

}
