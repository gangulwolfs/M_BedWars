package net.mc.gaul.m_bedwars.Events.Listener;

import net.mc.gaul.m_bedwars.DB.ConfigGetDefault;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeafultEvents implements Listener {

    private Map<Player, Set<Location>> placeBlocks;

    @EventHandler
    public void PlaceBlock(BlockPlaceEvent event){
        Player player = event.getPlayer();
        Set<Location> setloc = new HashSet<>();
        setloc.add(event.getBlock().getLocation());
        placeBlocks.put(player, setloc);
    }

    @EventHandler
    public void BreakBlock(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if (!placeBlocks.get(player).stream().anyMatch(m -> {
            if (player.isOp()){
                return true;
            }
            if (m.getBlock().getLocation() == event.getBlock().getLocation()){
                return true;
            }
            return false;
        })){
            event.setCancelled(true);
            player.sendMessage(ConfigGetDefault.Prefix + "이 블럭을 파괴할 권한이 없습니다.");
        }

    }
    //그니까. 블럭 파괴 방지.
//    public void OnPlayerBlockBreak(PlayerInteractEvent event){
//        Player player = event.getPlayer();
//        if (player.isOp()){
//            return;
//        }
//
//        World world = player.getWorld();
//        //world.getBlockAt()
//
//        if(ClickedBlock(event.getAction())){
//            event.setCancelled(true);
//        }
//
//    }
//
//    private boolean ClickedBlock(Action action) {
//        return action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK;
//    }
}
