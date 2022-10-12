package com.example.trainingprojectsiddesh

fun main(){
    var myNum =5
    myNum +=3
    myNum *=4


    myNum++


    myNum--

    println("Current Num is $myNum")

    println("My Num is ${myNum++}")

    println("My Num is ${++myNum}")

    println("My Num is ${myNum--}")

    println("My Num is ${--myNum}")

    var heightPerson1 = 170
    var heightPerson2 = 170

    if(heightPerson1 > heightPerson2) {
        println("Use raw force")

    }else if (heightPerson1 == heightPerson2){
        println("Use your power technique 1337")


    } else{
        println("Use Technique")
    }

    println()
    val age= 31
    if(age >=21){
        println("Now you may drink in the US")
    }else if(age >=18){
        println("You may vote now")
    }else if(age >=16){
        println("You may drive now")
    }else{
        println("You are two young")
    }


//    if(age >=32)
//        println("You are above 30")
//        println("You are above 30")

    println()

    var name = "Denis"

    if(name == "Denis"){
        println("Welcome home Denis")
    }else{
        println("Who are you?")
    }

    val isRainy = true
    if(isRainy){
        println("It's Rainy")
    }

    println()
    var season = 3
    when(season){
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autum")
        }

        4 -> println("Winter")

        else -> println("Invalid Season")
    }
    println()

    var month = 10
    when(month){
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        else -> println("Invalid Season")
    }

    println()
    var age2 = 35

    when(age2){
        in 1..10 -> println("Age less then 10")
        in 11..20 -> println("Age less then 20")
        in 21..30 -> println("Age less then 30")
        31, 32, 33 -> println("Live your dream")
        else -> {
            println("Go bold")
        }
    }

    println()
    when(age2){
        !in 0..20 -> println("You may drink in us")
        in 18..20 -> println("You may vote now")
        16, 17 -> println("You are too young")
        else -> println("Your are too young")
    }

    println()

//    var x : Any = 13.45
    var x : Any = 13.45F
//    var x : Any = "13.45"
    when(x){
        is Int -> println("$x is an Int")
        is Double -> println("$x is a Double")
        is String -> println("$x is a String")
        is Float -> println("$x is a Float")
        else -> println("$x is none of the above")
    }

    println()
    var count = 0

    while(count<= 10){
        count +=1
        print("$count ")
    }

    println()
    println()
    var count_inv = 10
    var piramid = 0
    var run_count=0

    while(count_inv<=111){

        if(run_count<=piramid){
            print("$count_inv ")
            run_count++
        }
        else{
            piramid++
            print("\n$count_inv ")
            run_count = 1
        }


        count_inv++

    }

    println()
    println()
    var x1 =1
    do{
        println("$x1")
        x1++
    }while (x1<=10)

    var feltTemp = "Cold"
    var roomTemp = 10
    while(feltTemp=="Cold"){
        roomTemp++
        print("$roomTemp ")
        if(roomTemp >=20){
            feltTemp = "Comfy"
            println("Its Comfy Now")
        }
    }

    println()
    println()

    for(num in 1..10){
        println("$num")
    }

    println()
    for(i in 1 until 10){
        print("$i ")
    }

    println()
    for(i in 10 downTo 1){
        print("$i ")
    }

    println()
    for(i in 10 downTo 1 step 2){
        print("$i ")
    }


    println()
    println()

    for(i in 0..10000){
        if(i==9001){
            println("ITS OVER 9000")
        }
    }


    println()
    println()

    var humidity = "humid"
    var humidityLevel = 80


    while (humidity=="humid"){
        if(humidityLevel<60){
            println("It's Comfy Now")
            humidity="comfy"
        }
        humidityLevel -=5
    }

    println()
    println()
    for(i in 1 until 20){

        if(i/2 == 5){
            break
        }
        print("$i ")
    }
    print("Done with the loop")

    println()
    println()
    for(i in 1 until 20){

        if(i/2 == 5){
            continue
        }
        print("$i ")
    }
    print("Done with the loop")





}