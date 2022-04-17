package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static sample.Controller.setScene;

public class ModuleAbonents {
    @FXML private ImageView CRMImg;
    @FXML private Label CRMLabel;
    @FXML private AnchorPane CRMPane;
    @FXML private AnchorPane CRM_AskPane;
    @FXML private Button CSVBtn;
    @FXML private TextField DTSpeedOSD;
    @FXML private TableColumn<Abonent, String> FIOColumn;
    @FXML private TableColumn<Abonent, String> LSColumn;
    @FXML private AnchorPane OAAddPane;
    @FXML private ComboBox<String> OACBox;
    @FXML private AnchorPane OMCAddPane;
    @FXML private ComboBox<String> OMSCBox;
    @FXML private AnchorPane OSDAddPane;
    @FXML private ComboBox<String> OSDCBox;
    @FXML private Label QALabel;
    @FXML private Label QALabel1;
    @FXML private ImageView abonentsImg;
    @FXML private TextField abonentsLSField;
    @FXML private Label abonentsLabel;
    @FXML private TextField abonentsNum;
    @FXML private TextField abonentsNumFieldGen;
    @FXML private TableColumn<Abonent, String> abonentsNumberColumn;
    @FXML private AnchorPane abonentsPane;
    @FXML private TableView<Debter> abonentsPaysTV;
    @FXML private TextField abonentsSurname;
    @FXML private CheckBox activeCB;
    @FXML private ImageView activesImg;
    @FXML private Label activesLabel;
    @FXML private Button addOA;
    @FXML private Button addOMC;
    @FXML private Button addOSD;
    @FXML private Button addTechOA;
    @FXML private Button addTechOMC;
    @FXML private Button addTechOSD;
    @FXML private TextField appointCardDT;
    @FXML private TextField appointCardLS;
    @FXML private TextField appointCardType;
    @FXML private Button appointEnge;
    @FXML private TextField askCloseDateField;
    @FXML private TextField askCreationTimeField;
    @FXML private TextField askNumField;
    @FXML private ComboBox<String> billingDateCB;
    @FXML private ImageView billingImg;
    @FXML private Label billingLabel;
    @FXML private Button changeBtn;
    @FXML private Button changeBtn1;
    @FXML private TableView<String> engesScheduleTable;
    @FXML private AnchorPane imgPane;
    @FXML private TableView<Abonent> mainTableView;
    @FXML private CheckBox notActiveCB;
    @FXML private TableColumn<Abonent, String> numColumn;
    @FXML private Button openCalcApp;
    @FXML private Label openedLabel;
    @FXML private TableColumn<Debter, String> payDebtColumn;
    @FXML private TableColumn<Debter, String> payLSColumn;
    @FXML private TableColumn<Debter, String> payPackagePriceColumn;
    @FXML private Button paySendBtn;
    @FXML private TableColumn<Debter, String> payServiceColumn;
    @FXML private TableColumn<History, String> paysBalanceColumn;
    @FXML private Button paysBtn;
    @FXML private TableColumn<History, String> paysDateColumn;
    @FXML private TableColumn<History, String> paysDebtColumn;
    @FXML private TableView<History> paysHistoryTV;
    @FXML private TableColumn<History, String> paysSumColumn;
    @FXML private TextField problemInfoField;
    @FXML private TextField problemTypeField;
    @FXML private Label profileLabel;
    @FXML private Label profileLabel1;
    @FXML private Button searchAbonent;
    @FXML private Button searchAbonentBtn;
    @FXML private TextField searchAbonentsLS;
    @FXML private TextField searchAbonentsSurname;
    @FXML private ComboBox<String> searchDistrictCB;
    @FXML private ComboBox<String> searchStreetCB;
    @FXML private ComboBox<String> serviceCBox;
    @FXML private Label serviceInfoLabel;
    @FXML private TableView<Service> serviceInfoTableView;
    @FXML private ComboBox<String> serviceSearchCB;
    @FXML private ComboBox<String> serviceStatusCBox;
    @FXML private TableColumn<Abonent, String> servicesColumn;
    @FXML private Button setAskBtn;
    @FXML private AnchorPane setWorkerOnServicePane;
    @FXML private RadioButton sortDebtRB;
    @FXML private RadioButton sortServiceRB;
    @FXML private TextField techCoefficient;
    @FXML private TextField techDTStandart;
    @FXML private TextField techDTStandartOA;
    @FXML private TextField techDataTransfer;
    @FXML private TextField techDataTransferOA;
    @FXML private TextField techInterfaces;
    @FXML private TextField techNameOA;
    @FXML private TextField techNameOMC;
    @FXML private TextField techNameOSD;
    @FXML private TextField techPortsOA;
    @FXML private TextField techPortsOSD;
    @FXML private TextField techRate;
    @FXML private TextField techRateOSD;
    @FXML private TextField techTypeField;
    @FXML private TextField techWhereOA;
    @FXML private TextField techWhereOMC;
    @FXML private TextField techWhereOSD;
    @FXML private AnchorPane textPane;
    @FXML private ComboBox<String> type1service;
    @FXML private ComboBox<String> type2service;
    @FXML private ComboBox<String> userComboB;
    @FXML private ComboBox<String> userHelpChooseAbonent;
    @FXML private AnchorPane userHelpPane;
    @FXML private ImageView userPhotoImg;
    @FXML private ImageView userhelpImg;
    @FXML private Label usersHelpLabel;
    @FXML private ImageView utilityImg;
    @FXML private Label utilityLabel;
    @FXML private AnchorPane utilityPane;
    @FXML private AnchorPane billingPane;
    @FXML private AnchorPane billingPayPane;
    @FXML private TableView<Tech> TechTV;
    @FXML private TableColumn<Tech, String> OAColumn;
    @FXML private TableColumn<Tech, String> OSDColumn;
    @FXML private TableColumn<Tech, String> OMCColumn;
    @FXML private TextField techNumberOA;
    @FXML private TextField techNumberOSD;
    @FXML private TextField techNumberOMC;

    DBHandler handler = new DBHandler();
    public static PickedUser pickedUser = new PickedUser();
    public static Abonent pickedAbonent = new Abonent();
    public static Abonent CRMSearchAbonent = new Abonent();
    public static Tech techChosen = new Tech();
    public static Debter pickedDebter = new Debter();
    Date datenow = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    ObservableList<String> type1services = FXCollections.observableArrayList("Подключение",
            "Управление договором/контактными данными","Управление тарифом/услугой",
            "Диагностика и настройка оборудования/подключения", "Оплата услуг");
    ObservableList<String> type2serviceConn = FXCollections.observableArrayList(
            "Подключение услуг с новой инфраструктурой","Подключение услуг на существующей инфраструктуре");
    ObservableList<String> type2serviceChangeContract = FXCollections.observableArrayList(
            "Изменение условий договора","Включение в договор дополнительной услуги",
            "Изменение контактных данных");
    ObservableList<String> type2serviceChangeService = FXCollections.observableArrayList("Изменение тарифа",
            "Изменение адреса предоставления услуг","Отключение услуги", "Приостановка предоставления услуги");
    ObservableList<String> type2serviceDiag = FXCollections.observableArrayList("Нет доступа к услуге",
            "Разрыв соединения","Низкая скорость соединения");
    ObservableList<String> type2servicePay = FXCollections.observableArrayList("Выписка по платежам",
            "Информация о платежах");
    ObservableList<String> date = FXCollections.observableArrayList(simpleDateFormat.format(datenow));

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        loadUsersCB();
        loadTable();
        loadAbonents();
        loadStreetsCB();
        loadTechs();
        ObservableList<String> services = FXCollections.observableArrayList("Интернет","Мобильная связь",
                "Телевидение", "Видеонаблюдение");
        ObservableList<String> servicesStatus = FXCollections.observableArrayList("Новая","Требует выезда",
                "Закрыта");
        ObservableList<String> districts = FXCollections.observableArrayList("Василеостровский",
                "Петроградский","Адмиралтейский");

        searchDistrictCB.setItems(districts);


        userComboB.setOnAction(ActionEvent ->{
            String userPicked = userComboB.getValue();
            try {
                ResultSet userPickedInDB = handler.getUsersFromDB(userPicked);
                while (userPickedInDB.next()) {
                    pickedUser.setFio(userPickedInDB.getString(AllConstants.UsersConsts.FIO));
                    pickedUser.setWork(userPickedInDB.getString(AllConstants.UsersConsts.WORK));
                    pickedUser.setId(userPickedInDB.getString(AllConstants.UsersConsts.ID));
                    System.out.println(pickedUser.getId() + pickedUser.getFio() + pickedUser.getWork());
                    //userPhotoImg.setImage(new Image("assets/ID1516.jpg"));
                    changeBecauseOfRole(pickedUser.getWork());
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        userhelpImg.setOnMouseClicked(ActionEvent -> {
            userHelpOpen();
        });

        usersHelpLabel.setOnMouseClicked(ActionEvent -> {
            userHelpOpen();
        });


        //Тип и вид услуги и их настройка в зависимости от выборов
        type1service.setOnAction(ActionEvent ->{
            setType2Service(type1service.getValue());
        });

        type2service.setOnAction(ActionEvent ->{
            System.out.println(type2service.getValue());
        });

        //Лейбл абонентов
        abonentsLabel.setOnMouseClicked(ActionEvent -> {
            abonentsOpen();
        });

        //Лейбл оборудования
        utilityLabel.setOnMouseClicked(ActionEvent ->{
            utilityOpen();
        });

        //Лейбл для окна CRM
        CRMLabel.setOnMouseClicked(ActionEvent -> {
            CRMOpen();
        });

        //Изображение для абонентов
        abonentsImg.setOnMouseClicked(ActionEvent -> {
            abonentsOpen();
        });

        //Изображение для оборудования
        utilityImg.setOnMouseClicked(ActionEvent -> {
            utilityOpen();
        });

        //Изображение для CRM
        CRMImg.setOnMouseClicked(ActionEvent -> {
            CRMOpen();
        });

        //Производится выбор услуги в CRM
        serviceCBox.setOnAction(ActionEvent ->{
            type1service.setItems(type1services);
        });

        //Сортировка по активным абонентам
        activeCB.setOnAction(ActionEvent ->{
            try {
                if (activeCB.isSelected()) {
                    loadActiveAbonents();
                } else if (notActiveCB.isSelected()) {
                    loadNotActiveAbonents();
                } else loadAbonents();
                if (activeCB.isSelected() && notActiveCB.isSelected()) {
                    loadAbonents();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        //Сортировка по неактивным абонентам
        notActiveCB.setOnAction(ActionEvent ->{
            try {
                if (notActiveCB.isSelected()) {
                    loadNotActiveAbonents();
                } else if (activeCB.isSelected()) {
                    loadActiveAbonents();
                } else loadAbonents();
                if (activeCB.isSelected() && notActiveCB.isSelected()){
                    loadAbonents();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        //Открытие приложения для расчетов
        openCalcApp.setOnAction(ActionEvent ->{
            System.out.println("Вы пытаетесь открыть приложение для расчетов");
        });

        //Кнопка поиска абонента на окне абонентов
        searchAbonentBtn.setOnAction(ActionEvent ->{
            String query = "";
            try {
                if (!searchAbonentsSurname.getText().equals("")) {
                    query += AllConstants.AbonentsConsts.FIO + " LIKE '" + searchAbonentsSurname.getText().trim() + "%' AND ";
                }
                if (!searchAbonentsLS.getText().equals("")) {
                    query += "`" + AllConstants.AbonentsConsts.PERSONAL_ACCOUNT + "`" + " LIKE '" + searchAbonentsLS.getText().trim() + "%' + AND";
                    System.out.println(query);
                }
                if (searchDistrictCB.getValue() != null && searchStreetCB.getValue() != null) {
                    query += "`" + AllConstants.AbonentsConsts.ADDRESSPSPT + "`" + " LIKE '%" + searchDistrictCB.getValue().trim() + ", " + searchStreetCB.getValue().trim() + "%' + AND";
                } else {
                    if (searchDistrictCB.getValue() != null) {
                        query += "`" + AllConstants.AbonentsConsts.ADDRESSPSPT + "`" + " LIKE '%" + searchDistrictCB.getValue().trim() + "%' + AND";
                    }
                    if (searchStreetCB.getValue() != null) {
                        query += "`" + AllConstants.AbonentsConsts.ADDRESSPSPT + "`" + " LIKE '%" + searchStreetCB.getValue().trim() + "%' + AND";
                    }
                }
                if (query.substring(query.length() - 4).contains("AND")){
                    query = query.substring(0, query.length()-5);
                    System.out.println(query);
                }
                loadSearchAbonents(query);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        //Кнопка оставления заявки
        setAskBtn.setOnAction(ActionEvent ->{
            Service newService = new Service();
            newService.setId(askNumField.getText().trim());
            newService.setDateCreation(askCreationTimeField.getText().trim());
            newService.setLs(abonentsLSField.getText().trim());
            newService.setService(serviceCBox.getValue());
            newService.setServicetype1(type1service.getValue());
            newService.setServicetype2(type2service.getValue());
            newService.setStatus(serviceStatusCBox.getValue());
            newService.setTech(techTypeField.getText().trim());
            newService.setTroublestype(problemTypeField.getText().trim());
            newService.setTroubles(problemInfoField.getText().trim());
            newService.setDateClose(askCloseDateField.getText().trim());

            try {
                handler.addNewService(newService);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        //Кнопка для схлопывания для лейблов->image
        changeBtn.setOnAction(Event -> {
            imgPane.setVisible(true);
            textPane.setVisible(false);
        });

        //Кнопка для схлопывания для изображений->label
        changeBtn1.setOnAction(Event -> {
            imgPane.setVisible(false);
            textPane.setVisible(true);
        });

        //Кнопка включение добавления оборудования абонента
        addOA.setOnAction(ActionEvent ->{
            OAAddPane.setVisible(true);
            OMCAddPane.setVisible(false);
            OSDAddPane.setVisible(false);
        });

        //Кнопка включение добавления оборудования сетей доступа
        addOSD.setOnAction(ActionEvent ->{
            OAAddPane.setVisible(false);
            OMCAddPane.setVisible(false);
            OSDAddPane.setVisible(true);
        });

        //Кнопка включение добавления оборудования магистральных сетей
        addOMC.setOnAction(ActionEvent ->{
            OAAddPane.setVisible(false);
            OMCAddPane.setVisible(true);
            OSDAddPane.setVisible(false);
        });

        //Кнопка поиска абонента для окна CRM
        searchAbonent.setOnAction(ActionEvent ->{
            String abonentsNumber = abonentsNum.getText().trim();
            String abonentsSecondName = abonentsSurname.getText().trim();
            if (!(abonentsNumber.equals("") && abonentsSecondName.equals(""))){
                try {
                    if (handler.checkAbonent(abonentsNumber, abonentsSecondName)){
                        CRM_AskPane.setVisible(true);
                        System.out.println("Абонент найден!");
                        askCreationTimeField.setText(simpleDateFormat.format(datenow));
                        abonentsLSField.setText(CRMSearchAbonent.getPersonal_account());
                        abonentsNumFieldGen.setText(CRMSearchAbonent.getId());
                        askNumField.setText(CRMSearchAbonent.getPersonal_account() + "/" + String.join("/" , askCreationTimeField.getText().split("\\.")));
                        serviceCBox.setItems(services);
                        serviceStatusCBox.setItems(servicesStatus);
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                //Заглушка если бд не работает
                if (abonentsNumber.matches("123") && abonentsSecondName.matches("123")){
                    askNumField.setText("123"); //Заглушка
                    askCreationTimeField.setText(simpleDateFormat.format(datenow));
                    abonentsLSField.setText("123"); //Заглушка
                    abonentsNumFieldGen.setText("123"); //Заглушка
                    CRM_AskPane.setVisible(true);
                    System.out.println("Абонент найден!");
                    serviceCBox.setItems(services);
                    serviceStatusCBox.setItems(servicesStatus);
                }
            } else System.out.println("Введите хотя бы какие-то данные!");
        });

        //Кнопки для добавления разного оборудования на utilityPane. Нужно дописать считывание данных для них.
        //Добавить класс под оборудование.
        addTechOA.setOnAction(ActionEvent ->{
            System.out.println("Попытка добавить оборудование для абонента");
        });
        addTechOMC.setOnAction(ActionEvent ->{
            System.out.println("Попытка добавить оборудование для магистральных сетей");
        });
        addTechOSD.setOnAction(ActionEvent ->{
            System.out.println("Попытка добавить оборудование для сетей доступа");
        });

        //Рабочий код, который что-то делает на даблклик в строку таблицы
        mainTableView.setRowFactory( tv -> {
            TableRow<Abonent> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 ){ // && (!row.isEmpty())
                    Abonent choosenAbonent = row.getItem();
                    pickedAbonent.setId(choosenAbonent.getId());
                    setScene("Abonents_Table.fxml");
                }
            });
            return row ;
        });

        serviceInfoTableView.setRowFactory( tv -> {
            TableRow<Service> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 ){ // && (!row.isEmpty())
                    setWorkerOnServicePane.setVisible(true);
                    utilityPane.setVisible(false);
                }
            });
            return row ;
        });

        TechTV.setRowFactory( tv -> {
            TableRow<Tech> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 ){ // && (!row.isEmpty())
                    System.out.println("Doubleclick on TTV");
                    //Открываем окно с информацией об оборудовании
                }
            });
            return row ;
        });

        abonentsPaysTV.setRowFactory( tv -> {
            TableRow<Debter> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 ){ // && (!row.isEmpty())
                    Debter tempdebt = row.getItem();
                    try {
                        ResultSet tempSet = handler.getAbonentIDFromLS(tempdebt.getLs());
                        if (tempSet.next()){
                            pickedDebter.setId(tempSet.getString(1));
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    paysHistoryTV.setVisible(true);
                    try {
                        loadHistory(pickedDebter.getId());
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    paySendBtn.setVisible(true); //Сюда иф для проверки есть ли задолженность у юзера!
                }
            });
            return row ;
        });

        billingImg.setOnMouseClicked(ActionEvent -> {
            billingOpen();
        });

        billingLabel.setOnMouseClicked(ActionEvent -> {
            billingOpen();
        });

        paysBtn.setOnAction(ActionEvent ->{
            billingPayPane.setVisible(true);
            billingDateCB.setItems(date);
            serviceSearchCB.setItems(type1services);
            try {
                loadDebters();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
        //Бесполезные картинки и лейблы
        /*
        QALabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на QA!");
        });
        activesLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на ACTIVES!");
        });
        profileLabel.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на иконку профиля!");
        });
        activesImg.setOnMouseClicked(ActionEvent -> {
            System.out.println("Вы нажали на активы-картинку!");
        });
        */
    }

    //Метод для скрытия всех окон кроме оборудования и установления текста в лейбл
    private void utilityOpen(){
        utilityPane.setVisible(true);
        abonentsPane.setVisible(false);
        CRMPane.setVisible(false);
        userHelpPane.setVisible(false);
        CRM_AskPane.setVisible(false);
        setWorkerOnServicePane.setVisible(false);
        billingPane.setVisible(false);
        openedLabel.setText("Управление оборудованием");
    }

    //Метод для скрытия всех окон кроме CRM и установления текста в лейбл
    private void CRMOpen(){
        CRMPane.setVisible(true);
        abonentsPane.setVisible(false);
        utilityPane.setVisible(false);
        userHelpPane.setVisible(false);
        setWorkerOnServicePane.setVisible(false);
        billingPane.setVisible(false);
        openedLabel.setText("CRM");
    }

    //Метод для скрытия всех окон абонентов утила и установления текста в лейбл
    private void abonentsOpen(){
        abonentsPane.setVisible(true);
        CRMPane.setVisible(false);
        CRM_AskPane.setVisible(false);
        userHelpPane.setVisible(false);
        utilityPane.setVisible(false);
        setWorkerOnServicePane.setVisible(false);
        billingPane.setVisible(false);
        openedLabel.setText("Абоненты ТНС");
    }

    private void userHelpOpen(){
        abonentsPane.setVisible(false);
        CRMPane.setVisible(false);
        CRM_AskPane.setVisible(false);
        utilityPane.setVisible(false);
        setWorkerOnServicePane.setVisible(false);
        userHelpPane.setVisible(true);
        billingPane.setVisible(false);
        openedLabel.setText("Поддержка пользователей");
    }

    private void billingOpen(){
        abonentsPane.setVisible(false);
        CRMPane.setVisible(false);
        CRM_AskPane.setVisible(false);
        utilityPane.setVisible(false);
        setWorkerOnServicePane.setVisible(false);
        userHelpPane.setVisible(false);
        billingPane.setVisible(true);
        openedLabel.setText("Биллинг");
    }

    //Ниже все для mainTableView
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

    private void loadActiveAbonents() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> Abonents = getActiveAbonentsList();
        mainTableView.setItems(Abonents);
    }

    private void loadNotActiveAbonents() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> Abonents = getNotActiveAbonentsList();
        mainTableView.setItems(Abonents);
    }

    private void loadSearchAbonents(String query) throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> Abonents = getSearchAbonentsList(query);
        mainTableView.setItems(Abonents);
    }

    private void loadTechs() throws SQLException, ClassNotFoundException {
        OAColumn.setCellValueFactory(new PropertyValueFactory<>("Oa"));
        OSDColumn.setCellValueFactory(new PropertyValueFactory<>("Osd"));
        OMCColumn.setCellValueFactory(new PropertyValueFactory<>("Omc"));
        ObservableList<Tech> techs = getTechList();
        TechTV.setItems(techs);
    }

    private void loadDebters() throws SQLException, ClassNotFoundException {
        payLSColumn.setCellValueFactory(new PropertyValueFactory<>("ls"));
        payServiceColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        payPackagePriceColumn.setCellValueFactory(new PropertyValueFactory<>("package_price"));
        payDebtColumn.setCellValueFactory(new PropertyValueFactory<>("debt"));
        ObservableList<Debter> debters = getDebtList();
        abonentsPaysTV.setItems(debters);
    }

    private void loadHistory(String abonentId) throws SQLException, ClassNotFoundException {
        paysDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        paysSumColumn.setCellValueFactory(new PropertyValueFactory<>("summ"));
        paysBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
        paysDebtColumn.setCellValueFactory(new PropertyValueFactory<>("debt"));
        System.out.println(abonentId);
        ObservableList<History> histories = getHistoryList(abonentId);
        paysHistoryTV.setItems(histories);
    }

    private ObservableList<History> getHistoryList(String abonentId) throws SQLException, ClassNotFoundException {
        ObservableList<History> list = FXCollections.observableArrayList();
        ResultSet historySet = handler.getHistoryFromDB(abonentId);
        if (historySet.next()) {
            History history = new History();
            history.setDate(historySet.getString(AllConstants.PAYS.DATE));
            history.setSumm(historySet.getString(AllConstants.PAYS.SUM));
            history.setBalance(historySet.getString(AllConstants.PAYS.BALANCE));
            history.setDebt(historySet.getString(AllConstants.PAYS.DEBT));
            System.out.println(history.getBalance());
            list.add(history);
        }
        return list;
    }

    private ObservableList<Debter> getDebtList() throws SQLException, ClassNotFoundException {
        ObservableList<Debter> list = FXCollections.observableArrayList();
        ResultSet debtSet = handler.getDebterFromDB();
        while (debtSet.next()) {
            Debter debt = new Debter();
            ResultSet tempRSet = handler.getAbonentIDFromLS(debtSet.getString(AllConstants.Debters.LS));
            if (tempRSet.next()){
                ResultSet temp2rset = handler.getHistoryFromDB(tempRSet.getString(1));
                if (temp2rset.next()){
                    debt.setDebt(temp2rset.getString(AllConstants.PAYS.DEBT));
                }
            }
            debt.setLs(debtSet.getString(AllConstants.Debters.LS));
            if (!debtSet.getString(AllConstants.Debters.RATE2).equals("")){
                debt.setRate(debtSet.getString(AllConstants.Debters.RATE1) + " + " + debtSet.getString(AllConstants.Debters.RATE2));
            } else   debt.setRate(debtSet.getString(AllConstants.Debters.RATE1));
            debt.setPackage_price("123");
            list.add(debt);
        }
        return list;
    }

    private ObservableList<Abonent> getAbonentsList() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> list = FXCollections.observableArrayList();
        ResultSet abonentSet = handler.getAbonentsFromDB();
        while (abonentSet.next()) {
            Abonent abonent = new Abonent();
            abonent.setId(abonentSet.getString(AllConstants.AbonentsConsts.ID));
            abonent.setFio(abonentSet.getString(AllConstants.AbonentsConsts.FIO));
            abonent.setContract_num(abonentSet.getString(AllConstants.AbonentsConsts.CONTRACT_NUM));
            abonent.setPersonal_account(abonentSet.getString(AllConstants.AbonentsConsts.PERSONAL_ACCOUNT));
            abonent.setServices1(abonentSet.getString(AllConstants.AbonentsConsts.SERVICES1) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES2) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES3));
            list.add(abonent);
        }
        return list;
    }

    private ObservableList<Tech> getTechList() throws SQLException, ClassNotFoundException {
        ObservableList<Tech> list = FXCollections.observableArrayList();
        ResultSet OMCList = handler.getOMCFromDB();
        ResultSet OSDList = handler.getOSDFromDB();
        ResultSet OAList = handler.getOAFromDB();
        boolean OMCHasInfo = true;
        boolean OSDHasInfo = true;
        boolean OAHasInfo = true;
        while (true) {
            if (OMCHasInfo || OSDHasInfo || OAHasInfo) {
                Tech tech = new Tech();
                if (OMCList.next()) {
                    tech.setOmc(OMCList.getString("Серийный номер"));
                    System.out.println(tech.getOmc());
                } else {
                    tech.setOmc("");
                    OMCHasInfo = false;
                }
                if (OSDList.next()) {
                    tech.setOsd(OSDList.getString("Серийный номер"));
                } else {
                    tech.setOsd("");
                    OSDHasInfo = false;
                }
                if (OAList.next()) {
                    tech.setOa(OAList.getString("Серийный номер"));
                } else {
                    tech.setOa("");
                    OAHasInfo = false;
                }
                list.add(tech);
            } else break;
        }
        return list;
    }

    // Загрузка пользователей в comboBox
    private void loadUsersCB() throws SQLException, ClassNotFoundException {
        ObservableList<String> users = getUsersListCB();
        userComboB.setItems(users);
    }

    private void loadStreetsCB() throws SQLException, ClassNotFoundException {
        ObservableList<String> streets = getStreetsCB();
        searchStreetCB.setItems(streets);
    }

    private ObservableList<Abonent> getActiveAbonentsList() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> list = FXCollections.observableArrayList();
        ResultSet abonentSet = handler.getActiveAbonentsFromDB();
        while (abonentSet.next()) {
            Abonent abonent = new Abonent();
            abonent.setId(abonentSet.getString(AllConstants.AbonentsConsts.ID));
            abonent.setFio(abonentSet.getString(AllConstants.AbonentsConsts.FIO));
            abonent.setContract_num(abonentSet.getString(AllConstants.AbonentsConsts.CONTRACT_NUM));
            abonent.setPersonal_account(abonentSet.getString(AllConstants.AbonentsConsts.PERSONAL_ACCOUNT));
            abonent.setServices1(abonentSet.getString(AllConstants.AbonentsConsts.SERVICES1) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES2) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES3));
            list.add(abonent);
        }
        return list;
    }

    private ObservableList<Abonent> getSearchAbonentsList(String query) throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> list = FXCollections.observableArrayList();

        ResultSet abonentSet = handler.searchAbonent(query);
        while (abonentSet.next()) {
            Abonent abonent = new Abonent();
            abonent.setId(abonentSet.getString(AllConstants.AbonentsConsts.ID));
            abonent.setFio(abonentSet.getString(AllConstants.AbonentsConsts.FIO));
            abonent.setContract_num(abonentSet.getString(AllConstants.AbonentsConsts.CONTRACT_NUM));
            abonent.setPersonal_account(abonentSet.getString(AllConstants.AbonentsConsts.PERSONAL_ACCOUNT));
            abonent.setServices1(abonentSet.getString(AllConstants.AbonentsConsts.SERVICES1) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES2) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES3));
            list.add(abonent);
        }
        return list;
    }

    private ObservableList<Abonent> getNotActiveAbonentsList() throws SQLException, ClassNotFoundException {
        ObservableList<Abonent> list = FXCollections.observableArrayList();
        ResultSet abonentSet = handler.getNotActiveAbonentsFromDB();
        while (abonentSet.next()) {
            Abonent abonent = new Abonent();
            abonent.setId(abonentSet.getString(AllConstants.AbonentsConsts.ID));
            abonent.setFio(abonentSet.getString(AllConstants.AbonentsConsts.FIO));
            abonent.setContract_num(abonentSet.getString(AllConstants.AbonentsConsts.CONTRACT_NUM));
            abonent.setPersonal_account(abonentSet.getString(AllConstants.AbonentsConsts.PERSONAL_ACCOUNT));
            abonent.setServices1(abonentSet.getString(AllConstants.AbonentsConsts.SERVICES1) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES2) + " " +
                    abonentSet.getString(AllConstants.AbonentsConsts.SERVICES3));
            list.add(abonent);
        }
        return list;
    }

    private ObservableList<String> getUsersListCB() throws SQLException, ClassNotFoundException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet userSet = handler.getUsersFromDB("");
        while (userSet.next()) {
            User user = new User();
            user.setFio(userSet.getString(AllConstants.UsersConsts.FIO));
            list.add(user.getFio());
        }
        return list;
    }

    private ObservableList<String> getStreetsCB() throws SQLException, ClassNotFoundException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet streetsSet = handler.getStreetsFromDB();
        while (streetsSet.next()) {
            list.add(streetsSet.getString(1).split(",")[2] + ", " +
                    streetsSet.getString(1).split(",")[3].split(" ")[1] + " " +
                    streetsSet.getString(1).split(",")[3].split(" ")[2]);
        }
        return list;
    }

    //Скрываем кнопки в зависимости от работы пользователя
    public void changeBecauseOfRole(String role){
        switch (role){
            case ("Руководитель по работе с клиентами"):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(false);
                utilityLabel.setVisible(false);
                activesImg.setVisible(false);
                activesLabel.setVisible(false);
                billingImg.setVisible(true);
                billingLabel.setVisible(true);
                userhelpImg.setVisible(false);
                usersHelpLabel.setVisible(false);
                CRMImg.setVisible(true);
                CRMLabel.setVisible(true);
                break;
            case ("Руководитель отдела технической поддержки"):
            case ("Специалист ТП (выездной инженер)"):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(true);
                utilityLabel.setVisible(true);
                activesImg.setVisible(false);
                activesLabel.setVisible(false);
                billingImg.setVisible(false);
                billingLabel.setVisible(false);
                userhelpImg.setVisible(true);
                usersHelpLabel.setVisible(true);
                CRMImg.setVisible(true);
                CRMLabel.setVisible(true);
                break;
            case ("Директор по развитию"):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(true);
                utilityLabel.setVisible(true);
                activesImg.setVisible(true);
                activesLabel.setVisible(true);
                billingImg.setVisible(true);
                billingLabel.setVisible(true);
                userhelpImg.setVisible(true);
                usersHelpLabel.setVisible(true);
                CRMImg.setVisible(true);
                CRMLabel.setVisible(true);
                break;
            case ("Технический департамент"):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(true);
                utilityLabel.setVisible(true);
                activesImg.setVisible(true);
                activesLabel.setVisible(true);
                billingImg.setVisible(false);
                billingLabel.setVisible(false);
                userhelpImg.setVisible(true);
                usersHelpLabel.setVisible(true);
                CRMImg.setVisible(true);
                CRMLabel.setVisible(true);
                break;
            case ("Бухгалтер"):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(false);
                utilityLabel.setVisible(false);
                activesImg.setVisible(true);
                activesLabel.setVisible(true);
                billingImg.setVisible(true);
                billingLabel.setVisible(true);
                userhelpImg.setVisible(false);
                usersHelpLabel.setVisible(false);
                CRMImg.setVisible(false);
                CRMLabel.setVisible(false);
                break;
            case ("Менеджер по работе с клиентами"):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(false);
                utilityLabel.setVisible(false);
                activesImg.setVisible(false);
                activesLabel.setVisible(false);
                billingImg.setVisible(false);
                billingLabel.setVisible(false);
                userhelpImg.setVisible(false);
                usersHelpLabel.setVisible(false);
                CRMImg.setVisible(true);
                CRMLabel.setVisible(true);
                break;
            case (""):
                abonentsImg.setVisible(true);
                abonentsLabel.setVisible(true);
                utilityImg.setVisible(false);
                utilityLabel.setVisible(false);
                activesImg.setVisible(false);
                activesLabel.setVisible(false);
                billingImg.setVisible(false);
                billingLabel.setVisible(false);
                userhelpImg.setVisible(false);
                usersHelpLabel.setVisible(false);
                CRMImg.setVisible(false);
                CRMLabel.setVisible(false);
        }
    }
    public void setType2Service(String type1){
        switch (type1){
            case ("Подключение"):
                type2service.setItems(type2serviceConn);
                break;
            case ("Управление договором/контактными данными"):
                type2service.setItems(type2serviceChangeContract);
                break;
            case ("Управление тарифом/услугой"):
                type2service.setItems(type2serviceChangeService);
                break;
            case ("Диагностика и настройка оборудования/подключения"):
                type2service.setItems(type2serviceDiag);
                break;
            case ("Оплата услуг"):
                type2service.setItems(type2servicePay);
        }
    }
}