package code.java;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
 *
 * @author hyunjun
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerTriangle {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = solution(triangle);
        System.out.println(result);
    }

    public static int solution(int[][] triangle){
        if(triangle.length == 1){
            return triangle[0][0];
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i < triangle.length ; i++){
            for(int j = 0 ; j < triangle[i].length ; j++){
                int leftUpperVal = j == 0 ? 0 : triangle[i-1][j-1];  // 윗줄-왼쪽 값 조회, 현재 위치가 맨 왼쪽이면 0
                int upperVal = j == triangle[i].length-1 ? 0 : triangle[i-1][j];    // 바로 윗줄 값 조회, 현재 위치가 맨 오른쪽이면 0

                int val = leftUpperVal > upperVal ? leftUpperVal+triangle[i][j] : upperVal+triangle[i][j];  // 2개 비교해서 큰 값이랑 현재 위치 더하기 연산
                triangle[i][j] = val;   // 더한 값 누적 반영

                if(i == triangle.length-1){ // 마지막 줄인 경우 리스트에 추가
                    list.add(val);
                }
            }
        }

        return Collections.max(list);   // 가장 큰 값 리턴
    }
}
