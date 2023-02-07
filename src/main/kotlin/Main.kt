fun main(){
    when (readlnOrNull()){
        "/start" -> {println("Program started working")}
        "/end" -> {println("Program ended working")}
        "/help" -> {println("List of commands: \"/start\" - program starts working, \"end\" - program ends working")}
        else -> println("This command doesn't exist. Type \"/help\" to get the list of commands")
    }
}