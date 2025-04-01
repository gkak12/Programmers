package code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 인사고과
 * https://school.programmers.co.kr/learn/courses/30/lessons/152995
 * 
 * @author hyunjun
 *
 */

public class PersonnelEvaluation {

	public static void main(String[] args) {
//		int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
//		int[][] scores = {{4,3},{5,2},{1,2},{2,3},{3,3},{3,4}};
//		int[][] scores = {{3,3},{4,3},{5,4},{3,4},{2,2},{1,1}};
//		int[][] scores = {{1,1},{2,2},{3,3}};
//		int[][] scores = {{1,1},{1,1},{1,1},{2,2},{3,3}};
//		int[][] scores = {{0,2},{1,1},{1,1}};
//		int[][] scores = {{7,1},{6,6},{5,4},{5,4},{6,6}};
		int[][] scores = {{3,3},{4,3},{5,0},{3,4},{2,2},{1,1}};

		int res = solution(scores);
		System.out.println(res);
	}

	public static int solution(int[][] scores) {
        int answer = 0;
        int[] std = scores[0];	// 완호 점수
        
        // 근무태도점수 내림차순, 동료평가점수 오름차순 정렬
        Arrays.asList(scores).sort(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[0] > o2[0]) {
        			return -1;
        		} else if(o1[0] < o2[0]) {
        			return 1;
        		} else {
        			return Integer.compare(o1[1], o2[1]);
        		}
        	}
		});

		/**
		 * 완호 등수 확인
		 * 근무태도점수는 내림차순으로 정렬되었기 때문에 동료평가점수만 확인하면 됨
		 */
        int maxScore = 0;
        for(int[] score : scores) {
        	if(score[1] < maxScore) {	// 동료평가점수가 낮아서 인센티브 못 받는 경우
        		if(score.equals(std)) {	// 그 경우가 완호인 경우
        			return -1;
        		}
        	} else {	// 동료평가점수가 낮지 않아서 인센티브 받는 경우
        		maxScore = score[1];
        		
        		if(!score.equals(std) && score[0]+score[1] > std[0]+std[1]) {	// 완호보다 점수 높은 직원
        			answer++;
        		}
        	}
        }
        
        answer = answer+1;
        return answer;
    }
}
