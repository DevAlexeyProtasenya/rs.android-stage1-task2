package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var letterB = 0
        var result = "NO"
        for (i in 0 until a.length){
            if(b[letterB] == a[i] || b[letterB] == a[i].toUpperCase()){
                letterB++
                if (letterB==b.length){
                    result = "YES"
                    break
                }
            }
        }
        return result
    }
}
