package fynances.desktop

import fynances.desktop.view.MainView
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus

class FynancesApp: App(MainView::class, Styles::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}
