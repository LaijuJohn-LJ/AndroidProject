package com.example.mykotlinapp

fun main(args: Array<String>) {
    var Listarrayof = arrayListOf<Any>("kotlin",2,2.5,true,"kotlin")
    println(Listarrayof.size)
    println(Listarrayof.last())
//setrof using avoid same values
    var setarray = setOf<Any>("kotlin",2,2.5,true,"kotlin")
    println(setarray.size)
    println(setarray.last())
}