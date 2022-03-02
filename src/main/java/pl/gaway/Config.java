package pl.gaway;

import com.github.jsixface.YamlConfig;

import java.io.*;

public class Config {
    private String token;
    private String activity;
    private String mysql;
    private String admintag;
    private String memetitle;
    private String ip;
    private String port;
    private String database;
    private String user;
    private String pass;
    private String updatemessage;
    private String permissionmessage;
    private String updatecommand;
    private String memecommand;
    private String reloadcommand;

    public Config() throws FileNotFoundException {
        this.token = token;
        this.activity = activity;
        this.mysql = mysql;
        this.admintag = admintag;
        this.memetitle = memetitle;
        this.ip = ip;
        this.port = port;
        this.database = database;
        this.user = user;
        this.pass = pass;
        this.updatemessage = updatemessage;
        this.permissionmessage = permissionmessage;
        this.memecommand = memecommand;
        this.updatecommand = updatecommand;
        this.reloadcommand = reloadcommand;
    }
    InputStream resource = new FileInputStream(new File("config.yml"));
    YamlConfig config = YamlConfig.load(resource);
    public String getToken(){return this.token= config.getString("token");}
    public String getActivity(){
        return this.activity = config.getString("activity");
    }
    public String getMysql(){
        return this.mysql = config.getString("mysql");
    }
    public String getAdmintag(){
        return this.mysql = config.getString("admintag");
    }
    public String getMemetitle(){
        return this.mysql = config.getString("memetitle");
    }
    public String getIp(){
        return this.ip = config.getString("database.ip");
    }
    public String getPort(){
        return this.port = config.getString("database.port");
    }
    public String getDatabase(){
        return this.database = config.getString("database.database");
    }
    public String getUser(){
        return this.user = config.getString("database.user");
    }
    public String getUpdatemessage(){
        return this.pass = config.getString("updatemessage");
    }
    public String getPermissionmessage(){
        return this.pass = config.getString("permissionmessage");
    }
    public String getPass(){
        return this.pass = config.getString("database.pass");
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

    public static void generateConfig(){
        try {
            FileWriter myWriter = new FileWriter("config.yml");
            myWriter.write("token: \"\" #Discord Bot token https://discord.com/developers/applications\n" +
                    "activity: \"©Gaway-code\" #Widoczna aktyność bota\n" +
                    "mysql: \"false\" #Pobieranie danych z mysql z tabeli memki kolumna link (jeżeli wyłaczone to pobiera dane z folderu memiki)\n" +
                    "admintag: \"Gaway#4391\" #Nick uprawniony do aktualizacji memów (z plików lub bazy)\n" +
                    "database: #dane do mysql\n" +
                    "  ip: \"\"\n" +
                    "  port: \"\"\n" +
                    "  database: \"\"\n" +
                    "  user: \"\"\n" +
                    "  pass: \"\"\n" +
                    "memetitle: \"Codzienna dawka memów\" #Tytuł przy wysyłaniu mema\n" +
                    "updatemessage: \"Zaktualizowane liste memów\" #wiadomość jaka wyswietla się po wykonaniu komendy aktualizującej memy\n" +
                    "permissionmessage: \"Nie masz uprawnień\" #Wiadomosc wysyłana do osoby bez uprawnień do aktualizacji\n" +
                    "memecommand: \"!meme\" #komenda do wysłania mema\n" +
                    "updatecommand: \"!update\" #komenda do aktualizacji mema\n" +
                    "reloadcommand: \"!reload\" #komenda do aktualizacji mema\n" +
                    "\n");
            myWriter.close();
            System.out.println("plik config.yml został utworzony");
        } catch (IOException e) {
            System.out.println("Blad przy tworzeniu pliku config.yml");
            e.printStackTrace();
        }
    }
}
