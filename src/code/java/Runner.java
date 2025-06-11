package code.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * 
 * @author hyunjun
 *
 */

public class Runner {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		solution(participant, completion);
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		
		for(String p : participant) {	// 참가자 정보 HashMap에 저장
			if(pMap.get(p) == null) {
				pMap.put(p, 1);
			} else {
				int num = pMap.get(p);
				pMap.put(p, num+1);
			}
		}
		
		for(String c : completion) {	// 완주하지 못한 선수 추출
			if(pMap.get(c) > 0) {
				int num = pMap.get(c);
				
				if(num-1 == 0) {
					pMap.remove(c);
				} else if(num-1 > 0) {
					pMap.put(c, num-1);
				}
			}
		}
		
		answer = pMap.keySet().toString().replace("[", "").replace("]", "");
		return answer;
    }
}
