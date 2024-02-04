package com.example.recyclingapp.model

import androidx.annotation.DrawableRes

data class Product(
    @DrawableRes val image : Int,
    val name : String
)