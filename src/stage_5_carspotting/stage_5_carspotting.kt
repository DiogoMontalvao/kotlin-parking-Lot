import stage_5_carspotting.Car
import stage_5_carspotting.ParkingLot

private const val CREATE = "create"
private const val STATUS = "status"
private const val PARK = "park"
private const val LEAVE = "leave"
private const val EXIT = "exit"
private const val REG_BY_COLOR = "reg_by_color"
private const val SPOT_BY_COLOR = "spot_by_color"
private const val SPOT_BY_REG = "spot_by_reg"

fun runStage5Carspotting() {
    val parkingLot = ParkingLot()

    do {
        val command = scanner.next()
        execCommand(command, parkingLot)
    } while (command != EXIT)
}

private fun execCommand(command: String, parkingLot: ParkingLot) {
    when (command) {
        CREATE -> create(parkingLot)
        STATUS -> parkingLot.status()
        PARK -> park(parkingLot)
        LEAVE -> leave(parkingLot)
        REG_BY_COLOR -> regByColor(parkingLot)
        SPOT_BY_COLOR -> spotByColor(parkingLot)
        SPOT_BY_REG -> spotByReg(parkingLot)
    }
}

private fun create(parkingLot: ParkingLot) {
    val maxCapacity = scanner.nextInt()

    println(parkingLot.create(maxCapacity))
}

private fun park(parkingLot: ParkingLot) {
    val registrationNumber = scanner.next()
    val color = scanner.next()

    println(parkingLot.park(Car(registrationNumber, color)))
}

private fun leave(parkingLot: ParkingLot) {
    val spotNumber = scanner.nextInt()

    println(parkingLot.leave(spotNumber))
}

private fun regByColor(parkingLot: ParkingLot) {
    val color = scanner.next()

    println(parkingLot.regByColor(color))
}

private fun spotByColor(parkingLot: ParkingLot) {
    val color = scanner.next()

    println(parkingLot.spotByColor(color))
}

private fun spotByReg(parkingLot: ParkingLot) {
    val registrationNumber = scanner.next()

    println(parkingLot.spotByReg(registrationNumber))
}