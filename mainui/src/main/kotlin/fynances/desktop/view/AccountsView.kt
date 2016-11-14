package fynances.desktop.view

import fynances.desktop.Styles
import tornadofx.View
import tornadofx.addClass
import tornadofx.vbox

class AccountsView: View("Accounts") {
    override val root = vbox {
        addClass(Styles.accountsView)
    }
}
