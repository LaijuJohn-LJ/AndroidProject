package com.example.objectorientedkotlin.override

 class Car:Vehicle()  {

     fun superstart(){
         super.start()
     }
     fun superaccelerate(){
         super.accelerate(340)
     }
     fun superstop(){
         super.stop()
     }
   override fun start(){
        println("car has started")
    }
  override fun accelerate(speed:Int){
        println("Accelerate the car $speed")
    }
  override fun stop(){
        println("car has stop")
    }
}