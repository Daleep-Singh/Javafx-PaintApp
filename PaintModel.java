package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.shape.PathElement;

public class PaintModel extends Observable {

	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	private ArrayList<DrawCommand> drawCommands = new ArrayList<DrawCommand>();
	private ArrayList<DrawCommand> modifierCommands = new ArrayList<DrawCommand>();

	public void addPoint(Point p) {
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void addCircle(Circle c) {
		this.circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	
	public void addRectangle(Rectangle r) {
		this.rectangles.add(r);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Rectangle> getRectangles(){
		return rectangles;
	}

	public ArrayList<DrawCommand> getDrawCommands() {
		// TODO Auto-generated method stub
		return this.drawCommands ;
	}
	
	public void addModifierCommand(DrawCommand d) {
		this.modifierCommands.add(d);
	}
	public ArrayList<DrawCommand> getModifierCommands(){
		return this.modifierCommands;
	}
}
