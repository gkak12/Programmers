package code.java;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 데이터 분석
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 * 
 * @author hyunjun
 *
 */

public class DataAnalysis {

	public static void main(String[] args) {
		int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		
		solution(data, ext, val_ext, sort_by);
	}
	
	public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        final int extIdx = getIdx(ext);	// 필터기준 속성 조회
        final int sortIdx = getIdx(sort_by);	// 정렬기준 속성 조회
        
        List<int[]> resList = Arrays.asList(data)	// 스트림 통해서 특정 조건에 맞는 데이터 추출하고 정렬처리
        	.stream()
        	.filter(item -> item[extIdx] < val_ext)
        	.sorted(new Comparator<int[]>() {
        		@Override
        		public int compare(int[] o1, int[] o2) {
        			return Integer.compare(o1[sortIdx], o2[sortIdx]);
        		}
			})
        	.collect(Collectors.toList());
        
        answer = resList.toArray(new int[resList.size()][]);
        return answer;
    }
	
	public static int getIdx(String s) {
		int idx = -1;
		
		switch(s) {
	    	case "code":
	    		idx = 0;
	    		break;
	    	case "date":
	    		idx = 1;
	    		break;
	    	case "maximum":
	    		idx = 2;
	    		break;
	    	case "remain":
	    		idx = 3;
	    		break;
	    }
		
		return idx;
	}
}
