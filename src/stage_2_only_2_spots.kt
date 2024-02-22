private const val PARK = "park"
private const val LEAVE = "leave"

private const val OCCUPIED = 1
private const val FREE = 2

fun main() {
    val carRegistrationNumber: String
    val carColor: String
    val spotNumber: Int

    val command = scanner.next()
    when (command) {
        PARK -> {
            carRegistrationNumber = scanner.next()
            carColor = scanner.next()

            park(carColor)
        }
        LEAVE -> {
            spotNumber = scanner.nextInt()

            leave(spotNumber)
        }
    }

    scanner.close()
}

private fun park(carColor: String) {
    println("$carColor car parked in spot 2.")
}

private fun leave(spotNumber: Int) {
    when (spotNumber) {
        OCCUPIED -> println("Spot $spotNumber is free.")
        FREE -> println("There is no car in spot $spotNumber.")
    }
}