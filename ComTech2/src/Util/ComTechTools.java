package Util;

import java.io.IOException;


import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXTextField;

import eu.hansolo.medusa.Gauge;

import eu.hansolo.medusa.Gauge.SkinType;
import eu.hansolo.medusa.GaugeBuilder;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import loadData.loadData;

public class ComTechTools {

	public static void cleanNode(Node node) {
		if (node instanceof JFXTextField) {
			((JFXTextField) node).setText("");
		}
	}

	public void cambiarWindow(Scene scen, String direccion) {
		Stage currentStage;
		Scene scene = scen;
		currentStage = (Stage) scene.getWindow();
		currentStage.hide();
		// otro window parad resetContrasena

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(direccion));
			Scene newScene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setScene(newScene);
			newStage.initStyle(StageStyle.UTILITY);
			newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					loadData.saveTienda();
				}
			});
			newStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Setnotification(String title, String text, int durationSecond, String imageDireccion) {
		Image image = new Image(imageDireccion);
		Notifications notification = Notifications.create().title(title).text(text)
				.hideAfter(Duration.seconds(durationSecond)).position(Pos.BOTTOM_LEFT).graphic(new ImageView(image));

		notification.darkStyle();
		notification.show();
	}

	public static Gauge GaugeMethod(int cantMin, int cantNormal, int cantMax, String nombre) {
		Gauge gauge = GaugeBuilder.create().skinType(SkinType.BAR).animated(true).minValue(0)
				.maxValue(cantMax + (cantMax / 10)).build();
		gauge.setTitle(nombre);
//		gauge.setUnit("KM /H ");
		gauge.setUnitColor(Color.RED);
		gauge.setDecimals(0);
		gauge.setValueColor(Color.BLACK);
		gauge.setValue(cantNormal);
		gauge.setAnimated(true);
		gauge.setMaxSize(180, 180);
		gauge.setBarBackgroundColor(Color.LIGHTBLUE);
//		
//		gauge.setValueColor(Color.DARKGREEN);//chif ki anba ki represente l la
//		gauge.setTitleColor(Color.BLACK);
//		gauge.setSubTitleColor(Color.DARKBLUE);
//		
		if (cantNormal <= cantMin)
			gauge.setBarColor(Color.web("#F23A43"));
		else if (cantNormal > cantMin && cantNormal < cantMax)
			gauge.setBarColor(Color.web("#23DB76"));
		else
			gauge.setBarColor(Color.web("#27F11C"));

		// sa ki montre valeur a
//		gauge.setNeedleColor(Color.LIGHTBLUE);
//		
//		gauge.setThresholdColor(Color.GREEN);
//		gauge.setThreshold(85);

//		gauge.setThresholdVisible(true);

		return gauge;
	}

}
