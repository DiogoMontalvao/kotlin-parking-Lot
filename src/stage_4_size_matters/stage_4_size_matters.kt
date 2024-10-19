import stage_4_size_matters.Car
import stage_4_size_matters.ParkingLot

private const val CREATE = "create"
private const val STATUS = "status"
private const val PARK = "park"
private const val LEAVE = "leave"
private const val EXIT = "exit"

fun main() {
    val parkingLot = ParkingLot()

    do {
        val command = scanner.next()

        execCommand(command, parkingLot)
    } while (isRunning(command))
}

private fun execCommand(command: String, parkingLot: ParkingLot) {
    when (command) {
        CREATE -> create(parkingLot)
        STATUS -> parkingLot.status()
        PARK -> park(parkingLot)
        LEAVE -> leave(parkingLot)
    }
}

private fun isRunning(command: String) = command != EXIT

private fun create(parkingLot: ParkingLot) {
    val maxCapacity = scanner.nextInt()

    parkingLot.create(maxCapacity)
}

private fun park(parkingLot: ParkingLot) {
    val registrationNumber = scanner.next()
    val color = scanner.next()

    parkingLot.park(Car(registrationNumber, color))
}

private fun leave(parkingLot: ParkingLot) {
    val spotNumber = scanner.nextInt()

    parkingLot.leave(spotNumber)
}
