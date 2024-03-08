package code;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
//		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {0, 0, 0};
		int[] numbers = {1, 1, 0};
		
		String res = solution(numbers);
		System.out.println(res);
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
		
		int len = numbers.length;
		String[] sArr = new String[len];
		
		int idx = 0;
		for(int n : numbers) {
			sArr[idx] = String.valueOf(n);
			idx++;
		}
		
		Arrays.asList(sArr).sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		answer = sArr[0].equals("0") ? "0" : String.join("", sArr);
		return answer;
	}
}
