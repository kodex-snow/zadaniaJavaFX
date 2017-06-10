package kot.kotsnow.ookEditor;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsController {

	@FXML
	private GridPane settingsPane;

	@FXML
	private ChoiceBox<String>  themeChoiceBox;

	@FXML
	private Button save;

	@FXML
	private Button exit;

	Style style;
	Stage window;

	public SettingsController() {
		style = Style.getInstance();
		window = new Stage();
	}

	public void display() throws IOException{

		window.initModality(Modality.APPLICATION_MODAL);
		Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
		window.setScene(new Scene(root));
		root.getStylesheets().add(EditorGUI.class.getResource("OokEditor.css").toExternalForm());
		window.show();
	}
/*
	public void save(){
		String themeName =themeChoiceBox.getValue();
		Theme theme = Theme.getTheme(themeName);
		style.setTheme();
		exit();
	}*/

	public void exit(){

		Stage stage = (Stage)exit.getScene().getWindow();
		stage.close();
	}

}
