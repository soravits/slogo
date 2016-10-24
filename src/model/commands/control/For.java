package model.commands.control;
import controller.Node;
import controller.Parser;
import model.Model;
import model.commands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class For extends ControlCommand{

	private String variable;
	private double start;
	private double end;
	private double increment;
	Parser parser;

	public For(Node root, Parser parser, Model model) throws Exception{
		super(root,model);
		this.parser = parser;
		variable = root.getChildren().get(0).getValue().substring(1);
		start = Double.parseDouble(root.getChildren().get(1).getValue());
		end = Double.parseDouble(root.getChildren().get(2).getValue());
		increment = Double.parseDouble(root.getChildren().get(3).getValue());
	}

	@Override
	public double execute() throws Exception {
		
	}
}
