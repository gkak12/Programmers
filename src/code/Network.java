package code;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 * @author hyunjun
 */

import java.util.Stack;

public class Network {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		int res = solution(n, computers);
		System.out.println(res);
	}

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        // dfs
        boolean[] visitLog = new boolean[n];
        
        for(int selfIdx = 0 ; selfIdx < n ; selfIdx++) {
        	if(!visitLog[selfIdx]) {	// 자기 자신 네크워크 연결 확인하지 않은 경우 검색 실행
        		answer += search(selfIdx, n, computers, visitLog);
        	}
        }
        
        return answer;
    }
	
	public static int search(int selfIdx, int n, int[][] computers, boolean[] visitLog) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(selfIdx);
		
		while(!stack.isEmpty()) {
			int sIdx = stack.pop();
			visitLog[sIdx] = true;
			
			for(int otherIdx = 0 ; otherIdx < n ; otherIdx++) {
				if(visitLog[otherIdx] == false && computers[sIdx][otherIdx] == 1) {	// 아직 확인하지 않았고 다른 컴퓨터와 네트워크 연결되어 있는 경우
	    			stack.push(otherIdx);
	    		}
			}
		}
		
		return 1;
	}
}
