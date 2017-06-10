package kot.kotsnow.ookEditor;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EditorGUI extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));

		primaryStage.setScene(new Scene(root));
		root.getStylesheets().add(EditorGUI.class.getResource("OokEditor.css").toExternalForm());
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
