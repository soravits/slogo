package controller;

import error.InvalidCommandException;
import model.Model;

/**
 * Created by Soravit on 10/29/2016.
 */
public interface Executor {

    public static final String COMMAND_PACKAGE = "model.commands.";
    public static final String CONTROL_COMMAND_PACKAGE = "model.controlcommands.";
    public static final String TURTLE_COMMAND_PACKAGE = "model.turtlecommands";
    
    public double execute(Node root, CommandManager executor, Model model) throws InvalidCommandException;
}
