package code.kotlin

/**
 * 광고 삽입
 * https://school.programmers.co.kr/learn/courses/30/lessons/72414
 *
 * @author hyunjun
 */

fun main(){
    val play_time = "02:03:55"
    val adv_time = "00:14:15"
    val logs = arrayOf("01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30")

//    val play_time = "99:59:59"
//    val adv_time = "25:00:00"
//    val logs = arrayOf("69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00")

    val result = solution(play_time, adv_time, logs)
    println(result)
}

fun solution(play_time:String, adv_time:String, logs:Array<String>): String{
    val playTime = parseTimeToInt(play_time)
    val advTime = parseTimeToInt(adv_time)

    val arr = IntArray(playTime+1)

    // 누적합 세팅
    for(log in logs){
        val sArr = log.split("-")
        val start = parseTimeToInt(sArr[0])
        val end = parseTimeToInt(sArr[1])

        for(i in start until end){
            arr[i] += 1
        }
    }

    // 슬라이딩 윈도우 초기값 세팅
    var timeVal:Long = 0

    for(i in 0 until advTime){
        timeVal += arr[i].toLong()
    }

    var maxVal:Long = timeVal   // 최대 누적 시간
    val endTime = playTime-advTime  // 탐색 종료 시간
    var time = 0    // 최적 광고 시간

    // 최적 광고 시간 탐색
    for(i in 1 ..  endTime){
        timeVal = timeVal-arr[i-1]+arr[advTime+i-1]

        if(maxVal < timeVal){
            maxVal = timeVal
            time = i
        }
    }

    val answer = parseTimeToString(time)
    return answer
}

fun parseTimeToInt(time: String): Int{
    val sArr = time.split(":")

    val hour = sArr[0].toInt()*3600
    val minute = sArr[1].toInt()*60
    val second = sArr[2].toInt()

    return hour+minute+second
}

fun parseTimeToString(time:Int): String{
    val hour = time/3600
    val minute = (time%3600)/60
    val second = time%60

    return String.format("%02d:%02d:%02d", hour, minute, second)
}
