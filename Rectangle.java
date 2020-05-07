package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;


public class Rectangle extends Shape {
	private Point corner;
	private int width;
	private int height;
	
	public Rectangle(Color color, boolean isStroke, Double thickness, Point initial, Point endPoint) {
		super(thickness, color, isStroke);
		this.width = Math.abs(initial.getX() - endPoint.getX());
		this.height = Math.abs(initial.getY() - endPoint.getY());
		this.corner = initial;
		
		
		if (initial.getX() < endPoint.getX() && initial.getY() < endPoint.getY()) {
			this.corner = initial;
		}
		
		else if (initial.getX() < endPoint.getX() && initial.getY() > endPoint.getY()) {
			this.corner = new Point(initial.getX(), initial.getY() - height);
		}
		
		else if (initial.getX() > endPoint.getX() && initial.getY() > endPoint.getY()) {
			this.corner = new Point(initial.getX() - width, initial.getY() - height);
		}
	
		else if (initial.getX() > endPoint.getX() && initial.getY() < endPoint.getY()) {
			this.corner = new Point(initial.getX() - width, initial.getY());
		}
		
	
	}
	public void setCorner(Point NewCorner) {
		this.corner = NewCorner;
	}
	public Point getCorner(){
		return this.corner;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getheight() {
		return this.height;
	}

	
}
