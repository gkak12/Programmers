package code.java;

/**
 * 로또의 최고 순위와 최저 순위
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 * 
 * @author hyunjun
 *
 */

public class Lotto {

	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		solution(lottos, win_nums);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int lottoCnt = 0;
        int zeroCnt = 0;
        
        for(int l : lottos) {	// 당첨번호와 알아볼 수 없는 숫자 카운트
        	if(l == 0) {
        		zeroCnt += 1;
        		continue;
        	}
        	
        	for(int w : win_nums) {
        		if(l == w) {
        			lottoCnt += 1;
        		}
        	}
        }
        
        int[] answer = {lottoCnt+zeroCnt, lottoCnt};	// 최고 순위, 최저 순위

        for(int i = 0 ; i < answer.length ; i++) {	// 로또 등수 조회
        	int a = answer[i];
        			
        	switch(a) {
        		case 6:
        			answer[i] = 1;
        			break;
        		case 5:
        			answer[i] = 2;
        			break;
        		case 4:
        			answer[i] = 3;
        			break;
        		case 3:
        			answer[i] = 4;
        			break;
        		case 2:
        			answer[i] = 5;
        			break;
        		default:
        			answer[i] = 6;
        			break;
        	}
        }
        
        return answer;
    }
}
