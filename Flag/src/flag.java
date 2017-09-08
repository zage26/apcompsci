//US FLAG

import java.awt.*;
import javax.swing.JFrame;

public class flag extends JFrame {
	
	//Arrays used to place coordinates of star found in star method
	private int [ ] x1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	private int [ ] y1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

	//Took original star, center (100,100) w/ radius 23, subtracted 100 from every point and divided
	//the point by radius of 23, so now star has radius 1 and the points are based around origin (0,0)
	//Thus, this allows you, with the use of the stars method below to place the stars anywhere 
	//you would like 
	private double [ ] xg = {0.0/23.0, -7.0/23.0, -23.0/23.0, -12.0/23.0, -14.0/23.0, 0.0/23.0, 14.0/23.0, 12.0/23.0, 23.0/23.0, 7.0/23.0};
	private double [ ] yg = {-25.0/23.0, -10.0/23.0, -8.0/23.0, 4.0/23.0, 20.0/23.0, 12.0/23.0, 20.0/23.0, 4.0/23.0, -8.0/23.0, -10.0/23.0};


	public flag () {
		init();
	}

	public void init() {
		setSize(900,600);
		repaint();
	}
	
	//Parts of Flag
	//Dimensions are multiplied by 400
	public void paint(Graphics g) {
	
	//Deletes the past graphics "painted" before hand, and repaints 
	super.paint(g);
	
	//SCALING VARIABLES
	
	//Preset dimensions of the window (what we set the size too)
	double ww = 900;
	double wh = 600;
	
	//Current dimensions of the window
	double width = this.getWidth();
	double height = this.getHeight();
	
	//The ratio/scale factor of the current window to the preset/flag one
	double sfw = (width/ww);
	double sfh = (height/wh);
	
	//The average of the two ratios, to get the scale factor for both height and width
	double sf = ((sfw + sfh)/2);
		
	//RED BACKGROUND
	
	//Cable No. 70180 Old Glory Red Color
	g.setColor(new Color(191, 13, 62));
	
	//Red Background Coordinates with Scale Factor
	int rx = (int)(50*sf);
	int ry = (int)(100*sf);
	
	//Red Background Dimensions with Scale Factor
	int rw = (int)(760*sf);
	int rh = (int)(400*sf);
	
	//Drawing of Red Background
	g.fillRect(rx, ry, rw, rh);
	
	//WHITE RECTANGLES
	
	//Cable No. 70001 White Color
	g.setColor(new Color(255, 255, 255));
	
	//White Rectangles Coordinates with Scale Factor
	int wrx = (int)(50*sf);
	int wry = (int)(131*sf);
	
	//White Rectangles Dimensions with Scale Factor
	int wrw = (int)(760*sf);
	int wrh = (int)(31*sf);
	
	//Drawing of White Rectangles
	for (int i = 0; i < 6; i++) {
		g.fillRect(wrx, (int)(wry + (62*sf*i)), wrw, wrh);
	}
	
	//BLUE UNION
	
	//Cable No. 70075 Old Glory Blue
	g.setColor(new Color(4, 30, 66));
	
	//Blue Union/Background Coordinates with Scale Factor
	int ux = (int)(50*sf);
	int uy = (int)(100*sf);
	
	//Blue Union/Background Dimensions with Scale Factor
	int uw = (int)(304*sf);
	int uh = (int)(217*sf);
	
	//Drawing of Blue Union/Background
	g.fillRect(ux, uy, uw, uh);
	
	//WHITE STARS
	
	//Cable No. 70001 White
	g.setColor(new Color(255, 255, 255));
	
	//White star Radius with Scale Factor
	double radius = 12.32 * sf;
	
	//White star Coordinates with Scale Factor
	double scx = ux + (sf*25.2);
	double scy = uy + (sf*21.6);
	
	//White star (amount of movement on x and y axis) Dimensions with Scale Factor
	double movex = (50.4*sf);
	double movey = (21.6*sf);
	
	//Drawing of the first white star on the US flag
	stars(radius, scx, scy);
	
	//Five rows of six forward most stars 
	for (int i = 0; i < 6; i++) {
		//Nine rows of stars in total
		for (int j = 0; j < 9; j++) {
			//Creates five rows of six stars like the first row on the US flag 
			if (j % 2 == 0) {
				stars(radius, scx + (movex*i), scy + (movey*j));
				g.fillPolygon(x1, y1, 10);
			//Creates five rows of five stars like the second row on the US flag 
			} else if (i != 5){
				stars(radius, scx + ((movex*(i)) + (25.2*sf)), scy + (movey*j));
				g.fillPolygon(x1, y1, 10);
			}
		}
	}
}

	//Method for finding coordinates of a star given correct arguments
	public void stars(double radius, double starcenter_x, double starcenter_y) {
		//Assigns indexes of arrays given above to coordinates of star based on given radius center (0,0) 
		for (int i = 0; i < 10; i++) {
			x1[i] = (int)(xg[i] * radius);
			y1[i] = (int)(yg[i] * radius);
		}
		//Re-assigns indexes of arrays given above to coordinates of star by adjusting the center of the star properly 
		for (int i = 0; i < 10; i++) {
			x1[i] = (int)(x1[i] + starcenter_x);
			y1[i] = (int)(y1[i] + starcenter_y);
		}
	}

}