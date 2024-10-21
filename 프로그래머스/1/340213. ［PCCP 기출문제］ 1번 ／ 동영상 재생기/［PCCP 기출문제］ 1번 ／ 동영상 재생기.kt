class Solution {
    //"prev", 10초 전으로 이동,현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동
    // "next", 10초 후로 이동,10초 미만일 경우 영상의 마지막 위치
    //현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이  오프닝이 끝나는 위치로 이동
    fun solution(
        video_len: String,
        pos: String,
        op_start: String,
        op_end: String,
        commands: Array<String>
    ): String {
        val videoLen = video_len.toIntSec()
        val opStart = op_start.toIntSec()
        val opEnd = op_end.toIntSec()
        fun Int.check(): Int {
            //isEnd
            if (this >= videoLen) return videoLen
            //isStart
            if (this < 0) return 0.check()
            //isOp
            if (this in opStart until opEnd) return opEnd
            return this
        }

        var curPos = pos.toIntSec().check()
        commands.forEach {
            when (it) {
                "prev" -> curPos = (curPos - 10).check()
                "next" -> curPos = (curPos + 10).check()
            }
        }
        return curPos.toStrTime()
    }

    private fun String.toIntSec(): Int {
        return this.split(":").map { it.toInt() }.let {
            it[0] * 60 + it[1]
        }
    }

    private fun Int.toStrTime(): String {
        return String.format("%02d:%02d", this / 60, this % 60)
    }
}