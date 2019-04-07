package Vendedor;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Util.ComTechTools;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import loadData.loadData;
import logical.Componente;
import logical.Controladora;
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

	private void llenarGridpane() {
		int x = 0;

		GridPane grid = new GridPane();
		grid.setPrefWidth(878);

		grid.setVgap(15);

		anchorPrincipal.getChildren().add(grid);
		for (miniComponente comp : control.getTienda().getComponentes()) {

			BorderPane borderPic = new BorderPane();
			BorderPane borderDescription = new BorderPane();

			Image image = new Image(comp.getComp().getImagen());
			ImageView img = new ImageView(image);
			img.setFitWidth(334);
			img.setFitHeight(60);
			borderPic.setCenter(img);
			borderPic.setPrefHeight(140);
			borderPic.setPrefWidth(340);
			borderPic.setStyle("-fx-background-color:white");

			Label label = new Label(comp.getComp().getDetalles().toUpperCase());
			label.setStyle("-fx-font: 15px 'System'");

			borderDescription.setStyle("-fx-background-color:white");
			Label labelPrice = new Label(Float.toString(comp.getComp().getPrecioVenta()) + "  $ RD");
			labelPrice.setStyle("-fx-font-size: 16px;-fx-font-weight:bold");
			borderDescription.setBottom(labelPrice);
			borderDescription.setCenter(label);
			borderDescription.setPrefWidth(362);

			Pane pane = new Pane();
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
			Spinner<Integer> spin = new Spinner<Integer>();
			SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
					comp.getComp().getCantDispo(), 1);
			spin.setValueFactory(valueFactory);
			spin.setPrefSize(150, 25);
			spin.setStyle(
					"-fx-background-color: #1F5050; -fx-background-radius: 6px;-fx-text-fill:white;-fx-font-size:12px");
			VBox vbox = new VBox(spin, btnAgregar, btnComprar);
			VBox.setMargin(btnComprar, new Insets(10, 0, 0, 0));
			VBox.setMargin(btnAgregar, new Insets(15, 0, 0, 0));
			VBox.setMargin(spin, new Insets(8, 0, 0, 0));

			pane.getChildren().add(vbox);
			borderDescription.setStyle("-fx-background-color:white");

			grid.add(borderPic, 0, x);
			grid.add(borderDescription, 1, x);
			grid.add(pane, 2, x);
			grid.setPrefHeight(height * (x + 1));
			grid.setMaxHeight(height * (x + 1));
			x++;
		}
		scrollpane.setContent(grid);
	}

	@FXML
	void salir(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			loadData.saveTienda();
			System.exit(0);
		} else {
			Stage stage = (Stage) scrollpane.getScene().getWindow();
			stage.close();
		    
		}
	}

	@FXML
	void logOut(MouseEvent event) {
		com.cambiarWindow(scrollpane.getScene(), "/parteLogin/LOGIN.fxml");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblUser.setText(Controladora.getActualUser().getNombre());

		scrollpane.setPrefHeight(450);
		llenarGridpane();

	}

}
