package com.example.kointutorial.mindorks

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kointutorial.mindorks.data.model.User
import com.example.kointutorial.mindorks.data.repository.MainRepository
import com.example.kointutorial.mindorks.utils.NetworkHelper
import com.example.kointutorial.mindorks.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    /*private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users*/

    val users: MutableList<User> = emptyList<User>().toMutableStateList()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            //_users.postValue(Resource.Loading())

            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        it.body()?.let { usersResponse ->
                            users.addAll(usersResponse)
                        }
                    }
                }
            }

            /*if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.Success(it.body()))
                    } else _users.postValue(Resource.Error(it.errorBody().toString()))
                }
            } else _users.postValue(Resource.Error("No internet connection"))*/
        }
    }
}