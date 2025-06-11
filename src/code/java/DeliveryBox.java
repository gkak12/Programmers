package code.java;

/**
 *  택배 상자 꺼내기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/389478
 *
 *  @author hyunjun
 */

import java.util.HashMap;
import java.util.Map;

public class DeliveryBox {

    public static void main(String[] args){
//        int n = 22;
//        int w = 6;
//        int num = 8;

        int n = 13;
        int w = 3;
        int num = 6;

        int result = solution(n, w, num);
        System.out.println("result: " + result);
    }

    public static int solution(int n, int w, int num) {
        int answer = 0;
        int box = 1;
        int rows = n/w+1;
        int cols = w;
        int[][] arr = new int[rows][cols];
        Map<Integer, int[]> map = new HashMap<>();

        // 택배 상자 쌓기
        for(int i = 0; i < rows; i++){
            if(i % 2 == 0){ // row 인덱스가 짝수인 경우(왼쪽 -> 오른쪽)
                for(int j = 0; j < cols && box <= n; j++){
                    arr[i][j] = box;
                    map.put(box, new int[]{i, j});

                    box++;
                }
            } else{         // row 인덱스가 홀수인 경우(오른쪽 -> 왼쪽)
                for(int j = cols-1 ; j >= 0 && box <= n; j--){
                    arr[i][j] = box;
                    map.put(box, new int[]{i, j});

                    box++;
                }
            }
        }

        int[] idxArr = map.get(num);
        int numI = idxArr[0];
        int numJ = idxArr[1];

        // 택배 상자 꺼내기
        for(int i = numI ; i < rows ; i++){
            if(arr[i][numJ] != 0){
                answer++;
            }
        }

        return answer;
    }
}
