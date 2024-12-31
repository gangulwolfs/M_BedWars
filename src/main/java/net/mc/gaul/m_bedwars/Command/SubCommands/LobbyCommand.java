package net.mc.gaul.m_bedwars.Command.SubCommands;

import net.mc.gaul.m_bedwars.Command.SubCommand;
import net.mc.gaul.m_bedwars.DB.ConfigGetDefault;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand extends SubCommand {
    public LobbyCommand() {
        super("lobby");
    }

    @Override
    public String Permission(String Permission) {
        return "bw.lobby";
    }

    @Override
    public void command(CommandSender sender, String label, String[] args) throws Exception {
        if (args.length < 2 || args[1].equalsIgnoreCase("help")){
            sender.sendMessage(ConfigGetDefault.Prefix + "/bw lobby setlobby - 로비 장소를 설정합니다.");
            return;
        }
        if(args[1].equalsIgnoreCase("setlobby")){
            Player player = (Player) sender;
            ConfigGetDefault.cfg.getConfig().set("server.lobbyloc", player.getLocation());
            sender.sendMessage(ConfigGetDefault.Prefix + "성공적으로 로비의 위치가 설정되었습니다.");
        }
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
