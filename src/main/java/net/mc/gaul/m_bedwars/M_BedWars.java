package net.mc.gaul.m_bedwars;

import net.mc.gaul.m_bedwars.Command.CommandRegister;
import net.mc.gaul.m_bedwars.Events.EventsRegister;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class M_BedWars extends JavaPlugin {

    static Plugin plugin;
    static M_BedWars instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.plugin = this;
        this.instance = this;
        CommandRegister.Register();
        EventsRegister.Register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static M_BedWars getInstance() {
        return instance;
    }
}
