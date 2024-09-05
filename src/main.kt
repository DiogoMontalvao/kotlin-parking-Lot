import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val batata = MutableList(10) { (1..100).random() }
    println(batata)

    println(batata.ordenacaoSelecaoReversa())
}

fun MutableList<Int>.ordenacaoSelecaoReversa(): List<Int> {
    val lista = this.toMutableList()
    val novaLista = MutableList<Int>(0) { Int.MIN_VALUE }

    for (i in 0..lista.lastIndex) {
        val iMaiorN = encontraIndiceMaior(lista)
        novaLista.add(lista.removeAt(iMaiorN))
    }

    return novaLista
}

fun encontraIndiceMaior(lista: MutableList<Int>): Int {
    var maiorN = lista[0]
    var indiceMaiorN = 0

    lista.forEachIndexed { index, numero ->
        if (numero > maiorN) {
            maiorN = numero
            indiceMaiorN = index
        }
    }

    return indiceMaiorN
}
