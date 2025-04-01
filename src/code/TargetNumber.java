package code;

import java.util.Stack;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 
 * @author hyunjun
 *
 */

public class TargetNumber {

	public static void main(String[] args) {
//		int[] numbers = {1, 1, 1, 1, 1};
//		int target = 3;
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		int res = solution(numbers, target);
		System.out.println(res);
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length+1;
        int[] arr = new int[len];
        arr[0] = 0;
        
        for(int i = 1; i < len ; i++) {
        	arr[i] = numbers[i-1];
        }
        
//        answer = search(1, 0, target, arr);

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{1, 0});

		while(!stack.isEmpty()){
			int[] curr = stack.pop();
			int currIdx = curr[0];
			int currVal = curr[1];

			if(currIdx == arr.length){
				answer = currVal == target ? answer+1 : answer;
				continue;
			}

			stack.push(new int[]{currIdx+1, currVal-arr[currIdx]});
			stack.push(new int[]{currIdx+1, currVal+arr[currIdx]});
		}

        return answer;
    }
	
	public static int search(int idx, int val, int target, int[] arr) {
		if(idx == arr.length) {
			if(val == target) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int plusVal = val+arr[idx];
		int minusVal = val-arr[idx];
		
		return val + search(idx+1, plusVal, target, arr) + search(idx+1, minusVal, target, arr);
	}
}
