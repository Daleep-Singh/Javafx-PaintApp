package ca.utoronto.utm.paint;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
/**
 * This class contains the logic of allowing the user to select the thickness of the stroke of a shape.
 * @author amit
 *
 */
public class ThicknessChooserPanel extends GridPane{
	private Double thickness;
	
	public ThicknessChooserPanel(View view) {
		this.thickness = (double) 1;
		Slider slider = new Slider();
		slider.setMin(1);
		slider.setMax(20);
		slider.setValue(1);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(9);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);
		VBox vbox = new VBox();
		Label sliderText = new Label("Set Thickness:");
		vbox.getChildren().addAll(sliderText, slider);
		this.add(vbox, 0, 0);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
				setThickness(slider.getValue());
				ThicknessCommand thicknessCommand = new ThicknessCommand(view);
				view.getPaintModel().addModifierCommand(thicknessCommand);
            }
        });

		
	}
	
	
	public Double getThickness() {
		return this.thickness;
	}
	
	public void setThickness(Double thickness) {
		this.thickness = thickness;
	}
	
}
	
	
	
	
		
	
	


