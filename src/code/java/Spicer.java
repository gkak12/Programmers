package code.java;

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
		int val = Arrays.stream(scoville).min().orElse(0);

		if(val >= K){	// 현재 가장 맵지 않은 스코빌 지수가 K 이상인 경우
			return 0;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		Arrays.stream(scoville)
			.forEach(item -> {	// 배열 -> 우선순위 큐 저장
				queue.add(item);
			});

		while (!queue.isEmpty()) {
			if(queue.peek() >= K){	// 제일 작은 스코빌 지수가 K 이상인 경우 종료
				break;
			} else {	// 제일 작은 스코빌 지수가 K 미만인 경우
				if(queue.size() < 2){	// 우선순위 큐 사이즈가 2미만인 경우 -1 리턴
					answer = -1;
					break;
				}

				// 새로운 스코빌 지수 음식 추가
				Integer s1 = queue.poll();
				Integer s2 = queue.poll();
				queue.add(s1+(s2*2));

				answer++;
			}
		}

		return answer;
	}
}
