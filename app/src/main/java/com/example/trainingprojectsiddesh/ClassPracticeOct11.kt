package com.example.trainingprojectsiddesh


data class User(val id:Long, val name: String)


fun main(){
    var denis = Person("Denis", "Panjuta")
    println()
    var john = Person()
    var johnPeterson =Person(lastName = "Peterson")

    println()
    var samsung = MobilePhone(osName = "IOS", brand = "Sumsung", "Galazy S20")
    println()
    var galaxyS20 = MobilePhone("Android", "Samsung", "Galaxy s20")
    println()
    val mateXS = MobilePhone("Android", "Huawei", "Mate X S")
    println()


    var denis1 = Person("Denis", "Panjuta")
    denis1.hobby = "to Skateboard"
    denis1.StateHobby()


    john.hobby = "Play Video Games"
    john.StateHobby()
    john.age = 10
    println("${john.age}")

    println()
    println()

    var denis2 = Person("Denis", "Panjuta", 34)
    denis2.hobby = "New Hobby"
    denis2.StateHobby()
    println(denis2.age)
    denis2.age =20
    println(denis2.age)
    println(denis2)

    println()
    println()

    var myCar = Car()
    println(myCar.owner)

    println("Brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 200
//    myCar.maxSpeed = -5
    println("MaxSpeed is ${myCar.maxSpeed}")
    println( myCar.myModel)




}

class Person(firstName: String = "John", lastName: String = "Doe"){

    var age : Int? =null
    var hobby : String = "Watch Netflix"

    var firstName : String? = null
    var lastName : String?= null
    var fn : String? = null



    init{
        this.firstName = firstName
        println("Person Created")
        println("FirstName = $firstName and LastName = $lastName")
        this.firstName = "Siddesh"
        println("FirstName = ${this.firstName} and LastName = $lastName")
        fn = firstName
        println(fn)

    }

    // Member Functions - Methods
    fun StateHobby(){
        println("My Hobby is $hobby")
        println("$firstName \'s Hobby is $hobby")
    }

    // member secondary constructor
    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName){
        this.age = age
        println("Your new data $firstName and $lastName and $age")
    }

}


class MobilePhone(osName: String="Undefined", brand: String = "Undefined", model :  String = "Undefined"){
    init {
        println("Object Created")
        println("$osName, $brand, $model")
    }
}

class Car(){
    lateinit var owner : String

    val myBrand : String = "BMW"
        get(){
            return field.lowercase()
        }

    var maxSpeed : Int = 250
        set(value){
            field= if(value>0) value else throw IllegalArgumentException("Max speed cant be less the zero")
        }

    var myModel : String = "M5"
        private set


    init {
        this.owner = "Frank"
        this.myModel = "M3"
    }

}

