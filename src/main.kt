import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val string = scanner.next(); val n = scanner.nextInt()
    var newString = ""

    if (n > string.lastIndex) {
        println(string)
    } else {
        for (i in n..string.lastIndex) {
            newString += string[i]
        }

        for (i in 0 until n) {
            newString += string[i]
        }
    }

    println(newString)
}

