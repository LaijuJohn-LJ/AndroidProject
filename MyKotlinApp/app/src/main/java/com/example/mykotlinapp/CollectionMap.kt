package com.example.mykotlinapp

fun main(args: Array<String>) {
    println("------------------------immutable------------------")
    var MapAge = mapOf<String,Int>("David" to 20,"Alex" to 25)
    println("David age is :" + MapAge["David"])
    println("Alex age is :" + MapAge["Alex"])

    println("------------------------mutable------------------")


    var MutableMapAge = mutableMapOf<String,Int>("David" to 20,"Alex" to 25)
    MutableMapAge.put("Buffon",18)
    println("David age is :" + MapAge["David"])
    println("Alex age is :" + MapAge["Alex"])
    println("Buffon age is :" + MutableMapAge["Buffon"])

}