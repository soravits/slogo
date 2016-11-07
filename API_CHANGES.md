**Slogo Team 17 API Changes**

 Changes Made to the API
 **1. Model Internal**
 -Added a CommandController that stores executed commands to be included in the command history. This was a minor change that allowed us to store the command history but did not require major design changes. It was beneficial in allowing us a way to store commands dynamically.
 
 -We pass the commands different parameters depending on the type of the command. Most commands are just passed doubles from the controller, but control structures, variables, constants, and custom user instructions are passed the root to the tree of the command. This was a major change, because it not only required we parse different commands differently, but also made the process of executing commands less standardized. It was beneficial in allowing us to implement more commands but also made it more difficult to add more commands, since you have to think about what category the command fits in.
 
Methods added beyond the basic getters and setters for workspace, Turtles, Command History, and LineStates include:
1. Methods that allow executor methods to update the current active turtles in the workspace:
	1. Collection<Double> getIDs();
	2. void clearTellTurtles ();
	3. void addTurtle(double ID);
	4. Collection<Double> getTurtlesToModify ();
	5. void addNestedAsk ();
	6. void subtractNestedAsk ();
2. Methods that allow command classes to get and set the appropriate Display parameters:
	1. double getBackGround ();
	2. void setBackGround (double back);
	3. double getPenColor ();
	4. void setPenColor (double pencolor);
	5. double getPenSize ();
	6. void setPenSize (double pensize);
	7. double getPaletteIndex ();
	8. void setPaletteIndex (double paletteindex);
	9. double getShape ();
	10. void setShape (double shp);
	11. int()() getPaletteColors ();
	12. void setPaletteColors (int index, int[] paletteColor);
	
These API's were decided on later in the project after determining how to best implement the extensions from a design perspective
  

 **2. View Internal**
 -Added a UIBuilder class that has standardized methods for formatting parts of the UI. This was a major but not code-intensive change, since it standardized a way of customizing the UI with only a couple of public methods. This is beneficial because it removes a ton of duplicated code and allows different classes to easily modify the UI without writing the same code.

**3. Model External**
-Modified the Controller class to be the only public API in the controller that is responsible for updating the model and the view. This is a minor design change, since we were already planning to only give restricted public access to the controller. It is beneficial in encapsulating the data in the controller.
-Changed the way the view is updated such that we update the instance of the model used by the view with the actual back-end model This is minor, because we were already planning to either use bindings or change listeners to allow our front and back end to communicate through the controller. However, having two different versions of the model definitely made it easier to have a clear distinction between the back-end model and the model used by the view.

The following methods were added to the Model so that the View could access the pertinent parameters stored in the back end:

public void changeActiveTurtle(double ID);

public double()() getLines (double ID);

public Collection<Double> getTurtlesToModify();

public DisplayState getDisplay();

public double getBackGround ();

public void setBackGround (double back);

public double getPenColor ();

public void setPenColor (double pencolor);

public double getPenSize ();

public void setPenSize (double pensize);

public double getPaletteIndex ();

public void setPaletteIndex (double paletteindex);

public double getShape ();

public void setShape (double shp);

public int()() getPaletteColors ();

public void setPaletteColors (int index, int[] paletteColor);
    
In particular, the format of the lines presented to the front end was different. Instead of giving the View each line that the turtle had ever drawn, only the most recent line is given to the Front-End. Every time the model is updated, an array of array of doubles is passed to the line-drawing mechanism in the front end via getLines(). Also, the ability to handle multiple turtles and the display commands is accounted for by
the addition of the other methods.



**4. View External**
-Removed the DataOut class. This was major design change, because we give the view direct access to the public methods of the model. This can be a downside in terms of data encapsulation, but is beneficial for giving the view the access it needs to almost all of the data in the model.
-We decided to pass the whole command as a string for the controller to parse rather than an array of strings containing each word. This was a minor change in terms of changing the code but was really important in leaving all of the parsing to the controller and not the front-end. All of the language parsing is also done by the controller.

**Significant Changes Coming in the Next Few Days**
-The front-end is working on using the observer pattern to better separate the front-end and the back-end
-The core back-end is working on using interfacing to hide model data from the commands
-The controller is working on creating a class hierarchy for defining the way different commands are parsed.

Sections We Refactored during the Lab
-We mostly did research during the lab for the changes we mentioned above that we plan to make


