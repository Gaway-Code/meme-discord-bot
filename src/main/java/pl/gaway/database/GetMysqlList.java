package pl.gaway.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetMysqlList {
    public static List<String> memiki = new ArrayList<>();

    public static void updateMeme() throws SQLException { //Funkcja pobiera memy z bazy danych
        MySQL.connect();
        ResultSet rs = MySQL.con.createStatement().executeQuery("SELECT * FROM memki");
        while(rs.next()) {
            memiki.add(rs.getString("link"));
        }
        MySQL.disconnect();
    }
}
