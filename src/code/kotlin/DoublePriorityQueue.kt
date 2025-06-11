package code.kotlin

/**
 * 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 *
 * @author hyunjun
 */

import java.util.*

fun main(){
    val operations = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")

    val result = solution(operations)
    println("result is $result")
}

fun solution(operations: Array<String>): IntArray{
    val answer = IntArray(2)

    val pq: PriorityQueue<Int> = PriorityQueue()

    for(operation in operations){
        if(operation == "D 1"){
            if(!pq.isEmpty()){
                val max = pq.maxOrNull() ?: 0
                pq.remove(max)
            }
        } else if(operation == "D -1"){
            if(!pq.isEmpty()) pq.remove()
        } else{
            val num =  operation.split(" ")[1].toInt()
            pq.add(num)
        }
    }

    if(!pq.isEmpty()){
        answer[0] = pq.maxOrNull() ?: 0
        answer[1] = pq.peek() ?: 0
    }

    return answer
}
