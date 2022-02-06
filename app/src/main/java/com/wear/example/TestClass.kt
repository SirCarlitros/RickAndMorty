package com.wear.example

class TestClass<in T>( private var ent: T) {

    fun setItem(item: T){
        ent = item
    }


    fun <T> copyData(source: MutableList<T>,
                     destination: MutableList<in T>) {
        for (element in source) {
            destination.add(element)
        }
}
}


open class Animal(){
    fun eat(){}
}

open class Mammal(): Animal(){

    fun makeNoise(){}
}

class Dog(): Mammal(){
    fun bark(){}
}


fun main(){

    val animal = Animal()
    val mammal = Mammal()
    val dog = Dog()

    val xasd : MutableList<out Animal> = mutableListOf(mammal,dog)

    val xasdd : MutableList<in Dog> = mutableListOf(mammal,dog)

    val a = TestClass<Animal>(mammal)

    a.setItem(dog)
}