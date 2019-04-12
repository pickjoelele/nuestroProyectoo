package Vendedor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Util.ComTechTools;
import Util.Utiles;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import loadData.loadData;
import logical.Cliente;
import logical.CompoConDetalles;
import logical.Componente;
import logical.Compra;
import logical.Controladora;
import logical.Factura;
import logical.Kit;
import logical.SerieDetalles;
import logical.UnKit;
import logical.Vendedor;
import logical.miniComponente;

public class vendedorController implements Initializable {
	private Controladora control = loadData.getControladora();
	ComTechTools com = new ComTechTools();

	private final int height = 145;
	@FXML
	private ScrollPane scrollpane;
	@FXML
	private AnchorPane anchorPrincipal;
	@FXML
	private Label lblUser;
	@FXML
	private Label lblCantItem;
	@FXML
	private TitledPane checkoutTitlePane;
	@FXML
	private TableView<CompoConDetalles> tableTodos;
	@FXML
	private TableView<CompoConDetalles> tableCompra;
	@FXML
	private TableView<CompoConDetalles> tableCompra1;

	@FXML
	private TableColumn<CompoConDetalles, String> todosCantidad;

	@FXML
	private TableColumn<CompoConDetalles, String> TodosDetalles;

	@FXML
	private TableColumn<CompoConDetalles, String> TodosPrecioUnitario;

	@FXML
	private TableColumn<CompoConDetalles, String> TodosPrecioTotal;

	@FXML
	private TableColumn<CompoConDetalles, String> CompraCantidad;

	@FXML
	private TableColumn<CompoConDetalles, String> CompraDetalles;

	@FXML
	private TableColumn<CompoConDetalles, String> CompraPrecioUnitario;

	@FXML
	private TableColumn<CompoConDetalles, String> CompraPrecioTotal;
	@FXML
	private Label lblPriceTodos;
	@FXML
	private Label lblPriceCompra;
	@FXML
	private TextField txtfieldnombre;
	@FXML
	private TextField txtfieldDireccion;
	@FXML
	private TextField textfieldTelefono;
	@FXML
	private TextField txtFieldBuscarCliente;
	@FXML
	private TableView<Cliente> tableListarCliente;
	@FXML
	private TableColumn<Cliente, String> columnId;
	@FXML
	private TableColumn<Cliente, String> ColumnDireccion;
	@FXML
	private TableColumn<Cliente, String> ColumnNombre;
	@FXML
	private TableColumn<Cliente, String> ColumnTelefono;
	@FXML
	private Pane paneComprar;
	@FXML
	private Label lblClienteInformation;
	@FXML
	private JFXButton botonComprar;
	@FXML
	private Pane pane_shopping_cart;
	@FXML
	private TextField txtBusqueda;
	private String busquedaCom;

	private Cliente cliente;
	private ArrayList<CompoConDetalles> todosProductos = new ArrayList<CompoConDetalles>();
	private ArrayList<CompoConDetalles> productosComprar = new ArrayList<CompoConDetalles>();

	public void loadCliente() {

		tableListarCliente.getColumns().clear();

		tableListarCliente.setOnMouseClicked(e -> {

			if (e.getClickCount() == 2) {
				cliente = tableListarCliente.getItems().get(tableListarCliente.getSelectionModel().getSelectedIndex());
				String information = String.format("%s | %s  | %s", cliente.getNombre(), cliente.getDireccion(),
						cliente.getTelefono());
				lblClienteInformation.setText(information);
			}
		});
		columnId.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getID()));
		ColumnDireccion.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getDireccion()));
		ColumnNombre.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getNombre()));
		ColumnTelefono.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getTelefono()));

		tableListarCliente.getColumns().addAll(columnId, ColumnNombre, ColumnTelefono, ColumnDireccion);

		if (txtFieldBuscarCliente.getText().isEmpty())
			tableListarCliente.setItems(FXCollections.observableArrayList(control.getTienda().getClientes()));
		else
			tableListarCliente.setItems(FXCollections.observableArrayList(control.getTienda()
					.getClientesByname(txtFieldBuscarCliente.getText(), control.getTienda().getClientes())));

	}

	private String busquedaComponente;

	@FXML
	void llenarMicro(MouseEvent event) {
		busquedaComponente = "Microprocesador";
		llenarGridpane();
	}

	@FXML
	void ingresarCliente(ActionEvent event) {
		String nombre = txtfieldnombre.getText();
		String direccion = txtfieldDireccion.getText();
		String telefono = textfieldTelefono.getText();
		if (Utiles.isAlpha(nombre) && Utiles.isAddress(direccion) && Utiles.isNum(telefono)) {
			Cliente client = new Cliente(nombre, telefono, direccion);
			control.getTienda().insertarCliente(client);
			txtfieldDireccion.setText("");
			txtfieldnombre.clear();
			textfieldTelefono.clear();
			ComTechTools.Setnotification("Exito", "El ingreso fue de exito!!", 2, "mooo.png");
		} else
			ComTechTools.Setnotification("Error", "Revise sus informaciones", 2, "delete.png");

		loadCliente();
	}

	@FXML
	void llenarKits(MouseEvent event) {
		busquedaComponente = "Kit";
		llenarGridpane();
	}

	@FXML
	void return_Pagina_principal(MouseEvent event) {
		pane_shopping_cart.setVisible(true);
		busquedaComponente = "";
		anchorPrincipal.setVisible(true);
		checkoutTitlePane.setVisible(false);
		paneComprar.setVisible(false);
		llenarGridpane();
	}

	@FXML
	void llenarDisco(MouseEvent event) {
		busquedaComponente = "Disco Duro";
		llenarGridpane();
	}

	@FXML
	void llenarRam(MouseEvent event) {
		busquedaComponente = "Ram";
		llenarGridpane();
	}

	@FXML
	void llenarTarjeta(MouseEvent event) {
		busquedaComponente = "Tarjeta Madre";
		llenarGridpane();
	}

	private void llenarGridpane() {
		int x = 0;

		GridPane grid = new GridPane();
		grid.setPrefWidth(900);

		grid.setVgap(15);
		anchorPrincipal.getChildren().add(grid);
		busquedaCom = txtBusqueda.getText();
		for (CompoConDetalles comp : control.getTienda().getdetallesComponente()) {
			if (comp.getCantDisponibleS() > 0 || comp.getImagen().isEmpty()) {

				BorderPane borderPic = new BorderPane();
				BorderPane borderDescription = new BorderPane();
				Pane pane = new Pane();
				if (!comp.getImagen().isEmpty()) {
					Image image = new Image(comp.getImagen());
					ImageView img = new ImageView(image);
					img.setFitWidth(334);
					img.setFitHeight(60);
					borderPic.setCenter(img);
					borderPic.setPrefHeight(140);
					borderPic.setPrefWidth(340);
					borderPic.setStyle("-fx-background-color:white");

				}

				Label label = new Label(comp.getDetalles().toUpperCase());

				label.setStyle("-fx-font: 15px 'System'");

				borderDescription.setStyle("-fx-background-color:white");
				Label labelPrice = new Label(Float.toString(comp.getPrecioFinal()) + "  $ RD");
				labelPrice.setStyle("-fx-font-size: 16px;-fx-font-weight:bold");
				borderDescription.setBottom(labelPrice);

				pane.setPrefWidth(150);
				pane.setStyle("-fx-background-color: white;");

				JFXButton btnComprar = new JFXButton("Comprar");
				btnComprar.setPrefWidth(150);
				btnComprar.setPrefHeight(40);
				btnComprar.setStyle(
						"-fx-background-color: #1F5050; -fx-background-radius: 6px;-fx-text-fill:white;-fx-font-size:12px");
				JFXButton btnAgregar = new JFXButton("Agregar al Carrito");
				btnAgregar.setGraphic(new ImageView(new Image("shop-cart-icon.png")));

				btnAgregar.setStyle("-fx-background-color: #1F5050;-fx-text-fill:white;-fx-font-size:12px");
				btnAgregar.setPrefWidth(150);
				btnAgregar.setPrefHeight(40);
				VBox vbox = new VBox();
				btnAgregar.setOnMouseClicked((e) -> {
					if (comp.getImagen().isEmpty()) {
						CompoConDetalles uncompo = new CompoConDetalles(comp.getDetalles(), comp.getPrecio(),
								comp.getPrecioFinal(), 1);
						uncompo.setNombre(comp.getNombre());
						int cant = (int) Float.parseFloat(lblPriceTodos.getText());
						lblPriceTodos.setText(Float.toString((int) ((comp.getPrecioFinal() * 1) + cant)));

						todosProductos.add(uncompo);
					}
					int cant = Integer.parseInt(lblCantItem.getText());
					cant += 1;
					lblCantItem.setText(Integer.toString(cant));

				});

				if (!comp.getImagen().isEmpty()) {
					label.setMinWidth(350);

					Spinner<Integer> spin = new Spinner<Integer>();
					SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
							comp.getCantDisponibleS(), 1);
					spin.setValueFactory(valueFactory);
					spin.setPrefSize(150, 25);

					spin.setStyle(
							"-fx-background-color: #1F5050; -fx-background-radius: 6px;-fx-text-fill:white;-fx-font-size:12px");
					vbox.getChildren().add(spin);
					VBox.setMargin(spin, new Insets(8, 0, 0, 0));
					btnAgregar.setOnMouseClicked((e) -> {
						CompoConDetalles uncompo = new CompoConDetalles(comp.getDetalles(), comp.getPrecio(),
								comp.getPrecioFinal(), spin.getValue());
						int priceTotal = (int) Float.parseFloat(lblPriceTodos.getText());

						lblPriceTodos.setText(
								Float.toString((int) ((comp.getPrecioFinal() * spin.getValue()) + priceTotal)));
						uncompo.setNombre(comp.getNombre());
						todosProductos.add(uncompo);
						int cant = Integer.parseInt(lblCantItem.getText());
						cant += spin.getValue();
						lblCantItem.setText(Integer.toString(cant));

						comp.setCantDisponibleS(comp.getCantDisponibleS() - spin.getValue());
						llenarGridpane();
					});

				}
				vbox.setStyle("-fx-background-color:white");
				vbox.setMinWidth(300);

				vbox.getChildren().addAll(btnAgregar, btnComprar);
				VBox.setMargin(btnComprar, new Insets(10, 0, 0, 0));
				VBox.setMargin(btnAgregar, new Insets(10, 0, 0, 0));

				pane.getChildren().add(vbox);
				borderDescription.setTop(label);

				borderDescription.setStyle("-fx-background-color:white");

				if (busquedaComponente.equalsIgnoreCase(comp.getNombre()) || busquedaComponente.isEmpty()) {
					if (comp.getDetalles().toLowerCase().contains(busquedaCom.toLowerCase())) {

						if (!comp.getImagen().isEmpty()) {
							grid.add(borderPic, 0, x);
							grid.add(borderDescription, 1, x);
							grid.add(pane, 2, x);
						} else {
//						grid.add(borderDescription,1, x);
							label.setMinWidth(650);

							grid.add(borderDescription, 0, x, 2, 1);
							grid.add(pane, 2, x);
						}

						grid.setPrefHeight(height * (x + 1));
						grid.setMaxHeight(height * (x + 1));
					}
				}
				x++;

			}
		}

		busquedaCom = "";
		scrollpane.setContent(grid);
	}

	@FXML
	void salir(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("Salida");
		alert.setContentText("Esta seguro que quieres salir?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			loadData.saveTienda();
			System.exit(0);

		} else {

		}
	}

	@SuppressWarnings("unchecked")
	public void loadProductosComprar() {
		tableCompra.getColumns().clear();
		int precioCompleto = (int) Float.parseFloat(lblPriceCompra.getText());
		if (precioCompleto > 0)
			botonComprar.setDisable(false);
		else
			botonComprar.setDisable(true);

		tableCompra.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				int index = tableCompra.getSelectionModel().getSelectedIndex();

				if (index >= 0) {
					todosProductos.add(productosComprar.get(index));
					int precioProducto = (int) productosComprar.get(index).getPrecioFinal()
							* productosComprar.get(index).getCantDisponibleS();
					int preci = (int) ((int) precioCompleto - precioProducto);
					lblPriceCompra.setText((Float.toString(preci)));

					int precio = (int) Float.parseFloat(lblPriceTodos.getText());
					precio += precioProducto;
					lblPriceTodos.setText(Float.toString(precio));
					productosComprar.remove(index);
					loadTodosProductos();
					loadProductosComprar();
				}
			}
		});

		CompraCantidad.setCellValueFactory(
				item -> new SimpleStringProperty(Integer.toString(item.getValue().getCantDisponibleS())));
		CompraDetalles.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getDetalles()));
		CompraPrecioUnitario.setCellValueFactory(
				item -> new SimpleStringProperty(Float.toString(item.getValue().getPrecioFinal())));
		CompraPrecioTotal
				.setCellValueFactory(item -> new SimpleStringProperty(Float.toString(item.getValue().getTotal())));

		tableCompra.getColumns().addAll(CompraCantidad, CompraDetalles, CompraPrecioUnitario, CompraPrecioTotal);
		tableCompra.setItems(getCompraProductos());

	}

	public ObservableList<CompoConDetalles> getTodosProductos() {

		ObservableList<CompoConDetalles> componentes = FXCollections.observableArrayList(todosProductos);

		return componentes;

	}

	@SuppressWarnings("unchecked")
	public void loadTodosProductos() {
		tableTodos.getColumns().clear();

		tableTodos.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				int index = tableTodos.getSelectionModel().getSelectedIndex();
				int precio = (int) Float.parseFloat(lblPriceTodos.getText());
				if (index >= 0 && index < tableTodos.getItems().size()) {

					int precioFinal = (int) (todosProductos.get(index).getPrecioFinal()
							* todosProductos.get(index).getCantDisponibleS());
					precio -= precioFinal;
					int precioCompleto = (int) Float.parseFloat(lblPriceCompra.getText());
					precioCompleto += precioFinal;
					lblPriceCompra.setText(Float.toString(precioCompleto));
//					

					lblPriceTodos.setText(Float.toString(precio));
					productosComprar.add(todosProductos.get(index));
					todosProductos.remove(index);
					loadTodosProductos();
					loadProductosComprar();
				}
			}
		});
		todosCantidad.setCellValueFactory(
				item -> new SimpleStringProperty(Integer.toString(item.getValue().getCantDisponibleS())));
		TodosDetalles.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getDetalles()));
		TodosPrecioUnitario.setCellValueFactory(
				item -> new SimpleStringProperty(Float.toString(item.getValue().getPrecioFinal())));
		TodosPrecioTotal
				.setCellValueFactory(item -> new SimpleStringProperty(Float.toString(item.getValue().getTotal())));

		tableTodos.getColumns().addAll(todosCantidad, TodosDetalles, TodosPrecioUnitario, TodosPrecioTotal);
		tableTodos.setItems(getTodosProductos());

	}

	public ObservableList<CompoConDetalles> getCompraProductos() {

		ObservableList<CompoConDetalles> componentes = FXCollections.observableArrayList(productosComprar);

		return componentes;

	}

	@FXML
	void cancel(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Cancel");

		int price = (int) Float.parseFloat(lblPriceTodos.getText());
		if (checkoutTitlePane.isVisible()) {
			if (price > 0) {
				alert.setHeaderText("!Perdida de todos los productos guardados!");
				alert.setContentText("Esta seguro que quiere perder la lista de los productos guardados?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					reiniciarTodo();

				}
			} else
				reiniciarTodo();
		} else {
			alert.setHeaderText("!Perdida!");
			alert.setContentText("Esta seguro que no quiere comprarlos?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				paneComprar.setVisible(false);
				anchorPrincipal.setVisible(true);
				pane_shopping_cart.setVisible(true);

			}
		}

	}

	@FXML
	void comprar(ActionEvent event) {
		loadCliente();
		tableCompra1.getColumns().clear();
		tableCompra1.getColumns().addAll(tableCompra.getColumns());
		tableCompra1.setItems(tableCompra.getItems());
		checkoutTitlePane.setVisible(false);
		paneComprar.setVisible(true);

	}

	@FXML
	void facturar(ActionEvent event) {
		loadCliente();
		// problema con los precios
		control.getTienda().updateComponente();

		Factura factura = new Factura(cliente.getID(), Controladora.getActualUser().getNombre(),
				Controladora.getActualUser().getID());
		ArrayList<CompoConDetalles> productos = new ArrayList<CompoConDetalles>();
		productos.addAll(tableCompra1.getItems());
		factura.setProductos(productos);
		
		if(control.getTienda().restarComponente(cliente, productos)) {
			control.getTienda().getFacturas().add(factura);
			ComTechTools.Setnotification("Exito", "Tu compra fue exitosa", 2, "mooo.png");
			/*
			 * WritableImage wim = new WritableImage((int) lineChart.getWidth(),(int)
			 * lineChart.getHeight()); Scene scena = primaryStage.getScene();
			 * print(tableCompra1);
			 */
			/*
			 * reiniciarTodo(); if(Controladora.getActualUser() instanceof Vendedor) { int
			 * cantVenta= ((Vendedor)Controladora.getActualUser()).getCantVentas();
			 * ((Vendedor)Controladora.getActualUser()).setcantVentas(cantVenta++);
			 */
//			}?
		}
		else
			ComTechTools.Setnotification("Error", "Tu compra no pudo ser completada!!", 2, "delete.png");

	}
	public void print(WritableImage writableImage, Stage primaryStage) {
        ImageView imageView =new ImageView(writableImage);
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
        double scaleX = pageLayout.getPrintableWidth() / imageView.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / imageView.getBoundsInParent().getHeight();
        imageView.getTransforms().add(new Scale(scaleX, scaleY));

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean successPrintDialog = job.showPrintDialog(primaryStage.getOwner());
            if(successPrintDialog){
                boolean success = job.printPage(pageLayout,imageView);
                if (success) {
                    job.endJob();
                }
            }
        }
    }
		

	public void reiniciarTodo() {
		pane_shopping_cart.setVisible(true);
		productosComprar.clear();
		todosProductos.clear();
		lblCantItem.setText("0");
		control.getTienda().updateComponente();
		loadTodosProductos();
		loadProductosComprar();
		checkoutTitlePane.setVisible(false);
		anchorPrincipal.setVisible(true);
		lblPriceCompra.setText("0");
		lblPriceTodos.setText("0");
		paneComprar.setVisible(false);

	}

	@FXML
	void checkout(MouseEvent event) {
		pane_shopping_cart.setVisible(false);
		loadProductosComprar();
		loadTodosProductos();
		anchorPrincipal.setVisible(false);
		checkoutTitlePane.setVisible(true);
	}

	@FXML
	void logOut(MouseEvent event) {

		com.cambiarWindow(scrollpane.getScene(), "/parteLogin/LOGIN.fxml");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		txtFieldBuscarCliente.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.ENTER) {
				loadCliente();
			}

		});
		txtBusqueda.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.ENTER) {
				llenarGridpane();
			}

		});

		control.getTienda().updateComponente();
		lblPriceCompra.setText("0");
		lblPriceTodos.setText("0");
		// TODO Auto-generated method stub
		lblUser.setText(Controladora.getActualUser().getNombre());
		busquedaComponente = "";
		scrollpane.setPrefHeight(400);
		checkoutTitlePane.setVisible(false);

		llenarGridpane();
		lblCantItem.setText("0");

	}

}
