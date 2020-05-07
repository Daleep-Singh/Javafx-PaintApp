package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
/**
 * This class contains the StrokeChooserPanel which allows the user to select between a stroke or fill.
 * @author amit
 *
 */
public class StrokeChooserPanel extends GridPane implements EventHandler<ActionEvent>{
	private View view;
	private ToggleGroup toggleGroup;
	
	
	public StrokeChooserPanel(View view) {
		this.view = view;
		
		
		ToggleButton setToStroke = new ToggleButton("Stroke");
		ToggleButton setToFill = new ToggleButton("Fill");
		 
		setToStroke.setUserData("Stroke");
		setToFill.setUserData("Fill");
		 
		toggleGroup = new ToggleGroup();
		setToStroke.setToggleGroup(toggleGroup);
		setToStroke.setSelected(true);
		setToFill.setToggleGroup(toggleGroup);
		 
		setToStroke.setOnAction(this);
		setToFill.setOnAction(this);
		HBox fillOrStroke = new HBox();
		fillOrStroke.getChildren().addAll(setToStroke, setToFill);
		this.add(fillOrStroke, 0, 0);
}
	public ToggleGroup getToggleGroup() {
		return this.toggleGroup;
	}

	@Override
	public void handle(ActionEvent event) {
		StrokeCommand strokecommand = new StrokeCommand(this.view);
		this.view.getPaintModel().addModifierCommand(strokecommand);
		//this.view.getPaintPanel().setStroke(toggleGroup.getSelectedToggle().getUserData() == "Stroke");
		
		
	}
	
}
