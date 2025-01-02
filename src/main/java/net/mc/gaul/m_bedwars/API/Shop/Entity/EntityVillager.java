package net.mc.gaul.m_bedwars.API.Shop.Entity;


import net.minecraft.server.v1_5_R3.World;

public class EntityVillager extends net.minecraft.server.v1_5_R3.EntityVillager {
    public EntityVillager(World world, String name) {
        super(world);
        this.setAge(20);
        this.setCustomNameVisible(true);
        this.setCustomName(name);
    }

    public EntityVillager(World world, int i) {
        super(world, i);
    }
}
