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



}

class Dice{
    var sides =6

    fun roll(): Int{
        val randomNumber = (1..6).random()
        println(randomNumber)

        return randomNumber
    }

}