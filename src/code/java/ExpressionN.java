package code.java;

/**
 * N으로 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 *
 * @author hyunjun
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressionN {

    public static void main(String[] args) {
        int N = 5;
        int number = 55;

        int result = solution(N, number);
        System.out.println(result);
    }

    public static int solution(int N, int number){
        List<Set<Integer>> dp = new ArrayList<>();

        for(int i = 0 ; i <= 8; i++){   // 1~8번 사용한 연산 결과 저장 set 세팅
            dp.add(new HashSet<>());
        }

        for(int i = 1; i <= 8 ; i++){
            int repeatNumber = Integer.parseInt(String.valueOf(N).repeat(i));   // 중복되는 숫자 추가
            dp.get(i).add(repeatNumber);

            for (int j = 1; j < i; j++) {   // 조합
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (Integer a : set1) {
                    for (Integer b : set2) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            
            if(dp.get(i).contains(number)){ // 현재 n번 사용한 연산에서 number가 있는 경우
                return i;
            }
        }

        return -1;
    }
}
