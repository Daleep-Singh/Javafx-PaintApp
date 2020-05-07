package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class SquiggleCommand implements DrawCommand{

	
	/**
	   should just draw a SINGLE SQUIGGLE. 
	 * (should hold the state for drawing a single squiggle
	 *  not all of them).
	 */
	

	/** squiggle should be just two points**/
	private Squiggle squiggle;
	
	
	public SquiggleCommand(Squiggle s) {
		
		this.squiggle = s;
	}
	
	@Override
	public void execute(GraphicsContext g) {
		ArrayList<Point> points = this.squiggle.getPoints();
		int i = 0;
		g.setStroke(squiggle.getColor());
		g.setLineWidth(squiggle.getLineWidth());
		while (i < points.size() -1) {
			Point firstPoint = points.get(i);
			Point secondPoint = points.get(i + 1);
			g.strokeLine(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
			i++;
		}
		
	}
	
}
