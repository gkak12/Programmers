package code.java;

/**
 * 이웃한 칸
 * https://school.programmers.co.kr/learn/courses/30/lessons/250125
 * 
 * @author hyunjun
 *
 */

public class NeighborSpace {

	public static void main(String[] args) {
		String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
		int h = 1;
		int w = 1;
		
		solution(board, h, w);
	}
	
	public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int rows = board.length;
        int cols = board[0].length;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        String color = board[h][w];
        
        for(int i = 0 ; i < 4 ; i++) {	// 현재 위치의 색상이랑 같은 색상 상하좌우 검색
        	int nextH = h+dh[i];
        	int nextW = w+dw[i];
        	
        	if(nextH < 0 || nextH >= rows || nextW < 0 || nextW >= cols) {
        		continue;
        	}
        	
        	if(color.equals(board[nextH][nextW])) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
