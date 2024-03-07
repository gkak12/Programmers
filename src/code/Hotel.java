package code;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hotel {

	public static void main(String[] args) {
//		String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
//		String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
//		String[][] book_time = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
		String[][] book_time = {{"22:49", "23:39"}, {"23:49", "23:59"}};
		
		int res = solution(book_time);
		System.out.println(res);
	}
	
	public static int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.asList(book_time).sort(new Comparator<String[]>() {	// 오름차순 정렬
        	@Override
        	public int compare(String[] o1, String[] o2) {
        		int o1StartTime = Integer.parseInt(o1[0].replace(":", ""));
        		int o2StartTime = Integer.parseInt(o2[0].replace(":", ""));
        		
        		return Integer.compare(o1StartTime, o2StartTime);
        	}
		});
        
        String stdTime = "2024-03-07T";	// 기준 날짜
        long cleanTime = 10l;	// 청소 시간
        LocalDateTime lastDateTime = LocalDateTime.parse(stdTime+"23:59");	// 기준 날짜의 마지막 시간
        
        List<LocalDateTime[]> list = new ArrayList<LocalDateTime[]>();
        for(String[] b : book_time) {
        	LocalDateTime startLt = LocalDateTime.parse(stdTime+b[0]);
        	LocalDateTime endLt = LocalDateTime.parse(stdTime+b[1]).plusMinutes(cleanTime);	// 객실 청소시간 10분 추가
        	
        	if(endLt.isAfter(lastDateTime)) {	// 객실 청소시간 10분 추가한 시간이 23:59분 초과한 경우
        		endLt = endLt.minusMinutes(cleanTime);
        	}
        	
    		boolean flag = false;
    		int idx = 0;
    		
    		for(LocalDateTime[] lt : list) {
   				if(startLt.equals(lt[1]) || startLt.isAfter(lt[1])) {	// 객실 교체 가능한 경우
    				flag = true;
    				break;
    			}
    			
    			idx++;
    		}
    		
    		if(flag) {
    			list.remove(idx);
    		}
    		
    		list.add(new LocalDateTime[]{startLt, endLt});
        }
        
        answer = list.size();
        return answer;
    }
}
