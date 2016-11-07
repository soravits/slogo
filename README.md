# slogo
### Names: Brian Keohane, Soravit Sophastienphong, Diane Hadley, Pim Chuaylua
### Date Started: October 11, 2016
### Date Completed: November 1, 2016
### Estimate of Total number of man/woman-hours spent on the project: 110 hours
### Sources cited:
* https://www.tutorialspoint.com/design_pattern/command_pattern.htm (Brian)
* https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html (Brian)
* http://stackoverflow.com/questions/13744450/when-should-we-use-observer-and-observable (Brian)
* ADD THE REST HERE

### Files used to start program: Main (in 'main' package)
### Files used to test the program:
1. All of the previous files from example folder
2. 3 files in examples/custom_tests/ (tellnestedask.logo, telltest.logo, testaskwith.logo, dashfunction.logo) are used to test multiple turtle commands and the ability to read in a function and use it later (syntax for dash is 'dash 5 20', type this after uploading the file to show that turtle understands new dash function)

### Data or Resource Files required by the project: ADD FILES IF YOU KNOW OF ANY
### Any information about using the program:
1. Instead of pressing enter after entering all of the text required in the command line, press "Submit Commands"
2. To change the pen thickness, type a double (ex: 3.0) into the 'Pen Thickness' box. On the next turtle commands, the box will be checked for the value and pen thickness will be updated to the correct pixel size.
3. After checking "Show Active Turtle", each of the active turtles becomes highlighted in a blue-ish glow. You can toggle whether or not the turtle is active by clicking on the turtle in the GUI.
4. Unlimited Parameter parsing takes a slightly different syntax. Instead of '( sum 10 20 30 40 )', the syntax that works for us is 'sum ( 10 20 30 40 )'.
5. We chose to implement our command execution such that 'fd set :x + :x 10' causes each turtle to move
a different distance.
6. With regards to unlimited parameters: For non-arithmetic and non-boolean commands, only the parameters that are normally evaluated for each command are used EXCEPT for in Forward and Backward (they use a sum of all the parameters passed to them).
7. ADD MORE EXAMPLES

### Any known bugs, crashes or problems with the code's functionality:
1. None of the display commands actually update the front-end visuals (ex: setpencolor 4 will not change the actual pen color used within the GUI), but they will correctly update the back-end model.
2. The clearscreen command does not clear any of the lines on the screen, but it will return all of the 
turtles to the home position.
3. Functions become globally defined; Once a function is defined, it cannot be overwritten. So if you run
a program that creates 'to square [ :dist :x ] ....', then creating another square function will cause problems running the program. 
4. ADD MORE BUGS THAT YOU GUYS KNOW ABOUT

### Any Extra Features included in the project:
1. ADD ANY EXTRA FEATURES WE ADDED

### Impressions of the Assignment to help improve it in the future:
