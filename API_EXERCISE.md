**Cell Society**

**Visualization**
The visualization classes are the Cell and Grid inheritance hierarchies and the MainMenu class. The internal functions in visualization are the getters and setters from Cell, GUI methods in the Grid class, and the JavaFX configurations in the MainMenu class. The external functions are the majority of the methods in Grid that provides information about cells to the Simulation and the MainMenu's ability to start simulations.

**Configuration**
The configuration classes are the UserInput and SimulationXMLFactory hierarchies as well as part of the MainMenu class. The functions that configure the program connect the front-end and the back-end, so they are all external methods.

**Simulation**
The simulation classes are mainly the ones in the Simulation hierarchy. The majority of the methods in the Simulation classes are back-end except for creating the graph, instantiating the grid, and graphically updating the cells in the grid.

**SLogo**
We have a screen with a command line, implemented in the front-end. The front-end takes the text from the user and sends it to the back-end, who parses the text, updates the turtle abstractly, and sends data back to the front-end to update turtle graphically. If the back-end gets input from the front-end, it checks whether the input is valid considering the available commands, and if the input is invalid, sends data back to the front-end to display an error message and move on to the next input. The commands should only know what's being passed to it, checking whether the input corresponds to a certain command. Like in Cell Society, once the back-end parsing the command, it tells the front-end to update the visualization of the turtle based on its abstract state.

**Design**

**Visualization Internal**
This API is responsible for the styling of the user interface and settings for changing anything related to how the program looks. This includes both the window with the turtle and the command line. It also translates the given input to English.

**Visualization External**
This API sends the command to the back-end as a string.

**Model Internal**
Parses the command and changes the state of the turtle based on the command.

**Model External**
Updates the user interface based on the given command.