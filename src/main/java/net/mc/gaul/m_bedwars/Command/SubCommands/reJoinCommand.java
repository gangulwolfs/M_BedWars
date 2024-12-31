package net.mc.gaul.m_bedwars.Command.SubCommands;

import net.mc.gaul.m_bedwars.Command.SubCommand;
import org.bukkit.command.CommandSender;

public class reJoinCommand extends SubCommand {
    public reJoinCommand() {
        super("rejoin");
    }

    @Override
    public String Permission(String Permission) {
        return "";
    }

    @Override
    public void command(CommandSender sender, String label, String[] args) throws Exception {

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
