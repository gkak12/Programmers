package code.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 숫자 변환하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 * 
 * @author hyunjun
 *
 */

public class ConvertingNumber {

	public static void main(String[] args) {
//		int x = 10, y = 40, n = 5;
//		int x = 10, y = 40, n = 30;
//		int x = 2, y = 5, n = 4;
//		int x = 2, y = 11, n = 4;
		int x = 2, y = 2, n = 4;
		
		int res = solution(x, y, n);
		System.out.println(res);
	}
	
	public static int solution(int x, int y, int n) {
		int answer = -1;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {x, 0});	// 숫자, 연산횟수
        
        Set<Integer> set = new HashSet<Integer>();	// 방문 여부
        set.add(x);
        
        while(!queue.isEmpty()) {
        	int[] arr = queue.poll();

        	if(arr[0] == y) {
    			answer = arr[1];
    			break;
    		}
        	
        	int nextNum = arr[0]+n;
        	if(nextNum <= y && !set.contains(nextNum)) {	// n 더한 값이 y 이하이고 아직 방문하지 않은 경우 큐에 추가
        		queue.add(new int[]{nextNum, arr[1]+1});
        		set.add(nextNum);
        	}

        	nextNum = arr[0]*2;
        	if(nextNum <= y && !set.contains(nextNum)) {	// 곱하기 2한 값이 y 이하이고 아직 방문하지 않은 경우 경우 큐에 추가
        		queue.add(new int[]{nextNum, arr[1]+1});
        		set.add(nextNum);
        	}

        	nextNum = arr[0]*3;
        	if(nextNum <= y && !set.contains(nextNum)) {	// 곱하기 3한 값이 y 이하이고 아직 방문하지 않은 경우 경우 큐에 추가
        		queue.add(new int[]{nextNum, arr[1]+1});
        		set.add(nextNum);
        	}
        }
        
        return answer;
    }
}
