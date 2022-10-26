package com.example.myapplication

fun main(){

    val diceRange = 1..6
    val diceRange1:IntRange = 1..6

    val randomNumber =  diceRange.random()

    println("Random number: ${randomNumber}")

    val myFirstDice = Dice()
    println(myFirstDice.sides)

    myFirstDice.roll()

    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")

    println()
    myFirstDice.sides = 20
    println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")

    println()
    val myFirstDice2 = Dice2(12)
    val diceRoll2 = myFirstDice2.roll()
    println("Your ${myFirstDice2.numSides} sided dice rolled ${diceRoll2}!")


    println()
    val secondDice = Dice2(20)
    println("Dice Sides ${secondDice.numSides} and Dice Rolled ${secondDice.roll()}")


    println()
    val myThirdDice = Dice3(numSides = 20)
    println("Dice Sides ${myThirdDice.numSides} & Random Number Generated: ${myThirdDice.roll()}")


    println()
    val practiceDice1 = practiceDice(numSides = 10, color = "Red")
    println("Rolled Dice Val ${practiceDice1.roll()} and ${practiceDice1.description()}")

    println()
    val coinFlip = coin()
    println("Coin Flip Value is ${coinFlip.flip()}")

}

class Dice{
    var sides =6

    fun roll(): Int{
//        val randomNumber = (1..6).random()
        val randomNumber = (1..sides).random()

        println(randomNumber)

        return randomNumber
    }

}

class Dice2(val numSides: Int){
    fun roll() : Int{
        val randomNumber = (1..numSides).random()
        return randomNumber
    }


}

class Dice3(val numSides: Int) {
    fun roll(): Int{
        return (1..numSides).random()
    }
}


// Challenge Things

class practiceDice(val numSides:Int, val color:String){
    fun roll() :Int{
        return (1..numSides).random()
    }

    fun description(): String{
        return "Number of Sides ${numSides} and Color of the dice ${color}"
    }
}

class coin {
    fun flip(): String{
        val resultIntVal = (0..1).random()

//        return if (resultIntVal ==0){
//            "Tails"
//        }else{
//            "Heads"
//        }

        if (resultIntVal ==0){
            return "Tails"
        }else{
            return "Heads"
        }


    }
}