
public class Vocab16 {
	
	public static void main(String args[]) {
		binaryTree(0);
		permutation(4, 2);
	}

//	Binary tree (takes a number)
	public static boolean binaryTree(int n) {
		if (n == 2) {
			System.out.println("The number is 2.");
			return true;
		} else if (n > 2) {
			if(n > 107) {
				System.out.println("The number is greater than 107.");
				return true;
			} else {
				System.out.println("Number: " + n);
				return false;
			}
		} else {
			System.out.println("Num: " + n);
			return false;
		}
	}
	
//	permutation
	public static void permutation(int n, int r) {
		if (r == 0 || n == 0){
			System.out.println(1);
		} else if (r < 0 || n < 0 || r > n) {
			System.out.println("Error.");
		} else {
			double perm = (double)(factorial(n)/factorial(n-r));
			System.out.println("P(" + n + "," + r + ")" + " = " + perm);
		}
	}

//  factorial *helper method*
	public static int factorial(int n) {
		if (n == 0) return 1;	  
		return n * factorial(n - 1);
	}	
	
}
