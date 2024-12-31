package net.mc.gaul.m_bedwars.API.Map;

import net.mc.gaul.m_bedwars.API.Enum.Gen;
import org.bukkit.Location;

import java.util.List;

public interface ArenaSettingsInterface {

    void team(String ArenaName, String teamName);
    void teamsize(String ArenaName, int size);
    void spawn(String TeamName, Location location);
    void generator(Gen gen, List<Location> loc);
    void save();
    void shop();

}
