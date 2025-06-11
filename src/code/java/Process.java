package code.java;

/**
 * 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 *
 * @author hyunjun
 */

import java.util.LinkedList;
import java.util.Queue;

public class Process {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;

        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int idx = 0; idx < priorities.length; idx++) {  // 프로세스 배열을 대기 큐에 저장
            queue.add(new int[]{priorities[idx], idx}); // [우선순위, 인덱스] 저장
        }

        int order = 0;  // 실행순서

        while(!queue.isEmpty()) {   // 프로세스 실행
            int[] curr = queue.poll();  // 프로세스 추출
            int max = queue.stream().mapToInt(item -> item[0]).max().orElse(0); // 대기 큐에서 최대 우선순위 조회

            if(curr[0] < max){      // 현재 프로세스가 대기 큐에 있는 최대 우선순위보다 작은 경우
                queue.add(curr);    // 현재 프로세스 대기 큐에 추가
                continue;
            }

            order++;    // 실행순서 증가

            if(curr[1] == location){    // 현재 프로세스가 location인 경우
                answer = order;
            }
        }

        return answer;
    }
}
