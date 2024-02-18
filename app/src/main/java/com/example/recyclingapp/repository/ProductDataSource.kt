package com.example.recyclingapp.repository

import com.example.recyclingapp.R
import com.example.recyclingapp.model.Product

object ProductDataSource  {

    operator fun invoke(): ArrayList<Product> {
        val products : ArrayList<Product> = arrayListOf()
        products.add(Product(R.drawable.plastic,"Plastic"))
        products.add(Product(R.drawable.paper,"Paper"))
        products.add(Product(R.drawable.electronic,"Electronic"))
        products.add(Product(R.drawable.glass,"Glass"))
        products.add(Product(R.drawable.oil_bottle,"Oil"))
        products.add(Product(R.drawable.material,"Metal"))
        products.add(Product(R.drawable.clothes,"Textile"))
        products.add(Product(R.drawable.battery,"Battery"))
        return products

    }
}