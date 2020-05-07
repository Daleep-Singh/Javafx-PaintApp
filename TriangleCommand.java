package ca.utoronto.utm.paint;


import javafx.scene.canvas.GraphicsContext;
/**
 * This class contains the logic of drawing a triangle
 * @author amit
 *
 */
public class TriangleCommand implements DrawCommand{
	
	private Triangle triangle;
	
	public TriangleCommand(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
	
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		g.setLineWidth(triangle.getLineWidth());
		double arc = Math.atan2((triangle.getInitial().getY()-triangle.getEndPoint().getY()), (triangle.getInitial().getX()-triangle.getEndPoint().getX()));
		int length = (int)(Math.sqrt((Math.pow((double)triangle.getEndPoint().getY()-triangle.getInitial().getY(),2)+(Math.pow((double)triangle.getEndPoint().getX()-triangle.getInitial().getX(),2)))));
		Point p3 = new Point((int)(triangle.getEndPoint().getX()+length*Math.cos(arc+(Math.PI/3))), (int)(triangle.getEndPoint().getY()+length*Math.sin(arc+(Math.PI/3))));
		
		if (triangle.isStroke()) {
			g.setStroke(triangle.getColor());
			g.strokeLine(triangle.getInitial().getX(), triangle.getInitial().getY(), triangle.getEndPoint().getX(), triangle.getEndPoint().getY());
			g.strokeLine(triangle.getEndPoint().getX(), triangle.getEndPoint().getY(), p3.getX(), p3.getY());
			g.strokeLine(p3.getX(), p3.getY(), triangle.getInitial().getX(), triangle.getInitial().getY());


		}
		else {
			g.setFill(triangle.getColor());
			
			double xPoints[] = {triangle.getInitial().getX(), triangle.getEndPoint().getX(), p3.getX()};
			double yPoints[] = {triangle.getInitial().getY(), triangle.getEndPoint().getY(), p3.getY()};
			int nPoints = 3;
			g.fillPolygon(xPoints, yPoints, nPoints);
	
		}
		g.setLineWidth(1.0);
	}


}
