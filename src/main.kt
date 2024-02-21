fun main() {
    val interval = readln().toInt()..readln().toInt()

    for (i in interval) {
        when {
            isFizzBuzz(i) -> println("FizzBuzz")
            isFizz(i) -> println("Fizz")
            isBuzz(i) -> println("Buzz")
            else -> println(i)
        }
    }
}

fun isFizzBuzz(i: Int): Boolean { return i % 5 == 0 && i % 3 == 0 }

fun isFizz(i: Int): Boolean { return i % 3 == 0 }

fun isBuzz(i: Int): Boolean { return i % 5 == 0 }

