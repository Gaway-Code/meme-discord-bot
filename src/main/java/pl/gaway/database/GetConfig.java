package pl.gaway.database;

import pl.gaway.Config;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class GetConfig {

    public static HashMap<String,String> Lang=new HashMap<>();
    public static void loadConfig() throws FileNotFoundException {
        Config c = new Config();
        Lang.put("token", c.getToken());
        Lang.put("activity",c.getActivity());
        Lang.put("json",c.getJson());
        Lang.put("json-url",c.getJsonUrl());
        Lang.put("admintag",c.getAdmintag());
        Lang.put("memetitle",c.getMemetitle());
        Lang.put("updatemessage",c.getUpdatemessage());
        Lang.put("permissionmessage",c.getPermissionmessage());
        Lang.put("memecommand",c.getMemeCommand());
        Lang.put("updatecommand",c.getUpdatecommand());
        Lang.put("reloadcommand",c.getReloadcommand());
        Lang.put("deletecommand",c.getDeletecommand());
    }
}
