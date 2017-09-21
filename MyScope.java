/*
	By Zage Strassberg-Phillips, Period 4

	This homework has 4 problems. Your answers must be complete English sentences. Avoid using vague pronoun references. 
    Avoid circular explanations. Avoid passive voice. It would be bad because this is that.
	 
	Question 1: What does the following code print out (feel free to run it to find out.)?
				
				The following code prints out the numbers: 3, 3.14, 3, 7, 7, 88, 2, and 2.7.
	
	Question 2: The number 7 gets printed out twice in a row, but the number 88 is followed by a 2. Why?
	
	 			The number 7 was printed out twice because variable b is a static variable, accessible by the class, 
	 			so when the value of the variable is changed, this value gets changed for all classes of the MyScope class. 
	 			Whereas, 88 is followed by a 2 because when the value of variable a, a non-static variable, is changed to 
	 			88 in the code, only the value of a is changed in the code, this only changes the value of a for the 
	 			MyInstance class, NOT all classes of MyScope.   
	 
	Question 3: The first value printed out is that of MyScope.b. If we try to print MyScope.a, what happens, and why?
	
			    When you try to print out MyScope.a, you are unable to do so, because the variable a is not a static
			    variable, thus it remains unaccessible to classes of MyScope.

*/
	//CODE
	public class MyScope {
	   	int a = 2;
	   	static int b = 3;
	   	public static void main(String[] args) {
	          	MyScope myInstance = new MyScope();
	          	MyScope myOtherInstance = new MyScope();
	          	double a = 3.14;
	          	double b = 2.7;
	          	System.out.println(MyScope.b);
	          	System.out.println(a);
	          	System.out.println(myInstance.b);
	          	myInstance.b = 7;
	          	System.out.println(myInstance.b);
	          	System.out.println(myOtherInstance.b);
	          	myInstance.a = 88;
	          	System.out.println(myInstance.a);
	          	System.out.println(myOtherInstance.a);
	          	System.out.println(b);
	   	}
	}
/* 
	Question 4 (hard, do your best): Identify a way to generalize the way one can establish the scope of a variable. 
									 If you wish, you can invent a new declaration mechanism, for example you might say: 
	 
	 	I wish to make it possible to declare a variable using the special word LocalEverywhere. 
	 	This makes a local variable in all methods, it would look like this:
	
	EXAMPLE
	**public class aClassThatUsesMyNewDeclaration {
	    LocalEverywhere int a;
		public int add(int x, int y){
	    	a = x + y;
	    	return a;
	   }
		public int sub(int x, int y){
	   	a = x - y;
	   	return a;
	   }
	}**
		Then you would justify this new construct, and you would also criticize it. 
		Note especially that you can get full credit for a construct that would be a very bad idea --- 
		so long as you outline just why the construct would be bad.
		
		ANSWER:
		
			In Java there is the keyword "this" that allows you to differentiate between a value initialized in 
			a method and a value initialized before all methods, as an attribute, with the same names. However, my goal
			is to create a .that() method that serves the function of allowing you to now create three variables 
			with the same name and still be able to differentiate between them, like such (in the class, a method, 
			an if statement, etc):
			
		EXAMPLE
		
		public class Numbers {
			int z = 1;
			public void method() {
				int z = 2;
				if (z == this.z) {
					int z = 3;
				} 
				if (z == z.that()) {
					int z = 4;
				}
			}
		}
		
			However the functionality of the that() method has many flaws, one of which includes specificity 
			(as the name is vague), and also prompts the question -- How do I differentiate between variables 
			of the same name if I keep creating more if statements in more if statements, inside more if 
			statements/methods, that have the same variable names? Additionally, it would be interesting 
			to see if one could create a method that would find a way to have many variables with the same 
			exact name, but find a way to specifically identify each one individually with the use of keywords 
			such as this, that, etc. 
		
		~Credit @ Mr. Kuszmaul~ 

	You should probably talk to me and your classmates about this problem as part of the process of solving the problem.
	 
	Question 5: So, you thought there were only four questions, but here you are, reading further. 
 				Very well, try this one: Is it a good idea to be able to change the scope of a variable based on a 
 				conditional value that is not known until runtime?
 				
 				It is a bad idea to be able to change the scope of a variable based on a 
 				conditional value that is not known until runtime. The knowledge of the conditional value is 
 				important, as if it is unknown and the scope of a variable changes, this could cause major fluctuations 
 				in your code, resulting in (for example) an infinite loop, an error, etc. Additionally, if your code
 				had several variables with the same name, and you changed the scope of one variable, then your code will no 
 				longer know which variable(s) you are referencing throughout your code -- causing a major error. In general,
 				the scope of a variable should not be changed.  
 				
*/
