private const val PARK = 0
private const val LEFT = 1
private const val PARKED = 2

fun main() {
    var command = PARK
    while (command < 3) {
        val carColor = scanner.next()

        when (command) {
            PARK -> println("$carColor car has parked.")
            LEFT -> println("$carColor car left the parking lot.")
            PARKED -> println("$carColor car just parked here.")
        }
        command++
    }
}