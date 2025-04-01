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

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		// 배열 -> 우선순위 큐 저장
		for(int sc : scoville){
			queue.add(sc);
		}

		// 스코빌 지수 탐색
		while(!queue.isEmpty()){
			if(queue.peek() >= K){  // 제일 작은 스코빌 지수가 K 이상인 경우 종료
				break;
			} else {    // 제일 작은 스코빌 지수가 K 미만인 경우
				if(queue.size() < 2){   // 우선순위 큐 사이즈가 2미만인 경우 -1 리턴
					answer = -1;
				}

				// 새로운 스코빌 지수 음식 추가
				int firstSc = queue.poll();
				int secondSc = queue.poll();
				int newSc = firstSc + secondSc*2;
				queue.add(newSc);
				answer++;
			}
		}

		return answer;
    }
}
