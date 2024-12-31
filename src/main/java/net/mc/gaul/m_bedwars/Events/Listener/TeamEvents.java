package net.mc.gaul.m_bedwars.Events.Listener;

import net.mc.gaul.m_bedwars.DB.Config;
import net.mc.gaul.m_bedwars.DB.ConfigGetDefault;
import net.mc.gaul.m_bedwars.DB.Variables;
import net.mc.gaul.m_bedwars.M_BedWars;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class TeamEvents implements Listener {

    @EventHandler
    public void PlayerHit(EntityDamageByEntityEvent event){
        EntityType etype = event.getDamager().getType();
        if (!isPlayer(etype)){
            return;
        }
        //데미지를 받은 사람.
        Player player = (Player) event.getEntity();
        //데미지를 준 사람.
        Player hitplayer = (Player) event.getDamager();
        if(Variables.team.stream().anyMatch(m -> m.getMember(player) && m.getMember(hitplayer))){
            event.setCancelled(true);
            player.sendMessage(ConfigGetDefault.Prefix + "같은 팀은 때릴 수 없습니다.");
        }

    }


    @EventHandler
    public void TeamDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
    }

    @EventHandler
    public void TeamRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ConfigGetDefault.Prefix + "죽으셨습니다!");
        player.setGameMode(GameMode.SURVIVAL);
        player.setAllowFlight(true);
        Config cfg = new Config("Arena", player.getWorld().getName());
        player.teleport( (Location) cfg.getConfig().get("arena.specLoc"));
        Bukkit.getScheduler().runTaskTimer(M_BedWars.getPlugin(), new Runnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                player.sendMessage(ConfigGetDefault.Prefix + i + "초 후 리스폰 됩니다.");
            }
        }, 20L, 5);
    }

    public boolean isPlayer(EntityType type){
        return type == EntityType.PLAYER;
    }
}
