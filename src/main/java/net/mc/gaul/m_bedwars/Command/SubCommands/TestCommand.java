package net.mc.gaul.m_bedwars.Command.SubCommands;

import net.mc.gaul.m_bedwars.Command.SubCommand;
import net.minecraft.server.v1_5_R3.Entity;
import net.minecraft.server.v1_5_R3.EntityVillager;
import net.minecraft.server.v1_5_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_5_R3.CraftServer;
import org.bukkit.craftbukkit.v1_5_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_5_R3.entity.CraftVillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class TestCommand extends SubCommand {
    public TestCommand() {
        super("test");
    }

    @Override
    public String Permission(String Permission) {
        return "";
    }

    @Override
    public void command(CommandSender sender, String label, String[] args) throws Exception {
        Player player = (Player) sender;
        World world = ((CraftWorld) player.getWorld()).getHandle();
        CraftServer craftServer = (CraftServer) Bukkit.getServer();
        EntityVillager entity = new EntityVillager(world);
        CraftVillager villager = new CraftVillager( craftServer, entity);
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 100000, 1000000);
        villager.addPotionEffect(potionEffect);
        world.addEntity(villager.getHandle());
        sender.sendMessage("소환 완료...");
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getCommandName() {
        return "";
    }
}
