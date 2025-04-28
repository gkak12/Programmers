package code;

/**
 * 최소 직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 *
 * @author hyunjun
 */

public class MinimumRectangle {

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

        int result = solution(sizes);
        System.out.println(result);
    }

    public static int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for(int[] size : sizes) {
            int w = Math.min(size[0], size[1]);
            int h = Math.max(size[0], size[1]);

            width = Math.max(width, w);
            height = Math.max(height, h);
        }

        int answer = width * height;
        return answer;
    }
}
