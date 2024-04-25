package code;

/**
 * 문자열 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * 
 * @author hyunjun
 *
 */

public class StringCompression {

	public static void main(String[] args) {
		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
//		String s = "abcabcdede";
//		String s = "abcabcabcabcdededededede";
//		String s = "xababcdcdababcdcd";
//		String s = "abcabcdede";
		
		int res = solution(s);
		System.out.println(res);
	}
	
	public static int solution(String s) {
        int answer = s.length();
        
        for(int unit = 1 ; unit <= s.length()/2 ; unit++) {	// 문자열 자르는 단위 루프
        	StringBuilder sb = new StringBuilder();
        	String std = s.substring(0, unit);
        	int cnt = 1;
        	int idx = unit;
        	
        	while(idx < s.length()) {	// 반복 조회
        		String cmp = s.substring(idx, idx+unit);
        		
        		if(std.equals(cmp)) {	// 문자열이 반복되는 경우
        			cnt++;
        		} else {	// 문자열이 반복되지 않은 경우
        			sb = zipStr(cnt, std, sb);	// 기존 문자열 압축
        			
        			std = cmp;
        			cnt = 1;
        		}
        		
        		idx += unit;	// 인덱스 증가
        		
        		if(unit > s.length()-idx) {	// 다음 문자열 단위가 자르는 문자열 단위보다 작거나 없는 경우
        			sb = zipStr(cnt, std, sb);	// 기존 문자열 압축
        			sb.append(s.substring(idx));	// 남는 문자열 추가
        			
        			break;
        		}
        	}
        	
        	answer = Math.min(answer, sb.toString().length());	// 가장 짧은 문자열 조회
        }
        
        return answer;
    }
	
	public static StringBuilder zipStr(int cnt, String s, StringBuilder sb) {	// 문자열 압축 함수
		if(cnt == 1) {
			sb.append(s);
		} else if(cnt > 1) {
			sb.append(cnt).append(s);
		}
		
		return sb;
	}
}
