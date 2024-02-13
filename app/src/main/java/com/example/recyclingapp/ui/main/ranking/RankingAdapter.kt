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
        list.add(User("Deniz","Şimşek",35))
        list.add(User("Mustafa","Ünlü",32))
        list.add(User("user1","user1",35))
        list.add(User("user2","user2",35))
        list.add(User("user3","user3",35))
        list.add(User("user4","user4",35))
        list.add(User("user5","use5",35))
        list.add(User("user6","user6",35))
        list.add(User("user7","user7",35))
        list.add(User("user8","user8",35))
        list.add(User("user9","user9",35))
        list.add(User("user10","user10",34))
        list.add(User("user10","user10",34))
        list.add(User("user10","user10",34))
        list.add(User("user10","user10",34))
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