private const val PARK = "park"
private const val LEAVE = "leave"

private const val SPOT_FREE = false
private const val SPOT_OCCUPIED = true

private val parkingLot = mutableListOf(SPOT_OCCUPIED, SPOT_FREE)

fun main() {
    val command = scanner.next()

    when (command) {
        PARK -> park()
        LEAVE -> leave()
    }
}

private fun park() {
    val registrationNumber = scanner.next()
    val carColor = scanner.next()

    parkingLot.forEachIndexed { index, spot ->
        val spotNumber = index + 1

        if (spot == SPOT_FREE) {
            parkingLot[index] = SPOT_OCCUPIED
            println("$carColor car parked in spot $spotNumber.")
        }
    }
}

private fun leave() {
    val spotNumber = scanner.nextInt()
    val spotIndex = spotNumber - 1

    if (parkingLot[spotIndex] == SPOT_FREE) {
        println("There is no car in spot $spotNumber.")
    } else {
        parkingLot[spotIndex] = SPOT_FREE
        println("Spot $spotNumber is free.")
    }
}