package admin;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import loadData.loadData;
import logical.*;
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
	private Pane panelRam;

	@FXML
	private Pane panelDiscoDuro;

	@FXML
	private Pane panelTargetaMadre;

	@FXML
	private Pane PanelMicro;

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
		paneRam.setCenter(com.GaugeMethod(Ram.getCantMinimal(), Ram.getCantDisponible(), Ram.getCantMinimal(), "Ram"));
		paneDiscoDuro.setCenter(com.GaugeMethod(DiscoDuro.getCantMinimal(), DiscoDuro.getCantDisponible(),
				DiscoDuro.getCantMax(), "Disco Duro"));
		paneTarjetaMadre.setCenter(com.GaugeMethod(TarjetaMadre.getCantMinimal(), TarjetaMadre.getCantDisponible(),
				TarjetaMadre.getCantMax(), "Tarjeta Madre"));
		paneMicroprocesador.setCenter(com.GaugeMethod(Microprocesador.getCantMinimal(),
				Microprocesador.getCantDisponible(), Microprocesador.getCantMax(), "Microprocesador"));
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
		if (node.getId().equalsIgnoreCase(paneRam.getId()))
		{
			setAllPanelInvisible();
			compraComponentes.setVisible(true);
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
		lbl_Actual_user.setText(control.getActualUser().getApellido());
		setAllPanelInvisible();
		dashboard.setVisible(true);
		getComponentsStatistics();

	}

}
