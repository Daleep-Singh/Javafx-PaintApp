package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;


/**
 * This class is responsible for taking a polyline object and drawing a line between the points
 * that define a polyline. This class is apart of the command design pattern
 * and is used by the factory design pattern
 * 
 *
 */
public class PolyLineCommand implements DrawCommand{

		private PolyLine polyline;
		public PolyLineCommand(PolyLine p) { 
			this.polyline = p;
		}
		
		
	public void execute(GraphicsContext g) {
		//if the mouse is not being dragged
		try {
				if (polyline.getPoints().size() >= 2) {
						for (int i = 0 ; i < polyline.getPoints().size()-1;i++) {
							Point p1 = polyline.getPoints().get(i);
							Point p2 = polyline.getPoints().get(i+1);
							
							g.setLineWidth(polyline.getLineWidth());
							if (polyline.isStroke()) {
								g.setStroke(polyline.getColor());
								g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
								}
							g.setLineWidth(1.0);
						}
							}
						}
		//handles an error when the mouse is dragged
		catch (NullPointerException e) {
			
		}
					}
				}
			
			

	