private const val PARK = "park"
private const val LEAVE = "leave"
private const val EXIT = "exit"

private const val SPOT_FREE = false
private const val SPOT_OCCUPIED = true

private const val MAX_CAPACITY = 20

private val parkingLot = MutableList(MAX_CAPACITY) { SPOT_FREE }

fun main() {
    runProgram()
}

private fun runProgram() {
    var isRunning = true
    while (isRunning) {
        val command = scanner.next()

        when (command) {
            PARK -> park()
            LEAVE -> leave()
            EXIT -> isRunning = false
        }
    }
}

private fun park() {
    val registrationNumber = scanner.next()
    val carColor = scanner.next()

    if (isParkingLotFull()) {
        println("Sorry, the parking lot is full.")
    } else {
        for (spotIndex in parkingLot.indices) {
            val spotNumber = spotIndex + 1

            if (parkingLot[spotIndex] == SPOT_FREE) {

                parkingLot[spotIndex] = SPOT_OCCUPIED
                println("$carColor car parked in spot $spotNumber.")
                break
            }
        }
    }
}

private fun isParkingLotFull(): Boolean {
    var spotsOccupied = 0

    for (spot in parkingLot) {
        if (spot == SPOT_OCCUPIED) spotsOccupied++
    }

    return spotsOccupied == MAX_CAPACITY
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
