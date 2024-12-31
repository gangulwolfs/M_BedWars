package net.mc.gaul.m_bedwars.Events;

import net.mc.gaul.m_bedwars.Events.Listener.DeafultEvents;
import net.mc.gaul.m_bedwars.Events.Listener.TeamEvents;
import net.mc.gaul.m_bedwars.M_BedWars;

public class EventsRegister {

    public static void Register(){
        M_BedWars.getInstance().getServer().getPluginManager().registerEvents(new TeamEvents(), M_BedWars.getPlugin());
        M_BedWars.getInstance().getServer().getPluginManager().registerEvents(new DeafultEvents(), M_BedWars.getPlugin());
    }
}
