package org.wit.ansibin.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.ansibin.console.controllers.AnSibinUIController
import org.wit.ansibin.console.main.Styles
import tornadofx.*

class MenuScreen : View("Recipes Main Menu") {

    val anSibinUIController: AnSibinUIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        background{
            addClass(Styles.heading)
        }
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Recipes") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        anSibinUIController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List Recipes") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        anSibinUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }


}