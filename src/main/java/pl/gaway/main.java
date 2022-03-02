package pl.gaway;

import com.github.jsixface.YamlConfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import pl.gaway.database.GetConfig;
import pl.gaway.database.GetMysqlList;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static pl.gaway.database.GetImgFile.listFilesForFolder;

public class main {

    public static void main(String[] args) throws LoginException, IOException {
        File config = new File("config.yml");
        File folder = new File("memiki/");

        if (!folder.exists()) {
            folder.mkdir();
        }
        if(!config.exists()){
            Config.generateConfig();
            System.exit(0);
        }
        GetConfig.loadConfig();

        JDA jda = JDABuilder.createDefault(GetConfig.Lang.get("token")).setActivity(Activity.watching(GetConfig.Lang.get("activity"))).build(); //budowanie bota
        jda.addEventListener(new Listeners());//dodanie listenera z komendami
        listFilesForFolder(folder); //pobieranie memów z folderu memiki

        if(!GetConfig.Lang.get("mysql").equals("true")) {
            try {
                GetMysqlList.updateMeme(); //pobieranie memów z bazy
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
