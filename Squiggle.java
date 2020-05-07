package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Squiggle extends Shape {
	

	private ArrayList<Point> points;

	public Squiggle(ArrayList<Point> points, Double lineWidth, Color color) {
		super(lineWidth, color, true);
		this.points = points;
	}
	
	

	public ArrayList<Point> getPoints(){
		return this.points;
	}



}
