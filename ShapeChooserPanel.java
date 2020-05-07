package ca.utoronto.utm.paint;


/**
 * Allows the user to select a shape to draw.
 */
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private ToggleGroup toggleGroupShape;

	

	public ShapeChooserPanel(View view) {
		
		this.view = view;
		

		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Triangle"};

		
	
		
		toggleGroupShape = new ToggleGroup();
		int row = 0;
		for (String label : buttonLabels) {
			
			
			ToggleButton button = new ToggleButton();
			button.setGraphic(getIcon(label));
			button.setMinWidth(100);
			button.setUserData(label);		

			button.setToggleGroup(toggleGroupShape);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		
		}
		
				 
		
	}
	
	/**
	 *  Takes the button label as an argument
	 *  and returns the correct button icon
	 *  for the given label.
	 *  
	 *  For example: "Rectangle" would return a rectangle
	 *   icon.
	 *   
	 * @param buttonLabel
	 * @return
	 */
	private ImageView getIcon(String buttonLabel) {
		

		switch(buttonLabel) {
			
			case "Rectangle" :
				return new ImageView( getClass().getResource("rectangle.png").toExternalForm());
			case "Square" :
				return new ImageView( getClass().getResource("square.png").toExternalForm());
			case "Circle":
				return new ImageView( getClass().getResource("circle.png").toExternalForm());
			case "Squiggle":
				return new ImageView( getClass().getResource("squiggle.png").toExternalForm());
			case "Polyline":
				return new ImageView( getClass().getResource("polyline.png").toExternalForm());
			case "Triangle":
				return new ImageView( getClass().getResource("triangle.png").toExternalForm());
				
			default:
				return null;
		}
			
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Current Shape Selected: " + (String) toggleGroupShape.getSelectedToggle().getUserData());
		this.view.getPaintPanel().setMode((String) toggleGroupShape.getSelectedToggle().getUserData());
		
		
	}

	
	
}
