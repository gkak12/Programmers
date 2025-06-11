package code.java;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 
 * @author hyunjun
 *
 */

public class FindingPrimeNumber {

	public static void main(String[] args) {
//		String numbers = "17";
//		String numbers = "011";
		String numbers = "1234";
		
		int res = solution(numbers);
		System.out.println(res);
	}
	
	static Set<Integer> set;
	
	public static int solution(String numbers) {
        int answer = 0;
        String[] sArr = numbers.split("");
        set = new HashSet<Integer>();
        
        for(String s : sArr) {	// 1자리 수 set에 추가
        	set.add(Integer.parseInt(s));
        }
        
        int r = 2;
        int len = numbers.length();
        
        while(r <= len) {	// 2자리 수 부터 len자리까지 숫자 생성
        	boolean[] visitLog = new boolean[sArr.length];
        	int depth = 0;
        	int[] out = new int[r];
        	
        	perm(sArr, visitLog, r, depth, out);
        	
        	r++;
        }
        
        for(Integer s : set) {
        	boolean flag = isPrime(s);
        	
        	if(flag) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void perm(String[] sArr, boolean[] visitLog, int r, int depth, int[] out) {	// 순열 사용해서 숫자 생성
		if(depth == r) {
			StringBuilder sb = new StringBuilder();
			for(int o : out) {
				sb.append(o);
			}
			
			set.add(Integer.parseInt(sb.toString()));	// set에 저장
			return;
		}
		
		for(int i = 0 ; i < sArr.length ; i++) {
			if(!visitLog[i]) {
				visitLog[i] = true;
				out[depth] = Integer.parseInt(sArr[i]);
				perm(sArr, visitLog, r, depth+1, out);
				visitLog[i] = false;
			}
		}
	}
	
	public static boolean isPrime(Integer num) {	// 소수 확인하는 메소드, 소수면 true, 소수 아니면 false 반환
		if(num < 2) {
			return false;
		}
		
		Double d = Math.sqrt(num);
		
		for(int i = 2; i <= d.intValue() ; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
