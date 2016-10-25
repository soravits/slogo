package controller;

import model.Model;
import view.data.DataIn;

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

    private Model model;
    private Parser parser;
    private DataIn view;

    public Controller(DataIn view){
        this.view = view;
        model = new Model();
        parser = new Parser(model);
    }

    public void updateModel(Model model){
        this.model = model;
    }

    /**
     * This class takes the different data objects/variables packaged into the data object, modifies the controller.Parser and
     * Interpreter as necessary, and sends the data to the controller.Parser.
     * @param input The command inputted by the user
     * @throws Exception 
     */
    public void processCommand(String input) throws Exception{
    	model.clearConsoleReturn();
    	model.addCommand(input);
        parser.parseString(input);
        updateView();
    }

    private void updateView(){
        view.updateViewModel(model);
    }
    
    public void setLanguage(String language){
    	parser.setLanguage(language);
    }
    
    public void reset(){
    	model.clear();
    	view.updateViewModel(model);
    }

}