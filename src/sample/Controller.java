package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML
    private Button authBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TextField codeField;

    @FXML
    private TextField numField;

    @FXML
    private PasswordField passField;

    @FXML
    private ImageView refreshImgV;

    @FXML
    private Label timeLabel;

    public static String codeGenerated = "";
    public static int time = 0;
    public boolean canStartTimer = true;

    @FXML
    void initialize(){

        authBtn.setOnAction(Event ->{
            String code = codeField.getText().trim();
            if (code.matches(codeGenerated)){
                System.out.println("Код введен правильно!");
                setScene("Module_Abonents.fxml");
            } else System.out.println("Вы ввели неправильный код!");
        });

        numField.setOnAction(ActionEvent ->{
            System.out.println(numField.getText().trim());
            passField.setDisable(false);
        });

        passField.setOnAction(ActionEvent ->{
            System.out.println(passField.getText().trim());
            codeField.setDisable(false);
            refreshImgV.setDisable(false);
            authBtn.setDisable(false);
            if (canStartTimer){
                Timer timer = new Timer();
                generateCode();
                canStartTimer = false;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                time++;
                                timeLabel.setText(Integer.toString(10 - time));
                                if (time >= 10){
                                    System.out.println("Теперь вы можете вновь запросить код!");
                                    time = 0;
                                    canStartTimer = true;
                                    timer.cancel();
                                }
                            }
                        });
                    }
                }, 1, 1000);
            } else System.out.println("10 секунд еще не прошли!");
        });

        codeField.setOnAction(ActionEvent ->{
            System.out.println("Вы попытались войти через Enter!");
        });

        refreshImgV.setOnMouseClicked(ActionEvent ->{
            if (canStartTimer){
                Timer timer = new Timer();
                generateCode();
                canStartTimer = false;
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                time++;
                                if (time >= 10){
                                    System.out.println("Теперь вы можете вновь запросить код!");
                                    time = 0;
                                    canStartTimer = true;
                                    timer.cancel();
                                }
                            }
                        });
                    }
                }, 1, 1000);
            } else System.out.println("10 секунд еще не прошли!");
        });

        backBtn.setOnAction(Event ->{
            System.out.println("Вы завершили работу...");
            System.exit(0);
        });
    }
    public void generateCode(){
        Random random = new Random();
        int numAmount = 5;
        String code = "";
        for (int i = 0; i < numAmount; i++){
            code += random.nextInt(9);
        }
        codeGenerated = code;
        System.out.println(codeGenerated);
    }

    public static void setScene(String window){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller.class.getResource(window));

        try {
            loader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Parent Root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(Root));
        stage.setTitle("Telecom Neva");
        stage.show();
    }
}
