/**
 * Name: Anuj Kothari	
 * Date: May 11th
 * Project: Don'tTouchTheObstacle
 * Description: Try to move an object across the screen without touching the obstacles
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

public class Game extends Applet implements KeyListener 
{

	private final int DELAY = 150;
	private final int MAXSIZE = 60;
	private final int MAXRECTANGLES =7;
	private  int MAXVELOCITY =5;	
	private RectangleObstacle[] allObstacles;
	private int xPos =(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2; 
	private int yPos = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150;
	Ellipse2D circle = new Circle(xPos, yPos, 20,20).getCircle();
	Rectangle2D rect;
	private boolean indicator = false;

	public void init() 
	{
		addKeyListener(this);
		this.resize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		allObstacles=new RectangleObstacle[MAXRECTANGLES];
		//make sure the velocity wasn't set to 0
		int vel= (int)(Math.random()*45);
		if(vel == 0)
		{
			vel= 5;
		}
		//Creates a rectangleObstacle with all the requirements to create an actual rectangle
		for(int count = 0;count < MAXRECTANGLES; count++)
		{ 	

			allObstacles[count] = new RectangleObstacle(MAXSIZE,  MAXVELOCITY * vel, this.getWidth(), count * 100);
		}

		ActionListener taskPerformer = new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				repaint();
			}
		};

		new Timer(DELAY, taskPerformer).start();
	}	

	public void paint(Graphics g) 
	{	
		Graphics2D g2 = (Graphics2D)g;
		setBackground(Color.black);
		g2.setPaint(Color.white);	
		g2.draw(circle);
		//This has all the information for the rectangle which is stored in the allObstacles array. 
		for(int count = 0;count < MAXRECTANGLES; count++)
		{ 	
			
			//Updates the velocity of the rectangle
			allObstacles[count].updateX();

			if((allObstacles[count].getX()>this.getWidth()) || (allObstacles[count].getX()<0))
			{
				//If the rectangle touches the edge of the screen, it bounces back
				allObstacles[count].reverseXvelocity(); 
			}

			g2.setPaint(allObstacles[count].getColor());	
			//Creates the actual rectangle which is painted on the screen and the fields are from the allObstacle array.
			rect =new Rectangle2D.Double(allObstacles[count].getX(), allObstacles[count].getY(), allObstacles[count].getSize() + 20, allObstacles[count].getSize());
			g2.fill(rect);
			//Method call for intersections
			checkForIntersection(g2);
			checkForWin(g2);
		}
	}
	//The movement of the circle using the keyListener
	public void keyTyped( KeyEvent e ){ }
	public void keyReleased( KeyEvent e ){ }
	public void keyPressed( KeyEvent e )  
	{  
		int n = e.getKeyCode();
		System.out.println(n);
		if(n == KeyEvent.VK_RIGHT)
		{
			xPos += 22;
			e.consume();
		}
		if(n == KeyEvent.VK_LEFT)
		{
			xPos -= 22;
			e.consume();
		}   

		if(n == KeyEvent.VK_UP)
		{

			yPos -= 22;
			e.consume();
		}
		if(n == KeyEvent.VK_DOWN)
		{

			yPos += 22;
			e.consume();
		}   
		
		circle = new Circle(xPos, yPos, 20,20).getCircle();
	}
	
	public void checkForIntersection(Graphics g)
	{
		
		for(int count = 0;count < allObstacles.length; count++)
		{
			
			// checks if the ball will hit with any of the rectangles	
			if(circle.intersects(rect))
			{
				indicator = true;
			}
		}	
		
		if(indicator == true)
		{
			//Prints out game over if the ball hit a rectangle
			g.drawString("GAME OVER!",(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
			
			//If it did hit, ball "disappears" by setting the position of the ball to (-100,-100) to show the game is over
			xPos=0;
			yPos=-100;
			
		}

	}
	
	public void checkForWin(Graphics g)
	{
		if(yPos < 0 && (xPos != 0))
		{
			g.drawString("YOU WON!",(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
		}
	}
}
