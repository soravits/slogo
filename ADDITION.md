CompSci 308: SLOGO Additions
===================

###Estimation

I think it will take about 30 minutes to get reacquainted with the code, and then hopefully about an hour to an hour and a half to complete the future. I don't remember how well designed out id system was, which I think will have a big role in this addition. I will definitely have to make an addition to the TurtleSettings class because it holds the controls, like buttons and combo boxes. 

###Review

It took me less time than expected. I spent maybe 45 minutes total being reintroduced the the code and adding the new feature. I mostly needed to add to TurtleSettings (since it holds all of the functions that change the turtle settings). I did have to add two public methods to our API in TurtleScreen in order to get the turtle IDs and turtle images. I also changed Workspace a bit, but I was just making it smaller so that there would be more space for the new button I added. Finally, I added a line to the properties file that holds the displayed text.  

I guess I got it on the first try. I test a lot as I code so it wasn't working the very first time I ran it (ex. just testing that a stage popped up when I clicked the button). At the point when I expected it to work, it did work.

The addition can be seen by clicking the button "View Turtle Images"

###Analysis

It was a lot worse than I remembered. 

First of all, I did a bad job choosing the best layout or root for the scene. I used a Group in my game for the first project and loved the freedom to just place any item wherever I wanted, but as a consequence I didn't spend enough time looking at the rest of my options. For example, our controls are in a vertical column all spaced out the same amount which would have been the perfect time to use a VBox, but instead I placed each control separately because I didn't realize the power of a VBox. This made it very difficult to add more UI elements. 

My classes were also bloated. I remember at the time knowing that they were bloated and not having enough time to refactor them. Had I remembered that I would have to go back and work with that code, I definitely would've taken the time to separate my TurtleSettings into multiple classes because it is very difficult to find what I'm looking for. I imagine it would be near impossible for someone who isn't comfortable with the code. 

It was honestly bad enough that I will probably refactor it after this class is over. One way that it could be fixed (which I haven't mentioned yet) is changing the way roots are added to other roots. For example, the whole UI was made of many smaller nodes added to the parent root. However, I defined each node's location in the class that it originated from, rather than in the parent class so that all locations could be defined together (and therefore better coordinated). 

I also didn't understand utility classes at the time and definitely would like to change UIBuilder to match my knew knowledge. 

Finally, the updating and view/model relationship isn't great. There were many parts of the ui (like background color) that were never passed to the back end, which made it very difficult to later implements those extensions. We did out best to make it work for those, but there definitely could be a better relationship where the controller is always updating the view rather than the view often updating itself. 

All of this being said, it was surprisingly easy to add this new feature. I think I only had to change one line of code from the existing code and it was adding a parameter to a method I wanted to reuse. Therefore, there definitely were some parts that were well designed. For example, I thought to TurtleViewMap was very easy to re-learn and reuse. 

