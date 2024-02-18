package com.example.recyclingapp.ui.login

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentSignUpDetailBinding

class SignUpDetailFragment : Fragment() {

    private lateinit var binding:FragmentSignUpDetailBinding
    private lateinit var viewModel:SignUpDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSignUpDetailBinding.inflate(inflater,container,false)
        viewModel=ViewModelProvider(this).get(SignUpDetailViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding)
        {
            signUpButton.setOnClickListener {
                if(checkIfNull())
                {
                    viewModel.createUser(emailEdittext.text.toString(),passwordEdittext.text.toString())
                    findNavController().navigate(R.id.action_signUpDetailFragment_to_signInFragment)
                }
                else
                {
                    println("false")
                }
            }
            navigationIcon.setOnClickListener {
                findNavController().navigate(R.id.action_signUpDetailFragment_to_signUpFragment)
            }
        }
    }

    private fun checkIfNull():Boolean
    {
        var isNull=false
        with(binding)
        {
            val areNameSurnameNull=nameEdittext.text.toString().isEmpty()||surnameEdittext.text.toString().isEmpty()
            val isEmailNull=emailEdittext.text.toString().isEmpty()
            val arePasswordsNull=passwordEdittext.text.toString().isEmpty()||passwordAgainEdittext.text.toString().isEmpty()
            val arePasswordsSame=passwordEdittext.text.toString()==passwordAgainEdittext.text.toString()
            val isRadioButtonChecked=personalAccountButton.isChecked||corporateAccountButton.isChecked

            if(isRadioButtonChecked&&!arePasswordsNull&&!areNameSurnameNull&&!isEmailNull&&arePasswordsSame)isNull=true


        }

        return isNull
    }


}