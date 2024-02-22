import java.util.*

const val PARK = "park"
const val LEAVE = "leave"
const val OCCUPIED = 1
const val FREE = 2

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

            when (spotNumber) {
                OCCUPIED -> println("Spot $spotNumber is free.")
                FREE -> println("There is no car in spot $spotNumber.")
            }
        }
    }
}