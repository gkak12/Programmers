package code.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewsClustering {

	public static void main(String[] args) {
//		String str1 = "FRANCE";
//		String str2 = "french";
		
//		String str1 = "handshake";
//		String str2 = "shake hands";
		
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
		
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		int res = solution(str1, str2);
		System.out.println(res);
	}
	
	public static int solution(String str1, String str2) {
        List<String> list1 = parseStr(str1.toUpperCase());
        List<String> list2 = parseStr(str2.toUpperCase());
        
        int overlapCnt = 0;
        Iterator<String> itr1 = list1.iterator();
        
        while(itr1.hasNext()) {	// 교집합 추출
        	String s1 = itr1.next();
        	boolean flag = false;
        	
        	Iterator<String> itr2 = list2.iterator();
            
        	while(itr2.hasNext()) {
        		String s2 = itr2.next();
        		
        		if(s1.equals(s2)) {
        			flag = true;
        			itr2.remove();
        			
        			break;
        		}
        	}
        	
        	if(flag) {
                overlapCnt += 1;
        		itr1.remove();
        	}
        }
        
        int total = list1.size() + list2.size() + overlapCnt;	// 집합 전체 요소 개수
        int val = 65536;
        int answer = total == 0 ? val : val*overlapCnt/total;	// NaN인 경우 65536 리턴, NaN 아닌 경우 원래대로 계산
      
        return answer;
    }
	
	public static List<String> parseStr(String str){	// 문자열 파싱 함수
		List<String> list = new ArrayList<String>();
		String reg = "[^A-Z]";
		
		for(int i = 0 ; i < str.length()-1 ; i++) {
        	String s = str.substring(i, i+2).replaceAll(reg, "");
        	
        	if(s.length() == 2) {
        		list.add(s);
        	}
        }
		
		return list;
	}
}
