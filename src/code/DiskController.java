package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
//        int[][] jobs = {{0, 3}, {3, 2}, {7, 5}};

        int result = solution(jobs);
        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        if(jobs == null || jobs.length == 0) {
            return answer;
        }

        // 1. 요청 시각 오름차순으로 작업 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 2. 대기 큐 생성(정렬 기준 적용)
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            // 1. 작업 소요 시간 오름차순 정렬
            if(o1[1] < o2[1]) {
                return -1;
            } else if(o1[1] > o2[1]) {
                return 1;
            } else {
                // 2. 작업 요청 시간 오름차순 정렬
                if(o1[0] < o2[0]) {
                    return -1;
                } else if(o1[0] > o2[0]) {
                    return 1;
                } else {
                    // 3. 작업 번호 오름차순 정렬(인덱스 기준)
                    if(o1[2] < o2[2]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        int jobCnt = 0;     // 작업 수행 개수
        int jobIdx = 0;     // 작업 인덱스
        int time = 0;       // 현재 시간
        int waitTime = 0;   // 누적 작업 반환 시간

        // 3. 작업 수행
        while(jobCnt < jobs.length) {   // 모든 작업 다 수행
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= time) {    // 현재 시간 이전의 요청한 작업들을 대기 큐에 저장
                int[] job = {jobs[jobIdx][0], jobs[jobIdx][1], jobIdx};
                queue.add(job);

                jobIdx++;
            }

            if(!queue.isEmpty()) {  // 대기 큐가 비어있지 않은 경우 작업 수행
                int[] curr = queue.poll();
                time += curr[1];    // 작업 소요 시간 더해서 현재 시간 갱신

                waitTime += (time-curr[0]); // 누적 작업 반환 시간 갱신
                jobCnt++;
            } else {    // 대기 큐가 비어있는 경우
                time = jobs[jobIdx][0];     // 작업 요청 시간으로 현재 시간 갱신
            }
        }

        answer = waitTime / jobs.length;    // 누적 작업 반환 시간 평균
        return answer;
    }
}
