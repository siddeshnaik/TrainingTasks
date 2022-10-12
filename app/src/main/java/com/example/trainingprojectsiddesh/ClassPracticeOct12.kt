package com.example.trainingprojectsiddesh

data class UserClass(val id: Long, var name: String)


// coding challenge in udemy

class MobilePhoneUser(osName : String, brand : String, model : String){
    private var battery = 30

    init {
        println("The phone $model from $brand uses $osName as its operating System")
    }

    fun chargeBattery(chargedBy : Int){
        println("Battery was at $battery and is at ${battery+chargedBy} now" )
        battery+=chargedBy
    }
}

fun main(){
    val user1 = UserClass(1, "Denis")

    val name = user1.name
    println(name)
    user1.name = "Michael"
    val user2 = UserClass(1, "Michael")


    println(user1.equals(user2))
    println(user1==user2)

    println()
    println("User Details: $user1") //toString method is present inbuilt

    println()
    val updatedUser = user1.copy()
    println(updatedUser)
    println("updatedUser: $updatedUser")
    // Or
    println()
    val updatedUser2 = user1.copy(name="Denis Panjuta")
    println("updatedUser2: $updatedUser2")

    println()
    println(updatedUser.component1()) //print 1
    println(updatedUser.component2()) //print name var


    println()
    val (id, name1) = updatedUser
    // Other way is
    val name2 = updatedUser2.name
    val id2 = updatedUser2.id

    println("Id=$id2, name2: $name2")
    println()

    //coding Challenge Udemy
    val iphone = MobilePhoneUser("iOS", "Apple", "Iphone 12")
    val galaxy =MobilePhoneUser("Android", "Samsung", "Galaxy S20")
    val mateXS = MobilePhoneUser("Android", "Huawei", "Mate X S")

//    println(iphone)
    println(iphone.chargeBattery(20))
    println(galaxy.chargeBattery(30))

    println()
    val mainclasstest1 = Car2("SUV 700", "Mahindra") //main class


    println()
    val electricCartest2 = ElectricCar2("I10", "Nissan", 20.00)  //inhertied class

    println()
    mainclasstest1.drive(200.00)
    electricCartest2.drive(250.00)

    println()
    mainclasstest1.extendRange(10.0)
    mainclasstest1.extendRange(5.0)

    println()
    electricCartest2.extendRange(15.0)
    electricCartest2.extendRange(20.0)

    println()
    electricCartest2.drive(20.0)
    electricCartest2.drive()

    println()
    electricCartest2.chargerType = "Type2"

}


// Inheritance

// Super Class, Parent Class, Base Class
open class Vehicle{
    // properties
    // methods
}

// Sub Class Child Class or Derived Class
// Super Class, parent class of Electiric car
// sealed class Car1 : Vehicle()
open class Car1 : Vehicle(){

}

class ElectricCar : Car1(){

}

// parent class
open class Car2(val name: String, val brand: String){
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

    open fun drive(distance : Double){
        println("Drove for $distance KM")
    }


}

class ElectricCar2(name: String, brand: String, batteryLife: Double) : Car2(name, brand){

    init {
        println("Inherited Class running")
    }

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        super.drive(distance)
        println("Drove for $distance KM on Electricity")
    }

    fun drive(){
        println("Range: $range")
    }


}
