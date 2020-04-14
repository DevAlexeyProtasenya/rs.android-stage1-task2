package subtask4

import java.util.*

class Pangram {

    fun getResult(inputString: String): String {
        return if(inputString.isBlank()){
            ""
        } else {
            processResult(trimWhitespaces(inputString))
        }
    }

    private fun trimWhitespaces(inputString: String) : String{
        var result = inputString.replace("\n","")
        result = result.trim()
        result = result.replace("[\\s]+".toRegex(), " ")
        return result
    }

    private fun isPangram(inputString : String) : Boolean{
        val lowercase = inputString.toLowerCase()
        return  ('a'..'z').all { lowercase.contains(it) }
    }

    private fun processResult(inputString : String) : String{
        val result = StringBuilder("")
        var mas = inputString.split(' ').toMutableList()
        mas = if(isPangram(inputString)){
            processPangram(mas)
        } else {
            processNonPangram(mas)
        }
        mas.sortWith(Comparator{e1, e2 -> e1[0].compareTo(e2[0])})
        for(i in mas.indices){
            result.append(mas[i]).append(' ')
        }
        return result.trimEnd().toString()
    }

    private fun processPangram(mas : MutableList<String>) : MutableList<String>{
        for(i in mas.indices){
            var amount = 0
            var word = ""
            for(j in mas[i].indices){
                when(mas[i][j]){
                    'a',
                    'e',
                    'y',
                    'u',
                    'i',
                    'o' -> {
                        amount++
                        word += mas[i][j].toUpperCase()
                    }
                    else -> word += mas[i][j]
                }
            }
            mas[i] = amount.toString() + word
        }
        return mas
    }

    private fun processNonPangram(mas : MutableList<String>) : MutableList<String>{
        for(i in mas.indices){
            var amount = 0
            var word = ""
            for(j in mas[i].indices){
                when(mas[i][j].toLowerCase()){
                    'q',
                    'w',
                    'r',
                    't',
                    'p',
                    's',
                    'd',
                    'f',
                    'g',
                    'h',
                    'j',
                    'k',
                    'l',
                    'z',
                    'x',
                    'c',
                    'v',
                    'b',
                    'm',
                    'n' -> {
                        amount++
                        word += mas[i][j].toUpperCase()
                    }
                    else -> word += mas[i][j]
                }
            }
            mas[i] = amount.toString() + word
        }
        return mas
    }
}
