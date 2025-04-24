package code;

/**
 * 전력망을 둘로 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 *
 * @author hyunjun
 *
 */

import java.util.*;

public class DividingElectricityNet {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//        int n = 4;
//        int[][] wires = {{1,2},{2,3},{3,4}};
//        int n = 7;
//        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        int result = solution(n, wires);
        System.out.println(result);
    }

    public static int solution(int n, int[][] wires) {
        int answer = -1;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < wires.length; i++) {
            int removedIdx = i;     // 끊는 전선
            int node1 = wires[i][0];    // 끊는 전선 송신탑1
            int node2 = wires[i][1];    // 끊는 전선 송신탑2
            boolean[] visited1 = new boolean[n+1];  // 송신탑1 기준으로 탐색할 방문 여부
            boolean[] visited2 = new boolean[n+1];  // 송신탑2 기준으로 탐색할 방문 여부

            int cnt1 = search(wires, visited1, node1, removedIdx);  // 송신탑1 기준으로 탐색 실행
            int cnt2 = search(wires, visited2, node2, removedIdx);  // 송신탑2 기준으로 탐색 실행

            list.add(Math.abs(cnt1-cnt2));  // 각자 탐색한 송신탑 개수 차 저장
        }

        answer = Collections.min(list); // 가장 작은 차 리턴
        return answer;
    }

    public static int search(int[][] wires, boolean[] visited, int node, int removedIdx) {
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while(!stack.isEmpty()) {
            int curr = stack.pop();

            for(int i = 0; i < wires.length; i++) {
                if(i == removedIdx) {   // 끊는 전선인 경우 탐색 생략
                    continue;
                }

                int w1 = wires[i][0];   // 송신탑1
                int w2 = wires[i][1];   // 송신탑2

                if(w1 == curr && visited[w2] == false) {    // 송신탑2 방문하지 않은 경우 탐색
                    stack.push(w2);
                    visited[w2] = true;
                    cnt++;
                } else if(w2 == curr && visited[w1] == false) { // 송신탑1 방문하지 않은 경우 탐색
                    stack.push(w1);
                    visited[w1] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
