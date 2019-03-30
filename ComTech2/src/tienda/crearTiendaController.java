package tienda;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Util.ComTechTools;
import Util.Utiles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import loadData.loadData;
import logical.Admin;
import logical.Controladora;
import logical.Person;
import logical.Tienda;
import logical.Vendedor;

public class crearTiendaController implements Initializable {

	private Controladora control = loadData.getControladora();
	ComTechTools com = new ComTechTools();
//	private Person person = control.getActualUser();
	@FXML
	private TitledPane pane_crear_tienda;

	@FXML
	private Pane Pane_Crear_Tienda;

	@FXML
	private JFXTextField idTienda;

	@FXML
	private JFXTextField txtfield_DireccionTienda;

	@FXML
	private JFXTextField txtfield_tienda_municipio;

	@FXML
	private TableView<Tienda> tableView_Tienda;

	@FXML
	private TableColumn<Tienda, Integer> tableColumn_Tienda_id;

	@FXML
	private TableColumn<Tienda, String> tableColumn_Tienda_municipio;
	@FXML
	private Pane pane_crear_Sucursale;
	@FXML
	private JFXTextField txtfield_tienda_manager;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

}
