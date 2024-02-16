fun main() {
    val word = readln()

    var charCounter = 0
    var nextChar = 1

    if (word.isEmpty()) {
        return
    } else {
        for (currentChar in word) {
            charCounter++

            if (nextChar == word.length) {
                print("$currentChar$charCounter")
            } else if (currentChar == word[nextChar]) {
                nextChar++
            } else {
                print("$currentChar$charCounter")
                charCounter = 0
                nextChar++
            }
        }
    }
}

