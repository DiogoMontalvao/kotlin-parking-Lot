private const val PARK = "park"
private const val LEAVE = "leave"
private const val EXIT = "exit"

private const val OCCUPIED = true
private const val FREE = false

private const val MAX_CAPACITY = 20

fun main() {
    val parkingLot = MutableList(MAX_CAPACITY) { FREE }

    var carRegistrationNumber: String
    var carColor: String
    var spotNumber: Int

    var isRunning = true
    while (isRunning) {
        val command = scanner.next()
        when (command) {
            PARK -> {
                carRegistrationNumber = scanner.next()
                carColor = scanner.next()

                park(parkingLot, carColor)
            }

            LEAVE -> {
                spotNumber = scanner.nextInt()
                
                leave(parkingLot, spotNumber)
            }

            EXIT -> isRunning = !isRunning
        }
    }

    scanner.close()
}

private fun park(parkingLot: MutableList<Boolean>, carColor: String) {
    if (isParkingLotFull(parkingLot)) {
        println("Sorry, the parking lot is full.")
    } else {
        for (spot in parkingLot.indices) {
            if (parkingLot[spot] == FREE) {
                parkingLot[spot] = OCCUPIED

                println("$carColor car parked in spot ${spot + 1}")
                break
            }
        }
    }
}

private fun leave(parkingLot: MutableList<Boolean>, spotNumber: Int) {
    parkingLot[spotNumber - 1] = FREE

    println("Spot $spotNumber is free.")
}

private fun isParkingLotFull(parkingLot: MutableList<Boolean>): Boolean {
    var spotsOccupied = 0
    parkingLot.forEach { spot ->
        if (spot == OCCUPIED) spotsOccupied++
    }

    return spotsOccupied == MAX_CAPACITY
}
