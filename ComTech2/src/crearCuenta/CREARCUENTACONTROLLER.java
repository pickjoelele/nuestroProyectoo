package crearCuenta;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Util.ComTechTools;
import Util.Utiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import loadData.loadData;
import logical.Controladora;
import logical.Person;

public class CREARCUENTACONTROLLER implements Initializable {
	private Controladora control = loadData.getControladora();
	private Person ActualUser = Controladora.getActualUser();
	ComTechTools com = new ComTechTools();
	@FXML
	private Pane pane_adm;

	@FXML
	private JFXTextField txt_Usuario_Admin;

	@FXML
	private JFXPasswordField txt_contrasena_admin;

	@FXML
	private Pane pane_Vendedor;

	@FXML
	private JFXTextField txt_Nombre_Vendedor;

	@FXML
	private JFXTextField txt_Apellido_Vendedor;

	@FXML
	private JFXTextField txt_Direccion_Vendedor;

	@FXML
	private DatePicker datapicker_fechaVendedor;

	@FXML
	private JFXTextField txt_Usuario_id_vendedor;

	@FXML
	private JFXPasswordField txt_contrasena_vendedor;

	@FXML
	private Label label_adm;
	@FXML
	private Label lbl_Sucursale;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
