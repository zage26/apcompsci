package hivolts;
import java.awt.*;


public class GameGrid extends Canvas {
	static String[][] ps = new String[12][12];

    //Sets up the gridboard for the game
    //Replacing 20 x's with 20 interior fences
    //Replacing 12 x's with 12 Mho's
    //Replacing 1 x with 1 smiley face
	public static void main (String[] args) {
		setps();
		Fence.set(ps);
		Mho.set(ps);
		SmileyFace.set(ps);
		printps();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
    //Makes gridboard all x's
	public static void setps() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				ps[i][j] = "x";
			}
		}
	}
	
	public static void printps() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				p(ps[i][j]);
			}
			pln("");
		}
	}
	
	//Print Methods
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}

}
