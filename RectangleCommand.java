package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
/**
 * Responsible for the logic to draw a rectangle
 * @author amit
 *
 */
public class RectangleCommand implements DrawCommand {
	
	private Rectangle rectangle;
	public RectangleCommand(Rectangle r) {
		this.rectangle = r;
	}
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		
			int x = rectangle.getCorner().getX();
			int y = rectangle.getCorner().getY();
			g.setLineWidth(rectangle.getLineWidth());
			
			if (rectangle.isStroke()) {
				g.setStroke(rectangle.getColor());
				g.strokeRect(x, y,rectangle.getWidth(), rectangle.getheight());
			}
			else {
				g.setFill(rectangle.getColor());
				g.fillRect(x, y,rectangle.getWidth(), rectangle.getheight());
			}
			g.setLineWidth(1.0);
		
	}

}
