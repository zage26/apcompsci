package hivolts;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;

public class Main {
	
    /*
         All the code givne in the file was collaborated on by Ria, Sabrina, and I.
         As of now, not much ambiguity has been faced in this stage of the project,
         however further into the project we will face all ambiguity appropriately -
         creating methods wehn necessary and trying to compact code as much as posible.
     
         As of now, our group is trying to place an icon on the Jframe we have
         created,as seen in the code seen below. We are still struggling to do this, and
         have been using Stack overflow to help us/the internet.
    */
    
    
	public static void main(String[] args) {
		JFrame game = new JFrame("Hivolts");
		GameGrid grid = new GameGrid();
		game.add(grid);
		game.setDefaultCloseOperation(game.EXIT_ON_CLOSE);
		game.getContentPane().setBackground(Color.PINK);
		game.setSize(900, 700);
		game.setResizable(false);
		game.setVisible(true);
//		FenceImage fi = new FenceImage();
//		game.add(fi);
	}
	
}
