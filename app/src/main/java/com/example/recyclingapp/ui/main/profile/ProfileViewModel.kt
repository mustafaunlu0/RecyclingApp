package com.example.recyclingapp.ui.main.profile

import androidx.lifecycle.ViewModel
import com.example.recyclingapp.repository.AuthenticationRepository

class ProfileViewModel:ViewModel() {

    private val repository: AuthenticationRepository = AuthenticationRepository()
    fun signOut()
    {
        repository.signOut()
    }

}