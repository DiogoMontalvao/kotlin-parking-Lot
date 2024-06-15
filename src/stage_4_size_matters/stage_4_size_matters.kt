import stage_4_size_matters.Car
import stage_4_size_matters.ParkingLot

private const val CREATE = "create"
private const val STATUS = "status"
private const val PARK = "park"
private const val LEAVE = "leave"
private const val EXIT = "exit"

private val parkingLot = ParkingLot()

fun main() {
    var isRunning = true
    while (isRunning) {
        val command = scanner.next()

        when (command) {
            CREATE -> create()
            STATUS -> parkingLot.status()
            PARK -> park()
            LEAVE -> leave()
            EXIT -> isRunning = false
        }
    }
}

private fun create() {
    val maxCapacity = scanner.nextInt()

    parkingLot.create(maxCapacity)
}

private fun park() {
    val registrationNumber = scanner.next()
    val color = scanner.next()

    parkingLot.park(Car(registrationNumber, color))
}

private fun leave() {
    val spotNumber = scanner.nextInt()

    parkingLot.leave(spotNumber)
}
