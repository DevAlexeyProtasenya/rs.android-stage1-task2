package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when(blockB){
            String::class -> isString(blockA)
            LocalDate::class -> isDate(blockA)
            Int::class -> isInt(blockA)
            else -> ""
        }
    }

    private fun isString(blockA : Array<Any>) : String{
        var result = ""
        for(i in blockA.indices){
            if(blockA[i] is String){
                result += blockA[i]
            }
        }
        return result
    }

    private fun isInt(blockA : Array<Any>) : Int{
        var result = 0
        for(i in blockA.indices){
            if(blockA[i] is Int){
                result += blockA[i] as Int
            }
        }
        return result
    }

    private fun isDate(blockA : Array<Any>) : String{
        var amountOfDate = 0
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        var latestDate: LocalDate
        latestDate = LocalDate.parse("0001-01-01")
        for(i in blockA.indices){
            if(blockA[i] is LocalDate){
                if(amountOfDate == 0){
                    amountOfDate++
                    latestDate = blockA[i] as LocalDate
                } else {
                    if((latestDate as LocalDate).isBefore(blockA[i] as LocalDate)){
                        latestDate = blockA[i] as LocalDate
                    }
                }
            }
        }
        return latestDate.format(formatter)
    }
}
