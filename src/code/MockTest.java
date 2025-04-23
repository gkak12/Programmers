package code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 *
 * @author hyunjun
 */

public class MockTest {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};
//        int[] answers = {3, 3, 1, 1, 2};

        int[] result = solution(answers);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};                   // 1번 학생 푸는 방식
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};          // 2번 학생 푸는 방식
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    // 3번 학생 푸는 방식

        int[][] arr = {     // 각 학생별 점수 배열 저장(학생번호, 점수)
            {1, 0},
            {2, 0},
            {3, 0}
        };

        for(int i = 0 ; i < answers.length ; i++){
            if(answers[i] == pattern1[i%5]) arr[0][1]++;
            if(answers[i] == pattern2[i%8]) arr[1][1]++;
            if(answers[i] == pattern3[i%10]) arr[2][1]++;
        }

        int max = Arrays.stream(arr).mapToInt(item -> item[1]).max().orElse(0); // 가장 높은 점수

        int[] result = Arrays.stream(arr)
            .filter(item -> item[1] == max)     // 가장 많이 맞춘 학생 조건 필터
            .sorted((o1, o2) -> Integer.compare(o1[0], o2[0]))
            .mapToInt(item -> item[0])
            .toArray();

        return result;
    }
}
