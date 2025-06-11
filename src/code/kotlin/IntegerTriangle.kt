package code.kotlin

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
 *
 * @author hyunjun
 */

fun main(){
    val triangle = arrayOf(
        arrayOf(7),
        arrayOf(3, 8),
        arrayOf(8, 1, 0),
        arrayOf(2, 7, 4, 4),
        arrayOf(4, 5, 2, 6, 5)
    )

    val result = solution(triangle)
    println(result)
}

fun solution(triangle: Array<Array<Int>>): Int {
    if(triangle.size == 1){
        return triangle[0][0]
    }

    var list = mutableListOf<Int>()

    for(i in 1 until triangle.size){
        for(j in 0 until triangle[i].size){
            val leftUpperVal = if(j == 0) 0 else triangle[i-1][j-1]
            val upperVal = if(j == triangle[i].size-1) 0 else triangle[i-1][j]

            val value = if(leftUpperVal > upperVal) leftUpperVal+triangle[i][j] else upperVal+triangle[i][j]
            triangle[i][j] = value

            if(i == triangle.size-1){
                list.add(value)
            }
        }
    }

    return list.max() ?: 0
}