package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 
 * @author hyunjun
 *
 */

public class SportsUniform {

	public static void main(String[] args) {
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {1, 3, 5};
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {3};
//		int n = 3;
//		int[] lost = {3};
//		int[] reserve = {1};
//		int n = 5;
//		int[] lost = {1, 3};
//		int[] reserve = {5};
		int n = 5;
		int[] lost = {4, 2};
		int[] reserve = {3, 5};
		
		int res = solution(n, lost, reserve);
		System.out.println(res);
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> lostSet = new HashSet<Integer>();
        for(int l : lost) {
        	lostSet.add(l);
        	list.add(l);
        }
        
        Set<Integer> reserveSet = new HashSet<Integer>();
        for(int r : reserve) {
        	if(lostSet.contains(r)) {
        		lostSet.remove(r);
        	} else {
        		reserveSet.add(r);
        	}
        }
        
        Collections.sort(list);
        for(int l : list) {
        	if(reserveSet.contains(l-1)) {
        		lostSet.remove(l);
        		reserveSet.remove(l-1);
        	} else if(reserveSet.contains(l+1)) {
        		lostSet.remove(l);
        		reserveSet.remove(l+1);
        	}
        }
        
        answer = n - lostSet.size();
        return answer;
    }
}
