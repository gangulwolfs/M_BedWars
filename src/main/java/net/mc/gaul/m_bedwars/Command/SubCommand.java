package net.mc.gaul.m_bedwars.Command;

import org.bukkit.command.CommandSender;

public abstract class SubCommand {

    private String name;
    private String permission;

    public SubCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String Permission(String Permission);

    public abstract void command(CommandSender sender, String label, String[] args) throws Exception;

    public abstract String getDescription();

    public abstract String getCommandName();

    public String hasPermission() {
        return this.permission;
    }

}
