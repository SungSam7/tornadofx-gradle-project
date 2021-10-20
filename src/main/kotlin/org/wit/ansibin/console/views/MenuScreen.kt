package org.wit.ansibin.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.ansibin.console.controllers.AnSibinUIController
import tornadofx.*

class MenuScreen : View("An Sibin Main Menu") {

    val ansibinUIController: AnSibinUIController by inject()


    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Placemark") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        ansibinUIController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List Placemarks") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        ansibinUIController.loadListScreen()
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