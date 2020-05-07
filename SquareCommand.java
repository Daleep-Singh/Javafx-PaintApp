package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public class SquareCommand implements DrawCommand{
	private Square square;
	
	public SquareCommand(Square s) {
		this.square = s;
	}
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		
			int x = square.getCorner().getX();
			int y = square.getCorner().getY();
			g.setLineWidth(square.getLineWidth());
			
			if (square.isStroke()) {
				g.setStroke(square.getColor());
				g.strokeRect(x, y,square.getWidth(), square.getheight());
			}
			else {
				g.setFill(square.getColor());
				g.fillRect(x, y,square.getWidth(), square.getheight());
			}
			g.setLineWidth(1.0);
		
	}
}
