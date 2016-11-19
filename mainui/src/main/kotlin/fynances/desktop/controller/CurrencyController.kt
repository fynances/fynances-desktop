package fynances.desktop.controller

import fynances.desktop.model.Currency
import fynances.desktop.model.CurrencyViewModel
import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import tornadofx.Controller
import java.util.*

class CurrencyController : Controller() {
    private val storage : MutableMap<String, Currency> = HashMap()
    private val observableList : ObservableList<Currency> = FXCollections.observableArrayList()

    val selectedCurrency = CurrencyViewModel()

    init {
        observableList.addListener(ListChangeListener<Currency> {
            while (it.next()) {
                if (it.wasAdded()) {
                    it.addedSubList.map { storage.put(it.id, it) }
                } else if (it.wasRemoved()) {
                    it.removed.map { storage.remove(it.id) }
                }
            }
        })
    }

    fun save(currencyViewModel: CurrencyViewModel) {
        val newCurrency : Currency = Currency(currencyViewModel.id.value, currencyViewModel.name.value)
        if (currencyViewModel.item != null) {
            delete(currencyViewModel.item)
        }
        add(newCurrency)
    }

    fun add(currency : Currency) {
        if (currency.id.isEmpty()) {
            throw IllegalArgumentException("Currency with empty id!")
        }
        observableList.add(currency)
    }

    fun delete(currencyViewModel: CurrencyViewModel) {
        if (currencyViewModel.item != null) {
            delete(currencyViewModel.item)
        }
    }

    private fun delete(currency : Currency) {
        observableList.remove(currency)
    }

    fun list() : ObservableList<Currency> {
        return observableList
    }
}
