package com.app.todo.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.todo.Domain.Repositories.SellItemUseCase.SellItemUseCase
import com.app.todo.Models.Response.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SellItemViewModel @Inject constructor(private val itemUseCase: SellItemUseCase) :
    ViewModel() {

    private var _sellItems: MutableLiveData<List<Item>> = MutableLiveData()
    val sellItems: LiveData<List<Item>> get() = _sellItems


    init {
        getAllSellItems()
    }

     fun getAllSellItems() {
        viewModelScope.launch {
            _sellItems.postValue(itemUseCase.getItems.invoke().value)

        }
    }

     fun addSellItem(item: Item) {
        viewModelScope.launch {
            itemUseCase.addItem.invoke(item)
        }
    }

     fun updateSellItem(item: Item) {
        viewModelScope.launch {
            itemUseCase.removeItem.invoke(item)
        }
    }

     fun removeSellItem(item: Item) {
        viewModelScope.launch {
            itemUseCase.removeItem.invoke(item)
        }
    }

}