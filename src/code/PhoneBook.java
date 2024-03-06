package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 전화번호부
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 
 * @author hyunjun
 *
 */
public class PhoneBook {

	public static void main(String[] args) {
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"12","123","1235","567","88"};
//		String[] phone_book = {"0","1","2","3","4","10"};
//		String[] phone_book = {"010","2","3","4","120"};
//		String[] phone_book = {"123","2345","23467"};
		
		boolean res = solution(phone_book);
		System.out.println(res);
	}
	
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		Arrays.asList(phone_book).sort(new Comparator<String>() {	// 자릿수 기준 오름차순 정렬
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		Set<Integer> digitSet = new HashSet<Integer>();
		
		for(String p : phone_book) {
			digitSet.add(p.length());
		}

        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String p : phone_book) {
        	for(Integer d : digitSet) {
        		if(p.length() >= d) {
        			String s = p.substring(0, d);
        			
        			if(map.get(s) == null && p.length() <= d) {
        				map.put(s, 1);
        			} else if(map.get(s) != null && map.get(s) >= 1) {
            			return false;
            		}
        		}
        	}
        }
        
        return answer;
    }
}
