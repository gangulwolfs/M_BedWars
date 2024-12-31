package net.mc.gaul.m_bedwars.Command;

import net.mc.gaul.m_bedwars.M_BedWars;

public class CommandRegister {

    public static void Register(){
        M_BedWars.getInstance().getCommand("bw").setExecutor(new MainCommand());
    }
}
