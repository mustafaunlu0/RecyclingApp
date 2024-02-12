package com.example.recyclingapp.repository

import com.example.recyclingapp.model.Resource
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class AuthenticationRepository{

    private val auth= Firebase.auth
    fun createUserWithEmailAndPassword(email:String,password:String)
    {
        auth.createUserWithEmailAndPassword(email,password)
    }

    fun signIn(email:String,password: String)
    {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            result->
            if(result.isSuccessful)
            {
                println("signed ingmaig")
            }
        }
    }


}