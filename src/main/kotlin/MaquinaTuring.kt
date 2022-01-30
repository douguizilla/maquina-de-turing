class MaquinaTuring(
    private val states: List<String>,
    private val alphabet: List<Char>,
    private val tapeAlphabet: List<Char>,
    private val initialState: String,
    private val acceptedState: List<String>,
    private val whiteSymbol: String,
    private val transitions: Transitions,
    ) {


}