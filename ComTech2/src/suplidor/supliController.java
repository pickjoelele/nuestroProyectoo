package suplidor;

import java.io.IOException;

import com.jfoenix.controls.JFXTextField;

import Util.ComTechTools;
import Util.Utiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loadData.loadData;
import logical.Controladora;
import logical.Suplidor;

public class supliController {
	private Controladora control = loadData.getControladora();

	@FXML
	private JFXTextField txtFieldNombre;

	@FXML
	private JFXTextField txtFieldApellido;

	@FXML
	private JFXTextField txtFieldDireccion;

	@FXML
	private JFXTextField txtFieldPais;

	@FXML
	void IngresarSuplidor(ActionEvent event) {
		String nombre = txtFieldNombre.getText();
		String apellido = txtFieldApellido.getText();
		String direccion = txtFieldDireccion.getText();
		String pais = txtFieldPais.getText();
		if (Utiles.isAlpha(nombre) && Utiles.isAlpha(apellido) && Utiles.isAddress(direccion) && Utiles.isAlpha(pais)) {
			Suplidor supli = new Suplidor(nombre, apellido, direccion, pais);
			control.getTienda().insertarUnSuplidor(supli);
			ComTechTools.Setnotification("Exito", "Ingreso con exito", 2, "mooo.png");
			Stage stage = (Stage) txtFieldApellido.getScene().getWindow();
			stage.close();

		} else {
			ComTechTools.Setnotification("Error", "Revise sus informaciones por favor!", 2, "delete.png");

		}
	}

	public void display() throws IOException {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Ingresar Un suplidor");
		Parent root = FXMLLoader.load(getClass().getResource("/suplidor/Suplidor.fxml"));
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.initStyle(StageStyle.UTILITY);
		window.showAndWait();

	}

}
