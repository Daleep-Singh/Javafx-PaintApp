package ca.utoronto.utm.paint;
/**
 * This class creates a point which is used in shapes to keep track of co-ordinates.
 * @author amit
 *
 */
public class Point {
	private int x;
	private int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return (String) "(" + this.x + ", " + this.y + ")";
	}
}
