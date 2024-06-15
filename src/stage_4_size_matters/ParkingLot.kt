package stage_4_size_matters

private val SPOT_FREE = null

class ParkingLot() {
    private var isParkingLotCreated = false
    private var parkingLotSpots = MutableList<Car?>(0) { SPOT_FREE }

    fun create(maxCapacity: Int) {

        parkingLotSpots = MutableList(maxCapacity) { SPOT_FREE }
        isParkingLotCreated = true
        println("Created a parking lot with $maxCapacity spots.")
    }

    fun park(car: Car) {

        if (isParkingLotCreated) {

            if (isParkingLotFull()) {

                println("Sorry, the parking lot is full.")
            } else {
                for (spotIndex in parkingLotSpots.indices) {

                    val spotNumber = spotIndex + 1

                    if (parkingLotSpots[spotIndex] == SPOT_FREE) {

                        parkingLotSpots[spotIndex] = car
                        println("${car.color} car parked in spot $spotNumber.")
                        break
                    }
                }
            }
        } else {
            println("Sorry, a parking lot has not been created.")
        }
    }

    fun status() {

        if (isParkingLotCreated) {

            if (isParkingLotEmpty()) {

                println("Parking lot is empty.")
            } else {
                showCarsInfo()
            }
        } else {
            println("Sorry, a parking lot has not been created.")
        }
    }

    fun leave(spotNumber: Int) {

        val spotIndex = spotNumber - 1

        if (isParkingLotCreated) {

            if (parkingLotSpots[spotIndex] == SPOT_FREE) {
                println("There is no car in spot $spotNumber.")
            } else {
                parkingLotSpots[spotIndex] = SPOT_FREE
                println("Spot $spotNumber is free.")
            }
        } else {
            println("Sorry, a parking lot has not been created.")
        }
    }

    private fun isParkingLotFull(): Boolean {

        var spotsOccupied = 0

        parkingLotSpots.forEach { spot ->
            if (spot != SPOT_FREE) spotsOccupied++
        }

        return spotsOccupied == parkingLotSpots.size
    }

    private fun isParkingLotEmpty(): Boolean {

        var isEmpty = true

        for (spot in parkingLotSpots) {
            if (spot != SPOT_FREE) {
                isEmpty = false
                break
            }
        }

        return isEmpty
    }

    private fun showCarsInfo() {

        parkingLotSpots.forEachIndexed { index, car ->

            val spotNumber = index + 1

            if (car != SPOT_FREE) {
                println("$spotNumber ${car.registrationNumber} ${car.color}")
            }
        }
    }
}