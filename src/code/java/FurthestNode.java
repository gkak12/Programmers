package code.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * 
 * @author hyunjun
 *
 */

public class FurthestNode {

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		solution(n, vertex);
	}
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        int startNode = 1;
        int depth = 0;
        int maxDepth = 0;
        
        // 1. 시작노드에서 각 노드별 depth 저장하는 map 생성
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] e : edge) {
        	map.put(e[0], null);
        	map.put(e[1], null);
        }
        
        map.put(startNode, depth);
        
        // 2. 간선 탐색
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {startNode, depth});
        
        while(!queue.isEmpty()) {
        	int[] tmp = queue.poll();
        	int currNode = tmp[0];
        	int currDepth = tmp[1];
        	
        	if(currDepth > maxDepth) {	// depth 갱신
        		maxDepth = currDepth;
        	}
        	
        	for(int[] e : edge) {
        		int nextNode;
        		
        		if(e[0] == currNode) {	// 현재노드와 간선으로 연결된 경우
        			nextNode = e[1];
        		} else if(e[1] == currNode) {	// 현재노드와 간선으로 연결된 경우
        			nextNode = e[0];
        		} else {	// 간선으로 연결되지 않은 경우
        			continue;
        		}

        		if(map.get(nextNode) == null && nextNode != startNode) {	// 다음노드를 방문하지 않았고 다음노드가 시작노드가 아닌 경우
        			map.put(nextNode, currDepth+1);
        			queue.offer(new int[] {nextNode, currDepth+1});
        		}
        	}
        }
        
        // 3. 가장 먼 노드 개수 조회
        for(int node : map.keySet()) {
        	if(map.get(node) == maxDepth) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
