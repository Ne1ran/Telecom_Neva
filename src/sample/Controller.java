package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML private Button authBtn;
    @FXML private Button backBtn;
    @FXML private TextField codeField;
    @FXML private TextField numField;
    @FXML private PasswordField passField;
    @FXML private ImageView refreshImg;

    public static String codeGenerated = "";
    public static boolean canStartTimer = true;
    public static int time = 0;

    @FXML
    void initialize(){
        authBtn.setOnAction(ActionEvent ->{
            System.out.println("Вы попытались авторизироваться!");
            if (codeGenerated.matches(codeField.getText().trim())) {
                System.out.println("Успешная авторизация через код! и кнопку");
            } else System.out.println("Код введен неверно");
        });

        backBtn.setOnAction(ActionEvent ->{
            System.out.println("Вы закрыли программу...");
            System.exit(0);
        });

        numField.setOnAction(ActionEvent ->{
            System.out.println(numField.getText().trim());
            passField.setDisable(false);
        });

        passField.setOnAction(ActionEvent ->{
            System.out.println(passField.getText().trim());
            codeField.setDisable(false);
            refreshImg.setDisable(false);
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

        codeField.setOnAction(ActionEvent ->{
            if (codeGenerated.matches(codeField.getText().trim())) {
                System.out.println("Успешная авторизация через код! и Enter");
            } else System.out.println("Код введен неверно");
        });

        refreshImg.setOnMouseClicked(ActionEvent ->{
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
    }

    public void generateCode(){
        Random random = new Random();
        int numsInCode = 5;
        String code = "";
        for (int i = 0; i < numsInCode; i++){
            code += random.nextInt(9);
        }
        codeGenerated = code;
        System.out.println(codeGenerated);
    }
}
