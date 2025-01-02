package net.mc.gaul.m_bedwars.DB;

import net.mc.gaul.m_bedwars.API.GameUtils.Team;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.*;

public class Variables {

    public static ArrayList<Team> team = new ArrayList<>();
    public static Map<Player, Set<Block>> placeBlocks = new HashMap<>();
    public static ArrayList<Location> placeBlocksData = new ArrayList<>();;

}
