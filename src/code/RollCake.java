package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 롤케이크 자르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * 
 * @author hyunjun
 *
 */

public class RollCake {

	public static void main(String[] args) {
//		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
		int[] topping = {1, 2, 3, 1, 4};
		
		int res = solution(topping);
		System.out.println(res);
	}
	
	public static int solution(int[] topping) {
		int answer = 0;
		int len = topping.length;
		
		Map<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < len ; i++) {
			int cnt = rightMap.getOrDefault(topping[i], 0)+1;
			rightMap.put(topping[i], cnt);
		}
	
		for(int i = 0 ; i < len ; i++) {
			int cnt = leftMap.getOrDefault(topping[i], 0)+1;
			leftMap.put(topping[i], cnt);
			
			if(rightMap.get(topping[i]) != null) {
				int deCnt = rightMap.get(topping[i])-1;
				
				if(deCnt > 0) {
					rightMap.put(topping[i], deCnt);
				} else {
					rightMap.remove(topping[i]);
				}
			}
			
			if(leftMap.keySet().size() == rightMap.keySet().size()) {
				answer++;
			}
		}
        
		return answer;
    }
}
