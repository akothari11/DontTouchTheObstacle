import java.awt.Color;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;




public class Circle implements Shapes 
{
	private int myX;
	private int myY;
	private int myWidth = 80;
	private int myHeight = 20;
	private Color myColor = Color.black;
	private Ellipse2D myCircle; 

	public Circle(int x, int y, int width, int height)
	{
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
		myCircle = new Ellipse2D.Double(myX,myY,myWidth,myHeight);
	}

	public Ellipse2D getCircle()
	{
		return myCircle;
	}
	 
	public int getMyX() {
		return myX;
	}

	public void setMyX(int myX) {
		this.myX = myX;
	}

	public int getMyY() {
		return myY;
	}

	public void setMyY(int myY) {
		this.myY = myY;
	}

	public int getMyWidth() {
		return myWidth;
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}

	public int getMyHeight() {
		return myHeight;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}

	public Rectangle2D getRectangle() {
	
		return null;
	}

	

}
