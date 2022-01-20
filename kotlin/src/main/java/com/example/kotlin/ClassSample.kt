package com.example.kotlin

fun main(){
    val car=Car("","")
    car.drive()
    println("Hiii ".append("Ahmad"))

}

class Truck(color: String, model: String) : Car(color, model){
    override fun drive() {
        super.drive()
    }
}

open class Car(val color:String, var model:String){
    init {
        //color="Green"
        model="Benz "
    }
    open fun drive(){
        println("Drive vroom")
    }
}

class Button(val lable:String):ClickEvent{
    override fun onClick(message: String) {
        TODO("Not yet implemented")
    }
}

interface ClickEvent{
    fun onClick(message:String)
}

fun String.append(toAppend: String):String{
    return this.plus(toAppend)
}