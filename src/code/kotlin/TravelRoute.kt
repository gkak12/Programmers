package code.kotlin

/**
 * 여행 경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 *
 * @author hyunjun
 *
 */

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.copyOf
import kotlin.collections.indices
import kotlin.collections.isNotEmpty
import kotlin.collections.sort
import kotlin.collections.toTypedArray

fun main() {
    // val tickets = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
    // val tickets = arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL", "SFO"))
    // val tickets = arrayOf(arrayOf("ICN", "AAA"), arrayOf("ICN", "CCC"), arrayOf("CCC", "DDD"), arrayOf("AAA", "BBB"), arrayOf("AAA", "BBB"), arrayOf("DDD", "ICN"), arrayOf("BBB", "AAA"))
    val tickets = arrayOf(arrayOf("ICN", "AAA"), arrayOf("AAA", "BBB"), arrayOf("AAA", "CCC"), arrayOf("BBB", "AAA"), arrayOf("CCC", "AAA"))

    val result = solution(tickets)
    for (r in result) {
        print("$r ")
    }
    println()
}

fun solution(tickets: Array<Array<String>>): Array<String> {
    val start = "ICN"
    val length = tickets.size

    val routeLog = ArrayDeque<StringBuilder>()
    val visitLog = ArrayDeque<BooleanArray>()

    // 출발지 티켓 조회
    for (i in tickets.indices) {
        val t = tickets[i]
        val sb = StringBuilder()

        if (start == t[0]) {
            routeLog.add(sb.append(t[0]).append(",").append(t[1]))

            val visit = BooleanArray(length)
            visit[i] = true
            visitLog.add(visit)
        }
    }

    val resList = LinkedList<String>()

    // 경로 탐색
    while (routeLog.isNotEmpty()) {
        val route = routeLog.removeFirst()
        val str = route.length - 3
        val end = route.length
        val r1 = route.substring(str, end)

        val visit = visitLog.removeFirst()
        var flag = true

        for (v in visit) {
            if (!v) {
                flag = false
                break
            }
        }

        if (flag) {
            resList.add(route.toString())
            continue
        }

        for (i in tickets.indices) {
            val t = tickets[i]

            if (r1 == t[0] && !visit[i]) {
                val sb = StringBuilder(route.toString())
                routeLog.add(sb.append(",").append(t[1]))

                val v = visit.copyOf()
                v[i] = true
                visitLog.add(v)
            }
        }
    }

    resList.sort()
    return resList.peekFirst().split(",").toTypedArray()
}
