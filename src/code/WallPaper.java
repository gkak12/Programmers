package code;

/**
 * 바탕화면 정리
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 * 
 * @author hyunjun
 *
 */

public class WallPaper {

	public static void main(String[] args) {
		String[] wallpaper = {".#...", "..#..", "...#."};
		solution(wallpaper);
	}
	
	public static int[] solution(String[] wallpaper) {
		int xLen = wallpaper[0].length();
        int yLen = wallpaper.length;
		int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0};
        
        for(int i = 0 ; i < yLen ; i++) {
        	for(int j = 0 ; j < xLen ; j++) {
        		if('.' == wallpaper[i].charAt(j)) {
        			continue;
        		}
        		
        		// left up y coord
        		if(i < answer[0]) {
        			answer[0] = i;
        		}
        		
        		// left up x coord
        		if(j < answer[1]) {
        			answer[1] = j;
        		}
        		
        		// right down y coord
        		if(i+1 > answer[2]) {
        			answer[2] = i+1;
        		}
        		
        		// right down x coord
        		if(j+1 > answer[3]) {
        			answer[3] = j+1;
        		}
        	}
        }
        
        return answer;
    }
}
