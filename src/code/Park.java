package code;

/**
 *  공원
 *  https://school.programmers.co.kr/learn/courses/30/lessons/340198
 *
 *  @author hyunjun
 */

import java.util.Arrays;

public class Park {

    public static void main(String[] args){
        int[] mats = {5,3,2};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

//        int[] mats = {1};
//        String[][] park = {
//            {"-1"}
//        };

//        int[] mats = {3};
//        String[][] park = {
//            {"-1", "-1", "-1"},
//            {"-1", "-1", "-1"},
//            {"-1", "-1", "A"},
//        };

        int result = solution(mats, park);
        System.out.println("result: " + result);
    }

    public static int solution(int[] mats, String[][] park) {
        String empty = "-1";
        int rows = park.length;
        int cols = park[0].length;
        int[][] parkArr = new int[rows][cols];

        // mats 배열 -> 정수 배열로 전환
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                parkArr[i][j] = empty.equals(park[i][j]) ? 1 : 0;
            }
        }

        int val = 0;

        // 정수 배열에서 최대 정사각형 돗자리 넓이 조회
        for(int i = 1 ; i < rows ; i++){
            for(int j = 1 ; j < cols ; j++){
                if(parkArr[i][j] == 0){
                    continue;
                }

                int num = Math.min(Math.min(parkArr[i-1][j], parkArr[i][j-1]), parkArr[i-1][j-1])+1;
                parkArr[i][j] = num;
                val = Math.max(val, num);
            }
        }

        int answer = -1;
        Arrays.sort(mats);  // 돗자리 오름차순 정렬

        // 가지고 있는 돗자리 중에서 제일 큰 돗자리 조회
        for(int mat : mats){
            if(mat <= val){
                answer = mat;
            }
        }

        return answer;
    }
}
