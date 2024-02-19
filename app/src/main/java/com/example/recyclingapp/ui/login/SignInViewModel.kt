package com.example.recyclingapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclingapp.repository.AuthenticationRepository
import kotlinx.coroutines.launch

class SignInViewModel:ViewModel() {
    private val repository: AuthenticationRepository = AuthenticationRepository()

    private val _isLoggedIn =MutableLiveData<Boolean>()
    val isLoggedIn:LiveData<Boolean>
        get() = _isLoggedIn

    fun signIn(email:String,password:String)
    {
        viewModelScope.launch {
            repository.signIn(email, password,_isLoggedIn)
        }

    }
}