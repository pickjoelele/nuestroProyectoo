package kit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Util.ComTechTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loadData.loadData;
import logical.Componente;
import logical.Controladora;
import logical.miniComponente;

public class KitController {
	Controladora control = loadData.getControladora();
	@FXML
	private Pane paneUsuario;

	@FXML
	private Label lblIInformationComponente;

	@FXML
	private Label precioVentaComponente;
	@FXML
	private Label lblPrecioDescuento;
	@FXML
	private Spinner<Integer> spinnerCantidad;

	@FXML
	private Spinner<Integer> spinnerDescuento;
	@FXML
	private ImageView refreshIcon;

	@FXML
	private Label labelRefresh;
	@FXML
	private Pane pane;
	private Componente componente;

	@FXML
	void RegresarKit(ActionEvent event) {

	}

	@FXML
	void ingresarKit(ActionEvent event) {
		control.getUnkit().setCantComponente(spinnerCantidad.getValue());
		control.getUnkit().setDesCuento(spinnerDescuento.getValue());
		
		ComTechTools.Setnotification("Exito", "El kit fue ingresado con exito", 2, "mooo.png");
		Stage stage = (Stage) spinnerCantidad.getScene().getWindow();
		stage.close();

	}

	public void display() throws IOException {

		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Ingresar Un kit");
		Parent root = FXMLLoader.load(getClass().getResource("/kit/Kit.fxml"));
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.initStyle(StageStyle.UTILITY);
		window.showAndWait();

	}

	@FXML
	void getInformation(MouseEvent event) {

		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
				control.getUnkit().getCantTotal(), 1);
		valueFactory.setValue(control.getUnkit().getCantComponente());
		SpinnerValueFactory<Integer> valueFactorynum = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		valueFactorynum.setValue(control.getUnkit().getDesCuento());

		spinnerCantidad.setValueFactory(valueFactory);
		
		spinnerDescuento.setValueFactory(valueFactorynum);

		refreshIcon.setVisible(false);
		labelRefresh.setVisible(false);
		lblPrecioDescuento.setVisible(false);
		lblIInformationComponente.setText(control.getUnkit().getComp().getDetalles());
		precioVentaComponente.setText(Float.toString(control.getUnkit().getComp().getPrecioVenta()));
		pane.setDisable(false);

	}

}
