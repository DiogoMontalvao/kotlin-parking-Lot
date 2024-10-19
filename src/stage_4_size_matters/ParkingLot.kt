package stage_4_size_matters

private val SPOT_FREE = null

class ParkingLot() {
    private var isParkingLotCreated = false
    private var parkingLot = MutableList<Car?>(0) { SPOT_FREE }

    fun create(maxCapacity: Int) {
        parkingLot = MutableList(maxCapacity) { SPOT_FREE }
        isParkingLotCreated = true
        println("Created a parking lot with $maxCapacity spots.")
    }

    fun park(car: Car) {
        if (!isParkingLotCreated) {
            println("Sorry, a parking lot has not been created.")
            return
        }

        if (isParkingLotFull()) {
            println("Sorry, the parking lot is full.")
            return
        }

        val spotIndex = parkingLot.indexOf(SPOT_FREE)
        val spotNumber = spotIndex + 1

        parkingLot[spotIndex] = car
        println("${car.color} car parked in spot $spotNumber.")
    }

    fun status() {
        if (!isParkingLotCreated) {
            println("Sorry, a parking lot has not been created.")
            return
        }

        if (isParkingLotEmpty()) {
            println("Parking lot is empty.")
            return
        }

        parkingLot.forEachIndexed { spotIndex, car ->
            val spotNumber = spotIndex + 1

            if (!isSpotFree(spotIndex)) {
                println("$spotNumber ${car?.registrationNumber} ${car?.color}")
            }
        }
    }

    fun leave(spotNumber: Int) {
        val spotIndex = spotNumber - 1

        if (!isParkingLotCreated) {
            println("Sorry, a parking lot has not been created.")
            return
        }

        if (isSpotFree(spotIndex)) {
            println("There is no car in spot $spotNumber.")
            return
        }

        parkingLot[spotIndex] = SPOT_FREE
        println("Spot $spotNumber is free.")
    }

    private fun isParkingLotFull() = SPOT_FREE !in parkingLot

    private fun isParkingLotEmpty(): Boolean {
        for (spotIndex in parkingLot.indices) {
            if (!isSpotFree(spotIndex)) return false
        }

        return true
    }

    private fun isSpotFree(spotIndex: Int) = parkingLot[spotIndex] == SPOT_FREE
}