package kot.kotsnow.ookEditor;

import java.io.File;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

public class Controller
{
	@FXML
	private HTMLEditor htmlEditor;

	@FXML
	private MenuItem open;
	@FXML
	private MenuItem save;
	@FXML
	private MenuItem exit;
	@FXML
	private MenuItem settings;

	@FXML
	private AnchorPane aPane;

	@ FXML ToggleGroup themesGroup;

	private SyntaxHighlighter syntaxHighlighter;
	private FileOperationHandler fileOperationHandler;
	private FileChooser chooser;
	private HtmlTagHandler htmlTagHandler;
	private Style style;
	private String filename;
	private WebEngine webEngine = new WebEngine();



	public Controller(){

		chooser = new FileChooser();
		syntaxHighlighter = SyntaxHighlighter.getInstance();
		fileOperationHandler = FileOperationHandler.getInstance();
		style = Style.getInstance();
		htmlTagHandler = HtmlTagHandler.getInstance();

	}

	public void initialize(){

		try {

			htmlEditor.lookup(".top-toolbar").setManaged(false);
		    htmlEditor.lookup(".top-toolbar").setVisible(false);

		    htmlEditor.lookup(".bottom-toolbar").setManaged(false);
		    htmlEditor.lookup(".bottom-toolbar").setVisible(false);

		    htmlEditor.setHtmlText(htmlTagHandler.wrapRawText(""));
		    setTheme();


		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void open(){

	    chooser.setTitle("Otwórz");
	    try{
	    	File file = chooser.showOpenDialog(getWindow());
	    	String content = fileOperationHandler.open(file);
	    	filename = file.getName();
	    	htmlEditor.setHtmlText(htmlTagHandler.wrapRawText(content));
	    	setTheme();
	    } catch(Exception e){
	    	e.printStackTrace();
	    }
	}


	public void save(){

		try{
		chooser.setTitle("Zapisz");
		chooser.setInitialFileName(filename);
	    File file = chooser.showSaveDialog(getWindow());
	    String content = htmlTagHandler.deleteAllHtmlTags(htmlEditor.getHtmlText());
	    fileOperationHandler.save(content, file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exit(){
		System.exit(0);
	}

	public void setTheme(){
		RadioButton selectedRadioButton = (RadioButton) themesGroup.getSelectedToggle();
		style.setTheme(selectedRadioButton.getId());

		htmlEditor.setHtmlText(syntaxHighlighter.getRefreshedContentWithTags(htmlEditor.getHtmlText()));
		checkText();

	}
	public void checkText(){
		htmlEditor.setHtmlText(syntaxHighlighter.highlight(htmlEditor.getHtmlText()));

		System.out.println(htmlEditor.getHtmlText());

	}
	private Window getWindow (){
		return htmlEditor.getScene().getWindow();
	}

}
