package code.java;

/**
 * 등교길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 *
 * @author hyunjun
 */

public class SchoolRoad {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {};

        int result = solution(m, n, puddles);
        System.out.println(result);
    }

    public static int solution(int m, int n, int[][] puddles){
        int num = 1000000007;
        int rows = n+1;
        int cols = m+1;
        int[][] dp = new int[rows][cols];

        // 웅덩이 표시
        boolean[][] isPuddle = new boolean[rows][cols];

        for (int[] puddle : puddles) {
            int x = puddle[1]; // y축 (세로)
            int y = puddle[0]; // x축 (가로)

            isPuddle[x][y] = true;
        }

        dp[1][1] = 1; // 시작점

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (isPuddle[i][j]) {
                    dp[i][j] = 0; // 웅덩이면 경로 없음
                } else {
                    if (i > 1) dp[i][j] += dp[i-1][j];
                    if (j > 1) dp[i][j] += dp[i][j-1];
                    dp[i][j] %= num;
                }
            }
        }

        return dp[n][m];
    }
}
