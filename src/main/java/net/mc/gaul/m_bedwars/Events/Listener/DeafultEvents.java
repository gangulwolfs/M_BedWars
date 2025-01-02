package net.mc.gaul.m_bedwars.Events.Listener;

import net.mc.gaul.m_bedwars.DB.ConfigGetDefault;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static net.mc.gaul.m_bedwars.DB.Variables.placeBlocksData;

public class DeafultEvents implements Listener {


    @EventHandler
    public void PlaceBlock(BlockPlaceEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlockPlaced();
        Set<Block> setloc = new HashSet<>();
        //setloc.add(event.getBlock());
        //placeBlocks.put(player, setloc);
        placeBlocksData.add(event.getBlockPlaced().getLocation());
    }

    @EventHandler
    public void BlockExplosion(ExplosionPrimeEvent event){
        if(event.getEntity().getType() == EntityType.CREEPER){
            event.setCancelled(true);
        }
        if (event.getEntity().getType() == EntityType.PRIMED_TNT) {
            TNTPrimed tnt = (TNTPrimed) event.getEntity();
            float radius = event.getRadius();
            Block block = event.getEntity().getLocation().getBlock();
            Bukkit.getLogger().warning("Radius: " + radius);
            Bukkit.getLogger().warning("Block: " + block);


            // 폭발로 파괴될 블록을 확인
//            for (Block blockInRadius : block) {
//                if (!placeBlocksData.contains(blockInRadius)) {
//                    // 사용자가 설치한 블록이 아니면 파괴되지 않도록 설정
//                    event.setCancelled(true);
//                }
//            }
        }
    }

    @EventHandler
    public void BreakBlock(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (placeBlocksData == null){
            return;
        }
        Location eventblock = event.getBlock().getLocation();

        boolean canBreak = placeBlocksData.stream().anyMatch(m -> m.getBlock().getLocation().equals(eventblock));
        if(!canBreak){
            event.setCancelled(true);
            player.sendMessage("§cYou can't break this block.");
        }


        /*
        *
        * if(player.isOp()){
                return;
            }
            if(m.getBlock().getLocation().equals(eventblock)){
                return;
            }
            event.setCancelled(true);
            player.sendMessage("§cYou can't break this blocks.");
        *
        * */
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
