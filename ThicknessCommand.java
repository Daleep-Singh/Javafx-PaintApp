package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * Command for selecting line thickness
 */
public class ThicknessCommand implements DrawCommand {
	
	private View view;

	public ThicknessCommand(View view) {
		this.view = view;

	}
	
	public void execute(GraphicsContext g) {
		this.view.getPaintPanel().setThickness(this.view.getThicknessChooserPanel().getThickness());
	}
}
