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

    /**
     * 프림 알고리즘
     */
    public static int solution(int n, int[][] costs){
        List<List<Edge>> islandList = new ArrayList<>();

        for (int i = 0; i < n; i++){    // 각 섬의 정보 초기화
            islandList.add(new ArrayList<>());
        }

        for (int[] cost : costs) {  // 섬에 연결되어있는 간선 정보 저장
            islandList.get(cost[0]).add(new Edge(cost[1], cost[2]));
            islandList.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));   // 우선순위 큐를 비용 오름차순 정렬 기준으로 생성
        pq.add(new Edge(0, 0));

        int val = 0;
        int visitCnt = 0;

        while (!pq.isEmpty()) {     // 섬 탐색
            Edge curr = pq.poll();

            if (visited[curr.to]){  // 이미 연결한 섬이면 루프 생략
                continue;
            }

            visited[curr.to] = true;    // 방문 여부 갱신
            val += curr.weight;         // 비용 갱신
            visitCnt++;                 // 연결한 섬 갯수 갱신

            if(visitCnt == n){  // 모든 섬을 다 연결한 경우 탐색 종료
                break;
            }

            for (Edge next : islandList.get(curr.to)) {     // 다음 연결할 섬 탐색
                if (!visited[next.to]) {    // 아직 연결하지 않은 경우
                    pq.add(next);           // 간선 정보 추가(비용 오름차순 정렬)
                }
            }
        }

        return val;
    }

    static class Edge {
        int to;         // 연결된 섬 번호
        int weight;     // 다리 건설 비용

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    /**
     * 크루스칼 알고리즘
     */
//    public static int solution(int n, int[][] costs){
//        int val = 0;
//
//        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));  // 비용 기준 오름차순 정렬(최소비용)
//
//        int[] rootArr = new int[n];     // 각 섬의 루트를 저장하는 배열
//
//        for(int i = 0 ; i < n ; i++){   // 각 섬의 루트를 자기자신으로 초기화 
//            rootArr[i] = i;
//        }
//
//        for(int[] cost : costs){    // 간선 탐색
//            // 각 섬의 루트 조회
//            int root1 = searchRoot(rootArr, cost[0]);
//            int root2 = searchRoot(rootArr, cost[1]);
//
//            if(root1 != root2){     // 각 섬의 루트가 다른 경우(사이클이 없는 경우)
//                merge(rootArr, root1, root2);   // 간선 연결
//                val += cost[2];     // 비용 갱신
//            }
//        }
//
//        return val;
//    }
//
//    public static int searchRoot(int[] rootArr, int node){  // 섬의 최상위 섬 조회
//        if(rootArr[node] == node){
//            return node;
//        }
//
//        return searchRoot(rootArr, rootArr[node]);
//    }
//
//    public static void merge(int[] rootArr, int root1, int root2){  // 섬 연결, 작은 숫자의 섬을 루트로 설정
//        if(root1 < root2){
//            rootArr[root2] = root1;
//        } else {
//            rootArr[root1] = root2;
//        }
//    }

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
