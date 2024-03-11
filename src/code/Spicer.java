package code;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * 
 * @author hyunjun
 *
 */

public class Spicer {

	public static void main(String[] args) {
//		int[] scoville = {1, 2, 3, 9, 10, 12};
//		int K = 7;
//		int[] scoville = {1, 4, 8, 10};
//		int K = 5;
//		int[] scoville = {1, 1, 1};
//		int K = 5;
		int[] scoville = {1, 1, 1};
		int K = 10;
		
		int res = solution(scoville, K);
		System.out.println(res);
	}

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        Arrays.sort(scoville);
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();
        
        for(int s : scoville) {
        	list.add(s);
        }
        
        int sNum = 2;
        boolean flag = list.peek() < K ? true : false;
        
        while(flag) {	// 스코빌 지수 보다 작은 경우
        	int food1 = list.poll();
        	int food2 = list.poll();
        	int newFood = food1 + (food2*sNum);

        	list.add(newFood);
        	answer++;
        	
        	if(list.peek() < K) {
        		flag = true;
        		
        		if(list.size() == 1) {
        			flag = false;
        			answer = -1;
        		}
        	} else {
        		flag = false;
        	}
        }
        
        return answer;
    }
}
