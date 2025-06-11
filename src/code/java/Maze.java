package code.java;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

	public static void main(String[] args) {
//		String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//		String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
		String[] maps = {"LOOOS","XXXXO","OOOOO","OXXXX","OOOOE"};
		solution(maps);
	}
	
	public static int solution(String[] maps) {
		boolean sFlag = false;
		boolean lFlag = false;
		int[] start = null;
		int[] lever = null;
		
		for(int i = 0 ; i < maps.length ; i++) {
			if(sFlag == true && lFlag == true) {
				break;
			}
			
			String m = maps[i];
			int s = -1;
			int l = -1;
			
			if((s = m.indexOf("S")) > -1) {
				sFlag = true;
				start = new int[] {i, s, 0};
			}
			
			if((l = m.indexOf("L")) > -1) {
				lFlag = true;
				lever = new int[] {i, l, 0};
			}
		}
		
		int val1 = bfs(maps, start, 'L') ;
		
		if(val1 == -1) {
			return -1;
		}
		
		int val2 = bfs(maps, lever, 'E');
		
		if(val2 == -1) {
			return -1;
		}
		
		return val1+val2;
	}
	
	public static int bfs(String[] maps, int[] start, char end) {
		int res = -1;
		int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0 , -1, 1};
	    
	    int rows = maps.length;
	    int cols = maps[0].length();
	    
	    boolean[][] visitLog = new boolean[rows][cols];
        visitLog[start[0]][start[1]] = true;
        
	    Queue<int[]> queue = new LinkedList<int[]>();
	    queue.offer(start);
	    
	    while(!queue.isEmpty()) {
	    	int[] curr = queue.poll();
	    	int x = curr[0];
	    	int y = curr[1];
	    	int level = curr[2];
	    	
	    	if(maps[x].charAt(y) == end) {
	    		res = level;
	    		break;
	    	}
	    	
	    	for(int i = 0 ; i < 4 ; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
			
				if(nx > -1 && nx < rows && ny > -1 && ny < cols && maps[nx].charAt(ny) != 'X' && visitLog[nx][ny] == false) {
					queue.offer(new int[]{nx, ny, level+1});
					visitLog[nx][ny] = true;
				}
			}
	    }
	    
	    return res;
    }
}
