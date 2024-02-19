package com.example.recyclingapp.ui.main.prize

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentPrizeBinding
import com.example.recyclingapp.model.Prize

class PrizeFragment : Fragment() {

    private lateinit var binding : FragmentPrizeBinding

    private  var prizes : ArrayList<Prize> = arrayListOf()


    init {
        prizes.add(Prize(R.drawable.ps4, "Playstation 4", "50000 P",))
        prizes.add(Prize(R.drawable.tablet, "Tablet", "45000 P",))
        prizes.add(Prize(R.drawable.phone, "Phone", "30000 P",))
        prizes.add(Prize(R.drawable.earphone, "Earbuds", "25000 P",))
        prizes.add(Prize(R.drawable.my_book, "Surprise Book", "10000 P",))
        prizes.add(Prize(R.drawable.desk_lamp, "Desk Lamp", "9000 P",))
        prizes.add(Prize(R.drawable.book_set, "Book Set", "8000 P",))
        prizes.add(Prize(R.drawable.book_mark, "Book Mark", "4000 P",))
        prizes.add(Prize(R.drawable.ticket_big, "Surprise Ticket", "4000 P",))
        prizes.add(Prize(R.drawable.ticket_big, "Surprise Ticket", "3000 P",))
        prizes.add(Prize(R.drawable.ticket_big, "Surprise Ticket", "2000 P",))
        prizes.add(Prize(R.drawable.ticket_big, "SSurprise Ticket", "1000 P",))


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPrizeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.joysticCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_color))
        binding.joysticCardview.setOnClickListener {
            setPrize(0)
            binding.joysticCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_color))
            binding.bookCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.unselected_color))
            binding.ticketCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.unselected_color))
        }
        binding.bookCardview.setOnClickListener {
            setPrize(4)
            binding.joysticCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.unselected_color))
            binding.bookCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_color))
            binding.ticketCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.unselected_color))
        }
        binding.ticketCardview.setOnClickListener {
            setPrize(8)
            binding.joysticCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.unselected_color))
            binding.bookCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.unselected_color))
            binding.ticketCardview.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_color))
        }

    }

    private fun setPrize(index : Int){
        binding.product1Imageview.setImageResource(prizes[index].image)
        binding.product1NameTextview.text = prizes[index].name
        binding.product1CoinTextview.text = prizes[index].point

        binding.product2Imageview.setImageResource(prizes[index+1].image)
        binding.product2NameTextview.text = prizes[index+1].name
        binding.product2CoinTextview.text = prizes[index+1].point

        binding.product3Imageview.setImageResource(prizes[index+2].image)
        binding.product3NameTextview.text = prizes[index+2].name
        binding.product3CoinTextview.text = prizes[index+2].point

        binding.product4Imageview.setImageResource(prizes[index+3].image)
        binding.product4NameTextview.text = prizes[index+3].name
        binding.product4CoinTextview.text = prizes[index+3].point
    }


}