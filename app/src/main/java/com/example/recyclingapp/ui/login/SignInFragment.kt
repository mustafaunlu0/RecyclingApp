package com.example.recyclingapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private lateinit var binding:FragmentSignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if(isChecked)
            {
                when(checkedId)
                {
                    R.id.email_button->{
                        println("email button clicked")
                        binding.emailLayout.visibility=View.VISIBLE
                        binding.phoneLayout.visibility=View.GONE
                    }
                    R.id.phone_button->{
                        println("phone button clicked")

                        binding.emailLayout.visibility=View.GONE
                        binding.phoneLayout.visibility=View.VISIBLE
                    }
                }
            }
        }
        binding.signUpTextview.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

}