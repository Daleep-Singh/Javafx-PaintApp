package ca.utoronto.utm.paint;


import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
/**
 * This class allows the creation of a CircleCommand, which is a type of DrawCommand specific to drawing a Circle.
 * @author amit
 *
 */
public class CircleCommand implements DrawCommand{

	private Circle circle;
	
	/**
	 * 
	 * @param c  : the circle intended to be drawn
	 */
	public CircleCommand(Circle c) {
		this.circle = c;
	}
	
	/**
	 * Draws the circle.
	 * @param g : the GraphicsContext where the circle will be drawn.
	 */
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		
		
			int x = circle.getCentre().getX();
			int y = circle.getCentre().getY();
			int radius = circle.getRadius();
		
			g.setLineWidth(circle.getLineWidth());
			if (circle.isStroke()) {
				g.setStroke(circle.getColor());
				g.strokeOval(x-radius, y-radius, radius*2, radius*2);
			}
			
			else {
				g.setFill(circle.getColor());
				g.fillOval(x-radius, y-radius, radius*2, radius*2);
			}
			g.setLineWidth(1.0);
		
		
		
		
	}

}
