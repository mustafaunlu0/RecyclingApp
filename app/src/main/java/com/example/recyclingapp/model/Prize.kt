package com.example.recyclingapp.model

import androidx.annotation.DrawableRes

data class Prize(
    @DrawableRes val image : Int,
    val name : String,
    val point : String,
    var isSelected : Boolean = false
)