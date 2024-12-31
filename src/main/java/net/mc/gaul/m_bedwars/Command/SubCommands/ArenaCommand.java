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
        if (args.length < 2 || args[1].equalsIgnoreCase("help")){
            sender.sendMessage("/bw arena [arenaName] team [name] - 해당 팀을 생성합니다.");
            sender.sendMessage("/bw arena [arenaName] teamsize [size] - 모든 팀 인원수를 설정합니다.");
            sender.sendMessage("/bw arena [arenaName] spawn [teamName] - 팀들의 스폰 장소를 설정합니다.");
            sender.sendMessage("/bw arena [arenaName] generator [iron/gold/diamond/emerald] - 아이템 드롭 장소 설정.");
            sender.sendMessage("/bw arena [arenaName] save - 아레나를 저장합니다.");
            return;
        }
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
