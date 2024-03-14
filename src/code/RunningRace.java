package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 달리기 경주
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * 
 * @author hyunjun
 *
 */

public class RunningRace {

	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		
		solution(players, callings);
	}
	
	public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        int i = 0;
        for(String p : players) {
        	map.put(p, i++);
        }
        
        for(String c : callings) {
        	int idx = map.get(c);
        	int raceIdx = idx-1;
        	map.put(c, raceIdx);
        	
        	String behindPlayer = players[raceIdx];
        	map.put(behindPlayer, idx);
        	
        	players[raceIdx] = c;
        	players[idx] = behindPlayer;
        }
        
        return players;
    }
}
