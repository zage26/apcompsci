package implementSetStuff;
import java.util.ArrayList;

public class setStuff {

	public static void main(String args[]) {
		//Examples using some of the methods
		
		//Set two int ArrayLists using setInfinity Methods
		ArrayList<Integer> arr1 = setInfinity(3, 1);
		ArrayList<Integer> arr2 = setInfinity(2, 2);
		
		//Set two object ArrayLists using listify Methods
		ArrayList<Object> arr3 = listify(345678, 467485, 34869749);
		ArrayList<Object> arr4 = listify(212, 1029384, 343);
		
		//Returns zeroth element of arr1
		System.out.println(zerothElement(arr1));
		
		//Return an arraylist that contains 17
		System.out.println(ret17());
		
		//Check if int array contains the number 7
		int[] ar = {1, 2, 4, 7, 8, 9};
		System.out.println(contains(7, ar));
		
		//Takes two arrays and returns true if any element of a is in b
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		System.out.println(anyContains(a, b));
		
		//Returns the int array that contains all elements in either a or b 
		int[] union = union(a, b);
		for(int i = 0; i < union.length; i++) {
			System.out.print(union[i] + " ");
		}
		System.out.println("");
		
		//Returns the int array that contains the intersection of the elements in c and d
		int[] c = {1, 2, 5, 7, 8};
		int[] d = {4, 5, 6, 7, 9};
		int[] intersect = intersect(c, d);
		for(int i = 0; i < intersect.length; i++) {
			System.out.print(intersect[i] + " ");
		}
		System.out.println("");
		
		//Takes the edges arrayList and three ints and then returns
		//makes those three integers into an arrayslist and adds that
		//arraylist to the edges arrayList and returns that
		/*Using the two object arrayLists made above ...*/
		ArrayList<ArrayList<Object>> edges = new ArrayList<ArrayList<Object>>();
		edges.add(arr3);
		edges.add(arr4);
		System.out.println(addEdge(edges, 123, 456, 789));
		
		/*Takes an arraylist of arraylists of size three of 
		integers and returns an arraylist that contains the 
		union of all the integers that appear in the first 
		two elements of each arraylist of size three*/
		/*Using the two integers arrayLists made above ...*/
		ArrayList<ArrayList<Integer>> collect = new ArrayList<ArrayList<Integer>>();
		collect.add(arr1);
		collect.add(arr2);
		System.out.println(collectNodes(collect));
		
		//Example of nearestUnvisitedNode method that is explained in the comments below
		boolean[] vis = {true, false, false};
		int[] dis = {1,2,3};
		String[] node = {"A", "B", "C"};
		System.out.println(nearestUnvisitedNode(vis, dis, node));
	}

	//Get zero index
	public static int zerothElement(ArrayList<Integer> al){
		 return al.get(0);
	}
	
	//Return an ArrayList<Integer> that contains 17
	public static ArrayList<Integer> ret17() {
		ArrayList<Integer> s = new ArrayList<Integer>();
		s.add(17);
		return s;
	}
	
	//Check if an int array contains an int arg
	public static boolean contains(int a, int[] ar){
		  for(int n : ar) {
		    if (a == n) {
		      return true;
		    }
		  }
		return false;
	}
	
	//Takes two arrays and returns 
	//true if any element of a is in b
	public static boolean anyContains(int[] a, int[] b){
		  if(a.length > b.length) {
		    for(int i: a) {
		      for(int j: b) {
		        if(i == j) return true;
		      }
		    }
		  } else {
		    for(int i: b) {
		      for(int j: a) {
		        if(i == j) return true;
		      }
		    }
		  }
		  return false;
		}

	//Return the int array that contains all elements in either a or b 
	//Assume the intersection of a and b is empty
	public static int[] union(int[] a, int[] b){
		  int arr[] = new int[a.length+b.length];
		  int num = 0;
		  for(int n1: a) {
		    arr[num] = n1;
		    num++;
		  }
		  for(int b1: b) {
		    arr[num] = b1;
		    num++;
		  }
		  return arr;
		}
	
	//Write the intersect method: It returns an array that: 1: Is sorted 2: 
	//has no repeat values 3: Contains any value that is in both a and b 
	//NOTE: Assume a and b are sorted (lowest to highest)
	public static int[] intersect(int[] a, int[] b){
		  int num = 0;
		  for(int i: a) {
		    for(int j: b) {
		      if (i == j) {
		        num++;
		      }
		    }
		  }
		  int[] arr = new int[num];
		  int num2 = 0;
		  for(int i: a) {
		    for(int j: b) {
		      if (i == j) {
		        arr[num2] = j;
		        num2++;
		      }
		    }
		  }
		  return arr;
		}

	/*Take three arrays, one boolean one integer and one String. Return the String 
	 * at the index of the smallest integer for which the corresponding boolean is false. 
	 * For example: Boolean (visited): {true, false, false} integer (distance): {1,2,3} 
	 * String (node): {"A", "B", "C"} results in a return value of "B" because node B 
	 * has a distance of 2 which is the smallest of the values not yet visited. 
	 * Return the empty string if no distances qualify. You may assume the largest 
	 * value in distance is less than 99999.*/
	public static String nearestUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName){
		 int d = 10000;
		 int index = -1;
		 for (int i = 0; i < visited.length; i++) {
		   if (!visited[i]) {
		    if (distance[i] < d) {
		d = distance[i];
		index = i;
		    }
		   }
		 }
		 if (index == -1) {
			 return "";
		 } else {
			 return nodeName[index];
		 }
	}
	
	//Take three ints and return an arrayList containing them
	public static ArrayList<Object> listify(int a, int b, int c){
		  ArrayList<Object> arr = new ArrayList<Object>();
		  arr.add(a);
		  arr.add(b);
		  arr.add(c);
		  return arr;
		}
	
	//Take an arraylist of arraylists of integers, and three integers, 
	//and make those three integers into an arrayslist and add that 
	//arraylist to the given arraylist and return that
	public static ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c){
		  ArrayList<Object> arr = new ArrayList<Object>();
		  arr.add(a);
		  arr.add(b);
		  arr.add(c);
		  ArrayList<ArrayList<Object>> newArr = graph;
		  newArr.add(arr);
		  return newArr;
		}
	
	/*Take an arraylist of arraylists of size three of 
	integers and return an arraylist that contains the 
	union of all the integers that appear in the first 
	two elements of each arraylist of size three.
	Your returned arraylist must be in 
	the order elements appear in the argument*/
	public static ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist){
		  ArrayList<Integer> arr = new ArrayList<Integer>();
		  for (int i= 0; i < edgelist.size(); i++) {
		    for(int j = 0; j < 2; j++) {
		      if(!(arr.contains(edgelist.get(i).get(j)))) {
		        arr.add(edgelist.get(i).get(j));
		      }
		    }
		  }
		  return arr;
		}

	/*Given an integer for the size and an integer for 
	the start node create an arraylist of integers 
	whose values are maximal except the entry at the 
	index of the start, which should be zero.*/
	public static ArrayList<Integer> setInfinity(int n, int start){
		 ArrayList<Integer> arr = new ArrayList<Integer>();
		 for(int i = 0; i < start; i++) {
		   arr.add(2147483647);
		 }
		 arr.add(0);
		 int num = n - start - 1;
		 for(int i = 0; i < num; i++) {
		   arr.add(2147483647);
		 }
		 return arr;
	}
}
