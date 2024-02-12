package com.example.recyclingapp.ui.login

import androidx.lifecycle.ViewModel
import com.example.recyclingapp.repository.AuthenticationRepository

class SignInViewModel:ViewModel() {
    private val repository: AuthenticationRepository = AuthenticationRepository()
    fun signIn(email:String,password:String)
    {
        repository.signIn(email, password)
    }
}