package stage_4_size_matters

private val SPOT_FREE = null

class ParkingLot() {
    private var parkingLot = MutableList<Car?>(0) { SPOT_FREE }

    private var isParkingLotCreated = false
    private var maxCapacity = -1
    private var occupiedSpots = -1

    fun create(_maxCapacity: Int) {
        parkingLot = MutableList(_maxCapacity) { SPOT_FREE }

        isParkingLotCreated = true
        maxCapacity = _maxCapacity
        occupiedSpots = 0

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

        occupiedSpots++
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

            if (isSpotOccupied(spotIndex)) {
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

        if (!isSpotOccupied(spotIndex)) {
            println("There is no car in spot $spotNumber.")
            return
        }

        parkingLot[spotIndex] = SPOT_FREE
        occupiedSpots--

        println("Spot $spotNumber is free.")
    }

    private fun isParkingLotFull() = occupiedSpots == maxCapacity

    private fun isParkingLotEmpty() = occupiedSpots == 0

    private fun isSpotOccupied(spotIndex: Int) = parkingLot[spotIndex] != SPOT_FREE
}