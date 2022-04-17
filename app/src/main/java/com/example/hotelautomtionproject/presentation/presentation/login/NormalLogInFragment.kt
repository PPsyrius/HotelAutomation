package com.example.hotelautomtionproject.presentation.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hotelautomtionproject.R
import com.example.hotelautomtionproject.databinding.FragmentNormalLoginBinding


class NormalLogInFragment : Fragment() {
    private lateinit var binding : FragmentNormalLoginBinding


    companion object {

        fun newInstance(): NormalLogInFragment {
            return NormalLogInFragment()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_normal_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNormalLoginBinding.bind(view)

        binding.btSignIn.setOnClickListener {
            Toast.makeText(context,"Sign In Button clicked", Toast.LENGTH_SHORT).show()
        }

        binding.tvSignIn.setOnClickListener{
            Toast.makeText(context,"Sign In Text View clicked", Toast.LENGTH_SHORT).show()

        }
    }


}