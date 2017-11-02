package hivolts;
import java.util.Random;

public class Fence {
	
	private static int InteriorFences = 20;
	
	public static void set(String[][] ps) {
		
		//Sets exterior fences
		setExterior(ps);
		
		//Sets 20 interior fences in random places
		for (int i = 0; i < InteriorFences; i++) {
			setInterior(ps);
		}
	}
	
	//Sets exterior fences in the outer parts of the board
	private static void setExterior(String[][] ps) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 1) {
					ps[11][i] = "F";
					ps[i][11] = "F";
				} else {
					ps[0][i] = "F";
					ps[i][0] = "F";
				}
			}
		}
	}
	
	//Sets interior places to 20 random places in the inside 10 by 10 of the board
	private static void setInterior(String[][] ps) {
		
		//random row array number
		int r = randInt(1, 10);
		
		//random column array number
		int c = randInt(1, 10);
		
		//Runs again if the position is taken, adds one F to the position array
		if (ps[r][c].equals("x")) {
			ps[r][c] = "F";
		} else {
			setInterior(ps);
		}
	}
	
	//returns a random value between specified bounds
	private static int randInt(int min, int max) {
		Random rand = new Random();
		int retval = rand.nextInt((max - min) + 1) + min;
		return retval;
	}
}