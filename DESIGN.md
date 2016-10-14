Soravit Sophastienphong, Brian Keohane, Diane Hadley, Pim Chuaylua

# Slogo: Design Document

## Introduction

By writing this program, the team will allow any user the ability to write and run Logo code in an integrated development environment. One of the primary design goals of the project is to encapsulate data between the front end and the back end such that making changes to view will not heavily affect the functionality of the model and vice-versa. Additionally, we want our program to be robust and flexible such that we could add additional features without making major changes to the existing code. In the view, we have a JavaFX window with the command line through which the program receives user input. The view sends this input to the controller in the back-end, which parses the text, interprets the command, and updates the state of the model before sending the data back to the front-end to update the model graphically. When the back-end gets a command from the front-end, it checks whether the command is valid considering the available commands. If the command is invalid, then it sends the data back to the front-end to display an error message and move on to the next input. For the most part, the implementation details of each respective external and internal API will be hidden from others, but the data sent between the view and model will be the most open parts of the program’s design.

## Design Overview

Our program is divided up into four APIs: **View Internal**, **View External**, **Model Internal**, and **Model External**. 

*View Internal* - This API is responsible for the styling of the user interface and settings for changing anything related to how the program looks. This includes windows for the turtle, the command line, the console, and the workspace. The classes in the front end containing the internal API are Turtle, CommandLine, Console, Workspace, TurtleSettings, GeneralSettings, DisplayError, HelpWindow, and Data. Turtle, CommandLine, Console, and Workspace will all have public methods getRoot() that the UI will call and add to the current root in order to complete the visualization. CommandLine will also have a method getCommand() which will return a List and Data will call this method. TurtleSettings will contain public methods getBackgroundColor(), getPenColor(), getTurtleImage(), and getRoot() which the UI will call to implement those settings in the scene and insert the comboboxes for those settings. GeneralSettings will contain public method getLanguage() which Data will call and getRoot() which UI will call. DisplayError will contain public method displayErrorDialogBox, which the methods in TurtleSettings will call. HelpWindow will contain public method getRoot(). Data will pass information to the DataSorterr after a command is performed. It will contain the public method getResultsFromController(). DataSorter will then pass information to each corresponding part of the visualization. It will contain public methods getTurtleData(), getConsoleDate(), and getWorkspaceData(). 

*View External* - View External API is mainly responsible of sending data to the back end and receiving data from the backend. 

*Model Internal* - Internally, commands are dealt with via communication between the Controller and the Model. This utilizes the Command Design Pattern. Inside of the controller, the correct command will be constructed after parsing (a black box for now). There will be a command superclass (CommandController) with the interface method ‘execute(Command)’, so the Model (Interpreter?) class will call the CommandController.execute(Command) method. This execute function varies in implementation for each different command, but each command should be constructed by passing in the Model (to be updated) and all of the parameters specified in the expression tree. We still need to work out how to fit this design pattern into the overall architecture of the program. 
Each command class will update the model using public setters (Internal API). Additionally, this allows for easy updating of the command history (and the potential to undo commands, which may be useful as a possible extension). 

*Model External* - 
There are two ways in which the Model and View interact: through a controller (or adapter) and directly via a Model Manager class. This is still very much incomplete; we are trying to figure out a way to update the view using ChangeListeners (without needing gets and sets for information).
The ModelManager class has a number of getters and setters that pass information between itself, the View and the Controller. These include:
	getTurtleState();
	getVariables();
	getCommandHistory();
	getLineState();
And the corresponding setters for these are called in the command classes that extend the general CommandController class (specified above).
Part of this API essentially acts as the controller and is responsible for the interaction between the front-end and the back-end of the program. The controller creates an instance of a Parser that parses the string received from the view and creates an expression tree for each command. Each tree is sent to the Interpreter class, which stores it in a priority queue and interprets the commands to call methods from the internal model. The classes in this API include but are not limited to: Controller, Parser, and Interpreter. The data structures used are trees and queues. 

## User Interface

The link to our front end design can be found [here](https://gomockingbird.com/projects/lfxknge/0T48t0)

Various Parts of our GUI Include....

*Help* - opens a new window that contains a list of commands and what they do. 

*Language dropdown* - the user can choose the language from the list that he wants to use for the command line

*Turtle screen* - the results of the command line execution are displayed in this screen if the command controls the turtle. The screen will continue showing the turtle and its movements from more commands until the user clicks “Reset turtle”.

*Console* - the results from math operations and non-turtle operations (any operation that prints an answer) are displayed in this space

*Workspace* - the variables that the users work with are shown; they can also be changed when clicked. The Workspace will store all variables until the user clicks “Reset all.”

*Background color dropdown* - the users can choose the turtle background color from the list here. 

*Pen color* - the users can choose the pen color for the turtle from the list here

*Reset turtle* - clear the turtle screen, clear all the past command lines that have to do with the turtle

*Reset all* - clear turtle screen, console, workspace and history

*Get history* -  displays the history of the command lines the users have typed

*Command lines space* - The users type the command lines here; they can type more than one command lines

*Enter* - when pressing enter, all command lines are submitted to be executed once


## API Details

**View Internal**

Turtle.getRoot() allows UI to get the root created in Turtle, add the root to the scene root, and display the turtle. This design is flexible because any additions to the visualization of the turtle just have to be added to the root and the UI does not have to be involved. Console.getRoot() allows UI to get the root created in Console, add the root to the scene root, and display the console. This design is used for the same reason as the design in Turtle. CommandLine.getRoot() and Workspace.getRoot() have similar functions and justifications as Console.getRoot) and Turtle.getRoot(). CommandLine.getCommand() allows Data to get a list of the commands that the user typed. This design is flexible because any new command that needs to made for an additional requirement could be added to the list if used by user. It is also useful because it passes all the commands to Data in one Object. TurtleSettings and GeneralSettings have getRoot methods for the same reason as previous classes. TurtleSettings also has getBackgroundColor, getPenColor, and getTurtleImage, which allow the user to set a background color, set a pen color, and set an image to use for the turtle which are then displayed by the UI. GeneralSettings has getLanguage which allows Data to get the language the user has chosen. These class can be extended to include additional settings that a user can determine by creating a new public method to return that setting and adding the visuals for the user to decide the setting to the root. For these reasons, this API is flexible. DisplayError.displayErrorDialogBox() is called in TurtleSettings if a user chooses a setting that is invalid. An example is if they choose a file for image that is not a valid image file. This method will work for any front end error that could be caused by new extensions as well. HelpWindow.getRoot() will allow UI to display the button that a user can press to get to the HTML page. If the button functionality needs to change due to extensions, it will not affect the API. Data.getResultsFromController() will return all the data received from the back end as one Object (flexible if extensions increase the data possibilities). DataSorter calls Data to get the information from the back end and sorts the data so that Turtle can call getTurtleData, Console can call getConsoleData, and Workspace can call getWorkspaceData(). A new method would need to be added to return a new type of data. 


**View External**

View External API is mainly responsible of sending data to the back end and receiving data from the backend. The data that this API sends to the back end are as follows: language, a data structure containing command lines, changes being made to the variables in the workspace, a reset command called by users. The data to be received from the backend are as follows: result of command line execution with the destinations where they are going to be displayed (either console, workspace or turtle screen). Additionally, this API is able to observe if there’s an error (e.g. from invalid command line) in the backend and then send this to the Internal View API to display the error from the interface. 


**Model Internal**

Inside the model, communication occurs between the Interpreter class, the Command Class, and the Model Class. From the controller and using a Queue of actions (stored using an expression tree), the correct Command Class is instantiated, then passed to the Command Controller. This Command Controller calls the public method executeCommand(), and each command has the method execute() that is called and implements the correct implementation.
A variety of public methods that update, remove, and overwrite data in the different State Classes (TurtleState, LineState, etc.) are also part of this API. These methods are useful because they make it easy to add on extensions such as multiple turtles, different line-styles, etc. 
To check for errors, the method in Interpreter that gets all of the variables to pass to the Command will throw a NullVariableException if set of variables does not contain the specified variable input. Another error we will throw is an InvalidCommandError; this will be thrown when the string being parsed cannot be found in the resource file. We anticipate that additional errors will need to be thrown, but we have not figure them out yet. They should be able to be added easily enough.


**Model External**

In order for the back-end of our project to communicate with the front-end, we need to have a controller that can facilitate the exchange of data between the two. This is imperative to allowing our program to support the feature stated in the assignment specification of receiving, parsing, and executing a set of commands. This API will take advantage of powerful Java techniques including regular expressions and reflection to parse commands, interpret them, and apply them to our model. Moreover, since this API defines the way user input is parsed, then it can be extended to account for additional types of expressions and commands. With regard to the classes needed for this API, we will start with the Parser class. This class is important in allowing us to determine the validity of the received input and translate it to English. It is also responsible for creating the expression tree for each command. The Interpreter class then stores these expression trees in a queue to be translated into actual method calls. The Controller class is important because it instantiates instances of the Parser and Interpreter class and acts as a facilitator of the two.
The way that the front-end gets information from the back-end is via the gets in the Model class public API. 


## API Example Code

General Use Case: The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.

Data.addCommand(userCommandInput) (Data Class getting the command the users type in string on the UI)
String s=Data.getCommand(); (The backend gets the the string from Data Class (External View))

The following steps occur in the back-end model:
1. parser.parseInput(s) (Parser Class)<br />
2. parser.createCommandTree(s) (Parser Class)
3. Class<?> newClass = Class.forName(commandQueue.dequeue().getValue()); (Interpreter Class)
4. Constructor<?> constructor = newClass.getConstructor(Integer.class); (Interpreter Class)
5. Command CommandFD = new CommandFD(50, myModel);
6. CommandController.executeCommand(CommandFD);
7. CommandFD.execute();
8. Data.addResultsFromController() (Data class gets information from backend and stores in an object)
9. Object o = Data.getResultsFromController (In DataSorter. Gets information from Data and then sorts it)
10. Object o = DataSorter.getTurtleData (in Turtle. Private methods add to root)
11. Group turtleRoot = Turtle.getRoot() (UI displays turtle)


*Internal View Additional Use Case - The user sets the color of the turtle background*

Color backgroundColor = TurtleSettings.getBackgroundColor (in Turtle class. Color is added to turtle root)
Group turtleRoot = Turtle.getRoot() (UI displays turtle)


*External View Additional Use Case - receiving the results of math operations command execution from the back end and then sends it the External View API to be displayed*

Object results = Data.getResults();
Data.sendToUI(results);


*Internal Model Additonal Use Case - User asks to add 2 numbers and store them in variable ‘y’*

Parse command and create class CommandAdd(num1, num2)
Call CommandController.executeCommand(command)
This runs CommandAdd.execute() which returns sum of the 2 numbers
Next in the expression tree is assigning the number to the variable
CommandController.executeCommand(CommandVar(num1, ‘y’))
ReturnState = CommandVar.execute()


*External Model Additional Use Case - The user enters “dog”, which is an invalid command.*

Once the interpreter attempts to instantiate a new instance of dog through its expression tree with interpretCommand(Node n), it will throw an error that the class doesn’t actually exist to the front-end. 



## Design Considerations

In terms of the back-end, there are a couple of design decisions that need to fully resolved before our API design is complete. The first important decision that we discussed at length was whether or not we needed a controller. At first, we thought that it would be easier to have the front-end and back-end communicate directly with each other, but it became more apparent that having a controller to control the flow of data between the two was crucial. Although the controller is still considered a part of the back-end, the organization of our program is much clearer with a middleman between the view and the model.

Additionally, we also considered if it was excessive to make a class for every single Logo command, but after we decided that we would use reflection as a way to call classes without having to look at every single command, having a class for each command became an increasingly necessary part of our design. From our discussion with Rhondu, we decided it would make sense to pass these command classes a reference to the State, such that it can be updated according to the command. We are still in the process of discussing whether or not the Command design pattern can be implemented in order to deal with individual commands.

In terms of the front end, we are still figuring out how Data will give information from the backend to the UI. We have discussed having separate methods for getting each type of command/data which allows the corresponding classes to get the data easily. However, this forces Data to sort where the data needs to go, which is an additional job for an already busy class. The current implementation has Data return all the information from the backend. DataSorter calls the method to get this information and then determines where the information should go. This reduces the size of Data but might be an unnecessary additional step. 

Lastly, there are some inconsistencies in our interfaces/API’s that need to be ironed out in the coming days (the front-end doing work that it does not need to, etc.). We also need to figure out whether or not we should use binding to automatically update the front-end view as the Model values change. We have not figured out yet where to set-up these binding relationships (if needed). There are definitely design patterns that we could incorporate to make our design better (Command, Mediator, etc.), but we will have to discuss them further and see if we can plan well enough before people start implementing.


## Team Responsibilities

We’ve divided the team into two parts, front-end and back-end. In the back-end, Soravit is responsible for the integration between the view and the model, most importantly the controller and the parser while Brian is responsible for developing the model, implementing the commands, and error-checking. In the front end, Diane is responsible for the visualization/UI . Pim is responsible for how command lines are sent to the backend and results of execution of command lines are received from the backend.

