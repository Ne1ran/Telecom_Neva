package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModuleAbonents {

    @FXML
    private Label CRMLabel;
    @FXML
    private TableColumn<Abonent, String> FIOColumn;
    @FXML
    private TableColumn<Abonent, String> LSColumn;
    @FXML
    private Label QALabel;
    @FXML
    private TableColumn<Abonent, String> abonentsNumberColumn;
    @FXML
    private CheckBox activeCB;
    @FXML
    private Label activesLabel;
    @FXML
    private Label billingLabel;
    @FXML
    private TableView<Abonent> mainTableView;
    @FXML
    private CheckBox notActiveCB;
    @FXML
    private Label profileLabel;
    @FXML
    private TableColumn<Abonent, String> servicesColumn;
    @FXML
    private ComboBox<?> userComboB;
    @FXML
    private Label usersHelpLabel;
    @FXML
    private Label utilityLabel;
    @FXML
    private Label abonentsLabel;
    @FXML
    private TableColumn<Abonent, String> numColumn;
    @FXML
    private AnchorPane imgPane;
    @FXML
    private Button changeBtn;
    @FXML
    private Button changeBtn1;
    @FXML
    private AnchorPane textPane;
    @FXML
    private ImageView abonentsImg;
    @FXML
    private ImageView utilityImg;
    @FXML
    private ImageView activesImg;
    @FXML
    private ImageView billingImg;
    @FXML
    private ImageView userhelpImg;
    @FXML
    private ImageView CRMImg;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        loadTable();
        loadAbonents();

        CRMLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на CRM!");
        });

        QALabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на QA!");
        });

        activesLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на ACTIVES!");
        });

        billingLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на Billing!");
        });

        profileLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на иконку профиля!");
        });

        usersHelpLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на помощь!");
        });

        utilityLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на управление!");
        });

        abonentsLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на abonents!");
        });

        abonentsImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на абонентов-картинку!");
        });

        utilityImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на управление-картинку!");
        });

        activesImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на активы-картинку!");
        });

        billingImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на биллинг-картинку!");
        });

        userhelpImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на помощь-картинку!");
        });

        CRMImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на СРМ-картинку!");
        });

        changeBtn.setOnAction(Event -> {
            imgPane.setVisible(true);
            textPane.setVisible(false);
        });

        changeBtn1.setOnAction(Event -> {
            imgPane.setVisible(false);
            textPane.setVisible(true);
        });
    }

    private void loadTable() {
        numColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        FIOColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));
        abonentsNumberColumn.setCellValueFactory(new PropertyValueFactory<>("contract_num"));
        LSColumn.setCellValueFactory(new PropertyValueFactory<>("personal_account"));
        servicesColumn.setCellValueFactory(new PropertyValueFactory<>("services1"));
    }

    private void loadAbonents() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> Abonents = getAbonentsList();
        mainTableView.setItems(Abonents);
    }

    private ObservableList<Abonent> getAbonentsList() throws SQLException, ClassNotFoundException {
        DBHandler handler = new DBHandler();
        ObservableList<Abonent> list = FXCollections.observableArrayList();
        ResultSet abonentSet = handler.getAbonentsFromDB();
        while (abonentSet.next()) {
            Abonent abonent = new Abonent();
            abonent.setId(abonentSet.getString(1));
            abonent.setFio(abonentSet.getString(2));
            abonent.setContract_num(abonentSet.getString(13));
            abonent.setPersonal_account(abonentSet.getString(17));
            abonent.setServices1(abonentSet.getString(18) +
                                abonentSet.getString(19) +
                                abonentSet.getString(20));
            list.add(abonent);
        }
        return list;
    }
}
