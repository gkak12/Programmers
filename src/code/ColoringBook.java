package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ColoringBook {

	public static void main(String[] args) {
//		int m = 6;
//		int n = 4;
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		int m = 5;
		int n = 5;
		int[][] picture = {{1, 1, 1, 1, 1}, {1, 1, 1, 0, 0}, {2, 2, 2, 2, 2}, {0, 0, 2, 2, 2}, {1, 1, 1, 1, 1}};
		
		int[] res = solution(m, n, picture);
		System.out.println(res[0] + ", " + res[1]);
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];
        
        int rows = picture.length;
        int cols = picture[0].length;
        
        boolean[][] visitLog = new boolean[rows][cols];
        List<int[]> list = new ArrayList<int[]>();
        
        for(int i = 0 ; i < rows ; i++) {
        	for(int j = 0; j < cols ; j++) {
        		int num = picture[i][j];
        		
        		if(num > 0) {	// 색상인 경우 탐색(0보다 큰 경우)
        			int val = search(i, j, num, picture, visitLog);
        			
        			if(val > 0) {	// 색상 영역이 0보다 큰 경우 리스트에 추가
        				list.add(new int[]{num, val});
        			}
        		}
        	}
        }
        
        Collections.sort(list, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o2[1], o1[1]);
        	}
		});
        
        answer[0] = list.size();
        answer[1] = list.get(0)[1];
        
        return answer;
    }
	
	public static int search(int i, int j, int num, int[][] picture, boolean[][] visitLog) {
		int rows = picture.length;
        int cols = picture[0].length;
        
        if((i < 0 || i > rows-1) || (j < 0 || j > cols-1)) {	// 인덱스가 picture 범위 벗어났는지 확인
        	return 0;
        }
        
        if(!visitLog[i][j]) {	// 방문하지 않은 경우
        	if(picture[i][j] == num) {	// 같은 색상인 경우(같은 영역인 경우)
        		visitLog[i][j] = true;
        		
        		return 1 
    				+ search(i-1, j, num, picture, visitLog)	// top 탐색
    				+ search(i, j+1, num, picture, visitLog)	// right 탐색
    				+ search(i+1, j, num, picture, visitLog)	// bottom 탐색
    				+ search(i, j-1, num, picture, visitLog);	// left 탐색
        	} else {	// 같은 영역이 아닌 경우(다른 색상인 경우)
        		return 0;
        	}
        } else {	// 방문한 경우
        	return 0;
        }
	}
}
