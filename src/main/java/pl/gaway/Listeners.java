package pl.gaway;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pl.gaway.database.GetConfig;
import pl.gaway.database.GetImgFile;
import pl.gaway.database.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static pl.gaway.database.GetImgFile.listFilesForFolder;

public class Listeners extends ListenerAdapter {
    File folder = new File("memiki/");
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        Random generator = new Random();
        String user = msg.getAuthor().getAsTag();
        if (msg.getContentRaw().equals(GetConfig.Lang.get("memecommand"))) { //Sprawdzanie komendy memów
            JsonObject jsonObject = new JsonParser().parse(json.jsonGetRequest(GetConfig.Lang.get("json-url"))).getAsJsonObject();
            MessageChannel channel = event.getChannel();
            if(GetConfig.Lang.get("json").equals("false")) {
                File img = new File("memiki/"+ GetImgFile.memikiImg.get(generator.nextInt(GetImgFile.memikiImg.size())));

            }else {
                channel.sendMessage(new EmbedBuilder().setTitle(GetConfig.Lang.get("memetitle")).setImage(jsonObject.get("url").getAsString()).build()).queue();
            }
        }
        if (msg.getContentRaw().equals(GetConfig.Lang.get("updatecommand"))) { //Sprawdzanie komendy update
            MessageChannel channel = event.getChannel();
            if(!user.equals(GetConfig.Lang.get("admintag"))){
                channel.sendMessage(GetConfig.Lang.get("permissionmessage")).queue();
                return;
            }
            if(GetConfig.Lang.get("json").equals("false")){
                listFilesForFolder(folder);
                channel.sendMessage(GetConfig.Lang.get("updatemessage")).queue();
            }else {
                channel.sendMessage("Memów wrzuconych nie musisz przeładowywać!").queue();
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
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                channel.sendMessage("blad " + e.getMessage()).queue();
            }
        }
    }
}
