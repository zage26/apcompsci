
public class Main {

	/*AS exercises 1.11 and 1.12 (in Java)

	Exercise 1.11. A function f is defined by the rule that

 	f(n) = n if n < 3,

	f(n) = f(n-1) + 2f(n-2) + 3f(n-3) if n >= 3

	Write a procedure that computes f by means of a recursive process. 
	Write a procedure that computes f by means of an iterative process.

	Exercise 1.12.  The following pattern of numbers is called Pascal's triangle.

	The numbers at the edge of the triangle are all 1, and each number inside the 
	triangle is the sum of the two numbers above it.35 Write a procedure that computes 
	elements of Pascal's triangle by means of a recursive process.

*/
	public static void main(String[] args) {
		
		//Exercise 1.11
		System.out.println(fr(5));
		System.out.println(fi(5));
		
		//Exercise 1.12
		System.out.println(pt(3, 2)); //2
		System.out.println(pt(4, 4)); //1
		System.out.println(pt(5, 3)); //6
		
	}
	
	
	//recursive
	public static int fr(int n) {
		if (n < 3) {
			return n;
		} else if (n >= 3) {
			int var1 = fr(n-1);
			int var2 = 2*fr(n-2);
			int var3 = 3*fr(n-3);
			return(var1 + var2 + var3);
		} else {
			return 0;
		}
	}
	
	//iterative 
	public static int fi(int n) {
		return iter(0, 1, 2, n);
	}
	
	public static int iter(int a, int b, int c, int count) {
		if (count == 0) {
			return a; 
		} else {
			int var = c + 2*b + 3*a;
			count--;
			return iter(b, c, var, count);
		}
	}
	
	//Pascal's triangle -- recursive 
	public static int pt(int r, int c) {
		if(r == c || c == 1 || r == 1) {
			return 1;
		}else{
			int var2 = pt(r-1, c-1);
			int var1 = pt(r-1, c);
			return var1 + var2;
		}
	}
	
}
