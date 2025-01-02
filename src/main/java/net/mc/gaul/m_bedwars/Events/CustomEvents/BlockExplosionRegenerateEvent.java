package net.mc.gaul.m_bedwars.Events.CustomEvents;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class BlockExplosionRegenerateEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    ExplosionPrimeEvent primeEvent;

    public BlockExplosionRegenerateEvent(ExplosionPrimeEvent event) {
        this.primeEvent = event;
    }

    public ExplosionPrimeEvent getPrimeEvent() {
        return primeEvent;
    }

    public void getRadius(){
        primeEvent.getRadius();
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {
        return;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }


    public static HandlerList getHandlerList() {
        return handlers;
    }
}
