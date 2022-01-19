package com.example.kotlin

fun main(){
    val car=Car("","")
    car.drive()

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

