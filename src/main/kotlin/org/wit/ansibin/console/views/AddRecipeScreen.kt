package org.wit.ansibin.console.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.ansibin.console.controllers.AnSibinUIController
import tornadofx.*

class AddRecipeScreen : View("Add Recipe") {
    val model = ViewModel()
    val _title = model.bind { SimpleStringProperty() }
    val _description = model.bind { SimpleStringProperty() }
    val anSibinUIController: AnSibinUIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Title") {
                textfield(_title).required()
            }
            field("Description") {
                textarea(_description).required()
            }
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        anSibinUIController.add(_title.toString(),_description.toString())

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        anSibinUIController.closeAdd()
                    }
                }
            }
        }
    }

    override fun onDock() {
        _title.value = ""
        _description.value = ""
        model.clearDecorators()
    }
}