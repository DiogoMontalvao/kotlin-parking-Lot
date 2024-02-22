import java.util.*

private const val PARK = 0
private const val LEFT = 1
private const val PARKED = 2

fun main() {
    val scanner = Scanner(System.`in`)

    var counter = 0
    while (scanner.hasNext()) {
        val car = scanner.next()

        when (counter) {
            PARK -> println("$car car has parked.")
            LEFT -> println("$car car left the parking lot.")
            PARKED -> println("$car car just parked here.")
        }
        counter++

        if (counter > 2) counter = 0
    }
}