class Transitions {
   val rule: HashMap<String, TransitionOutput> = hashMapOf()

    fun show(){
        val keys = rule.keys
        for(key in keys){
            val value = rule[key]
            value?.let {
                print("($key)->")
                value.show()
            }
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

    fun show(){
        println("(${this.state},${this.symbol},${this.direction})")
    }
}