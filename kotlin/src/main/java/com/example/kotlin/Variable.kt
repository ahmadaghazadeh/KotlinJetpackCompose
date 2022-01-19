package com.example.kotlin

fun main(){
    // var - mutable
    // val - immutable

    val name="Ahmad"
    val family:String="Aghazadeh"
    val age:Int=39
    val numberLong=1L

    //print("Hello, my name is $name $family and I'm $age years old.")

    //loop()
    //breakFor()

//    enhancedMassage(message = "Hello there,"){ str->
//        print(str)
//        add(15,15)
//    }

    listSample()


}

fun listSample(){
    val myListOfNames= listOf("Ahmad","Ali","Mohammad","ali")
    val myMutableListOfNames= mutableListOf("Ahmad","Ali","Mohammad")

    myMutableListOfNames.add("Ali 2")

    var xx=myMutableListOfNames[1]
    myListOfNames.forEach{
        println(it)
    }

    for (item in myListOfNames){
        println(item)
    }


    val mySetOfNames= setOf("Ahmad","Ali","Mohammad","Ahmad","Ali","Mohammad")// unique value
    println(mySetOfNames)

    val myMapOfNames= mutableMapOf("Up" to 1,"Down" to 2,"Left" to 3,"Right" to 4)
    println(myMapOfNames.keys)
    println(myMapOfNames.values)
    myMapOfNames.put("Next" , 5)
    myMapOfNames["Next"] = 5
    if("Up" in myMapOfNames) println("Up in map")
    if(4 in myMapOfNames.values) println("4 in map")

    var emptyList= emptyList<String>()

    val startWithA=myListOfNames.filter {
        it.startsWith("A",ignoreCase = true)
    }
    println(startWithA)
}

fun enhancedMassage(message:String,funAsParameter:(String)->Int){
    println("$message ${funAsParameter("Hay")}")
}

private fun breakFor()  {
    for (i in 1 until  20)
    {
        if (i/2==5){
            continue
        }
        print("$i ")
    }
    print("Done with the loop")
}

private fun loop() {
    val amount = 1000
    when (amount) {
        in 1..100 -> print("This amount is between 1 and 100")
        !in 10..90 -> print("This amount is outside the range")
        999 -> print("You have 999")
        1000 -> print("You have 1000")
        else -> print("else")
    }
    for (i in 1..100) {
        print("Index is $i")
    }
}

val add:(Int,Int)->Int={a,b->a+b}

val add1:(Int)->Int={
    it*8
}

fun sum(a:Int,b:Int):Int{
    return a+b
}

