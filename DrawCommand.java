package ca.utoronto.utm.paint;


import javafx.scene.canvas.GraphicsContext;
/**
 * General draw command interface that is implemented by 'Shape'Command's
 * @author amit
 *
 */
public interface DrawCommand {

	public abstract void execute(GraphicsContext g);
}
