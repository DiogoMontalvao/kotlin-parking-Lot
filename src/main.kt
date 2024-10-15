import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val sentence = readln().lowercase()
    val haveThe = sentence.contains("the")
    var theIndex = -1

    if (haveThe) theIndex = sentence.indexOf("the")

    println(theIndex)
}