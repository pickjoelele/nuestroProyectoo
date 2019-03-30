package Splashscreen;

import java.net.URL;
import java.util.ResourceBundle;

import Util.ComTechTools;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class splashScreenController implements Initializable {
	@FXML
	private ImageView image;
	ComTechTools com = new ComTechTools();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000), image);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0);

		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				com.cambiarWindow(image.getScene(), "/parteLogin/LOGIN.fxml");

			}
		});
		fadeTransition.play();

	}
}
