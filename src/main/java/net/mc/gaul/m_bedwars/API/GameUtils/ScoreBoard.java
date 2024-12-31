package net.mc.gaul.m_bedwars.API.GameUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {

    Map<String, Scoreboard> sb = new HashMap<>();
    Team team;

    public void CreateScoreBoard(String sboardName){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective(sboardName, "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(sboardName);
        sb.put(objective.getDisplayName(), objective.getScoreboard());
    }

    public void CreateTeam(String sbname, String teamName){
        this.team = sb.get(sbname).registerNewTeam(teamName);
        team.setPrefix("[ " + teamName + " ] ");
    }

    public Team getTeam(String sbname, String teamName){
        return this.team = sb.get(sbname).getTeam(teamName);
    }

    public void setLines(String name, String line, int score) {
        Scoreboard scoreboard = sb.get(name);
        if (scoreboard == null) {
            return;
        }
        Objective objective = scoreboard.getObjective(name);
        if (objective == null) {
            return;
        }
        Score scores = objective.getScore(Bukkit.getOfflinePlayer(line)); // Score 객체를 가져옴
        scores.setScore(score); // 점수 설정
    }

    public void showScoreBoard(Player player, String name){
        player.setScoreboard(sb.get(name));
    }




}
