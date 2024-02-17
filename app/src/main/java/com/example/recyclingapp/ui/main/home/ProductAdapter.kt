package com.example.recyclingapp.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.ProductRowBinding
import com.example.recyclingapp.model.Product
import com.example.recyclingapp.repository.LocalDataSource
import com.example.recyclingapp.repository.ProductDataSource

class ProductAdapter(val onItemClick : () -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    private var products : ArrayList<Product> = ProductDataSource()


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
            onItemClick()
        }
    }


}