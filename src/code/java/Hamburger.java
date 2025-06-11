package code.java;

import java.util.Arrays;

/**
 * 햄버거 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * 
 * @author hyunjun
 *
 */

public class Hamburger {

	public static void main(String[] args) {
		int[] gredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//		int[] gredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
//		int[] gredient = {1, 2, 3, 1, 1, 2, 3, 1};
		solution(gredient);
	}
	
	public static int solution(int[] ingredient) {
		int answer = 0;
		
		// 1. int[] -> String 세팅
		String s = Arrays.toString(ingredient).replaceAll("[^0-9]","");
		StringBuilder sb = new StringBuilder(s);
		
		// 2. 햄버거 포장, 1-2-3-1
		String hamburger = "1231";
		int i = 0;
		
		while( sb.indexOf(hamburger) >= 0 ) {
			i = sb.indexOf(hamburger);
            sb.delete(i, i+4);
			answer++;
		}
		
//		System.out.println(answer);
		return answer;
	}
}
