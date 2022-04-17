package sample;

import java.sql.*;

import static sample.ModuleAbonents.CRMSearchAbonent;

public class DBHandler extends Config{
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://"+ Host + ":" + Port + "/" + Name;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connStr, User, Password);
        return connection;
    }

    public ResultSet getAbonents() throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    //Не нужно
    /*
    public boolean checkNumber(String number) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT numbers FROM dbname WHERE number =?";
        PreparedStatement prst = getConnection().prepareStatement(select);
        prst.setString(1, number);
        rset = prst.executeQuery();
        if (rset.wasNull()){
            System.out.println("Номера нету");
            return false;
        } else return true;
    }

    public boolean checkPassword(String number, String password) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT numbers FROM dbname WHERE number =? and password =?";
        PreparedStatement prst = getConnection().prepareStatement(select);
        prst.setString(1, number);
        prst.setString(2, password);
        rset = prst.executeQuery();
        if (rset.wasNull()){
            System.out.println("Номера нету");
            return false;
        } else return true;
    }
    */

    public ResultSet getAbonentsFromDB() throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE;

        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();

        return rset;
    }

    public ResultSet getActiveAbonentsFromDB() throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE + " where `Дата расторжения договора` = ''";

        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();

        return rset;
    }

    public ResultSet getNotActiveAbonentsFromDB() throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE + " where `Дата расторжения договора` != ''";

        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();

        return rset;
    }
    public ResultSet searchAbonent(String query) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE + " where " + query;

        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();

        return rset;
    }

    public ResultSet getUsersFromDB(String FIO) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        if (FIO.equals("")) {
            String select = "SELECT * FROM " + AllConstants.UsersConsts.USERS_TABLE;
            PreparedStatement prst = getConnection().prepareStatement(select);
            rset = prst.executeQuery();
            return rset;
        } else {
            String select = "SELECT * FROM " + AllConstants.UsersConsts.USERS_TABLE + " WHERE ФИО =?";
            PreparedStatement prst = getConnection().prepareStatement(select);
            prst.setString(1, FIO);
            rset = prst.executeQuery();
            return rset;
        }
    }

    public ResultSet getStreetsFromDB() throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT `Адрес прописки` FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public boolean checkAbonent(String num, String surname) throws SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE + " WHERE ФИО LIKE '"
                + surname + "%' AND `Номер телефона` LIKE '%" + num + "%'" ;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        if (rset.next()){
            CRMSearchAbonent.setPersonal_account(rset.getString("Лицевой счет"));
            CRMSearchAbonent.setId(rset.getString("Номер абонента"));
            return true;
        } else return false;
    }

    public ResultSet getSearchAbonent(String abonentID) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE
                + " WHERE `Номер абонента` = '" + abonentID + "'";
        System.out.println(select);
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public ResultSet getDebterFromDB( ) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.Debters.DEBT_TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public ResultSet getHistoryFromDB(String abonentId) throws  SQLException, ClassNotFoundException {
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.PAYS.PAYS_TABLE + " WHERE `Номер абонента` = '" + abonentId + "'";
        System.out.println(select);
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public ResultSet getAbonentIDFromLS(String ls) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT `Номер абонента` FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE
                + " WHERE `Лицевой счет` = '" + ls + "'";
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public ResultSet getOMCFromDB( ) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.OMCConsts.OMC_TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }
    public ResultSet getOSDFromDB( ) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.OSDConsts.OSD_TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }
    public ResultSet getOAFromDB( ) throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.OAConsts.OA_TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public void addNewService(Service service) throws SQLException, ClassNotFoundException{
        String insert = "INSERT INTO " + AllConstants.ServicesConsts.SERVICES_TABLE + "("
                + AllConstants.ServicesConsts.ID + ',' + AllConstants.ServicesConsts.CREATE_DATE + ',' +
                AllConstants.ServicesConsts.LS + ',' + AllConstants.ServicesConsts.SERVICE + ',' +
                AllConstants.ServicesConsts.SERVICE_TYPE1 + ',' + AllConstants.ServicesConsts.SERVICE_TYPE2 + ',' +
                AllConstants.ServicesConsts.STATUS + ',' + AllConstants.ServicesConsts.TECH + ',' +
                AllConstants.ServicesConsts.TROUBLES + ',' + AllConstants.ServicesConsts.CLOSE_DATE + ','
                + AllConstants.ServicesConsts.TROUBLE_TYPE + ')' + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(insert);
        PreparedStatement prst = getConnection().prepareStatement(insert);
        prst.setString(1, service.getId());
        prst.setString(2, service.getDateCreation());
        prst.setString(3, service.getLs());
        prst.setString(4, service.getService());
        prst.setString(5, service.getServicetype1());
        prst.setString(6, service.getServicetype2());
        prst.setString(7, service.getStatus());
        prst.setString(8, service.getTech());
        prst.setString(9, service.getTroubles());
        prst.setString(10, service.getDateClose());
        prst.setString(11, service.getTroublestype());
        prst.executeUpdate();
    }
}
