package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        var result = ""
        var formattedHour : Int
        var formattedMinute : Int
        var secretWord = ""
        if (hour.toInt()<12 && minute.toInt()<60){
            if(minute.toInt() <= 30){
                formattedHour = hour.toInt()
                formattedMinute = minute.toInt()
                secretWord = "past"
            } else {
                formattedHour = hour.toInt() + 1
                formattedMinute = 60 - minute.toInt()
                secretWord = "to"
                if(formattedHour == 12){
                    formattedHour = 0
                }
            }
            var counts = mapOf(
                0 to "twelve",
                1 to "one",
                2 to "two",
                3 to "three",
                4 to "four",
                5 to "five",
                6 to "six",
                7 to "seven",
                8 to "eight",
                9 to "nine",
                10 to "ten",
                11 to "eleven",
                12 to "twelve",
                13 to "thirteen"
            )
            if(formattedMinute == 0){
                result = counts.getValue(hour.toInt()) + " o' clock"
            } else {
                when(formattedMinute){
                    in 1..13 -> result = counts.getValue(formattedMinute) + " minutes " + secretWord
                    14 -> result = counts.getValue(formattedMinute-10) + "teen" + " minutes " + secretWord
                    15 -> result = "quarter $secretWord"
                    in 16..19 -> result = counts.getValue(formattedMinute-10) + "teen" + " minutes " + secretWord
                    20 -> result = "twenty minutes $secretWord"
                    in 21..29 -> result = "twenty " + counts.getValue(formattedMinute-20) + " minutes " + secretWord
                    30 -> result = "half $secretWord"
                }
                result += " " + counts.getValue(formattedHour)
            }
        }
        return result
    }
}
