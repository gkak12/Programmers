package code;

/**
 * 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 *
 * @author hyunjun
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordConversion {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words);
        System.out.println(result);
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        if(!Arrays.asList(words).contains(target)) {    // 목표 문자열이 단어 집합에 없는 경우
            return answer;
        }

        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[] {begin, "0"});   // 문자와 변환 횟수를 큐에 추가
        int matchCnt = begin.length()-1;

        while(!queue.isEmpty()) {
            String[] curr = queue.poll();
            String currWord = curr[0];
            Integer currCnt = Integer.parseInt(curr[1]);

            if(currWord.equals(target)) {   // 현재 문자열이 목표 문자열과 일치하는 경우
                answer = currCnt;   // 현재 변환 횟수 대입 및 루프 중단
                break;
            }

            for(String word : words) {  // 단어 집합 탐색
                int charCnt = 0;
                boolean charFlag = false;

                if(currWord.equals(word)) {     // 현재 문자열이 단어 집합에 있는 경우 생략
                    continue;
                }

                for(int i = 0 ; i < word.length() ; i++) {
                    if(currWord.charAt(i) == word.charAt(i)) {  // 1글자씩 비교해서 일치하는지 확인
                       charCnt++;
                    }

                    if(charCnt == matchCnt){    // 1글자를 제외한 나머지 글자가 일치하는지 확인
                        charFlag = true;        // 비교 중단
                        break;
                    }
                }

                if(charFlag) {  // 1글자를 제외한 나머지 글자가 일치하는 경우
                    queue.add(new String[] {word, String.valueOf(currCnt+1)});  // 다음 탐색 대상에 추가
                }
            }
        }

        return answer;
    }
}
