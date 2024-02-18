package com.example.recyclingapp.ui.main.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclingapp.databinding.RankingItemBinding
import com.example.recyclingapp.model.User

class RankingAdapter: RecyclerView.Adapter<RankingAdapter.RankingHolder>() {
    inner class RankingHolder(val binding: RankingItemBinding) :RecyclerView.ViewHolder(binding.root)

    private val list= mutableListOf<User>()
    init {
        list.add(User("Fiona","Rees",35))
        list.add(User("Victor","Chapman",32))
        list.add(User("Matt","Peters",35))
        list.add(User("Max","Manning",35))
        list.add(User("Elizabeth","Wallace",35))
        list.add(User("Brandon","Powell",35))
        list.add(User("Faith","Lambert",35))
        list.add(User("Diane","Mathis",35))
        list.add(User("Ella","King",35))
        list.add(User("Nicholas","White",35))
        list.add(User("Richard","Manning",35))
        list.add(User("Adam","Parr",34))
        list.add(User("Benjamin","Randall",34))
        list.add(User("Isaac","Clarkson",34))
        list.add(User("Karen","Springer",34))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingHolder {
        val binding=RankingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RankingHolder(binding)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: RankingHolder, position: Int) {
        holder.binding.sequence.text= (position+1).toString()
        holder.binding.userName.text= list[position].firstName+" "+list[position].lastName
        holder.binding.userScore.text= list[position].score.toString()
    }
}