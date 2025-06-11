package code.kotlin

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * @author hyunjun
 *
 */

fun main(){
    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3

    val result = solution(numbers, target)
    println(result)
}

fun solution(numbers: IntArray, target: Int): Int{
    var answer = 0
    val len = numbers.size+1
    val arr = IntArray(len)

    for(i in 1 until len){
        arr[i] = numbers[i-1]
    }

    answer = search(1, 0, target, arr)
    return answer
}

fun search(idx: Int, value: Int, target: Int, arr: IntArray): Int{
    if(idx == arr.size){
        if(value == target){    // value가 target와 같은 경우
            return 1            // 방법 카운트
        } else{         // value가 target와 같지 않은 경우
            return 0    // 방법 카운트 X
        }
    }

    val plusVal = value+arr[idx]    // value와 현재 배열 요소 더한 값
    val minusVal = value-arr[idx]   // value와 현재 배열 요소 뺀 값

    return value
        + search(idx+1, plusVal, target, arr)
        + search(idx+1, minusVal, target, arr)
}

fun searchRecursive(idx: Int, value: Int, target: Int, arr: IntArray): Int{
    if(idx == arr.size){
        return if(value == target) 1 else 0
    }

    return value
        + searchRecursive(idx+1, value+arr[idx], target, arr)
        + searchRecursive(idx+1, value-arr[idx], target, arr)
}