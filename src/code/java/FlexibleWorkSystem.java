package code.java;

/**
 *  유연근무제
 *  https://school.programmers.co.kr/learn/courses/30/lessons/388351
 *
 *  @author hyunjun
 *
 */

public class FlexibleWorkSystem {

    public static void main(String[] args) {
//        int[] schedules = {700, 800, 1100};
//
//        int[][] timelogs = {
//                {710, 2359, 1050, 700, 650, 631, 659},
//                {800, 801, 805, 800, 759, 810, 809},
//                {1105, 1001, 1002, 600, 1059, 1001, 1100}
//        };
//
//        int startday = 5;

        int[] schedules = {730, 855, 700, 720};

        int[][] timelogs = {
            {710, 700, 650, 735, 700, 931, 912},
            {908, 901, 805, 815, 800, 831, 835},
            {705, 701, 702, 705, 710, 710, 711},
            {707, 731, 859, 913, 934, 931, 905}
        };

        int startday = 1;

        int result = solution(schedules, timelogs, startday);
        System.out.println("result: " + result);
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday){
        int answer = 0;
        int days = 7;
        int saturdayIdx = -1;
        int sundayIdx = -1;

        for(int i = 0 ; i < days ; i++){
            int day = (i+startday);

            if(day % days == 6){  // 토요일
                saturdayIdx = i;
            } else if(day % days == 0){    // 일요일
                sundayIdx = i;
            }
        }

        int length = schedules.length;
        int allowedMin = 10;

        for(int i = 0 ; i < length ; i++){
            int scheduleTime = parseTime(schedules[i]);
            int scheduleMaxTime = scheduleTime + allowedMin;
            boolean flag = true;

            for(int j = 0 ; j < days ; j++){
                if(j == saturdayIdx || j == sundayIdx){
                    continue;
                }

                int logTime = parseTime(timelogs[i][j]);

                if(logTime > scheduleMaxTime){
                    flag = false;
                    break;
                }
            }

            if(flag){
                answer++;
            }
        }

        return answer;
    }

    public static int parseTime(int val){
        int hour = val / 100;
        int min = val % 100;

        return hour * 60 + min;
    }
}
