package code.java;

/**
 * 주식 가격
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * 
 * @author hyunjun
 *
 */

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		
		int[] res = solution(prices);
		for(int r : res) {
			System.out.println(r);
		}
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for(int i = 0 ; i < prices.length-1 ; i++) {
			int std = prices[i];
			int sec = 0;
			
			for(int j = i+1 ; j < prices.length ; j++) {
				int cmp = prices[j];
				sec++;
				
				if(std > cmp) {
					break;
				}
			}
			
			answer[i] = sec;
		}
		
		return answer;
	}
}
