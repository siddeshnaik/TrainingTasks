package com.example.trainingprojectsiddesh

var lambda1 = {println("Siddesh Practice") }
fun higherFuncPrint( lmbd: () -> Unit ) {
    lmbd()
}


var lambda2 = {a: Int, b:Int -> a+b }
fun higherFuncAdd(lmbd: (Int, Int) -> Int){
    var result = lmbd(2,4)
    println(result)
}


fun printNewString(passedString :String) : Unit {
    println("The passed String is $passedString")
}

fun higherOrderPrintFunc(StringPassed : String, myfunc : (String)-> Unit){
    myfunc(StringPassed)
}




fun main() {

    higherFuncPrint(lambda1)
    higherFuncAdd(lambda2)
    higherOrderPrintFunc("Siddesh Naik", ::printNewString)

}


