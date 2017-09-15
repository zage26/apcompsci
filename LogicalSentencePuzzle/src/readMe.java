
public class readMe {
	
	/*
Logical Puzzle Summary (ReadMe)
By Zage Strassberg - Phillips, Period 4

Introduction
	The purpose of this project was the analyze the given code below, given by my teacher, Mr. Kuszmaul, and create the necessary classes and methods in order to have functional code. I faced many challenges throughout completing the flag project, specifically with creating the truth Table method and understanding how the evaluate method worked,, but was able to overcome them with help from friends, such as Ria, Jordan, and Georgia, my teacher Mr. Kuszmaul, as well as Stack Overflow and other resources on the internet. 

How this fulfills/Does not fulfill the specification
         My java code successfully fulfills the requirements, as of now, all of my code is functionally, returning the correct values. I have a propositional constant class, which takes a string: “a” or “b”, as well as a logical sentence class, which takes a propositional constant. The logical sentence class extends to the negation subclass, which takes a logical sentence, as well as the conjunction subclass, which takes a logical sentence and a negated logical sentence. Additionally, I made a truth assignment class, which initializes with no arguments given. Lastly, all class methods such as put and evaluate were created and stationed in the appropriate classes, and the other methods, legal, findMatch, and truth Table, were created in the main class. 

Explanation of current error/anything that falls short of project specifications and how you might fix them
	Currently, I have found no problems in my code. However, with more trials of these methods, errors are sure to found and from then on can be analyzed and fixed. (Code needs to be further de-bugged). Overall, if problems were to arise, I would start by re-organizing my code, running through it logically to find the error, and if needed ask Stack Overflow, or a friend or teacher, for assistance. 

Overview of the code explaining/Structure

Below is each class of the Logical Puzzle Project, including an explanation for each method used and created.

	I had six classes  in my Logical Puzzle Project: 

	Main.java - purpose was to run the given code without any bugs 

		Legal Method - My code taken from previous project, that determines whether a given phrase is a legal sentence
Truth Table Methods - Printing the truth table consists of two methods. One which takes in the argument of a String array (the components in the truth table), iterates through this array, printing each component, thus making the column headers and lastly using the other method to print out the truth values of each column.  The second method takes in the argument of the number of components in the table. Then creates the necessary number of rows (or 2 to the power of the number of components). Next, the method, runs through each row, and through math (check my code for specifics) determines if the result will be 0 or 1. If the result is a zero then “True” will be printed, and if not, the result will print “False”. 
*In total, creating the truth table was fairly difficult.*
Status: Complete
Scale of effort:  8   

PropositionalSentence.java - Creates a propositional constant variable as well as has  a constructor for the class that takes in the argument of a string, or propositional constant (one letter). 
Status: Complete
Scale of effort:  3 

LogicalSentence.java - Creates a propositional constant variable, a logical sentence variable, and two other logical sentence variables that will be further used in the conjunction class. This class also has a constructor for the logical sentence class that takes in the argument of a propositional constant. (Additionally, this class has two other constructor methods and getter methods for the negation and conjunction subclass which will be explained below).  Lastly, this class has an evaluate method, which takes in a truth assignment and returns the truth value of the given propositional constant (using a method in the truth assignment class - getb()). 
Status: Complete
Scale of effort:  5  

Negation.java - Creates a logical sentence variable and supers the negation constructor originally created in the logical sentence class taking in the argument of a logical sentence. This class also has an evaluate method, taking in a truthassignent, which simply supers the evaluate method created in the logical sentence class and returns the the negated boolean value of the propositional constant given. 
Status: Complete
Scale of effort:  5 

	Conjunction.java - Creates no variables, but rather supers the conjunction constructor originally created in the logical sentence class taking in the arguments of two logical sentences ((1) from logical sentence class and (2) from negation subclass). This class also has an evaluate method which returns a boolean value of the conjunction of both boolean values of the given logical sentences (or in reality their propositional constants).
Status: Complete
Scale of effort:  5 

	TruthAssignment.java -  Creates two arraylists: (1) and arraylist of propositional constants and (2) and arraylist of booleans. Even the constructor of truth assignments takes no arguments, it still initializes these arraylists as they are needed for the given class methods. As the put method takes in the arguments of a propositional constant as well as a boolean value, each time this method is called, these values will be added to the appropriate arraylists. Lastly, a method was created called “get()” (used in the evaulatuare method in Logical sentence) which takes a propositional constant, locates its index in the proposition constant arraylist, and then gets the value of this index in the boolean arraylist. 
Status: Complete
Scale of effort:  6

	readMe.java - explanation of my project, overview, etc. (what you are reading now)

Overall, my code is functional, running all appropriate methods in the specified classes. 

Discussion of major challenges encountered in the process of making the code
	The major challenges I encountered during this project included: learning how construct a truth table correctly, how to super constructors/methods, as well as force my mind to think about these methods logically (in a logical way) and how one might construct them. These challenges were overcome through the use of the internet, previous code/projects,  and help from friends and Mr.Kusmaul.

Acknowledgements (who helped you, what resources you used etc.)
	I would like to acknowledge the provider, and creator, of the code given for this project: Mr. Kuszmaul. Additionally, I would like to thank all of my friends, Ria, Jordan, and Georgia, Mr. Kuszmaul (again for his help with certain methods, ex. findMatch), Stack overflow, and in general the internet -- as all of this sources aided in the overall creation of this project. 
	 */

}
