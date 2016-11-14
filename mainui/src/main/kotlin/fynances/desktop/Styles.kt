package fynances.desktop

import javafx.geometry.Pos
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px


class Styles : Stylesheet() {
    companion object {
        val mainView by cssclass()
        val accountsView by cssclass()
        val currenciesView by cssclass()
    }
    init {
        select(mainView) {
            padding = box(20.px)
            alignment = Pos.CENTER
            minWidth = 250.px
            spacing = 10.px
        }
        select(accountsView, currenciesView) {
            minWidth = 250.px
            minHeight = 250.px
        }
    }
}