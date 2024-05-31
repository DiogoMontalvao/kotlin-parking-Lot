import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val title = input.nextLine()
    val author = input.nextLine()
    val pages = input.nextInt()

    val book = Book(title, author, pages)
}

class Book(
    val title: String,
    val author: String,
    val pages: Int
) {
    init {
        description(title, author, pages)
    }

    fun description(title: String, author: String, pages: Int) {
        println("$title by $author has $pages pages")
    }
}