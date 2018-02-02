package LSubProces;

import Eror.LogEror;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {

    private Connection Con = null;
    //String url = "jdbc:mysql://localhost:3306/";
    //String user = "root";
    //String pass = "";
    String db = "dbinventoryit";
    //String url = "jdbc:mysql://localhost/";
    String url = "jdbc:mysql://192.168.1.20:1358/";
    String user = "root";
    String pass = "";

    public String GetUrl() {
        return url;
    }

    public String GetDb() {
        return db;
    }

    public String GetUser() {
        return user;
    }

    public String GetPass() {
        return pass;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url + db, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            LogEror.SaveEror(ex);
            JOptionPane.showMessageDialog(null, "Koneksi Ke Server Database Gagal !!!");

        }
        return Con;
    }
}
