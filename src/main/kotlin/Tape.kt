class Tape(
    word: String,
    val whiteSymbol: Char,
    val acceptedSymbols: List<Char>,
    var actualState: String = ""

) {

    private var size: Int = 0
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

    fun walkOnTape(direction: Char, symbolToWrite: Char) : Boolean{
        if (direction == 'R' || direction == 'r' || direction == 'D' || direction == 'd') {
            return walkToRight(symbolToWrite)
        }
        if (direction == 'L' || direction == 'l' || direction == 'E' || direction == 'e') {
            return walkToLeft(symbolToWrite)
        }
        return false
    }

    private fun walkToRight(symbolToWrite: Char) : Boolean{
        if (symbolIsValid(symbolToWrite)) {
            tape[actualPosition] = symbolToWrite
            if(canWalkToRight()) {
                actualPosition++
                return true
            }
        }
        return false
    }

    private fun walkToLeft(symbolToWrite: Char) : Boolean{
        if (symbolIsValid(symbolToWrite)) {
            tape[actualPosition] = symbolToWrite
            if (canWalkToLeft()) {
                actualPosition--
                return true
            }
        }
        return false
    }

    private fun canWalkToLeft() = actualPosition != 0
    private fun canWalkToRight() = actualPosition < size - 1

    private fun symbolIsValid(symbolToWrite: Char) = acceptedSymbols.contains(symbolToWrite)

    fun getActualSymbol() = tape[actualPosition]
}