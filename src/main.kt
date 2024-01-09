import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val lista = mutableListOf<Int>()
    var value: Int

    do {
            value = scanner.nextInt()
            lista.add(value)
    } while ((value != 0))

    println(lista.max())
}