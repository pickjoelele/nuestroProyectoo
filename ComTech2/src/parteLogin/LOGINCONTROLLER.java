package parteLogin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import Util.ComTechTools;
import animatefx.animation.Bounce;
import database.Database;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import loadData.loadData;
import logical.Admin;
import logical.Controladora;
import logical.Person;
import logical.Tienda;
import tienda.crearTiendaController;

public class LOGINCONTROLLER implements Initializable {
	private Controladora control = loadData.getControladora();

	@FXML
	private AnchorPane anchorPanePrincipal;

	@FXML
	private JFXTextField txt_usuario;

	@FXML
	private JFXTextField txt_contrasena;

	@FXML
	private Label lbl_crear_Cuenta;
	@FXML
	private Label lbl_olvide_contrasena;
	@FXML
	private Pane panel;
	@FXML
	private ImageView imageViewSlideshow;
	@FXML
	private ProgressIndicator progressIndicator;
	@FXML
	private Pane PaneTechDerecha;
	ComTechTools com = new ComTechTools();

	@FXML
	void ConfirmLogin(ActionEvent event) {
		Person person = control.confirmLogin(txt_usuario.getText(), txt_contrasena.getText());
		if (person != null) {
			Controladora.setActualUser(person);
			String informacion = String.format("Bienvenido  %s %s", person.getNombre(), person.getApellido());
			com.cambiarWindow(txt_contrasena.getScene(), "/admin/PrincipalAdmin.fxml");
			ComTechTools.Setnotification("Exito", informacion, 2, "mooo.png");
			

		} else {

			
			new Bounce(txt_contrasena).setCycleDuration(10).setCycleCount(1).setDelay(Duration.valueOf("100ms")).play();
			new Bounce(txt_usuario).setCycleDuration(10).setCycleCount(1).setDelay(Duration.valueOf("100ms")).play();

			ComTechTools.Setnotification("Error", "Revise su contrasena y usuario", 2, "delete.png");
		}

	}

	@FXML
	void resetContrasena(MouseEvent event) {
		com.cambiarWindow(txt_contrasena.getScene(), "/resetContrasena/RESETCONTRASENA.fxml");
	}

	@FXML
	void CrearCuenta(MouseEvent event) {

		com.cambiarWindow(txt_contrasena.getScene(), "/crearCuenta/CREARCUENTA.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Controladora.setActualUser(null);
	}

}
