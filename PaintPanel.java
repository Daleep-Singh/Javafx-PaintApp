package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.math.*;
class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {
	
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private Double lineThickness;
	private Color color;
	private boolean stroke;
	private static boolean isDrag;
	private Point initial;
	private ArrayList<Point> pointList;

	private Point endPoint;
	private Point p1;
	private Point p2;
	private Point p3;
	private Canvas canvas;
	private GraphicsContext g;

	private ArrayList<DrawCommand> drawCommands;
	private ArrayList<DrawCommand> deletedDrawCommands;
	private ArrayList<DrawCommand> modifierCommands; //command arraylist of shape modifiers(line thickness, color, etc)
	public PaintPanel(PaintModel model, View view) {
		
		this.canvas = new Canvas(650,650);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = "Circle"; // bad code here?
		this.lineThickness = (double) 1; // the initial thickness
		this.stroke = true; // initial stroke value 
		//this.color = Color.BLACK; //initial color
		this.pointList = new ArrayList<Point>();

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
		drawCommands = this.model.getDrawCommands();
		modifierCommands = this.model.getModifierCommands();
		deletedDrawCommands = new ArrayList<DrawCommand>();
	}
	

	public void repaint() {
		this.g = this.canvas.getGraphicsContext2D();
		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setStroke(Color.WHITE);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;

		
		for(DrawCommand c: this.drawCommands) {
			c.execute(g);
		}
		
	}
	public void undo() {
	
		if(this.drawCommands.size() > 0) {
			DrawCommand rcommand = (drawCommands.get(drawCommands.size()-1));
			this.deletedDrawCommands.add(rcommand);
			this.drawCommands.remove(rcommand);
				
			}
		repaint();
		
	}
	
	public void redo() {
		if (this.deletedDrawCommands.size() > 0) {
			this.drawCommands.add(this.deletedDrawCommands.get(this.deletedDrawCommands.size() - 1));
			this.deletedDrawCommands.remove(this.deletedDrawCommands.size() - 1);
			repaint();
		}
	}
		

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * Sets the thickness of the lines drawn.
	 * @param double1
	 */
	public void setThickness(Double thickness) {
		
		this.lineThickness = thickness;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setStroke(boolean setToStroke) {
		this.stroke = setToStroke;
	}
	public static boolean getIsDrag() {
		return PaintPanel.isDrag;
	}
	
	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			mouseExited(event);
		}
	}

	private void mouseMoved(MouseEvent e) {
		
	}

	private void mouseDragged(MouseEvent e) {
		PaintPanel.isDrag = true;
		this.endPoint = new Point((int) e.getX(), (int) e.getY());
		this.pointList.add(endPoint);
		ShapeFactory shapeFactory = new ShapeFactory(this.mode, this.color, this.stroke , this.lineThickness, this.initial, this.endPoint, null, pointList);
		this.drawCommands.add(shapeFactory.getCommand());
		this.repaint();
		this.drawCommands.remove(this.drawCommands.size() - 1);
		}
	
	

	private void mouseClicked(MouseEvent e) {

		this.p1 = new Point((int)e.getX(), (int) e.getY());
		this.p2 = new Point((int)e.getX(), (int) e.getY());
		this.p3 = new Point((int)e.getX(), (int) e.getY());
		ShapeFactory shapefactory = new ShapeFactory(this.mode, this.color, this.stroke, this.lineThickness, this.p1, this.p3, this.p2, pointList);
		this.drawCommands.add(shapefactory.getCommand());
		this.repaint();

	}
	private void mousePressed(MouseEvent e) {
		this.initial = new Point((int) e.getX(),(int) e.getY());
		this.pointList.add(initial);
	}

	private void mouseReleased(MouseEvent e) {
		PaintPanel.isDrag = false;
		this.endPoint = new Point((int) e.getX(), (int) e.getY());
		ShapeFactory shapeFactory = new ShapeFactory(this.mode, this.color, this.stroke , this.lineThickness, this.initial, this.endPoint, null, pointList);
		this.drawCommands.add(shapeFactory.getCommand());
		pointList = new ArrayList<Point>();
		this.repaint();	
		}
		
	
	private void mouseEntered(MouseEvent e) {
		for (DrawCommand d: modifierCommands) {
			d.execute(g);
		}
	}

	private void mouseExited(MouseEvent e) {
	
}


	public void addCommand(DrawCommand cmd) {
		this.drawCommands.add(cmd);
		
	}


	public Double getLineThickness() {
		return this.lineThickness;
	}


	public Color getColor() {
		return this.color;
	}
	
}
