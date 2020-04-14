package subtask1

import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        var result = ""
        try {
            var date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            if (date.dayOfMonth.toString() != day){
                result = "Такого дня не существует"
            } else {
                when(month){
                    "1" -> result = "$day января, "
                    "2" -> result = "$day февраля, "
                    "3" -> result = "$day марта, "
                    "4" -> result = "$day апреля, "
                    "5" -> result = "$day мая, "
                    "6" -> result = "$day июня, "
                    "7" -> result = "$day июля, "
                    "8" -> result = "$day августа, "
                    "9" -> result = "$day сентября, "
                    "10" -> result = "$day октября, "
                    "11" -> result = "$day ноября, "
                    "12" -> result = "$day декабря, "
                }
                when (date.dayOfWeek.toString()){
                    "MONDAY" -> result += "понедельник"
                    "TUESDAY" -> result += "вторник"
                    "WEDNESDAY" -> result += "среда"
                    "THURSDAY" -> result += "четверг"
                    "FRIDAY" -> result += "пятница"
                    "SATURDAY" -> result += "суббота"
                    "SUNDAY" -> result += "воскресенье"
                }
            }
        } catch (e: Exception) {
            result = "Такого дня не существует"
        } finally {
            return result
        }
    }
}
