package hivolts;
import java.util.Random;

public class Mho {
	
	public static int Mhos = 12;
	public static int[][] mpa = new int[12][12];
	
	public static void set(String[][] ps) {
		
		//Sets 12 Mhos in random places
		for (int i = 0; i < Mhos; i++) {
			setMho(ps, i);
		}
	}
	
	//Sets 12 Mhos in random places in the inside 10 by 10 of the board
	private static void setMho(String[][] ps, int i) {
		
		//random row array number
		int r = randInt(1, 10);
		
		//random column array number
		int c = randInt(1, 10);
		
		//Runs again if the position is taken, adds one Mho to the position array
		if (ps[r][c].equals("x")) {
			ps[r][c] = "M";
			mpa[i][0] = r;
			mpa[i][1] = c;
		} else {
			setMho(ps, i);
		}
	}
	
	//returns a random value between specified bounds
	private static int randInt(int min, int max) {
		Random rand = new Random();
		int retval = rand.nextInt((max - min) + 1) + min;
		return retval;
	}
}