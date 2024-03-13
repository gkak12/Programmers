package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GemsShopping {

	public static void main(String[] args) {
//		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//		String[] gems = {"XYZ", "XYZ", "XYZ"};
//		String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//		String[] gems = {"A","B","B","B","B","B","B","C","B","A"};
//		String[] gems = {"A","A","A","B","B"};
//		String[] gems = {"DIA","RUBY","RUBY","RUBY","EMERALD","SAPPHIRE","SAPPHIRE","DIA"};
		String[] gems = {"DIA","DIA","DIA","RUBY","RUBY","EMERALD","SAPPHIRE","DIA"};
		
		int[] res = solution(gems);
		for(int r : res) {
			System.out.print(r+" ");
		}
	}
	
	public static int[] solution(String[] gems) {
		int gemsSize = new HashSet<String>(List.of(gems)).size();
		
		if(gemsSize == 1) {	// 보석 종류 1개인 경우 [1, 1] 리턴(예외처리)
			return new int[]{1, 1};
		} else if(gemsSize == gems.length) {	// 보석 종류 개수와 보석 개수가 같은 경우, 입출력 예제 4번
			return new int[]{1, gemsSize};
		}
		
		List<int[]> list = new ArrayList<int[]>();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		int idx = 0;
		
		for(String gem : gems) {
			map.put(gem, idx);	// map에 보석종류와 번호 저장
			
			if(map.keySet().size() == gemsSize) {
				int start = Collections.min(map.values())+1;	// 시작 번호, map에서 시작 번호 조회
				int end = idx+1;	// 끝 번호, 현재 번호가 마지막 번호이므로
				list.add(new int[] {end-start, start, end});
			}
			
			idx++;
		}
		
		list.sort(new Comparator<int[]>() {	// 구간 길이 우선 오름차순, 구간 길이 같으면 시작 번호 오름차순 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) {
					return -1;
				} else if(o1[0] > o2[0]) {
					return 1;
				} else {
					return Integer.compare(o1[1], o2[1]);
				}
			}
		});
		
		int[] answer = {list.get(0)[1], list.get(0)[2]};
		return answer;
	}
}
