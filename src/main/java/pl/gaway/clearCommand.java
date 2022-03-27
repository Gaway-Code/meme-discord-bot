package pl.gaway;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pl.gaway.database.GetConfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class clearCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(GetConfig.Lang.get("deletecommand"))) {
            Message msg = e.getMessage();
            String user = msg.getAuthor().getAsTag();
            MessageChannel channel = e.getChannel();
            if(!user.equals(GetConfig.Lang.get("admintag"))){
                channel.sendMessage(GetConfig.Lang.get("permissionmessage")).queue();
                return;
            }
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("Podaj ilość wiadomośći do usunięcia");
                usage.setDescription("użycie: "+GetConfig.Lang.get("deletecommand")+" <ilość wiadomosci>");
                e.getChannel().sendMessage(usage.build()).queue();
            } else {
                List<Message> messages = e.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                e.getChannel().deleteMessages(messages).queue();
                e.getChannel().sendMessage("Wiadomości zostały usunięte!").queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
            }
        }
    }
}
