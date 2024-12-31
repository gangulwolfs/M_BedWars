package net.mc.gaul.m_bedwars.API.Map;

import net.mc.gaul.m_bedwars.API.Enum.Gen;
import net.mc.gaul.m_bedwars.API.GameUtils.Team;
import net.mc.gaul.m_bedwars.DB.Config;
import net.mc.gaul.m_bedwars.DB.Variables;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class ArenaSettings implements ArenaSettingsInterface{

    String ArenaName;

    Config cfg = new Config("", ArenaName);

    public ArenaSettings(String ArenaName){
        this.ArenaName = ArenaName;
        Config.createNewFile("Arena", ArenaName);
    }

    @Override
    public void team(String ArenaName, String teamName) {
        cfg.getConfig().set("arena.teamlist." + teamName, "");
    }

    @Override
    public void teamsize(String ArenaName, int size) {
        cfg.getConfig().set("arena.teamMaxsize", size);
    }

    @Override
    public void spawn(String TeamName, Location location) {
        cfg.getConfig().set("arena.spawn.TeamName", location);
    }

    @Override
    public void generator(Gen gen, List<Location> loc) {
        if(gen == Gen.IRON){
            cfg.getConfig().set("arena.gen.iron", loc);
        } else if(gen == Gen.GOLD){
            cfg.getConfig().set("arena.gen.gold", loc);
        } else if(gen == Gen.DIAMOND){
            cfg.getConfig().set("arena.gen.diamond", loc);
        } else if(gen == Gen.EMERALD){
            cfg.getConfig().set("arena.gen.emerald", loc);
        }
    }

    @Override
    public void save() {

    }

    @Override
    public void shop() {

    }
}
