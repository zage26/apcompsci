package hivolts;
import java.lang.Math;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Graphics;

public class GameGrid extends JFrame {
	
	//The positional array for the game board and graphical board, holds the position of each Mho, Fence, and the User
	static String[][] ps = new String[12][12];
	
	//Color combinations for the graphical board
	static Color pink = new Color(255, 192, 203);
	static Color blue = new Color(174, 226, 255);
	static Color yellow = new Color(238, 221, 130);
	static Color purple = new Color(205, 209, 251);
	static Color red = new Color(255, 81, 72);
	static Color darkBlue = new Color(70, 130, 180);
	static Color brown = new Color(139, 69, 19);
	
	//boolean constant used to determine if the user is alive
	static boolean alive = true;
	
	//boolean constant used to determine if all Mho's are dead, which decides whether the user wins the game
	static boolean allMhoDead = false;
	
	//Tells whether the game is in need of a reset, either after a game over or a user win
	static boolean resetReady = false;
	
	//The number of turns, displayed with graphics to the user, and reset with the game reset
	static int turns = 0;
	
	//The reason for death, displayed to the user with the GameOver screen
	static String dieReason = "";
	
	//GameGrid initializing constructor with no arguments
	public GameGrid () {

		//Runs the initial part of Game Grid
		init();	
		
	}

	//Runs when GameGrid is called
	public void init() {	

		//Sets the position array with an x in each position
		setps();

		//Sets the fences in random places in the interior of the array
		Fence.set(ps);

		//Sets the Mhos in random places in the interior of the array
		Mho.set(ps);

		//Sets the Smiley Face (User) in random places in the interior of the array
		SmileyFace.set(ps);

		//Prints the positional array in the console (Game Board)
		printps();

		//Set's the size of the window, large enough for board + key
		setSize(850,700);
		
		//KEY LISTENER
		addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				//do nothing, part of interface so keep it
			}

			//Moves SmileyFace a certain direction when a specified key is pressed, then Mho's move
			//Note: Only runs when SmileyFace is alive, else, game over
			@Override
			public void keyPressed(KeyEvent e) {
				
				//Takes the character of the key pressed
				char key = e.getKeyChar();
				
				//If the reset screen is shown and the key P is pressed, then the game resets
				if (resetReady == true && key == 'p') {
					
					//resets the game
					reset();
					
					//sets the user to alive by setting the boolean alive to true
					alive = true;
					
					//Sets the resetReady boolean back to false
					resetReady = false;
					
					//Reruns the paint method with the new position array
					repaint();
				}
				
				//If the user is not alive, only P can be pressed to reset the game, any other key has no action
				if (!alive) return;
					
				//Performs the appropriate action depending on the key
				keyTurn(key);
			}
			
			//Performs a reset on the board as a whole when the key 'p' is pressed and resetReady is true
			public void reset() {
				
				//Sets the position array with an x in each position
				setps();
				
				//Sets the fences in random places in the interior of the array
				Fence.set(ps);

				//Sets the Mhos in random places in the interior of the array
				Mho.set(ps);

				//Sets the Smiley Face (User) in random places in the interior of the array
				SmileyFace.set(ps);
				
				//Sets the number of turns equal to 0
				turns = 0;
			}
			
			//Performs the corresponding actions for each key
			public void keyTurn (char key) {
				
				//stay
				if (key == 's') {
					
					//Moves the mhos accordingly
					mhosMove(Mho.mpa);
					
					//Runs the turns, checks if the Mhos died, prints the game board, and repaints
					forEachTurn();
					
				//move left
				} else if (key == 'a') {
					moveOrDie(0, -1);
					
				//move right
				} else if (key == 'd') {
					moveOrDie(0, 1);
					
				//move up
				} else if (key == 'w') {
					moveOrDie(-1, 0);

				//move down
				} else if (key == 'x') {
					moveOrDie(1, 0);
					
				//move right-diagonal-down
				} else if (key == 'c') {
					moveOrDie(1, 1);

				//move left-diagonal-up
				} else if (key == 'q') {
					moveOrDie(-1, -1);

				//move left-diagonal-down
				} else if (key == 'z') {
					moveOrDie(1, -1);

				//move right-diagonal-up
				} else if (key == 'e') {
					moveOrDie(-1, 1);

				//jump
				} else if (key == 'j') {
					jump();
					
				}
					
			}
			
			//Runs each operation needed after the end of the turn to implement the changes made
			public void forEachTurn() {
				
				//Tells the user they have performed a valid turn by increasing the number of turns by 1
				turns++;
				
				//Checks to see if all of the Mho's are dead
				allMhoDead = cMhoDead(Mho.mpa);
				
				//Prints the game board on the console
				printps();
				
				//Reruns the paint method
				repaint();
			}
			
			//Takes the translation given by the key and applies it, after determining if the user will still be alive
			public void moveOrDie(int ymove, int xmove) {
				
				//Determines whether the user is still alive, and if it is, SmileyFace.move moves the user to their new place 
				alive = SmileyFace.move(ymove, xmove, ps);
				
				//Sets the dieReason if the user moves into an occupied space
				if (!alive) {
					dieReason = "you ran into something!";
				}
				
				//Moves the mhos with the new user place
				mhosMove(Mho.mpa);
				
				//Runs the turns, checks if the Mhos died, prints the game board, and repaints
				forEachTurn();
				
				
			}
			
			//Relocates SmileyFace to a randomized place on the board
			public void jump() {
				
				//Determines whether the user is still alive, and if it is, SmileyFace.reseet moves the user to their new place 
				alive = SmileyFace.reset(ps);
				
				//Sets the die reason if the user landed on an mho
				if (!alive) {
					dieReason = "you landed on an mho!";
				}
				
				//Runs the turns, checks if the Mhos died, prints the game board, and repaints
				forEachTurn();
			}
			
			
			//Checks if the mhos are dead by iterating through mpa and checking whether all the coordinates are 0 (dead)
			public boolean cMhoDead(int[][] mpa) {
				for(int i = 0; i < mpa.length; i++) {
					for(int j = 0; j < mpa.length; j++) {
						if(mpa[i][0] != 0 && mpa[i][1] != 0) {
							return false;
						}
					}
				}
				return true;
			}
			
			//Mho's move in a specific order based on difference in location from the SmileyFace
			public void mhosMove(int[][] mpa) {
				
				//Runs through the x and y coordinates of each of the 12 mho's
				for (int i = 0; i < 12; i++) {
					
					//the boolean for determining if the mho's turn is finished
					boolean mhoMove = false;
					
					//sets y and x as the coordinates of a specific mho given by the mpa array
					int y = mpa[i][0];
					int x = mpa[i][1];
					
					//After confirming that both coordinates are not set to 0 (the mhos are not dead)
					if (y != 0 && x != 0) {
 									
					//checks equal vertical
					if (x == SmileyFace.x && mhoMove == false){
						if (y > SmileyFace.y) {
							if (ps[y-1][x].equals("x") || ps[y-1][x].equals("S")) {
								ps[y][x] = "x";
								ps[y-1][x] = "M";
								y -= 1;
							} else {
								ps[y][x] = "x";
								x = 0;
								y = 0;
							}
							mhoMove = true;
						} else if (y < SmileyFace.y){
							if (ps[y+1][x].equals("x") || ps[y+1][x].equals("S")) {
								ps[y][x] = "x";
								y += 1;
								ps[y][x] = "M";
							} else {
								ps[y][x] = "x";
								x = 0;
								y = 0;
							}
							mhoMove = true;
						}
					}
					
					//checks equal horizontal
					if (y == SmileyFace.y && mhoMove == false) {
						if(x > SmileyFace.x) {
							if (ps[y][x-1].equals("x") || ps[y][x-1].equals("S")) {
								ps[y][x] = "x";
								ps[y][x-1] = "M";
								x -= 1;
							} else {
								ps[y][x] = "x";
								x = 0;
								y = 0;
							}
							mhoMove = true;
						} else if (x < SmileyFace.x){
							if (ps[y][x+1].equals("x") || ps[y][x+1].equals("S")) {
								ps[y][x] = "x";
								ps[y][x+1] = "M";
								x += 1;
							} else {
								ps[y][x] = "x";
								x = 0;
								y = 0;
							}
							mhoMove = true;
						}
					} 	 	
					//diagonal left
					if (x > SmileyFace.x && mhoMove == false) {
						//up
							if(y > SmileyFace.y) {
								if (ps[y-1][x-1].equals("x") || ps[y-1][x-1].equals("S")) {
									ps[y][x] = "x";
									ps[y-1][x-1] = "M";
									x -= 1;
									y -= 1;
									mhoMove = true;
								} 

							} 
							//down
							else if (y < SmileyFace.y) {
								if (ps[y+1][x-1].equals("x") || ps[y+1][x-1].equals("S")) {
									ps[y][x] = "x";
									ps[y+1][x-1] = "M";
									x -= 1;
									y += 1;
									mhoMove = true;
								} 
							}
					} 
//						//diagonal right 
					if(x < SmileyFace.x && mhoMove == false) {
							//up
							if(y > SmileyFace.y) {
								if (ps[y-1][x+1].equals("x") || ps[y-1][x+1].equals("S")) {
									ps[y][x] = "x";
									ps[y-1][x+1] = "M";
									x += 1;
									y -= 1;
									mhoMove = true;
								} 
							} 
							//down
							else if (y < SmileyFace.y) {
								if (ps[y+1][x+1].equals("x") || ps[y+1][x+1].equals("S")) {
									ps[y][x] = "x";
									ps[y+1][x+1] = "M";
									x += 1;
									y += 1;
									mhoMove = true;
								}
							}
							
					}
//						//Horizontal >= vertical, move horizontal
					if (Math.abs(SmileyFace.x - x) >= Math.abs(SmileyFace.y - y) && mhoMove == false)  {
							if(x > SmileyFace.x) {
								if (ps[y][x-1].equals("x") || ps[y][x-1].equals("S")) {
									ps[y][x] = "x";
									ps[y][x-1] = "M";
									x -= 1;
									mhoMove = true;
								} else {
									ps[y][x] = "x";
									x = 0;
									y = 0;
								}
							} else if (x < SmileyFace.x){
								if (ps[y][x+1].equals("x") || ps[y][x+1].equals("S")) {
									ps[y][x] = "x";
									ps[y][x+1] = "M";
									x += 1;
									mhoMove = true;
								} else {
									ps[y][x] = "x";
									x = 0;
									y = 0;
								}
							} 
							
					} 
//						//Horizontal < vertical, move vertical 
					if (Math.abs(SmileyFace.y - y) > Math.abs(SmileyFace.x - x) && mhoMove == false) {
							if(y > SmileyFace.y) {
								if (ps[y-1][x].equals("x") || ps[y-1][x].equals("S")) {
									ps[y][x] = "x";
									ps[y-1][x] = "M";
									y -= 1;
									mhoMove = true;
								} else {
									ps[y][x] = "x";
									x = 0;
									y = 0;
								}
							} else if (y < SmileyFace.y){
								if (ps[y+1][x].equals("x") || ps[y+1][x].equals("S")) {
									ps[y][x] = "x";
									ps[y+1][x] = "M";
									y += 1;
									mhoMove = true;
								} else {
									ps[y][x] = "x";
									x = 0;
									y = 0;
								}
							}
					}

				}
							
					if (x == SmileyFace.x && y == SmileyFace.y) {
						alive = false;
						dieReason = "an mho ate you!";
					}
					
				
					mpa[i][0] = y;
					mpa[i][1] = x;
					
					}
				
		}

			@Override
			public void keyReleased(KeyEvent e) {
				//do nothing
			}

		});
	}

	//Runs paint method embedded in java JFrame class that reruns paint, over and over, among other things
	@Override
	public void paint(Graphics g) {

		//Deletes the past graphics "painted" on
		super.paint(g);
		
		//Legend Bar
		g.setColor(Color.gray.darker());
		g.fillRect(600, 201, 151, 5);

		//Sets font-size, color, and position of Legend
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.setColor(Color.white);
		g.drawString("Legend", 600, 200);
		
		
		//Variables for legend
		int widthobj = 635;
		int heightobj = 265;
		
		//Sets font-size, color, and position of labeled objects
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		//Sets the mho icon and text for the legend
		mhoIcon(5, 14, g);
		g.drawString(" = Mho", widthobj, heightobj);

		//Sets the fence icon and text for the legend
		fenceIcon(6, 14, g);
		g.drawString(" = Fence", widthobj, heightobj + 40);
		
		//Sets the smiley face icon and text for the legend
		sfIcon(7, 14, g);
		g.drawString(" = User", widthobj, heightobj + 80);
	
		//Width of the keys for the corresponding actions for each of the letters on the keyboard graphics 
		int widthkey1 = 560;
		int widthkey2 = 600;
		int widthkey3 = 640;
		

		//Height of the keys for the corresponding actions for each of the letters on the keyboard graphics 
		int heightkeys1 = 50;
		int heightkeys2 = 315;
		int heightkeys3 = 450;
		
		//Sets font-size, color, and position of labeled keys 
		g.setColor(Color.white);
		
		g.drawString("Q = left-diagonal-up", heightkeys1, widthkey1);
		g.drawString("A = left", heightkeys1, widthkey2);
		g.drawString("Z = left-diagonal-down", heightkeys1, widthkey3);
		
		g.drawString("W = up", heightkeys2, widthkey1);
		g.drawString("S = stay", heightkeys2, widthkey2);
		g.drawString("X = down", heightkeys2, widthkey3);
		
		g.drawString("E = right-diagonal-up", heightkeys3, widthkey1);
		g.drawString("D = right", heightkeys3, widthkey2);
		g.drawString("C = right-diagonal-down", heightkeys3, widthkey3);

		g.drawString("*J = jump*", 625, 600);
		g.drawString("Turns = " + turns, 625, 75);

		
		
		//Prints the game board
		pBoard(g);
		g.translate(3, 4);
		
		//Presents the game over screen and resets the neccessary variables after the user loses and alive is false
		gameOver(g);
		
		//Presents the you won screen and resets the neccessary variables after the user wins and alive is true
		youWon(g);

	}
	
	//Game over 
	public void gameOver(Graphics g){
		
		//Only if the user has died...
		if (alive == false) {
			
			//Sets the game over screen
			g.setColor(darkBlue);
			g.fillRect(0, 0, 850, 700);
			g.setColor(Color.white);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 125));
			g.drawString("GAME OVER", 50, 225);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g.drawString("Press 'P' to play again", 200, 350);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			g.drawString("You died because " + dieReason, 205, 400);
			
			//Resets the neccessary variable
			resetReady = true;
		}
	}
	
	//Returns a you won screen and allows the user to press P to play again
	public void youWon(Graphics g) {
		
		//Only if the user is alive and all of the mhos are dead
		if (alive == true && allMhoDead == true) {
			
			//Sets the you won screen
			g.setColor(yellow);
			g.fillRect(0, 0, 850, 700);
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 125));
			g.drawString(" YOU WON!!", 50, 225);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g.drawString("Press 'P' to play again", 200, 350);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			g.drawString("You took " + turns + " turns to complete the game!", 180, 425);
			
			//Resets the necessary variables
			resetReady = true;
			allMhoDead = false;
		}
	}

	//Prints game board in the console
	public static void pBoard(Graphics g) {
		g.setColor(Color.WHITE);

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				g.fillOval((j + 1) * 40, (i + 1) * 40, 40, 40);
				checkSpot(i, j, g);
				g.setColor(Color.WHITE);
			}
		}
	}

	//Adds Mho's, Fence's, and the SmileyFace to the displayed board
	public static void checkSpot(int i, int j, Graphics g) {

		if (ps[i][j].equals("F")) {
			fenceIcon(i, j, g);
		} else if (ps[i][j].equals("M")) {
			mhoIcon(i, j, g);
		} else if (ps[i][j].equals("S")) {
			sfIcon(i, j , g);
		}

	}
	
	public static void fenceIcon(int i, int j, Graphics g) {
		
		//Fence base
		g.setColor(purple);
		g.fillRect(((j + 1) * 40 + 7), ((i + 1) * 40 + 7), 25, 25);
		
		//Sets the first triangular tops of the fence icon
		g.setColor(brown);
		int[] x1 = {(j + 1) * 40 + 7, (j + 1) * 40 + 12, (j + 1) * 40 + 17};
		int[] y1 = {(i + 1) * 40 + 15, (i + 1) * 40 + 10, (i + 1) * 40 + 15};

		g.fillPolygon(x1, y1, 3);
		
		int[] x2 = {(j + 1) * 40 + 22, (j + 1) * 40 + 27, (j + 1) * 40 + 32};
		int[] y2 = {(i + 1) * 40 + 15, (i + 1) * 40 + 10, (i + 1) * 40 + 15};

		g.fillPolygon(x2, y2, 3);
		
		//Sets the vertical components of the fence icon
		g.fillRect(((j + 1) * 40 + 7), ((i + 1) * 40 + 15), 10, 17);
		g.fillRect(((j + 1) * 40 + 22), ((i + 1) * 40 + 15), 10, 17);
		
		//Sets the horizontal components of the fence icon
		g.fillRect(((j + 1) * 40 + 7), ((i + 1) * 40 + 18), 15, 3);
		g.fillRect(((j + 1) * 40 + 7), ((i + 1) * 40 + 26), 15, 3);
		
		//resets the fence color (for text)
		g.setColor(purple);
	}
	
	public static void mhoIcon(int i, int j, Graphics g) {
		
		//Mho base
		g.setColor(blue);
		g.fillRect(((j + 1) * 40 + 7), ((i + 1) * 40 + 7), 25, 25);
		
		//Mho ghost body
		g.setColor(darkBlue);
		g.fillOval(((j + 1) * 40 + 11), ((i + 1) * 40 + 8), 16, 16);
		g.fillRect(((j + 1) * 40 + 11), ((i + 1) * 40 + 16), 16, 10);
		
		//Mhos triangle ghost part
		int[] x1 = {(j + 1) * 40 + 11, (j + 1) * 40 + 13, (j + 1) * 40 + 15};
		int[] y1 = {(i + 1) * 40 + 26, (i + 1) * 40 + 30, (i + 1) * 40 + 26};

		g.fillPolygon(x1, y1, 3);
		
		int[] x2 = {(j + 1) * 40 + 15, (j + 1) * 40 + 17, (j + 1) * 40 + 19};
		int[] y2 = {(i + 1) * 40 + 26, (i + 1) * 40 + 30, (i + 1) * 40 + 26};

		g.fillPolygon(x2, y2, 3);
		
		int[] x3 = {(j + 1) * 40 + 19, (j + 1) * 40 + 21, (j + 1) * 40 + 23};
		int[] y3 = {(i + 1) * 40 + 26, (i + 1) * 40 + 30, (i + 1) * 40 + 26};

		g.fillPolygon(x3, y3, 3);
		
		int[] x4 = {(j + 1) * 40 + 23, (j + 1) * 40 + 25, (j + 1) * 40 + 27};
		int[] y4 = {(i + 1) * 40 + 26, (i + 1) * 40 + 30, (i + 1) * 40 + 26};

		g.fillPolygon(x4, y4, 3);
		
		//Mho's Eyes
		g.setColor(Color.white);
		g.fillOval((j + 1) * 40 + 15, (i + 1) * 40 + 12, 8, 8);
		g.setColor(Color.black);
		g.fillOval((j + 1) * 40 + 17, (i + 1) * 40 + 14, 4, 4);
		
		//resets the mho color (for text)
		g.setColor(blue);
	}
	
	public static void sfIcon(int i, int j, Graphics g) {
		
		//Sets the user icon
		g.setColor(pink);
		g.fillRect(((j + 1) * 40 + 7), ((i + 1) * 40 + 7), 25, 25);
		
		//Sets the outside white of the user's eyes
		g.setColor(Color.white);
		g.fillOval((j + 1) * 40 + 11, (i + 1) * 40 + 12, 6, 11);
		g.fillOval((j + 1) * 40 + 22, (i + 1) * 40 + 12, 6, 11);
		
		//Sets the inside black of the user's eyes
		g.setColor(Color.black);
		g.fillOval((j + 1) * 40 + 13, (i + 1) * 40 + 14, 3, 6);
		g.fillOval((j + 1) * 40 + 24, (i + 1) * 40 + 14, 3, 6);
		
		g.drawLine((j + 1) * 40 + 14, (i + 1) * 40 + 27, (j + 1) * 40 + 26, (i + 1) * 40 + 27);
		
		//resets the user color (for text)
		g.setColor(pink);
	}

	

	//Sets the position array to all x's
	public static void setps() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				ps[i][j] = "x";
			}
		}
	}

	//Prints the position array onto the console
	public static void printps() {
		
		System.out.println("Your game board looks like: ");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(ps[i][j]);
			}
			System.out.println("");
		}
	}
	
}