import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/2;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 15;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/2;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY, int scale, String dialouge)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.yellow);
		g2.fillOval(x, y, HEAD_DIMENSION/scale, HEAD_DIMENSION/scale);
		// Draw the eyes
		g2.setColor(Color.blue);
		x = catX + EYE_X/scale; 
		y = catY + EYE_Y/scale;
		g2.fillOval(x, y, EYE_WIDTH/scale, EYE_HEIGHT/scale);
		x += EYE_SEPARATION/scale;
		g2.fillOval(x, y, EYE_WIDTH/scale, EYE_HEIGHT/scale);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X/scale;
		y = catY + MOUTH_Y/scale;
		g2.fillOval(x, y, MOUTH_WIDTH/scale, MOUTH_HEIGHT/scale);
		g2.setColor(Color.black);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		if (dialouge.compareTo("") == 0) {
			g2.drawString("KILL ME", catX, catY+HEAD_DIMENSION/scale+10);	
			g2.drawString("LIFE IS PAIN", catX, catY+HEAD_DIMENSION/scale+20);
		}
		else {
			g2.drawString(dialouge, catX, catY+HEAD_DIMENSION/scale+10);
		}
	}
}
