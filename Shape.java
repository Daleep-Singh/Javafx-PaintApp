package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
/**
 * This class allows the user to create an instance Shape, a shape contains the data of line thickness, color, and if it is meant to be stroked or filled.
 * @author amit
 *
 */
public abstract class Shape {
	/** 
	 * Line width for all shapes
	 */
	protected Double lineWidth;
	private Color color;
	private boolean stroke;
	
	public Shape(Double lineWidth, Color color, boolean stroke) {
		this.lineWidth = lineWidth;
		this.color = color;
		this.stroke =stroke;
	}
	
	/**
	 * 	
	 * @return
	 */
	public Double getLineWidth() {
		
		return this.lineWidth;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean isStroke() {
		return this.stroke;
	}
	
	public void setToStroke(boolean s) {
		this.stroke = s;
	}
}
	
