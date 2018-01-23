package vocab14;

import java.util.ArrayList;
import java.lang.Math.*;

public class Vocab14 {
	
	//Driver Code
	public static void main(String args[]) {
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(1); arr1.add(4); arr1.add(4); arr1.add(9); 
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(2); arr2.add(1); arr2.add(4); arr2.add(10);
		
		//Union
		Union(arr1, arr2);
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(1); arr3.add(4); arr3.add(4); arr3.add(9);
		ArrayList<Integer> arr4 = new ArrayList<Integer>();
		arr4.add(2); arr4.add(1); arr4.add(4); arr4.add(10);
		
		//Intersection
		Intersection(arr3, arr4);
		
		ArrayList<Integer> arr5 = new ArrayList<Integer>();
		arr5.add(2); arr5.add(4); arr5.add(4); arr5.add(9);
		ArrayList<Integer> arr6 = new ArrayList<Integer>();
		arr6.add(10); arr6.add(1); arr6.add(4); arr6.add(10);
		
		//Set Difference 
		setDifference(arr5, arr6);
		
		//Binomial Coefficient
		binomialCoefficient(15, 9);
		
		//Limit
		geoLimit(4, 0.75);	
		
		//Standard Deviation Methods
		ArrayList<Integer> arrTest = new ArrayList<Integer>();
		arrTest.add(200); arrTest.add(30); arrTest.add(59); arrTest.add(87); arrTest.add(103);
		standardDeviation(arrTest);
		
		//l'hopital's rule
		hopitalRule(0.0001, 5);

	}
	
	//Union Method
	public static void Union(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> arrNew = arr1;
		for(int i = 0; i < arr2.size(); i++) { arrNew.add(arr2.get(i)); }
		System.out.println("The combined arrays are " + arrNew);
	}
	
	//Intersection Method
	public static void Intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> arrNew = new ArrayList<Integer>();
		for(int i = 0; i < arr1.size(); i++) {
			if(arrNew.contains(arr1.get(i))) continue;
			else if(arr2.contains(arr1.get(i))) arrNew.add(arr1.get(i));
		}
		System.out.println("The intersection of the arrays is " + arrNew);
	}
	
	//Set Difference Method  
	public static void setDifference(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> arrNew = new ArrayList<Integer>();
		for(int i = 0; i < arr1.size(); i++) {
			if(arrNew.contains(arr1.get(i))) continue;
			if(arr2.contains(arr1.get(i)) == false) arrNew.add(arr1.get(i));
		}
		for(int i = 0; i < arr2.size(); i++) {
			if(arrNew.contains(arr2.get(i))) continue;
			if(arr1.contains(arr2.get(i)) == false) arrNew.add(arr2.get(i));
		}
		System.out.println("The set difference of the arrays is " + arrNew);
	}
	

	//Binomial Coefficient 
	public static void binomialCoefficient(int n, int r) {
		if (r == 0) System.out.println(1);
		if (r < 0 || n < 1 || r > n) System.out.println("Error.");
		int integer = factorial(n)/(factorial(r)*(factorial(n-r)));
		System.out.println("Binomial Coefficient: " + integer);
	}
	
	//Factorial 
	public static int factorial(int n) {
		 if (n == 0) return 1;	  
		return n * factorial(n - 1);
	}
	
	//limit *Specifically for Geometric Infinite Sequences*
	public static void geoLimit(int a1, double ratio) {
		if (ratio == 1) System.out.println("Converge at zero");
		if (Math.abs(ratio) > 1) System.out.println("Diverge (limit --> (-/+)infinity)");
		if (Math.abs(ratio) < 1) System.out.println("Given: a = " + a1 + " and ratio = " + ratio + ", converge at " + a1/(1-ratio));
	}
	
	//Standard Deviation Methods 
	
	//finds the mean *assume all positive numbers*
	public static double findMean(ArrayList<Integer> arr) {
		int length = arr.size();
		int sum = 0;
		for(int i : arr) { sum += i; }
		return (double)sum/length;
	}
	
	//finds the variance
	public static double variance(ArrayList<Integer> arr) {
		double mean = findMean(arr);
		int length = arr.size();
		int sum = 0;
		for(int i : arr) { sum += Math.pow(((double)i - mean), 2); }
		return (double)sum/length;
	}
	
	//roots the variance
	public static void standardDeviation(ArrayList<Integer> arr) {
		System.out.println("Given the numbers: " + arr + ", the standard deviation is " + Math.sqrt(variance(arr)));
	}

	//l'hopital's rule 
	
	//For the purposes of this assignment I pre-assigned the functions
	//However, if I was to go more in depth, I would create functions
	//that allow the user to input their own functions
	public static double f(double x) {
		return (double)Math.pow(x, 2) - 16;
	}
	
	public static double g(double x) {
		return (double)x-4;
	}
	
	public static void hopitalRule(double deltaX, double a) {
		double top = f(a + deltaX) - f(a);
		double bottom = g(a + deltaX) - g(a);
		double output = top/bottom;
		System.out.println("Given deltaX = " + deltaX + " and that a = " + a + ", the output is " + output);
	}

}
