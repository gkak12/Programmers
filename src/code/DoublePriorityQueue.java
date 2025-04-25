package code;

/**
 * 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 *
 * @author hyunjun
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        int[] result = solution(operations);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String operation : operations) {
            if(operation.equals("D 1")){    // 최대값 삭제
                if(!pq.isEmpty()){  // 큐가 비어있지 않은 경우
                    int max = pq.stream().mapToInt(Integer::intValue).max().orElseThrow();
                    pq.remove(max);
                }
            } else if(operation.equals("D -1")){    // 최소값 삭제
                if(!pq.isEmpty()) pq.remove();  // 큐가 비어있지 않은 경우
            } else {    // 숫자 추가
                int val = Integer.parseInt(operation.split(" ")[1]);
                pq.add(val);
            }
        }

        if(!pq.isEmpty()){  // 큐가 비어있지 않은 경우
            answer[0] = pq.stream().mapToInt(Integer::intValue).max().orElseThrow();    // 최대값
            answer[1] = pq.peek();  // 최소값
        }

        return answer;
    }
}
