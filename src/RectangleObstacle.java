
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class RectangleObstacle implements Shapes
{
	private int myX;
	private int myY;
	private int myXvelocity;
	private int mySize;
	private Color myColor;
	private int myWidth;
	private int myHeight;
	private Rectangle2D myRectangle;
	private Color[] allColors = {Color.red, Color.blue, Color.green};


	public RectangleObstacle(int MAXSIZE, int MAXVELOCITY, int width, int height)
	{

		myX=((int)(Math.random()*width));
		myY= height;
		myXvelocity = MAXVELOCITY;
		mySize = MAXSIZE;
		myColor = allColors[(int)(Math.random()*allColors.length)];
		myRectangle = new Rectangle(myHeight,myWidth, myX, myY);
	}

	public Rectangle2D getRectangle()
	{
		return myRectangle;
	}
	public Color getColor() {
		return myColor;
	}

	public void setColor(Color color) {
		this.myColor = color;
	}

	public int getX() {
		return myX;
	}

	public void setX(int x) {
		this.myX = x;
	}

	public int getY() {
		return myY;
	}

	public void setY(int y) {
		this.myY = y;
	}

	public int getXvelocity() {
		return myXvelocity;
	}

	public void setXvelocity(int xvelocity) {
		this.myXvelocity = xvelocity;
	}

	public void updateX() {
		this.myX+=this.myXvelocity;
	}
	public void reverseXvelocity() {
		this.myXvelocity=-this.myXvelocity;
	}

	public int getSize(){
		return mySize;
	}
	public void setSize(int size){
		this.mySize=size;
	}

	public Ellipse2D getCircle() {
		return null;
	}
}