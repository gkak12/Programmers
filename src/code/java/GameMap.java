package code.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 
 * @author hyunjun
 *
 */
public class GameMap {
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		int res = solution(maps);
		System.out.println(res);
	}
	
	public static int solution(int[][] maps) {
		int answer = 0;
        
        List<Integer> list = search(maps);
        answer = list.size() == 0 ? -1 : Collections.min(list);
        
        return answer;
    }
	
	public static List<Integer> search(int[][] maps) {
		int rows = maps.length;
		int cols = maps[0].length;
		
		int destI = rows - 1;
        int destJ = cols - 1;
		
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0, 1});	// i, j, 지나간 칸 개수

		boolean[][] visit = new boolean[rows][cols];
		visit[0][0] = true;
		
		List<Integer> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currI = curr[0];
			int currJ = curr[1];
			int currNum = curr[2];
			
			if(currI == destI && currJ == destJ) {	// 상대편 진영에 도착한 경우
				list.add(currNum);
				continue;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextI = currI+di[i];
				int nextJ = currJ+dj[i];
				
				boolean flag = nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols;
				if(flag && !visit[nextI][nextJ] && maps[nextI][nextJ] == 1) {	// 범위 벗어나지 않고, 아직 방문하지 않고, 다음 칸 숫자가 1인 경우
					queue.add(new int[] {nextI, nextJ, currNum+1});
					visit[nextI][nextJ] = true;
				}
			}
		}
		
		return list;
	}
}
