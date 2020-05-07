package ca.utoronto.utm.paint;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
/**
 * This class creates a 'ColorChooserPanel' which allows the user to select a color for which new shapes will have.
 * @author amit
 *
 */
public class ColorChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private View view;
	private ChoiceBox<String> choiceBox;
	private int indexOfColor;
	private Color[] colors;

	
	/**
	 * Creates a ChoiceBox for the user to use.
	 * @param view 
	 */
	public ColorChooserPanel (View view) {
		this.view = view;
		
		indexOfColor = 0;
		colors = new Color[] {Color.BLACK, Color.WHITE, Color.ORANGE, Color.GREEN, Color.RED, Color.PINK, Color.YELLOW, Color.BLUE};
		this.choiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			    "Black", "White", "Orange", "Green", "Red", "Pink", "Yellow", "Blue"));
		this.choiceBox.setOnAction(this);
		this.choiceBox.setValue("Black");
		this.add(choiceBox, 0, 0);


	}
	
	/**
	 * 
	 * @return the ChoiceBox.
	 */
	public ChoiceBox<String> getColorPicker() {
		return this.choiceBox;
		
	}
	
	/**
	 * 
	 * @return the color in type Color.
	 */
	public Color getColor() {
		return colors[indexOfColor];
	}
	
	/**
	 * 
	 * @return String representation of current Color.
	 */
	public String getStringOfColor() {
		return choiceBox.getValue();
	}
	
	/**
	 * This handler works by getting index of color currently selected and setting the indexOfColor.
	 */
	@Override
	public void handle(ActionEvent event) {
		indexOfColor = choiceBox.getItems().indexOf(choiceBox.getValue());
		ColorCommand colorcommand = new ColorCommand(this.view);
		this.view.getPaintModel().addModifierCommand(colorcommand);
		System.out.println("Current Selected Color is: " + this.getStringOfColor());
		
		
	}

}
