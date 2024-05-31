fun main() {
    val word = readln()

    var counter1 = 0
    for (letter in word) {
        var counter2 = -1
        for (i in word) {
            if (letter == i) {
                counter2++
            }
        }
        if (counter2 == 0) counter1++
    }

    println(counter1)
}