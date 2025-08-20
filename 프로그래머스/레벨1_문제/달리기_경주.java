package 레벨1_문제;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            playerMap.put(players[i], i);
        }
        for(String calledPlayer : callings){
            int idx = playerMap.get(calledPlayer);
            String formerPlayer = players[idx-1];

            playerMap.put(calledPlayer, idx-1);
            playerMap.put(formerPlayer, idx);
            players[idx] = formerPlayer;
            players[idx - 1] = calledPlayer;

        }
        return players;
    }
}
