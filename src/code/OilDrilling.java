package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 석유 시추
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * 
 * @author hyunjun
 *
 */

public class OilDrilling {

	public static void main(String[] args) {
//		int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, 
//						{0, 0, 0, 0, 1, 1, 0, 0}, 
//						{1, 1, 0, 0, 0, 1, 1, 0}, 
//						{1, 1, 1, 0, 0, 0, 0, 0}, 
//						{1, 1, 1, 0, 0, 0, 1, 1}};
		
//		int[][] land = {{1, 0, 1, 0, 1, 1}, 
//						{1, 0, 1, 0, 0, 0}, 
//						{1, 0, 1, 0, 0, 1}, 
//						{1, 0, 0, 1, 0, 0}, 
//						{1, 0, 0, 1, 0, 1}, 
//						{1, 0, 0, 0, 0, 0}, 
//						{1, 1, 1, 1, 1, 1}};
		
		int[][] land = {{1, 0, 0, 0, 0, 1},
						{1, 1, 0, 0, 0, 0},
						{1, 1, 0, 1, 1, 1},
						{1, 0, 0, 0, 0, 0},
						{0, 0, 1, 1, 1, 1}};
		
		int res = solution(land);
		System.out.println(res);
	}
	
	public static int solution(int[][] land) {
		int answer = 0;
		
		int rows = land.length;
		int cols = land[0].length;
		
		int[] oilArr = new int[cols];	// 각 석유 시추관 별 석유 매장량 저장하는 배열
		boolean[][] visitLog = new boolean[rows][cols];
		
		int[] di = {-1, 0, 1, 0};	// top/right/bottom/left i 인덱스
		int[] dj = {0, 1, 0, -1};	// top/right/bottom/left j 인덱스
		
		for(int i = 0 ; i < rows ; i++) {	// 석유 시추관 조회
			List<int[]> list = new ArrayList<int[]>();
			
			for(int j = 0 ; j < cols ; j++) {	// 방문한 적 없고 석유가 있는 석유 시추관 위치 추가
				if(!visitLog[i][j] && land[i][j] == 1) {
					list.add(new int[] {i, j});
				}
			}
			
			for(int[] arr : list) {	// 석유 매장량 탐색
				int arrI = arr[0];
				int arrJ = arr[1];
				
				if(visitLog[arrI][arrJ]) {	// 이전에 방문한 위치면 탐색하지 않음
					continue;
				}
				
				Stack<int[]> stack = new Stack<int[]>();
				stack.push(new int[] {arrI, arrJ});
				
				Set<Integer> set = new HashSet<Integer>();	// 석유 탐색하면서 방문하는 수평 인덱스 저장
				set.add(arrJ);
				
				visitLog[arrI][arrJ] = true;
				int val = 1;
				
				while(!stack.isEmpty()) {
					int[] curr = stack.pop();
					int currI = curr[0];
					int currJ = curr[1];
					
					for(int dIdx = 0 ; dIdx < 4 ; dIdx++) {
						int nextI = currI + di[dIdx];
						int nextJ = currJ + dj[dIdx];
						
						boolean flag = nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols;
						
						if(flag && !visitLog[nextI][nextJ] && land[nextI][nextJ] == 1) {	// 다음 석유 매장량 위치 탐색
							stack.push(new int[] {nextI, nextJ});
							visitLog[nextI][nextJ] = true;
							val += 1;	// 석유 매장량 증가
							set.add(nextJ);	// 수평 인덱스 저장
						}
					}
				}
				
				for(Integer setIdx : set) {	// 석유 매장량 탐색하면서 방문한 수평 인덱스에 석유 탐색량 저장
					oilArr[setIdx] += val;
				}
			}
		}
		
		answer = Arrays.stream(oilArr).max().getAsInt();
		return answer;
	}
}
