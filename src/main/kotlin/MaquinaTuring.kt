class MaquinaTuring(
    private val states: List<String>,
    private val alphabet: List<Char>,
    private val tapeAlphabet: List<Char>,
    private val initialState: String,
    private val acceptedState: String,
    private val rejectedState: String,
    private val transitions: Transitions,
    ) {


}