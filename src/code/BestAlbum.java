package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 베스트 앨범
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 
 * @author hyunjun
 *
 */

public class BestAlbum {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		int[] res = solution(genres, plays);
		for(int r : res) {
			System.out.println(r);
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = null;
		
		int len = genres.length;
		Map<String, Integer> genrePlayMap = new HashMap<String, Integer>();
		Map<String, Integer> genreCntMap = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < len ; i++) {
			String genreName = genres[i];

			int genrePlays = genrePlayMap.getOrDefault(genreName, 0) + plays[i];
			genrePlayMap.put(genreName, genrePlays);
			
			int genreCnt = genreCntMap.getOrDefault(genreName, 0) + 1;
			
			if(genreCnt <= 2) {
				genreCntMap.put(genreName, genreCnt);
			}
		}
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		for(int i = 0 ; i < len ; i++) {
			Map<String, Object> tmpMap = new HashMap<String, Object>();
			
			tmpMap.put("num", i);
			tmpMap.put("plays", plays[i]);
			tmpMap.put("genreName", genres[i]);
			tmpMap.put("genrePlays", genrePlayMap.get(genres[i]));
			
			list.add(tmpMap);
		}
		
		Collections.sort(list, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				int o1GenrePlays = Integer.parseInt(o1.get("genrePlays").toString());
				int o2GenrePlays = Integer.parseInt(o2.get("genrePlays").toString());
				
				if(o1GenrePlays > o2GenrePlays) {	// 장르 총 재생수 내림차순 정렬
					return -1;
				} else if(o1GenrePlays < o2GenrePlays) {
					return 1;
				}
				
				int o1Plays = Integer.parseInt(o1.get("plays").toString());
				int o2Plays = Integer.parseInt(o2.get("plays").toString());
				
				if(o1Plays > o2Plays) {	// 장르 내 노래 재생수 내림차순 정렬 
					return -1;
				} else if(o1Plays < o2Plays) {
					return 1;
				}

				int o1Num = Integer.parseInt(o1.get("num").toString());
				int o2Num = Integer.parseInt(o2.get("num").toString());
				
				if(o1Num < o2Num) {	// 노래 고유번호 오름차순 정렬
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		List<Integer> resList = new ArrayList<Integer>();
		
		for(Map<String, Object> item : list) {
			String genreName = item.get("genreName").toString();
			Integer genreCnt = genreCntMap.get(genreName);
			
			if(genreCnt != null && genreCnt > 0) {
				genreCntMap.put(genreName, genreCnt-1);
				resList.add(Integer.parseInt(item.get("num").toString()));
			}
		}
		
		answer = resList.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}
}
