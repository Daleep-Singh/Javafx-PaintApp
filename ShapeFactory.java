package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;
/**
 * This shape factory inputs when a user draws an object and creates an instance which contains the current shape and drawcommand.
 * @author amit
 *
 */
public class ShapeFactory {
	Shape returnShape;
	DrawCommand drawCommand;
	public ShapeFactory(String mode, Color color, boolean isStroke, Double thickness, Point initial, Point endPoint, Point p2, ArrayList<Point> points) {
		if (mode == "Circle") {
			this.returnShape = new Circle(color, isStroke, thickness, initial, endPoint);
			this.drawCommand = new CircleCommand((Circle) this.returnShape);
			
			
		}
		else if (mode == "Rectangle") {
			this.returnShape = new Rectangle(color, isStroke, thickness, initial, endPoint);
			this.drawCommand = new RectangleCommand((Rectangle) this.returnShape);
		}

		else if (mode == "Triangle") {

			this.returnShape = new Triangle(color, isStroke, thickness, initial, endPoint);
			this.drawCommand = new TriangleCommand((Triangle) this.returnShape);
		}
		else if (mode == "Polyline") {
			if (PaintPanel.getIsDrag() == false) {
			this.returnShape = new PolyLine(color, isStroke, thickness, initial, endPoint);
			this.drawCommand = new PolyLineCommand((PolyLine) this.returnShape);
			}
			else if (PaintPanel.getIsDrag() == true) {
				this.drawCommand = new PolyLineCommand((PolyLine) this.returnShape);

			}
			
		

		}
		
		else if (mode == "Squiggle") {
			this.returnShape = new Squiggle(points, thickness, color);
			this.drawCommand = new SquiggleCommand((Squiggle) this.returnShape);
		}
		
		else if (mode == "Square") {
			this.returnShape = new Square(color, isStroke, thickness, initial, endPoint);
			this.drawCommand = new SquareCommand((Square) this.returnShape);
		}
	}
	
	public Shape getShape() {
		return this.returnShape;
	}
	
	public DrawCommand getCommand() {
		return this.drawCommand;
		
	}
}
