package code.kotlin

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 * @author hyunjun
 */

import java.util.Stack

fun main(){
    val n = 3
    val computers = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )

    val result = solution(n, computers)
    println(result)
}

fun solution(n: Int, computers:Array<IntArray>): Int{
    var answer = 0
    val visitLog = BooleanArray(n)

    for(selfIdx in 0 until n){
        if(!visitLog[selfIdx]){     // 자기 자신 네크워크 연결 확인하지 않은 경우 검색 실행
            answer += search(selfIdx, n, computers, visitLog)
        }
    }

    return answer
}

fun search(selfIdx: Int, n:Int, computers: Array<IntArray>, visitLog: BooleanArray): Int{
    val stack = Stack<Int>()
    stack.push(selfIdx)

    while(stack.isNotEmpty()){
        val sIdx = stack.pop()
        visitLog[sIdx] = true

        for(otherIdx in 0 until n){
            if(visitLog[otherIdx] == false && computers[sIdx][otherIdx] == 1){  // 아직 확인하지 않았고 다른 컴퓨터와 네트워크 연결되어 있는 경우
                stack.push(otherIdx)
            }
        }
    }

    return 1
}