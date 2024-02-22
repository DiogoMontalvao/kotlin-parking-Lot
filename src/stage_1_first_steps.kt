import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    var count = 0
    while(scanner.hasNext()) {
        var car = scanner.next()

        when (count) {
            0 -> println("$car car has parked.")
            1 -> println("$car car left the parking lot.")
            2 -> println("$car car just parked here.")
        }

        count++
        if (count > 2) count = 0
    }
}