package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var current = 0
        var next = 1
        var result = 0
        while (current * next <= n) {
            if (current * next == n){
                result = 1
                break
            } else {
                val sum = current + next
                current = next
                next = sum
            }
        }
        return intArrayOf(current, next, result)
    }
}
