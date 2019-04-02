package admin;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import Util.ComTechTools;
import Util.Utiles;
import eu.hansolo.medusa.Gauge;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import loadData.loadData;
import logical.*;
import suplidor.supliController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

public class principalAdminController implements Initializable {

	private Controladora control = loadData.getControladora();
	ComTechTools com = new ComTechTools();

	@FXML
	private StackPane stackpane;

	@FXML
	private TitledPane dashboard;

	@FXML
	private TitledPane hacer_compra;

	@FXML
	private TitledPane listar_compra;

	@FXML
	private TitledPane listar_venta;

	@FXML
	private TitledPane ingresa_vendedor;

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
	private TitledPane ingresa_cliente;

	@FXML
	private TitledPane listar_componente;
	@FXML
	private TitledPane compraComponentes;

	@FXML
	private Label lbl_Actual_user;
	@FXML
	private TableView<Vendedor> table_Vendedor;

	@FXML
	private TableColumn<Vendedor, String> column_vendedor_nombre;

	@FXML
	private TableColumn<Vendedor, String> column_vendedor_apellido;

	@FXML
	private TableColumn<Vendedor, String> column_vendedor_fechaEntrada;

	@FXML
	private TableColumn<Vendedor, Integer> column_vendedor_cantVentas;
	@FXML
	private BorderPane paneRam;

	@FXML
	private BorderPane paneDiscoDuro;

	@FXML
	private BorderPane paneTarjetaMadre;

	@FXML
	private BorderPane paneMicroprocesador;
	@FXML
	private TextField txtFieldPrecio;
	@FXML
	private ComboBox<String> comboboxModelo;
	@FXML
	private ComboBox<String> comboBoxMarca;

	@FXML
	private ComboBox<String> ComboxBoxSupli;
	@FXML
	private ComboBox<String> ComBoTipoRam;
	@FXML
	private ComboBox<String> comboDiscoTipoConector;
	@FXML
	private ComboBox<String> comboTarjetaTipoRam;
	@FXML
	private ComboBox<String> comboTarjetaConexiones;

	@FXML
	private Pane paneCompraRam;

	@FXML
	private Pane paneCompraDiscoDuro;

	@FXML
	private Pane paneCompraTarjetaMadre;

	@FXML
	private Pane paneCompraMicro;
	@FXML
	private Label lblTituloCompra;
	@FXML
	private ImageView addModelo;

	@FXML
	private ImageView addMarca;

	@FXML
	private ImageView addSupli;
	@FXML
	private TextField txtFieldModel;

	@FXML
	private TextField txtfieldMarca;

	@FXML
	private TextField txtFieldSerie;
	@FXML
	private TextField txtFieldCantMemoria;
	@FXML
	private TextField txtFieldCantidad;
	@FXML
	private TextField txtDiscoalma;
	@FXML
	private TextField textFieldMicroVelocidad;

	@FXML
	void exit(MouseEvent event) {
		JFXDialogLayout dialogLayout = new JFXDialogLayout();
		dialogLayout.setHeading(new Text("Close"));
		dialogLayout.setBody(new Text("Quieres Salir !"));
		dialogLayout.setPrefSize(100, 100);

		JFXButton ok = new JFXButton("Ok");
		JFXButton Cancel = new JFXButton("Cancelar");

		JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);

		ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		Cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.close();
			}
		});

		dialogLayout.setActions(ok, Cancel);
		dialog.show();
	}

	@FXML
	void ingresarCompra(ActionEvent event) {
		String modelo = txtFieldModel.getText();
		String marca = txtfieldMarca.getText();
		float precio = Float.parseFloat(txtFieldPrecio.getText());
		String serie = txtFieldSerie.getText();
		String supliNombre = ComboxBoxSupli.getValue();
		int x = 0;
		if (paneCompraRam.isVisible()) {
			Ram ram = new Ram(modelo, marca, precio, serie, txtFieldCantMemoria.getText(),
					ComBoTipoRam.getValue().toString());
			if ((!modelo.isEmpty()) && (!marca.isEmpty()) && (precio > 0) && (!serie.isEmpty())
					&& (!txtFieldCantMemoria.getText().isEmpty()) && (!ComBoTipoRam.getValue().toString().isEmpty())) {
				control.getTienda().insertarUnComponente(ram);
				x = 1;
			}

		} else if (paneDiscoDuro.isVisible()) {
			int alma = Integer.parseInt(txtDiscoalma.getText());
			DiscoDuro disco = new DiscoDuro(modelo, marca, precio, serie, alma,
					comboDiscoTipoConector.getValue().toString());
			if ((!modelo.isEmpty()) && (!marca.isEmpty()) && (precio > 0) && (!serie.isEmpty()) && (alma > 0)
					&& (!comboDiscoTipoConector.getValue().toString().isEmpty())) {
				control.getTienda().insertarUnComponente(disco);
				x = 1;
			}
		} else if (paneCompraTarjetaMadre.isVisible()) {
			TarjetaMadre tar = new TarjetaMadre(modelo, marca, precio, serie,
					comboTarjetaConexiones.getValue().toString(), comboTarjetaTipoRam.getValue().toString());
			if ((!modelo.isEmpty()) && (!marca.isEmpty()) && (precio > 0) && (!serie.isEmpty())
					&& (!comboTarjetaConexiones.getValue().toString().isEmpty())
					&& (!comboTarjetaTipoRam.getValue().toString().isEmpty())) {
				control.getTienda().insertarUnComponente(tar);
				x = 1;
			}
		} else if (paneCompraMicro.isVisible()) {
			Microprocesador micro = new Microprocesador(modelo, marca, precio, serie,
					textFieldMicroVelocidad.getText());
			if ((!modelo.isEmpty()) && (!marca.isEmpty()) && (precio > 0) && (!serie.isEmpty())
					&& (!textFieldMicroVelocidad.getText().isEmpty())) {
				control.getTienda().insertarUnComponente(micro);
				x = 1;
			}
		}
		if (x == 1) {
			ComTechTools.Setnotification("Exito", "Tu compra fue de Exito", 2, "mooo.png");
			txtFieldModel.clear();
			txtfieldMarca.clear();
			txtFieldPrecio.clear();
			txtFieldSerie.clear();
			ComboxBoxSupli.getSelectionModel().clearSelection();
			txtFieldCantMemoria.clear();
			ComBoTipoRam.getSelectionModel().clearSelection();
			txtFieldCantMemoria.clear();
			ComBoTipoRam.getSelectionModel().clearSelection();
			comboDiscoTipoConector.getSelectionModel().clearSelection();
			txtDiscoalma.clear();
			comboTarjetaConexiones.getSelectionModel().clearSelection();
			comboTarjetaTipoRam.getSelectionModel().clearSelection();
			textFieldMicroVelocidad.clear();
			
			//clean the nodes
			
			
		}
		else
			ComTechTools.Setnotification("Error", "Revise por favor", 2, "delete.png");

	}

	@FXML
	void addMarcaClick(MouseEvent event) {
		addMarca.setVisible(false);
		txtfieldMarca.setVisible(true);
		txtfieldMarca.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.ENTER) {
				if (!txtfieldMarca.getText().isBlank()) {
					control.getMarcaStr().add(txtfieldMarca.getText());
					addMarca.setVisible(true);
					txtfieldMarca.setVisible(false);
					txtfieldMarca.setText("");
					llenarComboBox();
				}
			}
		});
	}

	@FXML
	void addSupliClick(MouseEvent event) throws IOException {
		supliController supli = new supliController();
		supli.display();
		llenarComboBox();
	}

	@FXML
	void addModelClick(MouseEvent event) {
		addModelo.setVisible(false);
		txtFieldModel.setVisible(true);

		txtFieldModel.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.ENTER) {
				if (!txtFieldModel.getText().isBlank()) {
					control.getModeloStr().add(txtFieldModel.getText());
					addModelo.setVisible(true);
					txtFieldModel.setVisible(false);
					txtFieldModel.setText("");
					llenarComboBox();
				}
			}
		});
	}

	@FXML
	void regresarCompra(ActionEvent event) {
		setAllPanelInvisible();
		getComponentsStatistics();
		hacer_compra.setVisible(true);

	}

	@FXML
	void logOut(MouseEvent event) {
		com.cambiarWindow(dashboard.getScene(), "/parteLogin/LOGIN.fxml");

	}

	@FXML
	void ingresarVendedor(ActionEvent event) {
		String nombre = txt_Nombre_Vendedor.getText();
		String apellido = txt_Apellido_Vendedor.getText();
		String id = txt_Usuario_id_vendedor.getText();
		String direccion = txt_Usuario_id_vendedor.getText();
		String contrasena = txt_contrasena_vendedor.getText();
		String fechaNacimiento = datapicker_fechaVendedor.getValue().toString();

		if (Utiles.isAlpha(nombre) && Utiles.isAlpha(apellido) && Utiles.isUsername(id) && Utiles.isAddress(direccion)
				&& Utiles.isPassword(contrasena)) {

			Vendedor vendedor = new Vendedor(nombre, apellido, id, direccion, contrasena, fechaNacimiento);
			control.getTienda().insertarUnVendedor(vendedor);
			txt_Apellido_Vendedor.setText("");
			txt_Nombre_Vendedor.setText("");
			txt_Usuario_id_vendedor.setText("");
			txt_Direccion_Vendedor.setText("");
			txt_contrasena_vendedor.setText("");
			datapicker_fechaVendedor.setValue(LocalDate.now());
			loadVendedorTabla();

			ComTechTools.Setnotification("Exito", "Ingreso con exito", 2, "mooo.png");

		} else {
			ComTechTools.Setnotification("Error", "Revise sus datos", 2, "delete.png");
		}

	}

	@FXML
	void menu_hacerCompra(ActionEvent event) {
		setAllPanelInvisible();
		getComponentsStatistics();
		hacer_compra.setVisible(true);
	}

	public void getComponentsStatistics() {
		paneRam.setCenter(ComTechTools.GaugeMethod(Ram.cantMinimal, control.getTienda().cantRam(), Ram.cantMax, "Ram"));
		paneDiscoDuro.setCenter(ComTechTools.GaugeMethod(DiscoDuro.cantMinimal, control.getTienda().cantDiscoDuro(),
				DiscoDuro.cantMax, "Disco Duro"));
		paneTarjetaMadre.setCenter(ComTechTools.GaugeMethod(TarjetaMadre.cantMinimal,
				control.getTienda().cantTarjetaMadre(), TarjetaMadre.cantMax, "Tarjeta Madre"));
		paneMicroprocesador.setCenter(ComTechTools.GaugeMethod(Microprocesador.cantMinimal,
				control.getTienda().cantMicroprocesador(), Microprocesador.cantMax, "Microprocesador"));
	}

	@FXML
	void menu_ingresarVendedor(ActionEvent event) {
		setAllPanelInvisible();
		loadVendedorTabla();
		ingresa_vendedor.setVisible(true);
	}

	@FXML
	void menu_listarCliente(ActionEvent event) {
		setAllPanelInvisible();
		ingresa_cliente.setVisible(true);
	}

	@FXML
	void menu_listarComponente(ActionEvent event) {
		setAllPanelInvisible();
		listar_componente.setVisible(true);
	}

	@FXML
	void menu_listarCompra(ActionEvent event) {
		setAllPanelInvisible();
		listar_compra.setVisible(true);
	}

	@FXML
	void menu_listarVentas(ActionEvent event) {
		listar_venta.setVisible(true);
	}

	@FXML
	void return_Pagina_principal(MouseEvent event) {
		setAllPanelInvisible();
		dashboard.setVisible(true);
	}

	@FXML
	void color_mouse_Clicked(MouseEvent event) {
		Node node = (Node) event.getSource();
		node.setStyle("-fx-background-color : #2a324b");
		if (node.getId().equalsIgnoreCase(paneRam.getId())) {
			setAllPanelInvisible();

			compraComponentes.setVisible(true);
			lblTituloCompra.setText("Ingresar Ram");
			paneCompraRam.setVisible(true);
		} else if (node.getId().equalsIgnoreCase(paneDiscoDuro.getId())) {
			setAllPanelInvisible();
			compraComponentes.setVisible(true);
			lblTituloCompra.setText("Ingresar Disco Duro");
			paneCompraDiscoDuro.setVisible(true);
		} else if (node.getId().equalsIgnoreCase(paneTarjetaMadre.getId())) {
			setAllPanelInvisible();
			compraComponentes.setVisible(true);
			lblTituloCompra.setText("Ingresar Tarjeta Madre");
			paneCompraTarjetaMadre.setVisible(true);
		} else if (node.getId().equalsIgnoreCase(paneMicroprocesador.getId())) {
			setAllPanelInvisible();
			compraComponentes.setVisible(true);
			lblTituloCompra.setText("Ingresar Microprocesador");
			paneCompraMicro.setVisible(true);
		}

	}

	@FXML
	void color_mouse_Exited(MouseEvent event) {
		Node node = (Node) event.getSource();
		node.setStyle(
				"-fx-background-color : #FFFFFF ;  -fx-border-radius : 4px;-fx-border-width:0.5px;-fx-border-color:black; ");
	}

	@FXML
	void color_mouse_entered(MouseEvent event) {
		Node node = (Node) event.getSource();
		node.setStyle("-fx-background-color : #EFDBDC");
	}

	private void setAllPanelInvisible() {

		dashboard.setVisible(false);
		listar_componente.setVisible(false);
		listar_compra.setVisible(false);
		hacer_compra.setVisible(false);
		listar_venta.setVisible(false);
		ingresa_vendedor.setVisible(false);
		ingresa_cliente.setVisible(false);
		compraComponentes.setVisible(false);
		paneCompraDiscoDuro.setVisible(false);
		paneCompraMicro.setVisible(false);
		paneCompraRam.setVisible(false);
		paneCompraTarjetaMadre.setVisible(false);

	}

	public void loadVendedorTabla() {

		column_vendedor_nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		column_vendedor_apellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
		column_vendedor_fechaEntrada.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));
		column_vendedor_cantVentas.setCellValueFactory(new PropertyValueFactory<>("cantVentas"));
		table_Vendedor.setItems(getVendedores());
	}

	public ObservableList<Vendedor> getVendedores() {
		ObservableList<Vendedor> vendedores = FXCollections.observableArrayList();

		for (Vendedor vended : control.getTienda().getVendedores()) {
			vendedores.add(vended);
		}

		return vendedores;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lbl_Actual_user.setText(Controladora.getActualUser().getApellido());
		setAllPanelInvisible();
		dashboard.setVisible(true);
		getComponentsStatistics();
		llenarComboBox();

	}

	private void llenarComboBox() {
		int com = comboboxModelo.getSelectionModel().getSelectedIndex();
		comboboxModelo.getItems().setAll(control.getModeloStr());
		comboboxModelo.getSelectionModel().clearAndSelect(com);

		int marca = comboBoxMarca.getSelectionModel().getSelectedIndex();
		comboBoxMarca.getItems().setAll(control.getMarcaStr());
		comboBoxMarca.getSelectionModel().clearAndSelect(marca);
		
		int tipoConector = comboDiscoTipoConector.getSelectionModel().getSelectedIndex();
		comboDiscoTipoConector.getItems().setAll(control.getTipoConector());
		comboDiscoTipoConector.getSelectionModel().clearAndSelect(tipoConector);
		
		int tipoRam = ComBoTipoRam.getSelectionModel().getSelectedIndex();
		int tipoMicro = comboTarjetaTipoRam.getSelectionModel().getSelectedIndex();
		
		ComBoTipoRam.getItems().setAll(control.getTipoRam());
		comboTarjetaTipoRam.getItems().setAll(control.getTipoRam());

		ComBoTipoRam.getSelectionModel().clearAndSelect(tipoRam);
		comboTarjetaTipoRam.getSelectionModel().clearAndSelect(tipoMicro);

		//ram de tarjeta
		
		int conexioneTarje = comboTarjetaConexiones.getSelectionModel().getSelectedIndex();
		comboTarjetaConexiones.getItems().setAll(control.getConexiones());
		comboTarjetaConexiones.getSelectionModel().clearAndSelect(conexioneTarje);
		

		// add combobox para suplidores
		String[] listSupli = getListSupli();
		int supli = ComboxBoxSupli.getSelectionModel().getSelectedIndex();
		ComboxBoxSupli.getItems().setAll(listSupli);
		ComboxBoxSupli.getSelectionModel().clearAndSelect(supli);

	}

	public String[] getListSupli() {
		int cantSupli = control.getTienda().getSuplidores().size();
		String[] listsSupli = new String[cantSupli];
		for (int x = 0; x < cantSupli; x++) {
			listsSupli[x] = control.getTienda().getSuplidores().get(x).getNombre();
		}
		return listsSupli;
	}

}
