package org.wit.ansibin.console.views
import java.util.Scanner



import java.util.*

class RecipeView {

    fun menu() : Int{ // taking in the int from the AnSibinController

        var option : Int
        var input : String?

        // val reader = Scanner(System.`in`) //tried using java's way, got lost
        println("Welcome to An Síbín Supper Club,")
        println("Please select from the menu below: ")
        println()
        println("1 ---- View our Available dates")
        println("2 ---- What you will expect to cook while you are attending")
        println("3 ---- Where are we located")
        println("4 ---- See our recommended recipes using a choice of your proteins")
        println("-1 ---- To quit")
        print("Please select from 1-4: ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option



//      val select: Int = try{ reader.nextInt()} catch(e) {}

    }


}