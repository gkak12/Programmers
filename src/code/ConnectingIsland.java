package code;

/**
 * 섬 연결하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 *
 * @author hyunjun
 */

import java.util.*;

public class ConnectingIsland {

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int result = solution(n, costs);
        System.out.println(result);
    }

    public static int solution(int n, int[][] costs){
        int val = 0;

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));  // 비용 기준 오름차순 정렬(최소비용)

        int[] rootArr = new int[n];     // 각 섬의 루트를 저장하는 배열

        for(int i = 0 ; i < n ; i++){   // 각 섬의 루트를 자기자신으로 초기화 
            rootArr[i] = i;
        }

        for(int[] cost : costs){    // 간선 탐색
            // 각 섬의 루트 조회
            int root1 = searchRoot(rootArr, cost[0]);
            int root2 = searchRoot(rootArr, cost[1]);

            if(root1 != root2){     // 각 섬의 루트가 다른 경우(사이클이 없는 경우)
                merge(rootArr, root1, root2);   // 간선 연결
                val += cost[2];     // 비용 갱신
            }
        }

        return val;
    }

    public static int searchRoot(int[] rootArr, int node){  // 섬의 최상위 섬 조회
        if(rootArr[node] == node){
            return node;
        }

        return searchRoot(rootArr, rootArr[node]);
    }

    public static void merge(int[] rootArr, int root1, int root2){  // 섬 연결, 작은 숫자의 섬을 루트로 설정
        if(root1 < root2){
            rootArr[root2] = root1;
        } else {
            rootArr[root1] = root2;
        }
    }

/**
 * 백트래킹 사용한 코드 - 시간 초과
 */
//    public static int solution(int n, int[][] costs) {
//        int cost = 0;
//        Set<Integer> costSet = new HashSet<>();
//        Set<Integer> visitLog = new HashSet<>();
//
//        for(int[] c : costs){
//            visitLog.add(c[0]);
//            visitLog.add(c[1]);
//            cost += c[2];
//
//            search(n, costs, visitLog, cost, costSet);
//
//            visitLog.clear();
//            cost = 0;
//        }
//
//        return Collections.min(costSet);
//    }
//
//    public static void search(int n, int[][] costs, Set<Integer> visitLog, int cost, Set<Integer> costSet) {
//        if(visitLog.size() == n){
//            costSet.add(cost);
//            return;
//        }
//
//        for(int[] c : costs){
//            int nextIsland = 0;
//
//            if(visitLog.contains(c[0]) && !visitLog.contains(c[1])){
//                nextIsland = c[1];
//            } else if(visitLog.contains(c[1]) && !visitLog.contains(c[0])){
//                nextIsland = c[0];
//            }
//
//            if(nextIsland > 0 && !visitLog.contains(nextIsland)){
//                visitLog.add(nextIsland);
//                cost += c[2];
//
//                search(n, costs, visitLog, cost, costSet);
//
//                visitLog.remove(nextIsland);
//                cost -= c[2];
//            }
//        }
//    }
}
