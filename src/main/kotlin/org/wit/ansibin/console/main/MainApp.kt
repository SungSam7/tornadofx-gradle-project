package org.wit.ansibin.console.main

import org.wit.ansibin.console.views.MenuScreen
import org.wit.ansibin.console.main.Styles
import tornadofx.reloadStylesheetsOnFocus
import tornadofx.App as TornadofxApp


class MainApp: tornadofx.App (MenuScreen::class, Styles::class)
{init {
    reloadStylesheetsOnFocus()
}}