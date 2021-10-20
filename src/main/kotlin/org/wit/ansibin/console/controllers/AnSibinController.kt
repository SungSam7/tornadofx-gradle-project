package org.wit.ansibin.console.controllers


    import org.wit.ansibin.console.models.AnSibinLocation //need this to access the class
    import org.wit.ansibin.console.models.Recommended
    import org.wit.ansibin.console.models.Dates
    import java.util.*


    class AnSibinController {
//val location: String? = "An Síbín, Lisnagaul, Bansha, Co.Tipperary, Eircode: E34 Y656" //moved into its own class


        val ansibinlocation = AnSibinLocation() // need this to access the methods or variables in side the class
        val recommended = Recommended()
        val dates = Dates()
        fun menu() {
            var select: Int

            do {
                select = org.wit.ansibin.console.main.ansibinView.menu()
                when (select) {

                    1 -> availableDates()
                    2 -> recipes()
                    3 -> located()
                    4 -> recommended()
                    -1 -> println("Exiting App")
                    else -> println("Invalid Option")
                }
                println()
            } while (select != -1)
            println("Shutting down app")
        }


        fun availableDates() {

            dates.returnDates()
            //dummydata()

        }

        fun recipes() {


        }

        fun located() {

            println(ansibinlocation.location)
            println()
            println(ansibinlocation.location())
        }

        fun recommended() {
            var input: String = ""

            while (input != "q") {


                var protein: String?

                print("Enter a choice of protein to see our recommended recipes:  ")

                protein = readLine()!!.toLowerCase()

                recommended.recommended(protein)

                print("Press any key to search another protein recipe or 'q' to quit: ")
                input = readLine()!!.toLowerCase()


            }


        }

    }
