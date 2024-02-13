package com.example.recyclingapp.ui.main.ranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentRankingBinding
import com.example.recyclingapp.model.User


class RankingFragment : Fragment() {

    private val adapter= RankingAdapter()
    private lateinit var binding:FragmentRankingBinding
    private val topThree= mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        topThree.add(User("Deniz","Şimşek",42))
        topThree.add(User("Mustafa","Ünlü",40))
        topThree.add(User("user1","user1",38))
        binding=FragmentRankingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rankingRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rankingRecyclerView.adapter=adapter
        binding.firstWinnerName.text=topThree[0].firstName+" "+topThree[0].lastName
        binding.firstWinnerScore.text=topThree[0].score.toString()
        binding.secondWinnerName.text=topThree[1].firstName+" "+topThree[1].lastName
        binding.secondWinnerScore.text=topThree[1].score.toString()
        binding.thirdWinnerName.text=topThree[2].firstName+" "+topThree[2].lastName
        binding.thirdWinnerScore.text=topThree[2].score.toString()

    }

}