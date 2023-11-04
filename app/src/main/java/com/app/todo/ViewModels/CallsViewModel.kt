package com.app.todo.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.todo.Domain.Repository.Repositories.CallsRepository
import com.app.todo.models.Resource
import com.app.todo.models.response.Calls
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallsViewModel @Inject constructor(private val repository: CallsRepository) : ViewModel() {

    private var _calls: MutableLiveData<Resource<List<Calls>>> = MutableLiveData()
    val call: LiveData<Resource<List<Calls>>> get() = _calls

    init {
        getCalls()
    }

    fun getCalls() {
        viewModelScope.launch {
            _calls.postValue(Resource.Loading())
            try {

                repository.getAllCalls().run {
                    if (this.isSuccessful) {
                        _calls.postValue(Resource.Success(this.body() ?: listOf()))
                    } else {
                        _calls.postValue(Resource.Error(this.message().toString()))
                    }
                }
            } catch (e: Exception) {
                _calls.postValue(Resource.Error(e.message ?: "Unknown Error"))
            }
        }
    }

    fun Idle() {
        viewModelScope.launch {
            _calls.postValue(Resource.Empty())
        }
    }

}