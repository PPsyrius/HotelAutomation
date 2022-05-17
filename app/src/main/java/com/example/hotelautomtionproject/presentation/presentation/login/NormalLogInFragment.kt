package com.example.hotelautomtionproject.presentation.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.hotelautomtionproject.R
import com.example.hotelautomtionproject.databinding.FragmentNormalLoginBinding
import com.example.hotelautomtionproject.presentation.presentation.APIService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class NormalLogInFragment : Fragment() {
    private lateinit var binding: FragmentNormalLoginBinding

    @Inject
    private lateinit var apiService: APIService

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
            Toast.makeText(context, "Sign In Button clicked", Toast.LENGTH_SHORT).show()
        }

        binding.tvSignIn.setOnClickListener {
            Toast.makeText(context, "Sign In Text View clicked", Toast.LENGTH_SHORT).show()
            //TODO: Move the code chunk to view model if exist.
            lifecycleScope.launch() {
                try {
                    var user = apiService.getUserName(binding.editText.text.toString())[0]
                    if(user.password==binding.editText2.text.toString()) {
                        //TODO: Launch webview here using url from user.url
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "User or password is incorrect.", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
    }


}