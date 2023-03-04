package code;

public class Main {
	public static void main(String[] args) {
		MatrixEdge m = new MatrixEdge();
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] res = m.solution(rows, columns, queries);
		
		for(int i : res) {
			System.out.println(i);
		}
	}
}
