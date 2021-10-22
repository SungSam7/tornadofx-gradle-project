package org.wit.ansibin.console.main

import javafx.scene.paint.Color
import tornadofx.*
import tornadofx.Stylesheet.Companion.box
import tornadofx.Stylesheet.Companion.button
import tornadofx.Stylesheet.Companion.label
import javax.swing.text.html.StyleSheet

class Styles : Stylesheet() {
    companion object {
        val leftBox by cssclass()
        val rightBox by cssclass()

        val dangerColor = c("#a94442")
        val hoverColor = c("#d49942")
    }

    init {
        root {
            backgroundColor += Color.DARKBLUE
            button {
                backgroundColor += Color.ANTIQUEWHITE


                and(hover) {
                    backgroundColor += hoverColor
                }
            }
        }
    }
}