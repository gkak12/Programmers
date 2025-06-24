package code.java;

/**
 * 광고 삽입
 * https://school.programmers.co.kr/learn/courses/30/lessons/72414
 *
 * @author hyunjun
 */

public class Advertisement {

    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

//        String play_time = "99:59:59";
//        String adv_time = "25:00:00";
//        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        String result = solution(play_time, adv_time, logs);
        System.out.println(result);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = parseTimeToInt(play_time);
        int advTime = parseTimeToInt(adv_time);

        int[] arr = new int[playTime+1];

        // 누적합 세팅
        for(String log : logs){
            String[] sArr = log.split("-");
            int start = parseTimeToInt(sArr[0]);
            int end = parseTimeToInt(sArr[1]);

            for(int i = start ; i < end ; i++){
                arr[i] += 1;
            }
        }

        // 슬라이딩 윈도우 초기값 세팅
        long timeVal = 0;

        for(int i = 0 ; i < advTime ; i++){
            timeVal += arr[i];
        }

        long maxVal = timeVal;  // 최대 누적 시간
        int endTime = playTime-advTime; // 탐색 종료 시간
        int time = 0;   // 최적 광고 시간

        // 최적 광고 시간 탐색
        for(int i = 1 ; i <= endTime ; i++){
            timeVal = timeVal-arr[i-1]+arr[advTime+i-1];

            if(maxVal < timeVal){
                maxVal = timeVal;
                time = i;
            }
        }

        String answer = parseTimeToString(time);
        return answer;
    }

    public static int parseTimeToInt(String time){
        String[] sArr =  time.split(":");

        int hour = Integer.parseInt(sArr[0])*3600;
        int minute = Integer.parseInt(sArr[1])*60;
        int second = Integer.parseInt(sArr[2]);

        return hour+minute+second;
    }

    public static String parseTimeToString(int time){
        int hour = time/3600;
        int minute = (time%3600)/60;
        int second = time%60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
