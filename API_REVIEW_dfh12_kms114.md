Diane Hadley, Kayla Schulz


API Review
===

###Part 1

1. Kayla: The creation of the borderpane is intended to be flexible. The addition of another feature of the view should be simple. 
Diane: The UI design is intended to be flexible. Other classes that have visualization send a root to the UI and the root is added to the current scene root. Therefore, a new class could add to the visualization as long as it has a method that returns a root.
Both: The controller also makes the program more flexible because the data being received from the back end is centralized. 

2. Both: By having a controller and therefore utilizing the MVC structure, the front end is encapsulated because it has no knowledge of the back end. The front end passes information that the back end needs to the controller, which separates front end classes from the back end. Kayla: Only one class in the front end passes information to the controller.

3. Both: The back end will catch most exceptions. One exception that might occur in the front end is if the user tries to load a new image for the turtle that does not exist/have the correct file extension. Also, if we were to give the user the option of choosing a color from any Java color (not just a list that we provide), then an error could occur if the color is not valid. These can both be handled with pop-up dialog boxes.

4. Kayla: The design is good because the encapsulation of the AppScene interface makes it easy to read and pinpoint errors/debug. Also, communication with controller is in one place. Diane: All visualization classes send a root to UI, making it easy to understand and extend. Both: Communication with the back end is all in one place. A good API is: easy to use/understand, flexible, mindful of possible future additions.

###Part 2
1. Use Cases:
    1. User changes background color: Chooses color from a combo box. Class with turtle settings uses change listener and updates the UI. 
    2. User changes the language: Chooses language from a combo box. Sends new language to controller (maybe using change listener). Back end has a change listener and updates when language in controller changes. 
    3. User types a command: When run button is pressed, controller gets object from command line and back end gets object from controller. Back end parses command and controller waits for new data. New data is passed to cooresponding UI.
    4. User edits variables in workspace: User selects and changes variable. Next time run is clicked, backend updates its workspace.
    5. User accesses HTML page: Clicks button/link. Another window opens with HTML page.
	
2. Binding will help implement our designs because it uses the observer pattern, meaning that a change in the model will automatically update the view rather than having to manually update the view. 

3. Kayla: Excited to change image of the turtle because it gives the user the freedom to make the animation what they want it to be. Diane: Excited to implement the visualiztion of the turtle. 

4. Kayla: Worried about presenting errors in a user friendly way because current design involves highlighting lines with errors and creating a mirrored box that tells the user the error. Diane: Worried about figuring out what data and in what format is needed from the backend. 

