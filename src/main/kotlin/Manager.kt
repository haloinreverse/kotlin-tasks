class Manager {
    private class Parking(){
        val nullCar = Car("", "", "", Owner(""))
        val DEFAULT_CAPACITY = 10
        var carsOnParking = 0
        var capacity = DEFAULT_CAPACITY
        var parkingPlaces = mutableMapOf<Int, Car>()
        var total = 0
        init{
            for (i in 0..capacity){
                parkingPlaces[i] = nullCar
            }
        }

        fun findFreePlace():Int{
            for (i in 0..capacity){
                if (parkingPlaces[i] == nullCar){
                    return i
                }
            }
            return -1
        }

        fun findCarByNumber(number: String):Pair<Car?, Int>{
            for (i in 0..capacity){
                if (parkingPlaces[i]?.number == number){
                    return Pair<Car?, Int>(parkingPlaces[i], i)
                }
            }
            return Pair<Car?, Int>(null, 0)
        }
    }

    private var parking = Parking()
    fun parkCar(car:Car){
        if (parking.carsOnParking == parking.capacity){
            println("There are no free parking places!")
        }
        else {
            val currentPlace = parking.findFreePlace()
            parking.parkingPlaces[currentPlace] = car
            println("Car was successfully parked! Number of the place is $currentPlace")
            parking.carsOnParking++
            parking.total++
        }
    }
    fun returnCar(ownerName: String, carNumber: String){
        var (car, parkingPlace) = parking.findCarByNumber(carNumber)
        if (car == null){
            println("There is no car with this number on the parking")
        }
        else if (car.owner.name != ownerName){
            println("This car isn't yours!")
        }
        else{
            parking.parkingPlaces[parkingPlace] = parking.nullCar
            parking.carsOnParking--
            println("Car was returned to it's owner")
        }
    }
    fun findCarByNumber(carNumber: String){
        var (car, parkingPlace) = parking.findCarByNumber(carNumber)
        if (car == null){
            println("There is no car with this number on the parking")
        }
        else {
            println("Car with number $carNumber is parked on place $parkingPlace")
        }
    }

    fun findCarByParkingPlace(placeNumber: Int){
        val car = parking.parkingPlaces[placeNumber]
        if (placeNumber > parking.capacity){
            println("There is no such place")
        }
        else if (car == parking.nullCar){
            println("There is no car on this place")
        }
        else{
            if (car != null) {
                println("This place is taken by car with number ${car.number} ")
            }
        }
    }

    fun provideCurrentCapacity(){
        for (i in 1..parking.capacity){
            var car = parking.parkingPlaces[i]
            if (car == parking.nullCar){
                println("Place $i - free")
            }
            else println("Place $i - ${car?.brand} ${car?.number} ${car?.number} ${car?.owner?.name}")
        }
    }

    fun provideAllStats(){
        println("${parking.total} cars were parked in total")
    }

}