package com.example.recyclingapp.ui.login

import androidx.lifecycle.ViewModel
import com.example.recyclingapp.repository.AuthenticationRepository


class SignUpDetailViewModel:
    ViewModel() {

    private val repository: AuthenticationRepository=AuthenticationRepository()
    fun createUser(email:String,password:String)
    {
        repository.createUserWithEmailAndPassword(email, password)
    }

}