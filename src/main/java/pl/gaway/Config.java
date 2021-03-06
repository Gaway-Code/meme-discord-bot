package pl.gaway;

import com.github.jsixface.YamlConfig;

import java.io.*;

public class Config {
    private String token;
    private String activity;
    private String json;
    private String jsonUrl;
    private String admintag;
    private String memetitle;
    private String updatemessage;
    private String permissionmessage;
    private String updatecommand;
    private String memecommand;
    private String reloadcommand;
    private String deletecommand;

    public Config() throws FileNotFoundException {
        this.token = token;
        this.activity = activity;
        this.json = json;
        this.jsonUrl = jsonUrl;
        this.admintag = admintag;
        this.memetitle = memetitle;
        this.updatemessage = updatemessage;
        this.permissionmessage = permissionmessage;
        this.memecommand = memecommand;
        this.updatecommand = updatecommand;
        this.reloadcommand = reloadcommand;
        this.deletecommand = deletecommand;
    }
    InputStream resource = new FileInputStream(new File("config.yml"));
    YamlConfig config = YamlConfig.load(resource);
    public String getToken(){return this.token= config.getString("token");}
    public String getActivity(){
        return this.activity = config.getString("activity");
    }
    public String getJson(){
        return this.json = config.getString("json");
    }
    public String getJsonUrl(){
        return this.jsonUrl = config.getString("json-url");
    }
    public String getAdmintag(){
        return this.admintag = config.getString("admintag");
    }
    public String getMemetitle(){
        return this.memetitle = config.getString("memetitle");
    }
    public String getUpdatemessage(){
        return this.updatemessage = config.getString("updatemessage");
    }
    public String getPermissionmessage(){
        return this.permissionmessage = config.getString("permissionmessage");
    }
    public String getMemeCommand(){
        return this.memecommand = config.getString("memecommand");
    }
    public String getUpdatecommand(){
        return this.updatecommand = config.getString("updatecommand");
    }
    public String getReloadcommand(){
        return this.updatecommand = config.getString("reloadcommand");
    }
    public String getDeletecommand(){return this.deletecommand = config.getString("deletecommand");}

    public static void generateConfig(){
        try {
            PrintWriter writer = new PrintWriter("config.yml", "UTF-8");
            writer.print("token: \"\" #Discord Bot token https://discord.com/developers/applications\n" +
                    "activity: \"??Gaway-code\" #Widoczna aktyno???? bota\n" +
                    "json: \"false\" #Pobieranie danych z mysql z tabeli memki kolumna link (je??eli wy??aczone to pobiera dane z folderu memiki)\n" +
                    "json-url: \"http://meme.gaway.pl/json.php\" #Url do jsona wygenerowanego z aplikacji (Discord-meme-bot-Panel)\n" +
                    "admintag: \"Gaway#4391\" #Nick uprawniony do aktualizacji mem??w (z plik??w) i do usuwania wiadomo??ci\n" +
                    "memetitle: \"Codzienna dawka mem??w\" #Tytu?? przy wysy??aniu mema\n" +
                    "updatemessage: \"Zaktualizowane liste mem??w\" #wiadomo???? jaka wyswietla si?? po wykonaniu komendy aktualizuj??cej memy\n" +
                    "permissionmessage: \"Nie masz uprawnie??\" #Wiadomosc wysy??ana do osoby bez uprawnie?? \n" +
                    "memecommand: \"!meme\" #komenda do wys??ania mema\n" +
                    "updatecommand: \"!update\" #komenda do aktualizacji mema\n" +
                    "reloadcommand: \"!reload\" #komenda do prze??adowania konfiguracji\n" +
                    "deletecommand: \"!usun\" #komenda do usuwania wiadomosci\n");

            writer.close();
            System.out.println("plik config.yml zosta?? utworzony");
        } catch (IOException e) {
            System.out.println("Blad przy tworzeniu pliku config.yml");
            e.printStackTrace();
        }
    }
}
