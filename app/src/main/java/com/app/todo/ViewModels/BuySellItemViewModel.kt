package com.app.todo.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.todo.Domain.Repositories.SellItemUseCase.SellItemUseCase
import com.app.todo.Domain.Repository.Repositories.BuyItemRepository
import com.app.todo.models.Resource
import com.app.todo.models.response.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BuySellItemViewModel @Inject constructor(
    private val itemUseCase: SellItemUseCase,
    private val repository: BuyItemRepository
) :
    ViewModel() {


    private var _buy: MutableLiveData<Resource<List<Item>>> = MutableLiveData()
    val buy: LiveData<Resource<List<Item>>> get() = _buy


    fun addSellItem(item: List<Item>) {
        viewModelScope.launch {
            itemUseCase.addItem.invoke(item)
        }
    }

    suspend fun getSellItems() =

        itemUseCase.getItems.invoke()


    fun removeSellItem() {
        viewModelScope.launch {
            itemUseCase.removeItem.invoke()
        }
    }


    fun getBuyItems() {
        viewModelScope.launch {
            _buy.postValue(Resource.Loading())
            try {
                repository.getAllBuyItems().run {

                    if (this.isSuccessful) {
                        addSellItem(this.body() ?: arrayListOf())
                        _buy.postValue(Resource.Success(this.body() ?: listOf()))
                    } else {
                        _buy.postValue(Resource.Error(this.message().toString()))
                    }
                }
            } catch (e: Exception) {
                _buy.postValue(Resource.Error(e.message ?: "Unknown Error"))

            }
        }
    }

    fun onBuyRefresh() {
        viewModelScope.launch {

            _buy.postValue(Resource.Loading())
            try {
                repository.getAllBuyItems().run {


                    if (this.isSuccessful) {
                        _buy.postValue(Resource.Success(this.body() ?: listOf()))
                    } else {
                        _buy.postValue(Resource.Error(this.message().toString()))
                    }
                }
            } catch (e: Exception) {
                _buy.postValue(Resource.Error(e.message ?: "Unknown Error"))
            }
        }
    }

    fun onSellRefresh() {
        viewModelScope.launch {
            removeSellItem()
            getBuyItems()
            _buy.postValue(Resource.Loading())
            try {


                repository.getAllBuyItems().run {

                    if (this.isSuccessful) {
                        _buy.postValue(Resource.Success(this.body() ?: listOf()))
                    } else {
                        _buy.postValue(Resource.Error(this.message().toString()))
                    }

                }
            } catch (e: Exception) {
                _buy.postValue(Resource.Error(e.message ?: "Unknown Error"))
            }
        }
    }

    fun idleBuy() {
        viewModelScope.launch {
            _buy.postValue(Resource.Empty())
        }
    }


}