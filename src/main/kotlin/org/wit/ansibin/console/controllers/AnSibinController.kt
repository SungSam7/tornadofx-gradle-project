package org.wit.ansibin.console.controllers

import mu.KotlinLogging
import org.wit.ansibin.console.models.RecipeJSONStore
import org.wit.ansibin.console.models.RecipeModel
import org.wit.ansibin.console.views.RecipeView
import org.wit.ansibin.console.models.Recommended
import org.wit.ansibin.console.models.Dates
import org.wit.ansibin.console.models.AnSibinLocation

class AnSibinController {

    // val recipes = PlacemarkMemStore()
    val recomended = Recommended()
    val recipes = RecipeJSONStore()
    val dates = Dates()
    val recipeView = RecipeView()
    val ansibinLocation = AnSibinLocation()
    val logger = KotlinLogging.logger {}
    var input: String = ""

    init {
        logger.info { "Preparing to Launch An-Sibin App" }
        logger.info { "Launch Successful" }
        println("Recipes Kotlin App Version 6.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                6 -> searchRecommended()
                7 -> returnDates()
                8 -> location()

                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down An Sibin  App" }
    }

    fun menu() :Int { return recipeView.menu() }

    fun add(){
        var aRecipe = RecipeModel()

        if (recipeView.addRecipeData(aRecipe))
            recipes.create(aRecipe)
        else
            logger.info("Placemark Not Added")
    }

    fun list() {
        recipeView.listRecipes(recipes)
    }

    fun update() {

        recipeView.listRecipes(recipes)
        var searchId = recipeView.getId()
        val aRecipe = search(searchId)

        if(aRecipe != null) {
            if(recipeView.updateRecipeData(aRecipe)) {
                recipes.update(aRecipe)
                recipeView.showRecipe(aRecipe)
                logger.info("Recipe Updated : [ $aRecipe ]")
            }
            else
                logger.info("Recipe Not Updated")
        }
        else
            println("Recipe Not Updated...")
    }

    fun delete() {
        recipeView.listRecipes(recipes)
        var searchId = recipeView.getId()
        val aRecipe = search(searchId)

        if(aRecipe != null) {
            recipes.delete(aRecipe)
            println("Placemark Deleted...")
            recipeView.listRecipes(recipes)
        }
        else
            println("Placemark Not Deleted...")
    }

    fun search() {
        val aRecipe = search(recipeView.getId())!!
        recipeView.showRecipe(aRecipe)
    }


    fun search(id: Long) : RecipeModel? {
        var foundRecipe = recipes.findOne(id)
        return foundRecipe
    }

   fun searchRecommended(){
    var protein: String  = ""
       var exit: String = ""

       while (exit!="q") {
           print("Enter a protein you would like to search: ")
           protein = readLine()!!.toLowerCase()
           recomended.recommended(protein)

           print("Press any key to search another protein recipe or 'q' to quit: ")
           exit = readLine()!!.toLowerCase()
       }
   }

    fun location()
    {

        ansibinLocation.location()
        println()
        print("Press Enter to return to main menu: ")
        input = readLine()!!
    }

    fun returnDates()
    {

        dates.returnDates()
        print("Press Enter to return to main menu: ")
        input = readLine()!!
    }

}