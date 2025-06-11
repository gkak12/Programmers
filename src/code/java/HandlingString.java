package code.java;

/**
 * 문자열 다루기 기본
 * https://school.programmers.co.kr/learn/courses/30/lessons/12918?itm_content=course14743
 * 
 * @author hyunjun
 *
 */
public class HandlingString {

	public static void main(String[] args) {
//		String s = "a234";
//		String s = "1234";
//		String s = "123456";
//		String s = "a23456";
//		String s = "abcdef";
		String s = "12CDE";
		
		boolean res = solution(s);
		System.out.println(res);
	}
	
	public static boolean solution(String s) {
		boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        
        String reg = "\\d+";
        
        answer = s.matches(reg);
        return answer;
    }
}
