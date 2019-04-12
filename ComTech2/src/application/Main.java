package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import loadData.loadData;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			loadData.load();
			Parent root = FXMLLoader.load(getClass().getResource("/Splashscreen/SPLASHCREEN.fxml")); 
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Principal");
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UTILITY);
		
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
