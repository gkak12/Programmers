package code.java;

import java.util.*;

public class Tmp {
    // 메모이제이션을 위한 맵
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Fibonacci(" + n + "): " + fibonacci(n)); // 55
    }

    public static int fibonacci(int n) {
        // 이미 계산한 값이 있으면 반환
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // 기본 종료 조건
        if (n <= 1) {
            return n;
        }

        // 재귀적으로 두 값을 더하고 그 결과를 메모에 저장
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }
}
