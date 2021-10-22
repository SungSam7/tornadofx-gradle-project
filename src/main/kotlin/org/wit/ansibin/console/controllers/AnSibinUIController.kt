package org.wit.ansibin.console.controllers

import mu.KotlinLogging
import org.wit.ansibin.console.models.RecipeJSONStore
import org.wit.ansibin.console.models.RecipeModel
//import org.wit.ansibin.console.views.AddDateScreen
import org.wit.ansibin.console.views.AddRecipeScreen
import org.wit.ansibin.console.views.ListRecipeScreen
import org.wit.ansibin.console.views.MenuScreen
import tornadofx.*

class AnSibinUIController : Controller() {

    val recipes = RecipeJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Recipe TornadoFX UI App" }
    }
    fun add(_title : String, _description : String){

        var aRecipe = RecipeModel(title = _title, description = _description)
        recipes.create(aRecipe)
        println("Recipe Added")
    }

    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListRecipeScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        recipes.logAll()
    }

    fun loadAddScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddRecipeScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(AddRecipeScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeList() {
        runLater {
            find(ListRecipeScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadAddDateScreen()
    {
        runLater {
           // find(MenuScreen::class).replaceWith(AddDateScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }


}