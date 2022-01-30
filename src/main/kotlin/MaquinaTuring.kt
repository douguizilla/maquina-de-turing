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
}