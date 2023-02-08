enum class Command(val command:String) {
    START("/start - starts program"), HELP("/help - prints list of commands"), END("/end - ends work of program"),
    PARK("/park - park a car"), RETURN("/return - return a car to it's owner"), PARK_INFO_BY_CAR("/park_info_by_car - get parking place of a car"),
    PARK_INFO_BY_PLACE("/park_info_by_place - learn about car on parking place"),
}