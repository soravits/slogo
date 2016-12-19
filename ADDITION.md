###Estimation: before looking at the old code:
####how long do you think it will take you to complete this new feature?
2 hours
####how many files will you need to add or update? Why?
2 files: TurtleSettings which deals with the setting of the turtle and TurtleScreen which deals with the visualization of the turtle on the screen
###Review: after completing the feature:
####how long did it take you to complete this new feature?
half an hour
####how many files did you need to add or update? Why?
2 files. I created one more method that prompts a new window when if the user wants to change the image of turtle. Then, in TurtleScreen, I just call turtleSetting.changeImage() when the turtle is clicked.
####did you get it completely right on the first try?
Yes.
###Analysis: what do you feel this exercise reveals about your project's design and documentation?
It tests whether our code is readable or not. Also, it tests whether the documentation works or not.
####was it as good (or bad) as you remembered?
It was good. A teammate who was in charge of the turtle feature wrote a good comment for the methods. 
####what could be improved?
TurtleSetting and TurtleScreen classes are really big. They have almost 400 lines of code, so it was really hard to find a method at first. But after I found a method, it was easy to understand.
####what would it have been like if you were not familiar with the code at all?
It would be hard to find what method to look at because these two classes which deal with everything about the turtle are really big.