package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        
        Arrays.sort(stages);
        
        for(int n = 1 ; n <= N ; n++) {
        	int total = stages.length;
        	int fail = 0;
        	
        	for(int stage : stages) {
        		if(stage > n) {
        			break;
        		}
        		
        		fail++;
        	}
        	
        	System.out.println(n + ": " + fail + "/" + total);
        	
        	stages = Arrays.copyOfRange(stages, fail, total);
        	double percent = total == 0 ? 0 : (double) fail/total; 
            
            list.add(new double[] {(double) n, percent});
        }
        
        Collections.sort(list, new Comparator<double[]>() {
        	@Override
        	public int compare(double[] o1, double[] o2) {
        		if(o1[1] != o2[1]) {
        			return Double.compare(o2[1], o1[1]);
        		} else {
        			return Double.compare(o1[1], o2[1]);
        		}
        	}
		});
        
        answer = list.stream().mapToInt(arr -> (int) arr[0]).toArray();
        return answer;
    }
}
