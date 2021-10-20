package org.wit.ansibin.console.models

class Dates {
    fun returnDates()
    {
        println()
        var input : String = "a"

        while (input != "") {
            println("""Our available dates are the following:
            |12th November 2021
            |19th November 2021
            |26th November 2021
            |3rd December 2021
        """.trimMargin())

            print("Press Enter to return to main menu: ")
            input = readLine()!!
        }
    }

}