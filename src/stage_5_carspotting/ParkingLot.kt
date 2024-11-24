package stage_5_carspotting

private val SPOT_FREE = null

class ParkingLot() {
    private var parkingLot = MutableList<Car?>(0) { SPOT_FREE }

    private var isParkingLotCreated = false
    private var maxCapacity = -1
    private var occupiedSpots = -1

    private fun isParkingLotFull() = occupiedSpots == maxCapacity

    private fun isParkingLotEmpty() = occupiedSpots == 0

    private fun isSpotOccupied(spotIndex: Int) = parkingLot[spotIndex] != SPOT_FREE

    private fun isParkedCarColor(color: String): Boolean {
        parkingLot.forEach { car ->
            if (car?.color?.uppercase() == color.uppercase()) return true
        }

        return false
    }

    private fun isParkedRegistrationNumber(registrationNumber: String): Boolean {
        parkingLot.forEach { car ->
            if (car?.registrationNumber?.uppercase() == registrationNumber.uppercase()) return true
        }

        return false
    }

    fun create(_maxCapacity: Int): String {
        parkingLot = MutableList(_maxCapacity) { SPOT_FREE }

        isParkingLotCreated = true
        maxCapacity = _maxCapacity
        occupiedSpots = 0

        return "Created a parking lot with $maxCapacity spots."
    }

    fun park(car: Car): String {
        if (!isParkingLotCreated) return "Sorry, a parking lot has not been created."

        if (isParkingLotFull()) return "Sorry, the parking lot is full."

        val spotIndex = parkingLot.indexOf(SPOT_FREE)
        val spotNumber = spotIndex + 1

        occupiedSpots++
        parkingLot[spotIndex] = car

        return "${car.color} car parked in spot $spotNumber."
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

    fun leave(spotNumber: Int): String {
        val spotIndex = spotNumber - 1

        if (!isParkingLotCreated) return "Sorry, a parking lot has not been created."

        if (!isSpotOccupied(spotIndex)) return "There is no car in spot $spotNumber."

        parkingLot[spotIndex] = SPOT_FREE
        occupiedSpots--

        return "Spot $spotNumber is free."
    }

    fun regByColor(color: String): String {
        if (!isParkingLotCreated) return "Sorry, a parking lot has not been created."

        if (isParkingLotEmpty()) return "No cars with color $color were found."

        if (!isParkedCarColor(color)) return "No cars with color $color were found."

        val registrationNumbers = mutableListOf<String>()

        parkingLot.forEachIndexed { spotIndex, car ->
            if (isSpotOccupied(spotIndex) && car?.color?.uppercase() == color.uppercase())
                registrationNumbers.add(car.registrationNumber)
        }

        return registrationNumbers.joinToString()
    }

    fun spotByColor(color: String): String {
        if (!isParkingLotCreated) return "Sorry, a parking lot has not been created."

        if (isParkingLotEmpty()) return "No cars with color $color were found."

        if (!isParkedCarColor(color)) return "No cars with color $color were found."

        val spotNumbers = mutableListOf<Int>()

        parkingLot.forEachIndexed { spotIndex, car ->
            val spotNumber = spotIndex + 1

            if (isSpotOccupied(spotIndex) && car?.color?.uppercase() == color.uppercase())
                spotNumbers.add(spotNumber)
        }

        return spotNumbers.joinToString()
    }

    fun spotByReg(registrationNumber: String): String {
        if (!isParkingLotCreated) return "Sorry, a parking lot has not been created."

        if (isParkingLotEmpty())
            return "No cars with registration number $registrationNumber were found."

        if (!isParkedRegistrationNumber(registrationNumber))
            return "No cars with registration number $registrationNumber were found."

        var spotNumber = -1

        parkingLot.forEachIndexed { spotIndex, car ->
            if (isSpotOccupied(spotIndex) &&
                car?.registrationNumber?.uppercase() == registrationNumber.uppercase()
            )
                spotNumber = spotIndex + 1
        }

        return spotNumber.toString()
    }
}