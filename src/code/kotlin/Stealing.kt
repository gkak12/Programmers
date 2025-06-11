package code.kotlin

/**
 * 도둑질
 * https://school.programmers.co.kr/learn/courses/30/lessons/42897
 *
 * @author hyunjun
 */

import kotlin.math.max

fun main(){
//    val money = intArrayOf(1, 2, 3, 1)
//    val money = intArrayOf(1, 2, 3, 1, 1)
//    val money = intArrayOf(10, 5, 3, 1, 10)
    val money = intArrayOf(1 ,2 ,3 ,4 ,5 ,6 ,1 ,4)

    val result = solution(money)
    println(result)
}

fun solution(money: IntArray): Int{
    val len = money.size

    if(len <= 3){
        return money.maxOrNull() ?:0
    }

    val hArr1 = IntArray(len)
    hArr1[0] = money[0]
    hArr1[1] = money[1]
    hArr1[2] = money[0]+money[2]

    for(i in 3 until len-1){
        val val1 = hArr1[i-3]+hArr1[i]
        val val2 = hArr1[i-2]+hArr1[i]

        hArr1[i] = max(val1, val2)
    }

    val hMax1 = hArr1.max() ?:0

    val hArr2 = IntArray(len)
    hArr2[1] = money[1]
    hArr2[2] = money[2]

    for(i in 3 until len){
        val val1 = hArr2[i-3]+hArr2[i]
        val val2 = hArr2[i-2]+hArr2[i]

        hArr2[i] = max(val1, val2)
    }

    val hMax2 = hArr2.max() ?:0

    return max(hMax1, hMax2)
}