package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
/**
 * This class allows the creation of an instance of Triangle.
 * @author amit
 *
 */
public class Triangle extends Shape {

	private Point initial;
	private Point endPoint;

	public Triangle(Color color, boolean isStroke, Double thickness, Point initial, Point endPoint) {
		super(thickness, color, isStroke);
		this.initial = initial;
		this.endPoint = endPoint;
		
	}
	
	public Point getInitial() {
		return this.initial;
	}
	public Point getEndPoint() {
		return this.endPoint;
	}


}
