package com.example.mycompose.destructuring

class TestDestructuring {

    /**
     * A destructuring declaration creates multiple variables at once. You have declared two new
     * variables: name and age, and can use them independently:
     */

    fun doTest(){

        val (namez, agez, jipz) = User("name", 22, foo = "z",55, jip = 5.0)

        println("destructuring declaration:")
        println("namez = [$namez]")
        println("agez = [$agez]")
        println("jipz = [$jipz]")

        val people: List<Person> = listOf(Person("Fred", 32), Person("Leighton", 43),Person("Igor", 21))
            for((name, age) in people) {
                println("Name: $name age: $age")
            }
    }







}


data class Person(var name: String, var age: Int)

data class User(val name: String, val age: Int, val foo:String?=null, val bar:Int?=null, val kop:Float?=null, val jip:Double?)

