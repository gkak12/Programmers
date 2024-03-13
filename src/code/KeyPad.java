package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 키패드 누르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * 
 * @author hyunjun
 *
 */

public class KeyPad {

	public static void main(String[] args) {
//		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//		String hand = "right";
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		solution(numbers, hand);
	}
	
	public static String solution(int[] numbers, String hand) {
		String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int leftPos = 10;	// 왼손 위치
        int rightPos = 12;	// 오른손 위치
        int leftDistance = 0;
        int rightDistance = 0;
        int[] nArr = null;
        int[] leftArr = null;
        int[] rightArr = null;
        
        // 키패드와 해당 키패드 인덱스 map에 저장
        Map<Integer, int[]> keyMap = new HashMap<Integer, int[]>();
		keyMap.put(1, new int[] {0, 0});keyMap.put(2, new int[] {0, 1});keyMap.put(3, new int[] {0, 2});
		keyMap.put(4, new int[] {1, 0});keyMap.put(5, new int[] {1, 1});keyMap.put(6, new int[] {1, 2});
		keyMap.put(7, new int[] {2, 0});keyMap.put(8, new int[] {2, 1});keyMap.put(9, new int[] {2, 2});
		keyMap.put(leftPos, new int[] {3, 0});keyMap.put(0, new int[] {3, 1});keyMap.put(rightPos, new int[] {3, 2});
        
        for(int n : numbers) {
        	if(n == 1 || n == 4 || n == 7) {	// 왼쪽 키패드인 경우
        		leftPos = n;
        		sb.append("L");
        	} else if(n == 3 || n == 6 || n == 9) {	// 오른쪽 키패드인 경우
        		rightPos = n;
        		sb.append("R");
        	} else {	// 가운데 키패드인 경우
        		nArr = keyMap.get(n);
        		
        		leftArr = keyMap.get(leftPos);	// 현재 키패드와 왼손 위치 계산
        		leftDistance = Math.abs(nArr[0]-leftArr[0]) + Math.abs(nArr[1]-leftArr[1]); 

        		rightArr = keyMap.get(rightPos);	// 현재 키패드와 오른손 위치 계산
        		rightDistance = Math.abs(nArr[0]-rightArr[0]) + Math.abs(nArr[1]-rightArr[1]);
        		
        		if(leftDistance < rightDistance) {	// 왼손이 가까운 경우
        			leftPos = n;
        			sb.append("L");
        		} else if(leftDistance > rightDistance) {	// 오른손이 가까운 경우
        			rightPos = n;
        			sb.append("R");
        		} else {	// 왼손과 오른손 모두 같은 위치에 있는 경우
        			if(hand.equals("left")) {	// 왼손잡이인 경우
        				leftPos = n;
        				sb.append("L");
        			} else {	// 오른손잡이인 경우
        				rightPos = n;
        				sb.append("R");
        			}
        		}
        	}
        }
        
        answer = sb.toString();
        return answer;
    }
}
