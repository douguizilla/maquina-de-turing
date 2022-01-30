fun main(args: Array<String>) {

    val mt = MTFactory("C:\\Users\\dougl\\IdeaProjects\\maquina-de-turing\\src\\main\\kotlin\\mt.txt").getMT()
    val tape = Tape("aaaaaaabbbbbb", mt.whiteSymbol, mt.tapeAlphabet, mt.initialState)
    mt.transitions.show()
    while(true){
//        print(tape.actualState + " ")
//        println(tape.getActualSymbol())

        println(tape.printTape())

       var transition = mt.getTransition(tape.actualState, tape.getActualSymbol())

       if(transition != null){
           tape.walkOnTape(transition.direction, transition.symbol)
           tape.actualState = transition.state
       }else{
           println("parei")
           if(mt.isAcceptable(tape.actualState)){
               println("ACEITA")
           }else{
               println("REJEITA")
           }
           break
       }
    }
}