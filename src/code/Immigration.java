package code;

import java.util.Arrays;

public class Immigration {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        long result = solution(n, times);
        System.out.println("result: " + result);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long minTime = 0;
        long maxTime = (long) n * Arrays.stream(times).max().getAsInt();

        while(minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2;    // 중간 시간 구하기
            long processed = 0;

            for(int time : times){  // 주어진 중간시간 동안 각 심사관이 처리할 수 있는 심사 수 조회
                processed += mid / time;
            }

            if(processed >= n) {
                answer = mid;
                maxTime = mid - 1;
            } else {
                minTime = mid + 1;
            }
        }

        return answer;
    }
}
