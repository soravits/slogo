

##Peer API Review
###Pim Chuaylua - pc131
###Part 1
####What about your API/design is intended to be flexible?
#####Internal
 - Styling, location of the turtle
 - Styling of the UI
	 - workspace that shows the variables/functions that the users have worked with
	 - styling of overall UI e.g. size of screen, pen/turtle color, language
 - How the error is displayed
 - Displaying the list of command lines that users have used
#####External
 - language setting of the command lines
 - get data back to display the result of the execution of command lines from the back-end

####How is your API/design encapsulating your implementation decisions?

 - All the styling has nothing to do with the back-end
 - The only things we need to send to the back-end are as follows: language of the command line, command lines, current information about the turtle
 - The things we need to receive from the back-end are:
	 - history of command lines
	 - result of the execution of the command lines e.g. the next destination of the turtle, calculation result

####What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

 - Invalid command lines and parameters
	 - The front end won't handle errors but it will observe the back-end and display the error as a pop-up window only when some changes are observed.

####Why do you think your API/design is good (also define what your measure of good is)?

 - For me, a "good design" means when distinct parts of codes are clearly separated from each other. Each part can only get/set/manipulate the data of the other part only if it is allowed to. Otherwise, other data are not strictly inaccessible.
 - I think my team's front ends design is relatively good although we don't know how we are going to implement this yet. It is good because all methods regarding styling of UI/pen/turtle and how to display data from the backend are internal or separated from the back end. On the other hand, we only communicate with the back-end only when we want the results of the execution of command lines, the history of command line execution which happens on the back-end.

###Part 2
####Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).

 - displaying errors
 - reset/clear the simulations
 - change the pen color
 - change the brush size
 - save and load the simulations

####How do you think at least one of the "advanced" Java features will help you implement your design?

 - Binding 
 - Observer/observable 

####What feature/design problem are you most excited to work on?

 - I'm really excited to learn how to build my own API and to provide the back-end limited access to the data on my side because in Cell Society, I don't think our team's back end and front end are clearly separated.

####What feature/design problem are you most worried about working on?

 - Building a good API to allows the back-end and front-end to communicate