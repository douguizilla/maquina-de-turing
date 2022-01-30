fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val mt = MTFactory("C:\\Users\\dougl\\IdeaProjects\\maquina-de-turing\\src\\main\\kotlin\\mt.txt").getMT()

}