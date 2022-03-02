package pl.gaway;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pl.gaway.database.GetConfig;
import pl.gaway.database.GetImgFile;
import pl.gaway.database.GetMysqlList;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Random;

import static pl.gaway.database.GetImgFile.listFilesForFolder;

public class Listeners extends ListenerAdapter {
    File folder = new File("memiki/");
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        Random generator = new Random();
        String user = msg.getAuthor().getAsTag();
        if (msg.getContentRaw().equals(GetConfig.Lang.get("memecommand"))) { //Sprawdzanie komendy memów
            MessageChannel channel = event.getChannel();
            if(GetConfig.Lang.get("mysql").equals("false")) {
                File img = new File("memiki/"+ GetImgFile.memikiImg.get(generator.nextInt(GetImgFile.memikiImg.size())));
                channel.sendMessage(GetConfig.Lang.get("memetitle")).addFile(img).queue();
            }else {
                channel.sendMessage(new EmbedBuilder().setTitle(GetConfig.Lang.get("memetitle")).setImage(GetMysqlList.memiki.get(generator.nextInt(GetMysqlList.memiki.size()))).build()).queue();
            }
        }
        if (msg.getContentRaw().equals(GetConfig.Lang.get("updatecommand"))) { //Sprawdzanie komendy update
            MessageChannel channel = event.getChannel();
            if(!user.equals(GetConfig.Lang.get("admintag"))){
                channel.sendMessage(GetConfig.Lang.get("permissionmessage")).queue();
                return;
            }
            if(GetConfig.Lang.get("mysql").equals("false")){
                listFilesForFolder(folder);
                channel.sendMessage(GetConfig.Lang.get("updatemessage")).queue();
            }else {
                try {
                    GetMysqlList.updateMeme();
                    channel.sendMessage(GetConfig.Lang.get("updatemessage")).queue();
                } catch (NullPointerException | SQLException e) {
                    channel.sendMessage("Bład mysql - " + e.getMessage()).queue();
                }
            }
        }
        if(msg.getContentRaw().equals(GetConfig.Lang.get("reloadcommand"))){
            MessageChannel channel = event.getChannel();
            if(!user.equals(GetConfig.Lang.get("admintag"))){
                channel.sendMessage(GetConfig.Lang.get("permissionmessage")).queue();
                return;
            }
            try {
                GetConfig.loadConfig();
                channel.sendMessage("Przeładowane!").queue();
                if(GetConfig.Lang.get("mysql").equals("true")){
                    GetMysqlList.updateMeme();
                    return;
                }
            } catch (FileNotFoundException | SQLException e) {
                e.printStackTrace();
                channel.sendMessage("blad " + e.getMessage()).queue();
            }

        }
    }
}
