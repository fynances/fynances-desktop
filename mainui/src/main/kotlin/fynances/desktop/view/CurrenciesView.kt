package fynances.desktop.view

import fynances.desktop.Styles.Companion.currenciesView
import tornadofx.View
import tornadofx.addClass
import tornadofx.vbox

class CurrenciesView: View("Currencies") {
    override val root = vbox {
        addClass(currenciesView)
    }
}

