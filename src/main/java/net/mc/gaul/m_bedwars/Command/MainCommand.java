package net.mc.gaul.m_bedwars.Command;

import net.mc.gaul.m_bedwars.Command.SubCommands.ArenaCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class MainCommand implements CommandExecutor {

    ArrayList<SubCommand> commandMap = new ArrayList<SubCommand>();

    public MainCommand(){
        commandMap.add(new ArenaCommand());
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
                sender.sendMessage("/bw stats [player] - 해당 유저의 스테이터스를 확인합니다.");
                return false;
            }
            if(args[0].equalsIgnoreCase(map.getName())){
                if(sender.hasPermission(map.hasPermission())){
                    try {
                        map.command(sender, label, args);
                        return true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return false;
    }
}
