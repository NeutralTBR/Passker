import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class mainApp extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Button btn1=new Button("Say, Hello World");
    }
}