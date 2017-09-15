import java.util.ArrayList;

public class Main {
	
	//Main content given by assignment 
	public static void main(String[] args) {
	PropositionConstant a = new PropositionConstant("a");
	PropositionConstant b = new PropositionConstant("b");
	LogicalSentence l1 = new LogicalSentence(a);
	LogicalSentence l2 = new LogicalSentence(b);
	LogicalSentence l3 = new Negation(l1);
	LogicalSentence l4 = new Negation(l3);
	
	//NOTES
	//Conjunction = And
	//Negation(l4) is technically l3
	
	LogicalSentence l5 = new Conjunction(l3, new Negation(l4));
	TruthAssignment ta1 = new TruthAssignment();
	ta1.put(b, true);
	ta1.put(a, false); 
	System.out.println(l5.evaluate(ta1));
	System.out.println(legal("a&"));
	System.out.println(findMatch("a(b)", 0));
	String[] pc = {"p"};
	truthTable(pc);
	}
	
	//Main Legal Method (used from previous project)
	//*Helper methods below*
	public static boolean legal(String s) {
		if (s.length() == 0) return false;
		if (simpleSentence(s)) return true;
		if (beginsWithNot(s)) return legal(cutNot(s));
		int lhsindex = findFirstOp(s);
		int rhsindex = finalIndexOfOperator(s);
		String LHS = s.substring(0, lhsindex);
		String RHS = s.substring(rhsindex, s.length());
		return legal(LHS) && legal(RHS);
	}
	
	//Checks for propositional constant
	//*Helper method for 'Legal Method'*
	public static boolean simpleSentence(String s) {
		if (s.equals("p") || s.equals("q")) {
			return true;
		}
		return false;
	}
	
	//Checks for negation
	//*Helper method for 'Legal Method'*
	public static boolean beginsWithNot(String s) {
		if (s.startsWith("~")) {
			return true;
		}
		return false;
	}
	
	//Cuts off negation 
	//*Helper method for 'Legal Method'*
	public static String cutNot(String s) {
		String newString = s.substring(1, s.length());
		return newString;
	}
	
	//Find first operator
	//*Helper method for 'Legal Method'*
	public static int findFirstOp(String s) {
		for(int i = 0; i < s.length(); i++) {
			if (s.split("")[i].matches("[&, |]") && i != 0) {
				return i;
			} else if (s.split("")[i].equals("=") && i != 0 && s.length() >= 4) {
				if (s.split("")[i+1].equals(">")) {
					return i;
				}
			} else if (s.split("")[i].equals("<") && i != 0 && s.length() >= 5) {
				if (s.split("")[i+1].equals("=")) {
					if (s.split("")[i+2].equals(">")) {
						return i;
					}
				}
			}
		}
		return 0;
	}
	
	//Find index of operator based on where it began/what type of operator
	//*Helper method for 'Legal Method'*
	public static int finalIndexOfOperator(String s) {
		for(int i = 0; i < s.length(); i++) {
			if (s.split("")[i].matches("[&, |]") && i != 0) {
				return i+1;
			} else if (s.split("")[i].equals("=") && i != 0 && s.length() >= 4) {
				if (s.split("")[i+1].equals(">")) {
					return i+2;
				}
			} else if (s.split("")[i].equals("<") && i != 0 && s.length() >= 5) {
				if (s.split("")[i+1].equals("=")) {
					if (s.split("")[i+2].equals(">")) {
						return i+3;
					}
				}
			}
		}
		return 0;
	}
	
	//Findmatch returns the index of the rightmost character in the first substring of the argument
	//that is enclosed by matching parens and which contains no parens.
	public static int findMatch(String string, int value) {
		int result = -1;
		//Runs through the string checking for open parens (adding 1 to value)
		//and checking for close parens (subtracting 1 to value). In the end if the 
		//value was zero, then you had an equal amount of open and close parens
		//so then you return the value of the character directly in front of the 
		//first close parens, else you resturn -1
		if ((string.length() >= 3) && (string.contains("(")) && (string.contains(")"))) {
			String[] s = string.split("");
			for (int i = 0; i < string.length(); i++) {
				if (s[i] == ("(")) {
					value++;
				} else if (s[i] == (")")) {
					value--;
				}
			}
			if (value == 0) {
				result = (string.indexOf(")") - 1);
			}
		}
		return result;
	}

	//Prints a truthTable 
	//*Uses helper method below*
	public static void truthTable(String[] propconst_a) {
		//Prints number of columns that will be used based on 
		//number of proposition constants 
		for (String propConst : propconst_a) {
			System.out.print(propConst + "          ");
		}
		System.out.println();
		printTruthTable(propconst_a.length);
	}
	
	//Creates truthTable based on number of components given
	public static void printTruthTable(int num) {
		//Creates number of rows
		int rows = (int) Math.pow(2,num);
		//Runs through each row checking if the outcome will be zero or one
		for (int i = 0; i < rows; i++) {
			for (int j = num-1; j >= 0; j--) {
				int value = (i / (int)Math.pow(2, j)) % 2;
				//If value is zero, then this method will print true
				//If value is one, then this method will print false 
				if (value == 0) {
					System.out.print("True" + "       ");
				} else {
					System.out.print("False" + "      ");
				}
			}
			System.out.println();
		}
	}
}
