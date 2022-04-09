package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Telecom Neva");
        primaryStage.setScene(new Scene(root, 662, 307));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
