import java.util.*

fun main(args: Array<String>) {

    var mt : MaquinaTuring
    var tape : Tape
    var option : Int?
    var path = ""

    do {
        menu()
        option = readLine()!!.toIntOrNull()

        option?.let { option ->
            when(option){
                1 -> {
                    print("Digite o caminho do arquivo: ")
                    path = readLine()!!
                    mt = MTFactory(path).getMT()
                }

                2 -> {
                    if(path.isNotEmpty()) {
                        print("Cadeia a ser testada: ")
                        val word = readLine()!!

                        mt = MTFactory(path).getMT()
                        tape = Tape(word,mt.whiteSymbol,mt.tapeAlphabet,mt.initialState)

                        println("\nProcessamento:")
                        while (true) {

                            println(tape.printTape())

                            var transition = mt.getTransition(tape.actualState, tape.getActualSymbol())

                            if (transition != null) {
                                var canWalk = tape.walkOnTape(direction = transition.direction, symbolToWrite = transition.symbol)
                                tape.actualState = transition.state

                                if(!canWalk ){

                                    if (mt.isAcceptable(tape.actualState)) {
                                        println("Resultado: ACEITA")
                                    } else {
                                        println("Resultado: REJEITA")
                                    }
                                    break
                                }
                            } else {
                                if (mt.isAcceptable(tape.actualState)) {
                                    println("Resultado: ACEITA")
                                } else {
                                    println("Resultado: REJEITA")
                                }
                                break
                            }
                        }
                    }else{
                        showInstruction()
                    }
                }
                3 ->{
                    if(path.isNotEmpty()) {
                        mt = MTFactory(path).getMT()
                        mt.show()
                    }else{
                        showInstruction()
                    }
                }
                4 ->{
                    println("Simula????o finalizada!")
                }
            }
        }

    }while (option == null || option != 4)


}

fun menu(){
    println("===========MAQUINA DE TURING - COM ESTADO FINAL===========")
    println("1 - Adicionar caminho do arquivo")
    println("2 - Adicionar cadeia")
    println("3 - Ver especifica????o da m??quina de turing")
    println("4 - Parar a simula????o")
    print("Op????o: ")
}

fun showInstruction(){
    println("AVISO: ?? necess??rio indicar um arquivo que contenha a especifica????o da M??quina de Turing com estado final...")
    println("O formato do arquivo deve obedecer a seguinte estrutura (os parenteses apenas explicam o que deve ter em cada linha do arquivo):")
    println(" *\n" +
            " * , (innerSplitter)\n" +
            " * ; (externalSplitter)\n" +
            " * q0;q1;q2;q3 (conjunto de estados)\n" +
            " * a;b;c;d;e;f;g (alfabeto)\n" +
            " * a;b;c;d;e;f;g;X;Y;Y (alfabeto fita)\n" +
            " * q0 (estado inicial)\n" +
            " * q2;q3 (estados de aceita????o)\n" +
            " * \$ (simbolo branco)\n" +
            " * (q0,a)->(q1,a,d);(q0,a)->(q1,a,d);(q0,a)->(q1,a,d) (fun????o transi????o)\n" +
            " *")
}