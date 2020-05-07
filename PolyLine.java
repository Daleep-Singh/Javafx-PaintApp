package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * 
 * This is a polyline, it contains a sequence of points as well as its various attributes (color,line thickness, etc)
 * 
 *
 */
public class PolyLine extends Shape {
	private Point initial;
	private Point endPoint;
	private static ArrayList<Point> points = new ArrayList<Point>();
	
	public PolyLine(Color color, boolean isStroke, Double thickness, Point initial, Point endPoint) {
		super(thickness, color, true);
		this.initial = initial;
		this.endPoint = endPoint;
		PolyLine.points.add(endPoint);
		
	}


	public Point getInitial() {
		return this.initial;
	}
	public void setInitial(Point s) {
		this.initial = s;
	}
	public Point getEndPoint() {
		return this.endPoint;
	}
	public void setEndPoint(Point s) {
		this.endPoint = s;
	}
	
	public ArrayList<Point> getPoints(){
		return PolyLine.points;
	}

}
