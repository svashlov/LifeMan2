package com.glitchlink.lifeman2.data.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.glitchlink.lifeman2.data.GenericDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = GenericDatabase.getDatabase(application).getUserDao()

    val getAllUsers : LiveData<List<User>> = userDao.getAllUsers()

    fun insertUser (user : User) {
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }

    fun deleteUser (user : User) {
        viewModelScope.launch {
            userDao.deleteUser(user)
        }
    }

}