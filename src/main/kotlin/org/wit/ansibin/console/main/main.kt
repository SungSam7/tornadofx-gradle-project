package org.wit.ansibin.console.main


import org.wit.ansibin.console.controllers.AnSibinController
import org.wit.ansibin.console.models.RecipeModel
import org.wit.ansibin.console.views.RecipeView

var ansibin = RecipeModel() // introducing a property called ansibin

val ansibinView = RecipeView()


fun main(args: Array<String>) {


    AnSibinController().menu()

}

