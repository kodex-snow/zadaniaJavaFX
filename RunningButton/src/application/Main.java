package application;

import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	int successCounter = 0;

	@Override
	public void start(Stage primaryStage) {

		Random random = new Random();

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-base: #29DF3B;");
        final int SCENE_HIGHT = 400;
        final int SCENE_WIDTH = 400;

        Scene scene = new Scene(root, SCENE_HIGHT, SCENE_WIDTH);

		primaryStage.setTitle("Hello World!");
	 	primaryStage.setScene(scene);

		Button btn = new Button();
        btn.setText("Kliknij mnie!!!");
        btn.setStyle("-fx-font: 20 arial; -fx-base: #FAFF54;");
        btn.setLayoutX(100);
        btn.setLayoutY(200);


        Label label = new Label("Licznik udanych prób : "+successCounter);
        label.setStyle("-fx-font: 20 arial; -fx-base: #FAFF54;");
        label.setLayoutX(10);
        label.setLayoutY(5);

        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

             btn.setLayoutX(random.nextInt(SCENE_WIDTH-10));
             btn.setLayoutY(random.nextInt(SCENE_HIGHT-10));

            }});

        //btn.setOnMouseExited(e->btn.setTranslateX(10));
        btn.setOnAction(
        		e ->{
        			successCounter++;
        			label.setText("Licznik udanych prób  : "+successCounter);
        			btn.setLayoutX(random.nextInt(SCENE_WIDTH -10));
                    btn.setLayoutY(random.nextInt(SCENE_HIGHT -10));
        			}
        		);
        root.getChildren().add(btn);
        root.getChildren().add(label);

        primaryStage.setTitle("Run!");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
