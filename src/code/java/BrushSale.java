package code.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 다단계 칫솔 판매
 */
public class BrushSale {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int brushVal = 100;	// 칫솔값
		double selfRatio = 0.9;	// 자기 몫 비율
		double nextRatio = 0.1;	// 추천인 몫 비율

		int enrollLength = enroll.length;
		int[] answer = new int[enrollLength];
        
        Map<String, Integer> enrollMap = new HashMap<String, Integer>();
        
        // enroll array -> map 변환
        int tmpIdx = 0;
        
        for(String s : enroll) {
        	enrollMap.put(s, tmpIdx++);
        }
        
        for(int i = 0 ; i < seller.length ; i++) {
        	String salesMan = seller[i];
        	int salesManIdx = -1;
        	int brushSales = amount[i]*brushVal;
        	
        	//본인 몫 분배
        	salesManIdx = enrollMap.get(salesMan);
        	answer[salesManIdx] += Math.ceil(brushSales*selfRatio);
        	
        	// 추천인 몫 분배
        	Stack<String> s = new Stack<String>();
        	s.push(referral[salesManIdx]);
        	double referVal = brushSales*nextRatio;
        	
        	while(!s.isEmpty()) {
        		if(referVal < 1) {	// 추천인 몫이 1원 미만인 경우 종료
        			break;
        		}
        		
        		String currRefer = s.pop();
        		
        		if(!currRefer.equals("-")) {
        			int referIdx = -1;
            		
            		// 현재 추천인 몫 분배
        			referIdx = enrollMap.get(currRefer);
            		answer[referIdx] += Math.ceil(referVal*selfRatio);
            		
            		// 다음 추천인 몫 분배
            		String nextRefer = referral[referIdx];
            		
            		if(nextRefer != null && !nextRefer.equals("-")) {
            			s.push(referral[referIdx]);	// 다음 추천인 추가
            			referVal = Math.floor(referVal*nextRatio);
            		}
        		}
        	}
        }
        
        return answer;
    }
}
