package net.mc.gaul.m_bedwars.API.gameMechanism;

import net.mc.gaul.m_bedwars.DB.ConfigGetDefault;
import net.mc.gaul.m_bedwars.M_BedWars;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

public class WorldRollBack {

    //Unloading maps, to rollback maps. Will delete all player builds until last server save
    public static void unloadMap(String mapname){

        synchronized (M_BedWars.getInstance()){
            for (Player player : Bukkit.getOnlinePlayers()){
                if(player.getWorld().getName().equals(mapname)){
                    Bukkit.getLogger().warning(ConfigGetDefault.Prefix + "예외 상황 발생! 플레이어가 맵 안에 남아있습니다!");
                }
            }
        }

        if(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false)){
            M_BedWars.getPlugin().getLogger().info("Successfully unloaded " + mapname);
        }else{
            M_BedWars.getPlugin().getLogger().severe("COULD NOT UNLOAD " + mapname);
        }
    }
    //Loading maps (MUST BE CALLED AFTER UNLOAD MAPS TO FINISH THE ROLLBACK PROCESS)
    public static void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }

    //Maprollback method, because were too lazy to type 2 lines
    public static void rollback(String mapname) {
        Bukkit.getScheduler().runTask(M_BedWars.getPlugin(), () -> {
            unloadMap(mapname);
            loadMap(mapname);
        });
    }

}
