package code;

import java.util.*;

public class Stealing {

    public static void main(String[] args) {
//        int[] money = {1, 2, 3, 1};
//        int[] money = {1, 2, 3, 1, 1};
//        int[] money = {10, 5, 3, 1, 10};
        int[] money = {1, 2, 3, 4, 5, 6, 1, 4};

        int result = solution(money);
        System.out.println(result);
    }

    public static int solution(int[] money) {
        int answer = 0;
        int len = money.length;

        if(len <= 3){   // 배열 길이가 3 이하인 경우
            return Arrays.stream(money).max().getAsInt();
        }

        // 첫번째 집을 포함하는 경우
        int[] hArr1 = new int[len];
        hArr1[0] = money[0];
        hArr1[1] = money[1];
        hArr1[2] = money[0]+money[2];

        for(int i = 3 ; i < len-1 ; i++) {
            int idx1 = i-3;
            int val1 = hArr1[idx1]+money[i];

            int idx2 = i-2;
            int val2 = hArr1[idx2]+money[i];

            hArr1[i] = Math.max(val1, val2);
        }

        int hMax1 = Arrays.stream(hArr1).max().getAsInt();

        // 첫번째 집을 포함하지 않는 경우
        int[] hArr2 = new int[len];
        hArr2[1] = money[1];
        hArr2[2] = money[2];

        for(int i = 3 ; i < len ; i++) {
            int idx1 = i-3;
            int val1 = hArr2[idx1]+money[i];

            int idx2 = i-2;
            int val2 = hArr2[idx2]+money[i];

            hArr2[i] = Math.max(val1, val2);
        }

        int hMax2 = Arrays.stream(hArr2).max().getAsInt();

        answer = Math.max(hMax1, hMax2);
        return answer;
    }
}
