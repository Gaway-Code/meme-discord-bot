package pl.gaway.database;

import pl.gaway.Config;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection con;

    public static void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+GetConfig.Lang.get("ip")+":"+GetConfig.Lang.get("port")+"/"+GetConfig.Lang.get("database"), GetConfig.Lang.get("user"), GetConfig.Lang.get("pass"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
