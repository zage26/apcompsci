
public class readme {
/*
	FLAG PROJECT PRE-PLAN
	
Overview
 	The plan is to create the red background first and then the white stripes. Next, this will be overlapped by the blue union which will contain the neatly organized 50 white stars. Overall, this will create one US flag. 

Part 1: The Red Background
First, I plan to create the red background with the correct dimensions (with a 400 multiplier). It was simple to create and apply fillPolygon method, as I had previously learned of this method in the cow project. It took about 5 minutes once I understood what needed to be done. 
Status: Complete
Scale of effort:   1   2   3   4   5   6   7   8   9   10

Part 2: The White Stripes
	Next, I plan to create the white stripes with the correct dimensions and coordinates (with a 400 multiplier). It was simple to create and apply fillPolygon method, however more difficult to understand how to find the coordinates and create a for loop that would create more white rectangles. I believe it will take about 5 minutes once I understood what needs to be done. 
Status: Incomplete, but started
Believed Scale of effort:   1   2   3   4   5   6   7   8   9   10

Part 3: The Union
Then, I plan to create the blue union/background with the correct dimensions (with a 400 multiplier), that will overlap the red background and white stripes. It will simple to create and apply the fillPolygon method once I understand what must be done. I belive this will take about 5 minutes to complete.
Status: Incomplete
Believed Scale of effort:   1   2   3   4   5   6   7   8   9   10

Part 4: The Stars
Lastly, I plan to create the white stars with the correct dimensions and coordinates (with a 400 multiplier). This itself seems very difficult to do. I hope to use a for loop to create rows of the given stars needed (using predetermined coordinates and dimensions), which will overlap the blue union. I belive this section will take me at last an hour to complete once I understand what must be done.  

*Lastly, I will reorganize my code and add comments making it quicker for the reader to comprehend and the computer to process* 

Timeline
	Thursday August 24th: Star White stripes
	Tuesday, August 29th: Complete white strips & complete blue union
	Thursday, August 31st: Start white stars
	Tuesday, September 5th: Finish white stars
	Thursday September 7th: Turn it in.


	FLAG PROJECT SUMMARY 
	
Introduction
The purpose for the flag project is to create an American flag according to the specification file, 
with the correct blue and red colors, exact measurements, and the ability to scale with the changing 
of window size (height and width). I faced many challenges throughout completing the flag project, 
specifically with the stars and the scaling, but was able to overcome them with help from friends, 
such as Ria, Jordan, and Georgia, my teacher Mr. Kuszmaul, as well as Stack Overflow and other 
resources on the internet. 

How this fulfills/Does not fulfill the specification
         My java code successfully fulfills the requirements from the specification file (picture shown to the left). 
         I was able to create a red background with white stripes, as well as a blue union overlapping it and 50 white 
         symmetrical stars correctly placed all on the flag. Throughout the entirety of my code I used a 400 multiplier 
         on all dimensions, thus making everything proportional through use of exact measurements. Lastly, even though 
         difficult, I was able to successfully scale my flag to the dimensions of the JFrame when the IFrame's height 
         and width was adjusted. (Additionally, I was able to fix the recurring problem that when I ran my code and
          moved the JFrame the flag keep repainting itself, but not deleting the previous copies. This problem occurred
           when I was inserting the scaling code into my project and was overcame by discovering the super.paint(Graphics g) 
           method via Stack Overflow. Every time the paint method ran in my code, this allowed the JFrame to cleared before 
           re-painting and rescaling the flag).

Explanation of current error/anything that falls short of project specifications and how you might fix them
	Currently, problems in my code include: when moving the JFrame the flag disappears before reappearing creating
	 a “spasimining” effect and at times the stars blink in and out of the blue union when moving the JFrame as well. 
	 I believe the “blinking” stars are due to the for loop used, because when moving the JFrame every star must rescale, 
	 thus relooping, creating the lag, or “blinking” affect seen on the screen. Additionally, I think the flag “spasming” 
	 is due to the super.paint(graphics g) specific design. Whenever the JFrame is moved, this method clears the screen
	  and then scales and paints a new US flag. Thus the disappearing and reappearing is due to the continual deletion 
	  and re-creation of the US Flag. Overall, I would fix these problems by reorganizing my code to see if it could 
	  be processed faster and delve deeper into the super.paint(Graphics g) method to see if there is a way that other
	   online have overcome a similar problem. 

Overview of the code explaining/Structure

Below is each file of my Flag Project, including an explanation for each method used and created

	I had two files in my Flag Project: 

	main.java - purpose was to print the flag to the screen via JFrame, additionally setting the background color

	Flag.java - purpose was to create methods in which the main.java file utilized to paint the flag 

		private int arrays: 
These int arrays (x1[] and y1[]) were used to place the coordinates of a determined star -- these coordinates were found using the star method (method discussed below)

		
		private double arrays: 
These double arrays consist of the coordinates of the original star we made with a center (100,100) radius 23,  however with 100 subtracted from every point and divided by 23. Now, the coordinates are configured around and the origin (0,0) and have a radius of 1. Now, this allows you, with the use of the star method (below) to place the stars anywhere you would like on JFrame.

		paint method: 

*super.paint(Graphics g) method - This method is used when scaling the flag. It is placed at the front of the 
            paint method so every time the JFrame dimensions change, the old flag 
           will be deleted from the screen and a new flag with adjusted dimensions 
 	           will be painted*

Note: Every physical number that is used below in these pieces of code is based off the exact 
           measurements given with a 400 multiplier applied (and exact colors used as well)	
			
			Scaling Variables - Scaling Variables were created 
First, pre-set dimensions of the JFrame window were found as well as the current dimensions of the window . Then, to find the scaling variables the ratio between the current and preset variables. This allows you to find the scaling variables for the height and width independently, which are then averaged in order to create a new scaling factor which affect the flag both by width and height at the same time. 	

			Red Background - Code creates the red background
The red background coordinates as well as the dimensions of the red background were found with with the scale factor applied and was drawn. 

			White Stripes - Code creates the white rectangles/stripes
The white rectangle/stripe coordinates as well as the dimensions of the white rectangle/stripe  were found with the scale factor applied. Then, a for loop was created in order to correctly position and draw the white rectangle on the red background.
			
			Blue Background/Union - Code creates the blue background/union
The blue background/union coordinates as well as the dimensions of the blue background/union were found with with the scale factor applied and was drawn. 

			White Stars - Code creates the rows of white stars 
The white star radius, coordinates, and as well as the dimensions (movement on x and y axis)  of the white star were found with with the scale factor applied. These arguments are then placed into the stars method (discussed below), finding the coordinates of the initial white star. Then, a for loop is used to correctly place 9 rows of white stars, 5 starting more towards the front of the flag and 4 starting more towards the back of the flag. 

		stars method: 
The star method is used to find the coordinates of the initial star in the us flag, given a radius and star center. The star method runs one for loop that changes the x and y coordinates of the private double arrays to account for this new given radius, assigning these coordinates as index to the private int arrays. Then, the star method runs a second for loop that re-assigns the indexes of the private in arrays to account for the given star center. In the end, the coordinates of the new star are given based off of the received arguments. 

	Overall, my project initially creates a red background, placing six white rectangle stripes on top, then overlapping this with a smaller blue rectangle, the union, and finally placing all of the 500 white symmetrical stars on the blue union. This process occurs every time the JFrame is moved, running the super.paint(Graphics g) method, thus deleting the old star, and then painting a new flag based on the changed dimensions of the JFrame. 

	readme.java - explanation of my project, overview, etc (what you are reading now)

Discussion of major challenges encountered in the process of making the code
	The major challenges I encountered during this project included: learning how to scale an object as well as learning how to create a star. Both of these challenges were overcome through the use of the internet, previous code/projects, especially helpful rom friend and Mr.Kusmaul and at times trial and error.

Acknowledgements (who helped you, what resources you used etc.)
	I would like to acknowledge the site: http://www.usflag.org/flag.specs.html, which provided us with the exact dimensions and colors of the American flag (as well as the colors). Additionally, I would like to thank all of my friends, Ria, Jordan, and Georgia, Mr. Kuszmaul, Stack overflow, and in general the internet as all of this sources aided in the overall creation of this project. 


	
*/
}
