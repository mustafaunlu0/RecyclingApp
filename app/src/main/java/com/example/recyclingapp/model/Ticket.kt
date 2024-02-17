package com.example.recyclingapp.model

data class Ticket(
    val id : String,
    val product: Product,
    val kg : Int,
    val point : Int,
    val desc : String,
    val time : String
)