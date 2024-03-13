package code;

import java.util.Stack;

/**
 * 110 옮기기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77886
 * 
 * @author hyunjun
 *
 */

public class Moving110 {

	public static void main(String[] args) {
		String[] sArr = {"1110","100111100","0111111010"};
//		String[] sArr = {"11111100", "10110", "00100"};
//		String[] sArr = {"1011110","01110","101101111010"};
		
		String[] res = solution(sArr);
		for(String r : res) {
			System.out.println(r);
		}
	}
	
	public static String[] solution(String[] sArr) {
		String[] answer = new String[sArr.length];
		
		for(int i = 0 ; i < sArr.length ; i++) {
			Stack<Character> stack = new Stack<Character>();
			StringBuilder stdSb = new StringBuilder();
			String std = "110";
			String s = sArr[i];
			
			for(int idx = 0 ; idx < s.length() ; idx++) {	// 문자열을 문자단위로 스택에 저장
				if(stack.size() >= 2) {	// 스택 사이즈가 2 이상인 경우 110 체크
					char secondC= stack.pop();
					char firstC = stack.pop();
					
					if(firstC == '1' && secondC == '1' && s.charAt(idx) == '0') {	// 이전 2개 문자와 현재 문자가 110인 경우 StringBuilder에 저장
						stdSb.append(std);
					} else {	// 이전 2개 문자와 현재 문자가 110이 아닌 경우 스택에 저장
						stack.push(firstC);
						stack.push(secondC);
						stack.push(s.charAt(idx));
					}
				} else {	// 스택 사이즈가 2 미만인 경우 스택에 저장
					stack.push(s.charAt(idx));
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			while(!stack.isEmpty()) {	// 스택에 있는 문자 StringBuilder에 저장
				sb.insert(0, stack.pop());
			}
			
			int pivotIdx = sb.lastIndexOf("0");	// 마지막 0 인덱스 조회
			
			if(pivotIdx > -1) {	// 마지막 0 인덱스에 110 저장한 StringBuilder 추가
				sb.insert(pivotIdx+1, stdSb.toString());
			} else {	// 마지막 0이 없는 경우 맨 앞에 110 저장한 StringBuilder 추가
				sb.insert(0, stdSb.toString());
			}
			
			answer[i] = sb.toString();
		}
		
		return answer;
	}
	
//	시간 초과 코드(4, 19, 21번 테스트케이스)
//	public static String[] solution(String[] sArr) {
//		String[] answer = new String[sArr.length];
//		String std = "110";
//
//		for(int i = 0 ; i < sArr.length ; i++) {
//			StringBuffer sb = new StringBuffer(sArr[i]);
//			StringBuffer stdSb = new StringBuffer();
//			int idx = 0;
//			
//			while( (idx = sb.indexOf(std)) > -1) {	// 110 포함하는 경우 110 삭제하고 StringBuilder에 저장
//				sb.delete(idx, idx+3);
//				stdSb.append(std);
//			}
//			
//			int pivotIdx = sb.toString().lastIndexOf("0");
//			
//			if(pivotIdx > -1) {
//				sb.insert(pivotIdx+1, stdSb.toString());
//			} else {
//				sb.insert(0, stdSb.toString());
//			}
//			
//			answer[i] = sb.toString();
//		}
//		
//		return answer;
//    }
}
