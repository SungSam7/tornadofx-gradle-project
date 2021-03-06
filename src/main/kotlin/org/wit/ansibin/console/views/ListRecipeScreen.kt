package org.wit.ansibin.console.views


import org.wit.ansibin.console.controllers.AnSibinUIController
import org.wit.ansibin.console.models.RecipeModel
import tornadofx.*

class ListRecipeScreen : View("List Recipes") {


    val anSibinUIController: AnSibinUIController by inject()
    val tableContent = anSibinUIController.recipes.findAll()
    val data = tableContent.observable()


    override val root = vbox {

        setPrefSize(600.0, 200.0)
        tableview(data) {
            column("ID", RecipeModel::id)
            column("Title", RecipeModel::title)
            readonlyColumn("Cuisine", RecipeModel::description)
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    anSibinUIController.closeList()
                }
            }
        }
    }

}