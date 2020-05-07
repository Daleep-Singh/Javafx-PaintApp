package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * This StrokeCommand is actually the command for both stroke Command and fill command.
 * This was done to satisfy the way that the stroke/fill was originally implemented.
 *
 */
public class StrokeCommand implements DrawCommand {
	
	private View view;
	public StrokeCommand(View view) {
		this.view = view;
	}
	
	public void execute(GraphicsContext g) {
		view.getPaintPanel().setStroke(view.getStrokeUserPanel().getToggleGroup().getSelectedToggle().getUserData() == "Stroke");	
	}
}
