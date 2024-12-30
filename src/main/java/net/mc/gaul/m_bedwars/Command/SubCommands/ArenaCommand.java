package net.mc.gaul.m_bedwars.Command.SubCommands;

import net.mc.gaul.m_bedwars.Command.SubCommand;
import org.bukkit.command.CommandSender;

public class ArenaCommand extends SubCommand {
    public ArenaCommand() {
        super("arena");
    }

    @Override
    public String Permission(String Permission) {
        return "";
    }

    @Override
    public void command(CommandSender sender, String label, String[] args) throws Exception {
        return;
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
