package com.example.fadel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fadel.data.CoreDatabase
import com.example.fadel.data.entity.UserEntity
import com.example.fadel.data.repository.UserRepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    application: Application
) : AndroidViewModel(application) {

    val readAllData: LiveData<List<UserEntity>>
    private val repository : UserRepositry

    init {
        val userDao = CoreDatabase.getDatabase(application).UserDao()
        repository = UserRepositry(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) { //Dispatcher IO for background thread
            repository.addUser(user)
        }
    }

    fun deleteUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser(user)
        }
    }

    fun updateUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }



}