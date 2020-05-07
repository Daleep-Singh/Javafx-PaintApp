package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
/**
 * This class creates a color command which works with the color chooser command to set the current color of the paint panel.
 * @author amit
 *
 */
public class ColorCommand implements DrawCommand{
	
	private View view;
	public ColorCommand(View view) {
		this.view = view;
		
	}
	
	public void execute(GraphicsContext g) {
		this.view.getPaintPanel().setColor(this.view.getColorChooserPanel().getColor());
	}
}
