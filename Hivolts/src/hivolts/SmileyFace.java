package hivolts;

import java.util.Random;

public class SmileyFace {
	
	public static void set(String[][] ps) {
		
		//random row array number
		int r = randInt(1, 10);
		
		//random column array number
		int c = randInt(1, 10);
		
		//Runs again if the position is taken, adds one F to the position array
		if (ps[r][c].equals("x")) {
			ps[r][c] = "S";
		} else {
			set(ps);
		}
	}
	
	//returns a random value between specified bounds
		private static int randInt(int min, int max) {
			Random rand = new Random();
			int retval = rand.nextInt((max - min) + 1) + min;
			return retval;
		}
	
}
