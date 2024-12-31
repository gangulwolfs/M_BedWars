package net.mc.gaul.m_bedwars.API.GameUtils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Team {

    //여기 클래스 자체에 보관할 것들 생각하자.
    /**1.맴버 플레이어들을 등록할 수 있음 좋겠다. // addMember 변수 존재함.
     * 2. 팀 목록을 출력해 줄 수 있었음 좋겠다. // 목록 출력하기위한 큰 틀 준비됨.
     * 3. 팀 이름을 출력할 수 있었으 좋겠다. //출력할 수 있게 변경됨.
     * 4. 특정 플레이어를 집어서 가져다 나올 수 있었음 좋겠다. / True of false로 대체.
     */
    String teamname;
    ArrayList<Player> member;

    public Team(String teamName){
        this.teamname = teamName;
    }

    public void addMember(Player player){
        member.add(player);
    }

    public ArrayList<Player> getAllMembers(){
        return member;
    }

    public boolean getMember(Player player) {
        return member.stream()
                .anyMatch(m -> player.getName().equalsIgnoreCase(m.getName()));
    }

    public String getTeamname() {
        return teamname;
    }
}
