# slogo
### Names: Brian Keohane, Soravit Sophastienphong, Diane Hadley, Pim Chuaylua
### Date Started: October 11, 2016
### Date Completed: November 1, 2016
### Estimate of Total number of man/woman-hours spent on the project: 110 hours
### Roles:
 * Brian:
 * Soravit: Implemented the controller as an interface between the front-end and back-end, coded the parsing user input, coded the creation of expression trees, coded the execution of commands represented by expression trees with reflection, implemented control commands (any basic and extensions command with brackets in syntax), implemented error-checking, implemented file-saving/file-reading extension, implemented variable scope, recursion and unlimited parameter extensions, helped with multiple turtles
 * Diane: Built user interface, helped with a few methods in external APIs to get the front end all the information it needed, coded turtle visualization, coded display of errors, and wrote HTML help page. In the second spring, completed extensions to see state of the turtle, see a palette of images/colors and associated numbers, select active turtles graphically and toggle if user can see which are active, and create multiple workspaces.
 * Pim:

### Sources cited:
* https://www.tutorialspoint.com/design_pattern/command_pattern.htm (Brian)
* https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html (Brian)
* http://stackoverflow.com/questions/13744450/when-should-we-use-observer-and-observable (Brian)
* http://stackoverflow.com/questions/4555009/if-i-call-an-interface-method-will-it-get-the-method-body-from-implementation-c/4555112#4555112 (Pim)

### Files used to start program: Main (in 'main' package)

### Files used to test the program:
1. All of the previous files from examples folder
2. 3 files in examples/custom_tests/ (tellnestedask.logo, telltest.logo, testaskwith.logo, dashfunction.logo) are used to test multiple turtle commands and the ability to read in a function and use it later (syntax for dash is 'dash 5 20', type this after uploading the file to show that turtle understands new dash function)

### Data or Resource Files required by the project: 
1. All of the files in the languages folder - newly added ones include TurtleCommands.properties, Control.properties, and Params.properties

### Any information about using the program:
1. Instead of pressing enter after entering all of the text required in the command line, press "Submit Commands"
2. To change the pen thickness, type a double (ex: 3.0) into the 'Pen Thickness' box. On the next turtle commands, the box will be checked for the value and pen thickness will be updated to the correct pixel size.
3. After checking "Show Active Turtle", each of the active turtles becomes highlighted in a blue-ish glow. You can toggle whether or not the turtle is active by clicking on the turtle in the GUI.
4. Unlimited Parameter parsing takes a slightly different syntax. Instead of '( sum 10 20 30 40 )', the syntax that works for us is 'sum ( 10 20 30 40 )'
5. Upload/Save commands work only with text files
6. Hover mouse over turtles to see their states

### Any known bugs, crashes or problems with the code's functionality:
1. None of the display commands actually update the front-end visuals (ex: setpencolor 4 will not change the actual pen color used within the GUI), but they will correctly update the back-end model.
2. The clearscreen command does not clear any of the lines on the screen, but it will return all of the 
turtles to the home position.
3. Functions become globally defined; Once a function is defined, it cannot be overwritten. So if you run
a program that creates 'to square [ :dist :x ] ....', then creating another square function will cause problems running the program. 
4. When pressing Redo button, the console print multiple lines of the same results.
5. Combo box to change pen type is not functional

### Any Extra Features included in the project:
1. User can see turtle state by hovering mouse over the turtle image (it was only required that the user be able to see the turtle state graphically)

### Impressions of the Assignment to help improve it in the future:
1. Learning about multiple design patterns to update model and view: observer pattern and binding
