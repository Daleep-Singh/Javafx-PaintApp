package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
/**
 * This class allows the user to create an instance of Circle, which is a subclass of type Shape.
 * @author amit
 *
 */
public class Circle extends Shape {
	
	private Point centre;
	private int radius;


	/**
	 * 
	 * @param color		Circle's color
	 * @param isStroke	boolean value of if the Circle is meant to be outlined, rather than filled.
	 * @param thickness thickness of Circle's outline
	 * @param initial	Circles initial point (which becomes the center)
	 * @param endPoint	endpoint of user's drag which is used to calculate the radius of the circle
	 */
	public Circle(Color color, boolean isStroke, Double thickness, Point initial, Point endPoint) {
		super(thickness, color, isStroke);
		this.centre = initial;
		this.radius = (int) Math.abs(Math.sqrt(Math.pow((endPoint.getX()-this.centre.getX()),2)+(Math.pow((endPoint.getY()-this.centre.getY()),2))));
	}
	/**
	 * 
	 * @return The center of the circle.
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * Sets a new centre for the circle.
	 * @param centre
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	/**
	 * 
	 * @return radius of the circle.
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * Sets a new radius for the circle.
	 * @param radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

}
