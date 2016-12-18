## Back-End Slogo Additions: Stamp and ClearStamps

### Estimation: Before looking at the old code....
#### How long do you think it will take you to complete this new feature?
*I believe that it will take me around 20 minutes to implement this new feature. This includes re-familiarizing myself
with the code and adding the necessary features*.
#### How many files will you need to add or update? Why?
*I will need to add/update 5 files: Two new command classes 'Stamp' and 'ClearStamp' that are called reflexively, the Model 
class to track the stamped turtles, the TurtleState class to add an image index, and a front-end class to display the turtles.*

### Review: After completing the feature...
#### How long did it take you to complete this new feature?
*It took me around 30 minutes to complete the addition of this new feature.*
#### How many files did you need to add or update? Why?
*I added 2 new files: the reflexively-called 'Stamp' and 'ClearStamp' classes as TurtleCommands. Between the interfaces
(ViewModelInterface, TurtleCommandInterface), the properties files (English.properties, Params.properties, TurtleCommands.properties)
and the necessary model and front-end classes (Model.java, TurtleState.java, TurtleScreen.java, ViewData.java), I ended up
modifying 9 files in addition to the 2 additions. This is because I needed to implement the design in the front-end, which added
to the API necessary in the ViewModelInterface. I also forgot that our parser depends on the properties files for syntax, so
I had to update them to get it to work.*
#### Did you get it completely right on the first try?
*No, I did not. I had a few issues, namely: the properties files weren't updated (so our parser couldn't even handle the commands)
and the imageviews were not being cleared properly from TurtleScreen.java's drawStamps() method. After 2 quick fixes, the
program worked soon after.*

## Analysis: 
#### What do you feel this exercise reveals about your project's design and documentation?
*This reveals that our project's design, while not flawless, is not a major detriment towards adding functionality in the
future. Our Model class turned out to have a need to be modified (breaking the rule of "Closed For Modification-Open For
Extension", but it was not a major modification that was required. Additionally, there are possibly ways that I could have
implemented the commands more elegantly (in terms of using the observable pattern to pass a stamp directly through to
the front end rather than storing them on the back end, but given the fact that I am very ill and stressed with finals, this
was the quickest and handiest implementation I could come up with. The documentation for the project helped a little bit;
some of the classes' comments kick-started my memory on what each class was doing within our design.*

#### Was it as good (or bad) as you remembered?
*Our design was about as good (and bad) as I remembered. Our front-end classes were still way too long and contained too
much functionality per class. Overall, our front-end design was a little weak, with our classes extremely long (300+ lines)
and doing too much. Our back-end design was simple enough to add 2 commands via 2 new classes and small tweaks to a few
existing classes.*
#### What could be improved?
*A more thorough refactoring could have eliminated the need to modify any front-end class and instead add a new front-end 
class via composition. Additionally, the documentation should be improved in terms of what files are necessary to process
commands, and a diagram of the general flow through our program would be an immensely helpful addition. Also, our Design.md
document is not extremely helpful.*
#### What would it have been like if you were not familiar with the code at all?
*It would have probably taken someone with no familiarity of the code __many__ times longer to add the commands required
for this extension. The hardest part would be knowing where to start. It seems clear to me that even a newbie would figure
out that a new Command class needs to be added for each new command. However, figuring out the Front-end class to change
and the interfaces that needed adjusting may have taken a little bit more time.*