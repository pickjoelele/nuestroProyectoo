package resetContrasena;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Util.ComTechTools;
import Util.Utiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.converter.LocalDateStringConverter;
import loadData.loadData;
import logical.Admin;
import logical.Controladora;
import logical.Person;
import logical.Vendedor;

public class resetController implements Initializable {

	ComTechTools com = new ComTechTools();
	Controladora control = loadData.getControladora();
	@FXML
	private Pane paneUsuario;

	@FXML
	private TextField txtFieldUsuario;

	@FXML
	private TextField txtFieldNombre;
	@FXML
	private TextField txtContrasena;
	@FXML
	private TextField txtContrasena2;

	@FXML
	private DatePicker DateFechaNacimiento;

	@FXML
	private Pane paneResetear;
	private Person person = null;
	Boolean bool = false;

	@FXML
	void confirmar(ActionEvent event) {
		System.out.println(DateFechaNacimiento.getValue().toString());
		if (paneUsuario.isVisible()) {
			person = control.getPersonById(txtFieldUsuario.getText());
			if (person != null) {
				bool = true;

			}
		}

		if (bool) {
			int x = 1;

			if (person instanceof Admin) {

				if (!((Admin) person).getFechaNacimiento().equalsIgnoreCase(DateFechaNacimiento.getValue().toString())
						|| !((Admin) person).getNombre().equalsIgnoreCase(txtFieldNombre.getText())) {
					ComTechTools.Setnotification("Error", "Chequea el nombre o la fecha de nacimiento!!", 2,
							"delete.png");
					x = 0;
				}
			}
			if (person instanceof Vendedor) {
				if (!((Vendedor) person).getFechaNacimiento().equalsIgnoreCase(DateFechaNacimiento.getValue().toString())
						|| !((Vendedor) person).getNombre().equalsIgnoreCase(txtFieldNombre.getText())) {
					ComTechTools.Setnotification("Error", "Chequea el nombre o la fecha de nacimiento!!", 2,
							"delete.png");
					x = 0;
				}
			
		}

		if (x == 1) {

			paneUsuario.setVisible(false);
			paneResetear.setVisible(true);
			if (!txtContrasena.getText().isEmpty()) {
				if (txtContrasena.getText().equals(txtContrasena2.getText())) {

					if (person instanceof Admin) {

						((Admin) person).setContrasena(txtContrasena.getText());
					} else {
						((Vendedor) person).setContrasena(txtContrasena.getText());

					}
					ComTechTools.Setnotification("Exito", "su contrasena fue reestablecido con exito!", 2, "mooo.png");
					com.cambiarWindow(txtFieldNombre.getScene(), "/parteLogin/LOGIN.fxml");
				} else {

					ComTechTools.Setnotification("Error", "Sus contrasenas no  coinciden!!", 2, "delete.png");

				}
			}
		}

	}else

	{
		ComTechTools.Setnotification("Error", "Este usuario no existe!!", 2, "delete.png");

	}

	}

	@FXML
	void regresarLogin(ActionEvent event) {
		com.cambiarWindow(txtFieldUsuario.getScene(), "/parteLogin/LOGIN.fxml");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DateFechaNacimiento.setValue(LocalDate.now());

	}

}
