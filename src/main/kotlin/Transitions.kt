class Transitions {
   val rule: HashMap<TransitionInput, TransitionOutput> = hashMapOf()
}

class TransitionInput {

    val state: String
    val symbol: Char

    constructor(state: String, symbol: Char) {
        this.state = state
        this.symbol = symbol
    }

    override fun equals(other: Any?): Boolean {
        return if (other as? TransitionInput != null) {
            other.state == this.state && other.symbol == this.symbol
        } else {
            false
        }
    }

}

class TransitionOutput {

    val state: String
    val symbol: Char
    val direction: Char

    constructor(state: String, symbol: Char, direction: Char) {
        this.state = state
        this.symbol = symbol
        this.direction = direction
    }

    override fun equals(other: Any?): Boolean {
        return if (other as? TransitionInput != null) {
            other.state == this.state && other.symbol == this.symbol
        } else {
            false
        }
    }

}