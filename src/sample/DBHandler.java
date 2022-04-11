package sample;

import java.sql.*;

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

    public ResultSet getAbonentsFromDB() throws  SQLException, ClassNotFoundException{
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AbonentsConsts.ABONENTS_TABLE;

        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();

        return rset;
    }

}
