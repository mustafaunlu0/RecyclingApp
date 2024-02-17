package com.example.recyclingapp.repository

import com.example.recyclingapp.R
import com.example.recyclingapp.model.Product

class LocalDataSource {


    var products : ArrayList<Product> = arrayListOf()

    init {
        products.add(Product(R.drawable.plastic,"Plastik"))
        products.add(Product(R.drawable.paper,"Kağıt"))
        products.add(Product(R.drawable.electronic,"Elektronik"))
        products.add(Product(R.drawable.glass,"Cam"))
        products.add(Product(R.drawable.oil_bottle,"Yağ"))
        products.add(Product(R.drawable.material,"Metal"))
        products.add(Product(R.drawable.clothes,"Tekstil"))
        products.add(Product(R.drawable.battery,"Pil"))

    }



}