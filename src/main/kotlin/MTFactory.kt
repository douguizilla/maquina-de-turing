/**
 * Formato arquivo
 * , (splitter)
 * q0,q1,q2,q3 (conjunto de estados)
 * a,b,c,d,e,f,g (alfabeto)
 * a,b,c,d,e,f,g,x,y,z (alfabeto fita)
 * q0 (estado inicial)
 * qAceita (estado aceita)
 * qRejeita (estado rejeita)
 * (q0,a)->(q1,a,d),(q0,a)->(q1,a,d),(q0,a)->(q1,a,d) (função transição)
 */

//Para o alfabeto aceitar
class MTFactory {

    private var splitter = ""

    private fun generateStates(states: String) = states.split(splitter)

    private fun generateAlphabet(alphabet: String): ArrayList<Char> {
        val aux = alphabet.split(splitter)
        val alphabetSymbols = arrayListOf<Char>()
        aux.forEach {
            alphabetSymbols.add(it[0])
        }
        return alphabetSymbols
    }

    private fun generateTransition(transition : String) : Transitions{
        val aux = transition.split(splitter)
        val transitions = Transitions()
        aux.forEach {
            val split = it.split("->")
            transitions.rule[getEntry(split[0])] = getOutput(split[1])
        }
        return transitions
    }

    private fun getEntry(entry : String) : TransitionInput{
        var input = entry.removePrefix("(")
        input = input.removeSuffix(")")
        var inputValues = input.split(splitter)
        return TransitionInput(inputValues[0], inputValues[1][0])
    }

    private fun getOutput(entry : String) : TransitionOutput{
        var input = entry.removePrefix("(")
        input = input.removeSuffix(")")
        var inputValues = input.split(splitter)
        return TransitionOutput(inputValues[0], inputValues[1][0], inputValues[2][0])
    }

}