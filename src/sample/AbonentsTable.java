package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

import static sample.ModuleAbonents.pickedAbonent;

public class AbonentsTable {

    @FXML
    private TableView<Abonent> abonentsInfoFull;

    @FXML
    private Button closeBtn;

    DBHandler handler = new DBHandler();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        loadAbonentTable();
        ObservableList<Abonent> abonentSearch = getAbonentSearch();
        abonentsInfoFull.setItems(abonentSearch);

        closeBtn.setOnAction(ActionEvent -> closeBtn.getScene().getWindow().hide());

    }
    private void loadAbonentTable() {
        TableColumn<Abonent, String> abonentID = new TableColumn<>(AllConstants.AbonentsConsts.ID);
        TableColumn<Abonent, String> FIO = new TableColumn<>(AllConstants.AbonentsConsts.FIO);
        TableColumn<Abonent, String> passport = new TableColumn<>(AllConstants.AbonentsConsts.PASSPORT);
        TableColumn<Abonent, String> passportDate = new TableColumn<>(AllConstants.AbonentsConsts.DATE_PSPT);
        TableColumn<Abonent, String> passportWhoGave = new TableColumn<>(AllConstants.AbonentsConsts.WHOGAVE);
        TableColumn<Abonent, String> contractNum = new TableColumn<>(AllConstants.AbonentsConsts.CONTRACT_NUM);
        TableColumn<Abonent, String> contractDate = new TableColumn<>(AllConstants.AbonentsConsts.CONTRACT_DATE);
        TableColumn<Abonent, String> contractType = new TableColumn<>(AllConstants.AbonentsConsts.CONTRACT_TYPE);
        TableColumn<Abonent, String> contractBreakDate = new TableColumn<>(AllConstants.AbonentsConsts.CONTRACT_BREAK_DATE);
        TableColumn<Abonent, String> contractBreakReason = new TableColumn<>(AllConstants.AbonentsConsts.BREAKREASON);
        TableColumn<Abonent, String> LS = new TableColumn<>(AllConstants.AbonentsConsts.PERSONAL_ACCOUNT);
        TableColumn<Abonent, String> address = new TableColumn<>(AllConstants.AbonentsConsts.ADDRESSPSPT);
        TableColumn<Abonent, String> allServices = new TableColumn<>(AllConstants.AbonentsConsts.SERVICES1);
        TableColumn<Abonent, String> techInfo = new TableColumn<>(AllConstants.AbonentsConsts.TECH_ID);
        TableColumn<Abonent, String> arendaInfo = new TableColumn<>(AllConstants.AbonentsConsts.ARENDAINFO);
        TableColumn<Abonent, String> userHelpInfo = new TableColumn<>("Обращения в тех. поддержку");

        abonentsInfoFull.getColumns().addAll(abonentID,FIO,passport,passportDate,passportWhoGave
                ,contractNum,contractDate,contractType,contractBreakDate,contractBreakReason,LS,address,allServices
                ,techInfo,arendaInfo,userHelpInfo);

        abonentID.setCellValueFactory(new PropertyValueFactory<>("id"));
        FIO.setCellValueFactory(new PropertyValueFactory<>("fio"));
        passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
        passportDate.setCellValueFactory(new PropertyValueFactory<>("date_pspt"));
        passportWhoGave.setCellValueFactory(new PropertyValueFactory<>("whogave"));
        contractNum.setCellValueFactory(new PropertyValueFactory<>("contract_num"));
        contractDate.setCellValueFactory(new PropertyValueFactory<>("contract_date"));
        contractType.setCellValueFactory(new PropertyValueFactory<>("contract_type"));
        contractBreakDate.setCellValueFactory(new PropertyValueFactory<>("contract_break_date"));
        contractBreakReason.setCellValueFactory(new PropertyValueFactory<>("breakreason"));
        LS.setCellValueFactory(new PropertyValueFactory<>("personal_account"));
        address.setCellValueFactory(new PropertyValueFactory<>("addresspspt"));
        allServices.setCellValueFactory(new PropertyValueFactory<>("services1"));
        techInfo.setCellValueFactory(new PropertyValueFactory<>("tech_id"));
        arendaInfo.setCellValueFactory(new PropertyValueFactory<>("arendainfo"));
        //userHelpInfo.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    private ObservableList<Abonent> getAbonentSearch() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> list = FXCollections.observableArrayList();
        ResultSet abonent = handler.getSearchAbonent(pickedAbonent.getId());

        while (abonent.next()){
            Abonent abonent1 = new Abonent();
            abonent1.setId(abonent.getString(AllConstants.AbonentsConsts.ID));
            abonent1.setFio(abonent.getString(AllConstants.AbonentsConsts.FIO));
            abonent1.setPassport(abonent.getString(AllConstants.AbonentsConsts.PASSPORT));
            abonent1.setDate_pspt(abonent.getString(AllConstants.AbonentsConsts.DATE_PSPT));
            abonent1.setWhogave(abonent.getString(AllConstants.AbonentsConsts.WHOGAVE));
            abonent1.setContract_num(abonent.getString(AllConstants.AbonentsConsts.CONTRACT_NUM));
            abonent1.setContract_date(abonent.getString(AllConstants.AbonentsConsts.CONTRACT_DATE));
            abonent1.setContract_type(abonent.getString(AllConstants.AbonentsConsts.CONTRACT_TYPE));
            abonent1.setContract_break_date(abonent.getString(AllConstants.AbonentsConsts.CONTRACT_BREAK_DATE));
            abonent1.setBreakreason(abonent.getString(AllConstants.AbonentsConsts.BREAKREASON));
            abonent1.setPersonal_account(abonent.getString(AllConstants.AbonentsConsts.PERSONAL_ACCOUNT));
            abonent1.setAddresspspt(abonent.getString(AllConstants.AbonentsConsts.ADDRESSPSPT));
            abonent1.setServices1(abonent.getString(AllConstants.AbonentsConsts.SERVICES1) +
                    abonent.getString(AllConstants.AbonentsConsts.SERVICES2) +
                    abonent.getString(AllConstants.AbonentsConsts.SERVICES3));
            abonent1.setTech_id(abonent.getString(AllConstants.AbonentsConsts.TECH_ID));
            abonent1.setArendainfo(abonent.getString(AllConstants.AbonentsConsts.ARENDAINFO));
            list.add(abonent1);
        }
        return list;
    }
}
