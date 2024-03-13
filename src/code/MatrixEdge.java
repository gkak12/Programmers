package code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 행렬 테두리 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 * 
 * @author hyunjun
 *
 */

public class MatrixEdge {
	public int[] solution(int rows, int columns, int[][] queries) {
        int answerLength = queries.length;
		int[] answer = new int[answerLength];
		int[][] arr = new int[rows][columns];
		
		//배열 세팅
		for(int i = 0 ; i < rows ; i++) {
			for(int j = 0 ; j < columns ; j++) {
				arr[i][j] = (i*columns)+j+1;
			}
		}
		
		for(int qIdx = 0 ; qIdx < queries.length ; qIdx++) {
			int[] q = queries[qIdx];
			
			int ltX = q[1]-1;
			int ltY = q[0]-1;
			int rbX = q[3]-1;
			int rbY = q[2]-1;
			
			Deque<Integer> d = new ArrayDeque<Integer>();	// 회전 대상 deque
			
			for(int idx = 0 ; idx <= rbX-ltX ; idx++) {	// top, 꼭지점 포함
				d.add(arr[ltY][ltX+idx]);
			}
			
			for(int idx = 1 ; idx < rbY-ltY ; idx++) {	// right, 꼭지점 제외
				d.add(arr[ltY+idx][rbX]);
			}
			
			for(int idx = 0 ; idx <= rbX-ltX ; idx++) {	// bottom, 꼭지점 포함
				d.add(arr[rbY][rbX-idx]);
			}
			
			for(int idx = 1 ; idx < rbY-ltY ; idx++) {	// left, 꼭지점 제외
				d.add(arr[rbY-idx][ltX]);
			}
			
			// 최소값 조회
			int min = d.getFirst();
			
			for(int n : d) {
				min = Math.min(n, min);
			}
			
			answer[qIdx] = min;
			
			// 회전 실행
			int tail = d.pollLast();
			d.addFirst(tail);
			
			for(int idx = 0 ; idx <= rbX-ltX ; idx++) {	// top, 꼭지점 포함
				arr[ltY][ltX+idx] = d.poll();
			}
			
			for(int idx = 1 ; idx < rbY-ltY ; idx++) {	// right, 꼭지점 제외
				arr[ltY+idx][rbX] = d.poll();
			}
			
			for(int idx = 0 ; idx <= rbX-ltX ; idx++) {	// bottom, 꼭지점 포함
				arr[rbY][rbX-idx] = d.poll();
			}
			
			for(int idx = 1 ; idx < rbY-ltY ; idx++) {	// left, 꼭지점 제외
				arr[rbY-idx][ltX] = d.poll();
			}
		}
		
		return answer;
    }
}
