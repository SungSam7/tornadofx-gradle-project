package org.wit.ansibin.console.views
//import java.util.Scanner
//
//
//
//import java.util.*
//
//class RecipeView {
//
//    fun menu() : Int{ // taking in the int from the AnSibinController
//
//        var option : Int
//        var input : String?
//
//        // val reader = Scanner(System.`in`) //tried using java's way, got lost
//        println("Welcome to An Síbín Supper Club,")
//        println("Please select from the menu below: ")
//        println()
//        println("1 ---- View our Available dates")
//        println("2 ---- What you will expect to cook while you are attending")
//        println("3 ---- Where are we located")
//        println("4 ---- See our recommended recipes using a choice of your proteins")
//        println("-1 ---- To quit")
//        print("Please select from 1-4: ")
//        input = readLine()!!
//        option = if (input.toIntOrNull() != null && !input.isEmpty())
//            input.toInt()
//        else
//            -9
//        return option
//
//
//
////      val select: Int = try{ reader.nextInt()} catch(e) {}
//
//    }
//
//
//}



import org.wit.ansibin.console.models.RecipeJSONStore
import org.wit.ansibin.console.models.RecipeModel

class RecipeView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Recipe")
        println(" 2. Update Recipe")
        println(" 3. List All Recipes")
        println(" 4. Search Recipes")
        println(" 5. Delete Recipe")
        println(" 6. See our recommended recipes using a choice of your proteins")
        println(" 7. View our Available dates")
        println(" 8. Where you can find us")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listRecipes(recipes : RecipeJSONStore) {
        println("List All Recipes")
        println()
        recipes.logAll()
        println()
    }

    fun showRecipe(recipe : RecipeModel) {
        if(recipe != null)
            println("Recipe Details [ $recipe ]")
        else
            println("Recipe Not Found...")
    }

    fun addRecipeData(recipe : RecipeModel) : Boolean {

        println()
        print("Enter a Title : ")
        recipe.title = readLine()!!
        print("Enter a Cuisine : ")
        recipe.description = readLine()!!

        return recipe.title.isNotEmpty() && recipe.description.isNotEmpty()
    }

    fun updateRecipeData(recipe : RecipeModel) : Boolean {

        var tempTitle: String?
        var tempDescription: String?

        if (recipe != null) {
            print("Enter a new Title for [ " + recipe.title + " ] : ")
            tempTitle = readLine()!!
            print("Enter a new Cuisine for [ " + recipe.description + " ] : ")
            tempDescription = readLine()!!

            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
                recipe.title = tempTitle
                recipe.description = tempDescription
                return true
            }
        }
        return false
        }

        fun getId() : Long {
            var strId : String? // String to hold user input
            var searchId : Long // Long to hold converted id
            print("Enter id to Search/Update/Delete : ")
            strId = readLine()!!
            searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
                strId.toLong()
            else
                -9

            return searchId
        }
    }