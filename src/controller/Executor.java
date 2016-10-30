package controller;

import model.Model;

/**
 * Created by Soravit on 10/29/2016.
 */
public interface Executor {

    public double execute(Node root, CommandManager executor, CommandController commandController, Model model) throws Exception;
}
