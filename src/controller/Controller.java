package controller;

import model.Model;
import model.State;
import view.DataIn;
import view.UI;

/**
 * The purpose of this class is to receive the data from the view and send it to the controller.Parser to be handled. It will
 * also take the tree that is returned by the parser and send it to the interpreter. Essentially, the controller.Controller
 * acts as a gateway to the back-end and facilitates the controller.Parser and Interpreter classes. Currently, it only
 * has an update function, but as the project progresses, it will likely assume more responsibility.
 *
 *
 * @author Soravit
 */
public class Controller {

    private State state;
    private Parser parser;
    private DataIn view;

    public Controller(DataIn view){
        this.view = view;
        state = new State();
        parser = new Parser(state);
    }

    public void updateState(State state){
        this.state = state;
    }

    public void updateView(Model model){
        view.updateModel(model);
    }

    /**
     * This class takes the different data objects/variables packaged into the data object, modifies the controller.Parser and
     * Interpreter as necessary, and sends the data to the controller.Parser.
     * @param input The command inputted by the user
     */
    public void processCommand(String input){
        parser.parseString(input);
    }

}
