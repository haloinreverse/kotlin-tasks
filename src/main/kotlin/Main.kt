fun main(){
    println("Enter your command")
    var line:String? = readlnOrNull()
    val manager:Manager = Manager()
    while (!line.equals("/end")){
        when (line){
            "/start" -> println("Program starts working")
            "/help" -> {
                for (str in Command.values()){
                    println(str.command)
                }
            }
            "/park" -> {
                println("Enter car's brand and model")
                val brand = readln()
                println("Enter car's color")
                val color = readln()
                println("Enter car's number")
                val number = readln()
                println("Enter owner's (your) name")
                val ownerName = readln()
                manager.parkCar(Car(brand, color, number, Owner(ownerName)))
            }
            "/return" ->{
                println("Enter car's number")
                val number = readln()
                println("Enter owner's (your) name")
                val ownerName = readln()
                manager.returnCar(ownerName, number)
            }
            "/park_info_by_car" ->{
                println("Enter car's number")
                val number = readln()
                manager.findCarByNumber(number)
            }
            "/park_info_by_place" ->{
                println("Enter parking place's number")
                val place = readln().toInt()
                manager.findCarByParkingPlace(place)
            }
            "/park_stats" -> {
                manager.provideCurrentCapacity()
            }
            "/park_all_stats" -> {
                manager.provideAllStats()
            }
            else ->{
                println("No such command exists! Try \"/help\"")
            }
        }
        line = readlnOrNull()

    }
    println("Bye-bye!")

}