package hivolts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Main {
	public static void main(String[] args) {
		
	//Creates a new instance of GameGrid
	GameGrid g = new GameGrid();
	
	//Has the operation close when the window closes
	g.setDefaultCloseOperation(g.EXIT_ON_CLOSE);
	
	//Sets the background of the window
	g.getContentPane().setBackground(Color.LIGHT_GRAY);
	
	//Sets all the graphics to visible
	g.setVisible(true);
	
	//Sets the title of the windownb
	g.setTitle("Hivolts");
	
	//Locks the size of the window, prevents resizing
	g.setResizable(false);
	
	}
}