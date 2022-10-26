package com.example.trainingprojectsiddesh

interface Drivable{
    val maxSpeed : Double
    fun drive() : String
    fun brake(){
        println("The Drivable is braking")
    }

}

open class Car3(override val maxSpeed: Double,
                val name: String, val brand: String): Drivable{
    init {
        println("Main Class running")
    }
    open var range : Double = 0.0

    fun extendRange(amount: Double){
        if(amount>0){
            range += amount
        }
        println("Range of the car is $range")
    }

// Alternate method
//    override fun drive(): String = "Driving the interface drive"

    override fun drive(): String {
        return "Driving the interface drive"
    }



    open fun drive(distance : Double){
        println("Drove for $distance KM")
    }


}

class ElectricCar3(maxSpeed: Double, name: String, brand: String, batteryLife: Double) : Car3(maxSpeed, name, brand){

    init {
        println("Inherited Class running")
    }

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        super.drive(distance)
        println("Drove for $distance KM on Electricity")
    }

    override fun drive(): String{
        return "Drove for $range KM on Electricity"
    }

    override fun brake() {
        super.brake()
        println("Brake Inside of the electric car")
    }


}

fun main(){

    var audiA3 = Car3(200.0, "A3", "Audi")
    var teslaS = ElectricCar3(240.0, "S-Model", "Tesla", 30.0)

    teslaS.chargerType = "Type2"
    teslaS.extendRange(200.0)

    println()
    teslaS.drive()

    println()
    teslaS.brake()
    audiA3.brake()


    println()
    audiA3.drive(200.0)
    teslaS.drive(250.0)

}

