package resetContrasena;

import Util.ComTechTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class resetController {

	ComTechTools com = new ComTechTools();
	@FXML
	private Pane paneUsuario;

	@FXML
	private TextField txtFieldUsuario;

	@FXML
	private TextField txtFieldNombre;

	@FXML
	private DatePicker DateFechaNacimiento;

	@FXML
	private Pane paneResetear;

	@FXML
	void confirmar(ActionEvent event) {
		paneUsuario.setVisible(false);
		paneResetear.setVisible(true);
	}

	@FXML
	void regresarLogin(ActionEvent event) {
		com.cambiarWindow(txtFieldUsuario.getScene(), "/parteLogin/LOGIN.fxml");

	}

}
