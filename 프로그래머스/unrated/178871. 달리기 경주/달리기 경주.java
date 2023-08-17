import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = new ArrayList<>();
        Map<String, Integer> playerIndexMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerList.add(players[i]);
            playerIndexMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            int calledPlayerIdx = playerIndexMap.get(calling);
            int leadingPlayerIdx = calledPlayerIdx - 1;
            String leadingPlayerValue = playerList.get(leadingPlayerIdx);
            
            playerList.set(leadingPlayerIdx, calling);
            playerList.set(calledPlayerIdx, leadingPlayerValue);
            
            playerIndexMap.put(leadingPlayerValue, calledPlayerIdx);
            playerIndexMap.put(calling, leadingPlayerIdx);
        }
        
        return playerList.toArray(new String[0]);
    }
}