package code.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 여행 경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * 
 * @author hyunjun
 *
 */

public class TravelRoute {

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};
		String[][] tickets = {{"ICN","AAA"}, {"AAA","BBB"}, {"AAA","CCC"}, {"BBB","AAA"}, {"CCC","AAA"}};
		
		String[] res = solution(tickets);
		for(String r : res) {
			System.out.print(r+" ");
		}
		System.out.println();
	}
	
	public static String[] solution(String[][] tickets) {
        String[] answer = {};
        String start = "ICN";
        int length = tickets.length;
        
        Queue<StringBuilder> routeLog = new LinkedList<StringBuilder>();
        Queue<boolean[]> visitLog = new LinkedList<boolean[]>();
        
        // 출발지 티켓 조회
        for(int i = 0; i < tickets.length ; i++) {
        	String[] t = tickets[i];
        	StringBuilder sb = new StringBuilder();
        	
        	if(start.equals(t[0])) {
        		routeLog.add(sb.append(t[0]).append(",").append(t[1]));
        		
        		boolean[] visit = new boolean[length];
        		visit[i] = true;
        		visitLog.add(visit);
        	}
        }
        
        LinkedList<String> resList = new LinkedList<String>();
        
        // 경로 탐색
        while(!routeLog.isEmpty()) {
        	StringBuilder route = routeLog.poll();
        	int str = route.length()-3;
        	int end = route.length();
        	String r1 = route.substring(str, end);

        	boolean[] visit = visitLog.poll();
        	boolean flag = false;
        	
        	for(boolean v : visit) {	// 모든 항공권 사용여부 확인
        		if(v == false) {
        			flag = false;
        			break;
        		}
        		
        		flag = true;
        	}
        	
        	if(flag) {	// 모든 항공권 사용한 경우
        		resList.add(route.toString());
        		
        		continue;
        	}
        	
        	for(int i = 0 ; i < tickets.length ; i++) {
        		String[] t = tickets[i];
        		
        		if(r1.equals(t[0]) && !visit[i]) {	// 다음 목적지 찾은 경우
        			StringBuilder sb = new StringBuilder(route.toString());
        			routeLog.add(sb.append(",").append(t[1]));
        			
        			boolean[] v = Arrays.copyOf(visit, visit.length);
        			v[i] = true;
        			visitLog.add(v);
        		}
        	}
        }
        
        Collections.sort(resList);
        
        answer = resList.peekFirst().split(",");
        return answer;
    }
	
//	public static String[] solution(String[][] tickets) {
//        String[] answer = {};
//        String start = "ICN";
//        int length = tickets.length;
//        
//        Queue<StringBuilder> routeLog = new LinkedList<StringBuilder>();
//        Queue<boolean[]> visitLog = new LinkedList<boolean[]>();
//        
//        // 시작 티켓 파싱
//        for(int i = 0; i < tickets.length ; i++) {
//        	String[] t = tickets[i];
//        	StringBuilder sb = new StringBuilder();
//        	
//        	if(start.equals(t[0])) {
//        		routeLog.add(sb.append(t[0]).append(",").append(t[1]));
//        		
//        		boolean[] visit = new boolean[length];
//        		visit[i] = true;
//        		visitLog.add(visit);
//        	}
//        }
//        
//        LinkedList<String> resList = new LinkedList<String>();
//        
//        // 경로 탐색
//        while(!routeLog.isEmpty()) {
//        	StringBuilder route = routeLog.poll();
//        	int str = route.length()-3;
//        	int end = route.length();
//        	String r1 = route.substring(str, end);
//
//        	boolean[] visit = visitLog.poll();
//        	boolean flag = false;
//        	
//        	for(boolean v : visit) {	// 모든 티켓 사용여부 확인
//        		if(v == false) {
//        			flag = false;
//        			break;
//        		}
//        		
//        		flag = true;
//        	}
//        	
//        	if(flag) {	// 모든 티켓 사용한 경우
//        		resList.add(route.toString());
//        		
//        		continue;
//        	}
//        	
//        	for(int i = 0 ; i < tickets.length ; i++) {
//        		String[] t = tickets[i];
//        		
//        		if(r1.equals(t[0]) && !visit[i]) {	// 다음 목적지 찾은 경우
//        			routeLog.add(route.append(",").append(t[1]));
//        			
//        			visit[i] = true;
//        			visitLog.add(visit);
//        			
//        			break;
//        		}
//        	}
//        }
//        
//        Collections.sort(resList);
//        
//        answer = resList.peekFirst().split(",");
//        return answer;
//    }
}
