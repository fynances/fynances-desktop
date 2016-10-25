package fynances.desktop

import fynances.core.Example
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*

class MyApp: App() {
    override val primaryView = MyView::class
}

class MyView: View() {
    override val root = VBox()
    init {
        root += Button("Press Me")
        root += Label(Example().data)
    }
}
