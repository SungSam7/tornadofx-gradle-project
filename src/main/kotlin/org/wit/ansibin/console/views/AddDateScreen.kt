package org.wit.ansibin.console.views

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*
import java.time.LocalDate

class AddDateScreen : View("My View") {


        override val root = vbox {
            setPrefSize(600.0, 200.0)
            datepicker {
                value = LocalDate.now()
            }

            button("Choose date") {
                style {
                    textFill = Color.GREEN
                    fontWeight = FontWeight.EXTRA_BOLD
                }
                action {
                    println("Button pressed!")

                }
            }
        }
    }