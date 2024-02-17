package com.example.recyclingapp.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.ProductRowBinding
import com.example.recyclingapp.model.Product
import com.example.recyclingapp.repository.ProductDataSource

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    private var products : ArrayList<Product> = arrayListOf()

    init {
        products=ProductDataSource()
        /*products.add(Product(R.drawable.plastic,"Plastik"))
        products.add(Product(R.drawable.paper,"Kağıt"))
        products.add(Product(R.drawable.electronic,"Elektronik"))
        products.add(Product(R.drawable.glass,"Cam"))
        products.add(Product(R.drawable.oil_bottle,"Yağ"))
        products.add(Product(R.drawable.material,"Metal"))
        products.add(Product(R.drawable.clothes,"Tekstil"))
        products.add(Product(R.drawable.battery,"Pil"))*/

    }
    class ProductViewHolder(val binding : ProductRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.productImageview.setImageResource(products[position].image)
        holder.binding.nameTextview.text = (products[position].name)

        holder.itemView.setOnClickListener {
            println("tıklandı: $position")
        }
    }


}