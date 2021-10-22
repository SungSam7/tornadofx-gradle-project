package org.wit.ansibin.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import javafx.geometry.Pos
import org.wit.ansibin.console.controllers.AnSibinUIController
import org.wit.ansibin.console.main.Styles
import tornadofx.*

class MenuScreen : View("Recipes Main Menu") {

    val anSibinUIController: AnSibinUIController by inject()

    override val root = form {
        setPrefSize(800.0, 400.0)

        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Recipes") {
                style {
                    alignment = Pos.TOP_LEFT
                }
                isDefaultButton = true

                action {
                    runAsyncWithProgress {
                        anSibinUIController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List Recipes") {
                style {
                    alignment = Pos.TOP_RIGHT
                }

                isDefaultButton = true

                action {
                    runAsyncWithProgress {
                        anSibinUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Add Date") {

                isDefaultButton = true

                action {
                    runAsyncWithProgress {
                        anSibinUIController.loadAddDateScreen()
                    }
                }
                text("")
                button("Exit") {


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
}