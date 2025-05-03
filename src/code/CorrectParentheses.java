package code;

/**
 * 올바른 괄호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
 *
 * @author hyunjun
 */

import java.util.Stack;

public class CorrectParentheses {

    public static void main(String[] args) {
        String s = "()()";
//        String s = "(())()";
//        String s = ")()(";
//        String s = "(()(";
//        String s = "()))";

        boolean result = solution(s);
        System.out.println(result);
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) { // 문자열 stack에 저장
            stack.push(c);
        }

        Stack<Character> otherStack = new Stack<>();

        while(!stack.isEmpty()) {   // 괄호 비교
            char c = stack.pop();

            if(c == ')'){   // 닫는 괄호인 경우 otherStack에 저장
                otherStack.push(c);
            } else {    // 여는 괄화인 경우 otherStack에 닫는 괄호 있는지 확인
                if(otherStack.isEmpty() || otherStack.pop() != ')'){    // otherStack이 비어있거나 otherStack pop 결과가 닫는 괄호가 아니면 false 리턴 
                    return false;
                }
            }
        }

        answer = otherStack.isEmpty();  // otherStack이 비어있지 않으면 false 리턴(괄호 비교가 끝나지 않았기 때문에)
        return answer;
    }
}
