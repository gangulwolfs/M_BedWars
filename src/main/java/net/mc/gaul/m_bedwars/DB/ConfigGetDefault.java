package net.mc.gaul.m_bedwars.DB;

import org.bukkit.Location;

public class ConfigGetDefault {

    public static Config cfg = new Config("", "config");
    public static Location LobbyLocation = (Location) cfg.getConfig().get("server.lobbyloc");
    public static String Prefix = cfg.getConfig().getString("server.prefix").replaceAll("&", "§");

}
