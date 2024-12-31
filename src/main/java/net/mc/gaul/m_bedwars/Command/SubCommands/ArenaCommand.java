package net.mc.gaul.m_bedwars.Command.SubCommands;

import net.mc.gaul.m_bedwars.API.Enum.Gen;
import net.mc.gaul.m_bedwars.API.Map.ArenaSettings;
import net.mc.gaul.m_bedwars.Command.SubCommand;
import net.mc.gaul.m_bedwars.DB.ConfigGetDefault;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArenaCommand extends SubCommand {

    private List<Location> genloc1 = new ArrayList<>();
    private Map<Gen, List<Location>> genloc = new HashMap<>();

    public ArenaCommand() {
        super("arena");
    }

    @Override
    public String Permission(String Permission) {
        return "bw.arena";
    }

    @Override
    public void command(CommandSender sender, String label, String[] args) throws Exception {
        if (args.length < 3 || args[1].equalsIgnoreCase("help")){
            sender.sendMessage(ConfigGetDefault.Prefix + "/bw arena [arenaName] team [name] - 해당 팀을 생성합니다.");
            sender.sendMessage(ConfigGetDefault.Prefix + "/bw arena [arenaName] teamsize [size] - 모든 팀 인원수를 설정합니다.");
            sender.sendMessage(ConfigGetDefault.Prefix + "/bw arena [arenaName] spawn [teamName] - 팀들의 스폰 장소를 설정합니다.");
            sender.sendMessage(ConfigGetDefault.Prefix + "/bw arena [arenaName] generator [iron/gold/diamond/emerald] - 아이템 드롭 장소 설정.");
            sender.sendMessage(ConfigGetDefault.Prefix + "/bw arena [arenaName] save - 아레나를 저장합니다.");
            return;
        }
        if (! (sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ConfigGetDefault.Prefix + "Player만 사용이 가능합니다.");
            return;
        }
        ArenaSettings arenaSettings = new ArenaSettings(args[1]);
        if (args[2].equalsIgnoreCase("team")){
            arenaSettings.team(args[1], args[3]);
        }if (args[2].equalsIgnoreCase("teamsize")){
            try{
                arenaSettings.teamsize(args[1], Integer.parseInt(args[3]));
            } catch (NumberFormatException e) {
                sender.sendMessage("숫자 타입이 아닙니다. 1로 임시 설정합니다.");
            } finally {
                arenaSettings.teamsize(args[1], 1);
            }
        }if (args[2].equalsIgnoreCase("spawn")){
            arenaSettings.spawn(args[1], ((Player) sender).getLocation());
        }if (args[2].equalsIgnoreCase("generator")){
            genloc1.add(((Player) sender).getLocation());
            genloc.put(Gen.valueOf(args[3].toUpperCase()), genloc1);
            genloc1 = new ArrayList<>();
        }if (args[2].equalsIgnoreCase("save")){
            arenaSettings.generator(Gen.valueOf(args[3].toUpperCase()), genloc.get(Gen.valueOf(args[3].toUpperCase())));
            sender.sendMessage(ConfigGetDefault.Prefix + "생성기의 위치가 저장되었습니다. 타입 ["+ Gen.valueOf(args[3].toUpperCase()) + "]");
            return;
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
