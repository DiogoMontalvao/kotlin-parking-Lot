import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max

val scanner = Scanner(System.`in`)

fun main() {
    carPrice()
}

fun carPrice(old: Int = 5, kilometers: Int = 100_000, maximumSpeed: Int = 120, automatic: Boolean = false) {
    var currentCarPrice = 20_000

    currentCarPrice -= 2_000 * old

    when {
        maximumSpeed > 120 -> currentCarPrice += 100 * (120 - maximumSpeed).absoluteValue
        maximumSpeed < 120 -> currentCarPrice -= 100 * (120 - maximumSpeed).absoluteValue
    }

    if (kilometers >= 10000) {
        val temp = kilometers / 10000
        currentCarPrice -= temp * 200
    }

    if (automatic) currentCarPrice += 1500

    println(currentCarPrice)
}

