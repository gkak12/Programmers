package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 실패율
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 
 * @author hyunjun
 *
 */

public class FailurePercent {

	public static void main(String[] args) {
//		int N = 5;
//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
//		int N = 4;
//		int[] stages = {4, 4, 4, 4, 4};
		
//		int N = 5;
//		int[] stages = {4, 4, 4, 4, 4};
		
//		int N = 5;
//		int[] stages = {1, 2, 1, 1, 3, 4};
		
//		int N = 4;
//		int[] stages = {1, 1, 2, 2, 3, 3, 4, 4};
		
//		int N = 3;
//		int[] stages = {3, 2, 1, 2, 2, 3, 1, 3};
		
//		int N = 3;
//		int[] stages = {3, 1, 1, 1, 2, 2, 1, 3};
		
//		int N = 3;
//		int[] stages = {4, 1, 1, 1, 2, 2, 1, 3};
		
//		int N = 5;
//		int[] stages = {4, 1, 1, 1, 2, 2, 1, 3};
		
//		int N = 6;
//		int[] stages = {1,2,2,1,3};
		
		int N = 6;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		solution(N, stages);
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
        List<double[]> list = new ArrayList<double[]>();
        
        Arrays.sort(stages);	// 사용자가 있는 스테이지 오름차순 정렬
        
        for(int n = 1 ; n <= N ; n++) {
        	int total = stages.length;	// 현재 스테이지에 도달한 사용자 수
        	int fail = 0;	// 실패한 사용자 인덱스
        	
        	for(int stage : stages) {	// 스테이지 실패한 사용자 수
        		if(stage > n) {
        			break;
        		}
        		
        		fail++;
        	}
        	
//        	System.out.println(n + ": " + fail + "/" + total);
        	
        	stages = Arrays.copyOfRange(stages, fail, total);	// 다음 스테이지에 올라갈 사용자 복사
        	double percent = total == 0 ? 0 : (double) fail/total;	// 현재 스테이지 실패율 계산
            
            list.add(new double[] {(double) n, percent});	// 현재 스테이지와 실패율 리스트 저장
        }
        
        Collections.sort(list, new Comparator<double[]>() {	// 실패율 내림차순 우선 정렬, 실패율이 동률이면 스테이지 번호 오름차순 정렬
        	@Override
        	public int compare(double[] o1, double[] o2) {
        		if(o1[1] != o2[1]) {
        			return Double.compare(o2[1], o1[1]);
        		} else {
        			return Double.compare(o1[1], o2[1]);
        		}
        	}
		});
        
        answer = list.stream().mapToInt(arr -> (int) arr[0]).toArray();	// 리스트 배열로 변환, 스테이지 번호 반환
        return answer;
    }
}
