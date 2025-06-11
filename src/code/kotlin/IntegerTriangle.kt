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
            val leftUpperVal = if(j == 0) 0 else triangle[i-1][j-1]     // 윗줄-왼쪽 값 조회, 현재 위치가 맨 왼쪽이면 0
            val upperVal = if(j == triangle[i].size-1) 0 else triangle[i-1][j]  // 바로 윗줄 값 조회, 현재 위치가 맨 오른쪽이면 0

            val value = if(leftUpperVal > upperVal) leftUpperVal+triangle[i][j] else upperVal+triangle[i][j]    // 2개 비교해서 큰 값이랑 현재 위치 더하기 연산
            triangle[i][j] = value

            if(i == triangle.size-1){   // 마지막 줄인 경우 리스트에 추가
                list.add(value)
            }
        }
    }

    return list.max() ?: 0  // 가장 큰 값 리턴
}