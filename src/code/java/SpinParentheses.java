package code.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 괄호 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * 
 * @author hyunjun
 *
 */

public class SpinParentheses {
	
	public static void main(String[] args) {
//		String s = "[](){}";
//		String s = "}]()[{";
//		String s = "[)(]";
		String s = "}}}";
		
		int res = solution(s);
		System.out.println(res);
	}
	
	public static int solution(String s) {
        int answer = 0;
        int typeNum = new HashSet<>(Arrays.asList(s.split(""))).size();
        
        if(typeNum == 1) {	// 문자열이 한가지 괄호로만 이루어진 경우
        	return 0;
        }
        
        LinkedList<String> list = new LinkedList<>(Arrays.asList(s.split("")));
        
        for(int x = 0 ; x < s.length() ; x++) {
        	if(x > 0) {	// x가 0보다 크면 회전 실행
        		String movedS = list.pollFirst();
        		list.addLast(movedS);
        	}
        	
        	boolean res = check(list);
        	
        	if(res) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static boolean check(List<String> list) {
		boolean res = false;
		
		if(list.get(0).equals(")") || list.get(0).equals("]") || list.get(0).equals("}")) {	// 첫문자가 닫는 괄호인 경우
			return false;
		}
		
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		
		for(String l : list) {	// 문자열 스택1에 저장
			stack1.push(l);
		}
		
		while(!stack1.isEmpty()) {	// 스택을 사용해 올바른 괄호인지 체크
			String s1 = stack1.pop();
			
			if(stack2.size() > 0) {	// 스택2가 비어있지않은 경우 비교
				String s2 = stack2.peek();
				
				if(s1.equals("(") && s2.equals(")")) {	// "(" 여는 괄호인 경우
					stack2.pop();
				} else if(s1.equals("[") && s2.equals("]")) { // "[" 여는 괄호인 경우
					stack2.pop();
				} else if(s1.equals("{") && s2.equals("}")) {	// "{" 여는 괄호인 경우
					stack2.pop();
				} else {
					stack2.push(s1);
				}
			} else {
				stack2.push(s1);
			}
		}
		
		if(stack1.size() == 0 && stack2.size() == 0) {	// 올바른 괄호인 경우
			res = true;
		}
		
		return res;
	}
}
