package com.example.recyclingapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding)
        {
            signInTextview.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
            }
            continueButton.setOnClickListener {
                if(validatePhoneNumber(phoneEdittext.text.toString()))
                {
                    findNavController().navigate(R.id.action_signUpFragment_to_signUpDetailFragment)
                }
                else{
                    phoneErrorText.visibility=View.VISIBLE
                }
            }

        }
    }

    private fun validatePhoneNumber(number:String):Boolean
    {
        return number.length == 10
    }

}