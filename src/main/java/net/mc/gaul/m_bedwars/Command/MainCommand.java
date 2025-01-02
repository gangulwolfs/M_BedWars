package net.mc.gaul.m_bedwars.Command;

import net.mc.gaul.m_bedwars.Command.SubCommands.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class MainCommand implements CommandExecutor {

    ArrayList<SubCommand> commandMap = new ArrayList<SubCommand>();

    public MainCommand(){
        commandMap.add(new ArenaCommand());
        commandMap.add(new LobbyCommand());
        commandMap.add(new JoinCommand());
        commandMap.add(new LeaveCommand());
        commandMap.add(new reJoinCommand());
        commandMap.add(new TestCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        for (SubCommand map : commandMap){
            if (!sender.isOp()){
                sender.sendMessage("/bw join - 랜덤으로 베드워즈 게임에 참여합니다.");
                sender.sendMessage("/bw leave - 베드워즈 게임을 떠납니다.");
                sender.sendMessage("/bw rejoin - 다시 게임을 재접속 합니다.");
                return false;
            }
            if (args.length < 1){
                sender.sendMessage("/bw arena help - 아레나와 관련된 도움말을 출력합니다.");
                sender.sendMessage("/bw lobby help - 아레나와 관련된 도움말을 출력합니다.");
                sender.sendMessage("/bw stats [player] - 해당 유저의 스테이터스를 확인합니다.");
                return false;
            }
            if(isPermission(map.hasPermission()) && !sender.hasPermission(map.hasPermission())){
                sender.sendMessage("펄미션 권한이 없습니다.");
                return false;
            }
            if(args[0].equalsIgnoreCase(map.getName())){
                try {
                    map.command(sender, label, args);
                    return true;
                } catch (Exception e) {
                    Bukkit.getLogger().warning(e.getMessage());
                    }
                return false;
            }
        }
        return false;
    }

    private boolean isPermission(String s) {
        return !s.isEmpty();
    }
}
