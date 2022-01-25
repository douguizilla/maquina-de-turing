class Tape(
    word: String,
    val acceptedSymbols: ArrayList<Char>,
    var actualState: String = ""

) {

    private var size: Int = 0
    private val whiteSymbol: Char = 'ç'
    private var tape: ArrayList<Char> = arrayListOf()
    private var actualPosition = 0

    init {
        size = word.length + 1
        word.forEach {
            tape.add(it)
        }
        tape.add(whiteSymbol)
    }

    fun printTape(): String {
        var aux = ""
        tape.forEachIndexed { index, c ->
            if (index == actualPosition) {
                aux += actualState
            }
            aux += c
        }
        return aux
    }

    fun wakeOnTape(direction: Char, symbolToWrite: Char) {
        if (direction == 'd') {
            walkToRight(symbolToWrite)
        }
        if (direction == 'e') {
            walkToLeft(symbolToWrite)
        }
    }

    private fun walkToRight(symbolToWrite: Char) {
        if (symbolIsValid(symbolToWrite)) {
            tape[actualPosition] = symbolToWrite
            if (canWalkToLeft()) {
                actualPosition++
            }
        }
    }

    private fun walkToLeft(symbolToWrite: Char) {
        if (symbolIsValid(symbolToWrite)) {
            tape[actualPosition] = symbolToWrite
            if (canWalkToLeft()) {
                actualPosition--
            }
        }
    }

    private fun canWalkToLeft() = actualPosition != 0

    private fun symbolIsValid(symbolToWrite: Char) = acceptedSymbols.contains(symbolToWrite)
}