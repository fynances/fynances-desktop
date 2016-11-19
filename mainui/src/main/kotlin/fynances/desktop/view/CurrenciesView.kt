package fynances.desktop.view

import fynances.desktop.Styles.Companion.currenciesView
import fynances.desktop.controller.CurrencyController
import fynances.desktop.model.Currency
import fynances.desktop.model.CurrencyViewModel
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import javafx.scene.input.MouseEvent
import javafx.util.Callback
import tornadofx.*

class CurrenciesView : View("Currencies") {

    override val root = hbox {
        addClass(currenciesView)
        this += CurrencyList::class
        this += CurrencyEditor::class
    }
}

class CurrencyList : View() {
    val currencyController: CurrencyController by inject()

    override val root = tableview(currencyController.list()) {
        column("Id", Currency::id)
        column("Name", Currency::name)
        bindSelected(currencyController.selectedCurrency)
        rowFactory = Callback<TableView<Currency>, TableRow<Currency>> {
            buildTableRow(it)
        }
        columnResizePolicy = SmartResize.POLICY
    }

    fun buildTableRow(tableView: TableView<Currency>): TableRow<Currency> {
        val tableRow : TableRow<Currency> = TableRow()
        tableRow.addEventFilter(MouseEvent.MOUSE_PRESSED, {
            val index = tableRow.index
            if (index >= 0 && index < tableView.items.size && tableView.selectionModel.isSelected(index)) {
                tableView.selectionModel.clearSelection()
                it.consume()
            }
        })
        return tableRow
    }
}

class CurrencyEditor : View() {
    val currencyController: CurrencyController by inject()
    val currencyViewModel: CurrencyViewModel = currencyController.selectedCurrency

    override val root = form {
        fieldset("Currency") {
            field("id") {
                textfield(currencyViewModel.id) {
                    required()
                    disableProperty().bind(!currencyViewModel.empty)
                }
            }
            field("name") {
                textfield(currencyViewModel.name) {
                    required()
                }
            }
            button("Save") {
                useMaxWidth = true
                setOnAction {
                    if (currencyViewModel.commit()) {
                        currencyController.save(currencyViewModel)
                    }
                }
            }
            button("Delete") {
                useMaxWidth = true
                setOnAction {
                    currencyController.delete(currencyViewModel)
                }
            }
        }
    }
}

