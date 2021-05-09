package com.example.mycompose.sealed

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.mycompose.models.TestViewModel


class TestSealedClass {

    @Composable
    fun DoTest(navController: NavController, testViewModel: TestViewModel){


        Text("Testing Sealed Classes in Kotlin")

        val foo = 1

        var y: Int = execute(foo,Operation.Add(1))
        println("Add $y")
        y = execute(foo,Operation.Subtract(1))
        println("Subtract $y")
        y = execute(foo,Operation.Multiply(1))
        println("Multiply $y")
        y = execute(foo,Operation.Divide(1))
        println("Divide $y")

        var bruins = Team("","", "")
        makeTeam("Boston Bruins", NHL.Team, bruins)
        makeTeam("Atlantic", NHL.Division, bruins)
        makeTeam("Eastern", NHL.Conference, bruins)
        makeTeam("foo", NHL.Foo, bruins)
        println(bruins.toString())

        var leafs = Team("","", "")
        makeTeam("Toronto Maple Leafs", NHL.Team, leafs)
        makeTeam("Atlantic", NHL.Division, leafs)
        makeTeam("Eastern", NHL.Conference, leafs)
        makeTeam("bar", NHL.Bar, leafs)
        println(leafs.toString())

    }

    private fun execute(x: Int, op: Operation) = when (op) {
        is Operation.Add -> x + op.value
        is Operation.Subtract -> x - op.value
        is Operation.Multiply -> x * op.value
        is Operation.Divide -> x / op.value
    }

    private fun makeTeam(arg: String, op: NHL, team:Team) = when (op) {
        is NHL.Team -> {
            team.team = arg
        }
        is NHL.Division -> {
            team.division = arg
        }
        is NHL.Conference -> {
            team.conference = arg
        }
        is NHL.Foo -> {
            op.doFoo(arg)
        }
        is NHL.Bar -> {
            op.doBar(arg)
        }
    }
}

data class Team(var team: String = "", var division: String = "", var conference: String = "")

sealed class Operation {
    class Add(val value: Int) : Operation()
    class Subtract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
}

//restricted class hierarchy
sealed class NHL{
    object Team : NHL()
    object Division : NHL()
    object Conference : NHL()
    object Foo : NHL() {
        fun doFoo(arg: String) {
            println("arg $arg")
        }
    }
    object Bar : NHL() {
        fun doBar(arg: String) {
            println("arg $arg")
        }
    }
}