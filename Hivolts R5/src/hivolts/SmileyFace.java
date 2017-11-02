package hivolts;
import java.util.Random;

public class SmileyFace {
	
	static int x;
	static int y;
	
	public static void set(String[][] ps) {
		
		//random row array number
		int r = randInt(1, 10);
		
		//random column array number
		int c = randInt(1, 10);
		
		//Runs again if the position is taken, adds S to the position array
		if (ps[r][c].equals("x")) {
			ps[r][c] = "S";
			y = r;
			x = c;
		} else {
			set(ps);
		}
	}
	
	//Used in the jump() method, resets position of SmileyFace in random location
	//But if lands on a fence or Mho, SmileyFace dies = game is over
	public static boolean reset(String[][] ps) {

		//random row array number
		int r = randInt(1, 10);

		//random column array number
		int c = randInt(1, 10);

		if (ps[r][c].equals("x")) {
			ps[y][x] = "x";
			y = r;
			x = c;
			ps[y][x] = "S";
			return true;
		} else if (ps[r][c].equals("F")) {
			return reset(ps);
		} else {
			return false;
		}
	}
	
	public static String jump(String[][] ps) {
		System.out.println("y is " + y);
		System.out.println("x is " + x);
		
		//random row array number
		int r = randInt(1, 10);
		System.out.println("r, the new y,  is " + r);

		//random column array number
		int c = randInt(1, 10);
		System.out.println("c, the new x, is " + c);

		if (ps[r][c].equals("x")) {
			ps[y][x] = "x";
			y = r;
			x = c;
			ps[y][x] = "S";
			return "S";
		} else if (ps[r][c].equals("F")) {
			System.out.println("you landed on a fence");
			return "F";
		} else {
			System.out.println("you landed on an mho");
			return "M";
		}
	}
	
	//returns a random value between specified bounds
	private static int randInt(int min, int max) {
		Random rand = new Random();
		int retval = rand.nextInt((max - min) + 1) + min;
		return retval;
	}
	
	public static void swap(int ymove, int xmove, String [][] ps) {
		ps[y][x] = "x";
		y += ymove;
		x += xmove;
		ps[y][x] = "S";
	}
	
	public static boolean move(int ymove, int xmove, String [][] ps) {
		boolean result = true;
		if (ps[y+ymove][x+xmove].equals("x")) {
			swap(ymove, xmove, ps);
			result = true;							
		} else {
			result = false;
		}
		
		return result;
	}
}