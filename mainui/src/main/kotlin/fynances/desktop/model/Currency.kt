package fynances.desktop.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

data class Currency(val id: String, val name: String)

class CurrencyViewModel : ItemViewModel<Currency>() {
    val id = bind { SimpleStringProperty(item?.id ?: "") }
    val name = bind { SimpleStringProperty(item?.name ?: "") }
}