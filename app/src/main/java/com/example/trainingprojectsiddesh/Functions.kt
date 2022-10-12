package com.example.trainingprojectsiddesh

import java.util.*

fun main(){
    myFunction()
    myFunction()
    println()
    val result = addUp(10,10)
    println("Result $result")

    println( "is result ${addUp(5, 3)}")

    println("Average Val = ${averageVal(6.0,4.0)}")
    val avg = averageVal(6.0,4.0)
    println("$avg")

    var name : String = "Denis"

    var nullableName : String? = "Denis"
    nullableName = null

    println("${name.length} ")



    if(nullableName!= null){
        var len2 = nullableName.length
    }else{
        null
    }
    // OR
    var len21 = nullableName?.length
    println("${nullableName?.length}")

//    println(nullableName?.toLowerCase())


    var nullable2 : String? = "SiddesH"
//    nullable2 = null

    println("${nullable2?.lowercase(Locale.getDefault())}")

//    nullableName?.Let { println(it.length) }

    var name2 : String = "Denis"


    // ?: Elvis Operator
    val name3 = nullable2 ?: "Guest"
    println(name3)

    var nullable3 : String? = "SiddesH"
//    nullable3 = null

    val name4 = nullable3 ?: "Guest"
    println(name4)

    println(nullable3!!.lowercase())

    myFunction(10)

}

// Parameter (
fun addUp(a: Int, b: Int) : Int{
    return a+b

}

fun averageVal(a:Double, b: Double) : Double{
    return (a+b)/2
}

fun myFunction(a: Int = 4){
    print("Called from myFunction")
    println("A = $a")
    var a = a
    println("$a")
    println("${++a}")


}
