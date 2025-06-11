package code.java;

import java.util.Arrays;

/**
 * 숫자 카드 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * 
 * @author hyunjun
 *
 */

public class CardSharing {

	public static void main(String[] args) {
		// 0
//		int[] arrayA = {10, 17};
//		int[] arrayB = {5, 20};
		
		// 10
//		int[] arrayA = {10, 20};
//		int[] arrayB = {5, 17};
		
		// 7
		int[] arrayA = {14, 35, 119};
		int[] arrayB = {18, 30, 102};
		
		int res = solution(arrayA, arrayB);
		System.out.println(res);
	}
	
	public static int solution(int[] arrayA, int[] arrayB) {
		int res = 0;
		
		int[] aArr = Arrays.stream(arrayA).sorted().toArray();
		int[] bArr = Arrays.stream(arrayB).sorted().toArray();
		
		int resA = getGCD(aArr);	// a배열 최대공약수 조회
		int resB = getGCD(bArr);	// b배열 최대공약수 조회
		
		if(resA > resB) {	// a배열 최대공약수가 큰 경우 b배열과 공유되는지 확인
			res = check(resA, arrayB) == true ? resA : 0;
		} else {	// b배열 최대공약수가 큰 경우 a배열과 공유되는지 확인
			res = check(resB, arrayA) == true ? resB : 0;
		}
		
		return res;
	}
	
	public static int getGCD(int[] arr) {	// 배열에서 최대공약수 구하는 메소드
		int res = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++) {
			res = findGCD(res, arr[i]);
		}
		
		return res;
	}
	
	public static int findGCD(int a, int b) {	// 최대공약수 구하는 메소드
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	public static boolean check(int val, int[] arr) {	// 상대 배열과 최대공약수 공유되는지 확인하는 메소드
		boolean res = true;
		
		for(int item : arr) {
			if(item % val == 0) {
				res = false;
				break;
			}
		}
		
		return res;
	}
}
