package com.example.recyclingapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.recyclingapp.model.Resource
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.util.concurrent.Flow
import javax.inject.Inject

class AuthenticationRepository{

    private val auth= Firebase.auth
    fun createUserWithEmailAndPassword(email:String,password:String)
    {
        auth.createUserWithEmailAndPassword(email,password)
    }

    suspend fun signIn(email:String,password: String,isLoggedIn:MutableLiveData<Boolean>)
    {

        withContext(Dispatchers.IO) {

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    result->
                isLoggedIn.postValue(result.isSuccessful)

            }
        }

    }

    fun signOut()
    {
        auth.signOut()
    }


}