package com.example.recyclingapp.ui.main.profile.history

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.HistoryItemBinding
import com.example.recyclingapp.model.Product
import com.example.recyclingapp.model.Ticket

class HistoryAdapter:RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {

    private val historyList = mutableListOf(
        Ticket("1", Product(R.drawable.plastic,"Plastik"),5,5,"Description","13:00-14:00"),
        Ticket("1", Product(R.drawable.electronic,"Elektronik"),4,12,"Phasellus iaculis orci eu est lacinia, id viverra metus mattis. Nunc tempor elit id tincidunt cursus. Curabitur imperdiet elementum sodales. Vivamus mattis tortor erat, sed laoreet turpis bibendum nec. Aenean ultricies augue et pellentesque feugiat. Cras id dolor fringilla, bibendum lorem sit amet, gravida urna.","13:00-14:00"),
    )

    inner class HistoryHolder(val binding: HistoryItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=HistoryItemBinding.inflate(layoutInflater,parent,false)
        return HistoryHolder(binding)
    }

    override fun getItemCount(): Int = historyList.size

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {

        if(position%2==1)
        {
            holder.binding.layout.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.light_grey))
        }

        holder.binding.productImage.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,historyList[position].product.image))
        holder.binding.productName.text=historyList[position].product.name
        holder.binding.point.text=historyList[position].point.toString()
        holder.binding.time.text=historyList[position].time
        holder.binding.desc.text=historyList[position].desc

    }

}