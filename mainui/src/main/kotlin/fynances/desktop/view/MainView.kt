package fynances.desktop.view

import fynances.desktop.Styles.Companion.mainView
import tornadofx.*

class MainView: View("Fynances") {
    override val root = vbox {
        addClass(mainView)
        button("Accounts") {
            setOnAction {
                find(AccountsView::class).openModal()
            }
        }
        button("Currencies") {
            setOnAction {
                find(CurrenciesView::class).openModal()
            }
        }
    }
}
