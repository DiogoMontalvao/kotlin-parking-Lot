import java.util.*

private const val PARK = "park"
private const val LEAVE = "leave"

private const val OCCUPIED = 1
private const val FREE = 2

fun main() {
    val scanner = Scanner(System.`in`)

    val registrationNumber: String
    val color: String
    val spotNumber: Int

    val command = scanner.next()
    when (command) {
        PARK -> {
            registrationNumber = scanner.next()
            color = scanner.next()

            println("$color car parked in spot 2.")
        }
        LEAVE -> {
            spotNumber = scanner.nextInt()
            leave(spotNumber)
        }
    }

    scanner.close()
}

fun leave(spotNumber: Int) {
    when (spotNumber) {
        OCCUPIED -> println("Spot $spotNumber is free.")
        FREE -> println("There is no car in spot $spotNumber.")
    }
}