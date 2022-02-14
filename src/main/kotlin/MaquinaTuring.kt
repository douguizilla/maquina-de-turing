class MaquinaTuring(
    val states: List<String>,
    val alphabet: List<Char>,
    val tapeAlphabet: List<Char>,
    val initialState: String,
    val acceptedState: List<String>,
    val whiteSymbol: Char,
    val transitions: Transitions,
){
    fun getTransition(state: String, symbol: Char): TransitionOutput? {
        return transitions.rule["$state,$symbol"]
    }

    fun isAcceptable(state: String) = acceptedState.contains(state)

    fun show(){
        println("Estados: $states")
        println("Alfabeto: $alphabet")
        println("Alfabeto da fita: $tapeAlphabet")
        println("Estado inicial: $initialState")
        println("Estados finais: $acceptedState")
        println("Simbolo branco: $whiteSymbol")
        println("Transições: {")
        transitions.show()
        println("}")
    }
}