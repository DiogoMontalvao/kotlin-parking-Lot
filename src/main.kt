import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val batata = MutableList(5) { (1..100).random() }
    println(batata)

    println(ordenacaoSelecao(batata))
    println(ordenacaoSelecaoReversa(batata))
}

fun ordenacaoSelecaoReversa(_lista: MutableList<Int>): List<Int> {
    val lista = _lista.toMutableList()
    val novaLista = MutableList<Int>(0) { Int.MIN_VALUE }

    for (i in 0..lista.size) {
        if (lista.size == 0) break

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
            maiorN = lista[index]
            indiceMaiorN = index
        }
    }

    return indiceMaiorN
}

fun ordenacaoSelecao(_lista: MutableList<Int>): List<Int> {
    val lista = _lista.toMutableList()
    val novaLista = MutableList<Int>(0) { Int.MAX_VALUE }

    for (i in 0..lista.size) {
        if (lista.size == 0) break

        val iMenorN = encontraIndiceMenor(lista)
        novaLista.add(lista.removeAt(iMenorN))
    }

    return novaLista
}

fun encontraIndiceMenor(lista: MutableList<Int>): Int {
    var menorN = lista[0]
    var indiceMenorN = 0

    lista.forEachIndexed { index, numero ->
        if (numero < menorN) {
            menorN = lista[index]
            indiceMenorN = index
        }
    }

    return indiceMenorN
}

fun pesquisaBinaria(lista: MutableList<Int>, numero: Int): Int? {
    var base = 0
    var topo = lista.lastIndex

    var operacoes = 0
    while (base <= topo) {
        operacoes++

        val meio = (topo + base) / 2
        val chute = lista[meio]

        if (chute == numero) {
            println(operacoes)
            return meio
        }
        if (chute > numero) topo = meio - 1
        if (chute < numero) base = meio + 1
    }

    println(operacoes)
    return null
}
