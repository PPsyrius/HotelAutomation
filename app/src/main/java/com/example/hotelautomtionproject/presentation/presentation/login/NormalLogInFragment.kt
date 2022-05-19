package com.example.hotelautomtionproject.presentation.presentation.login

import android.content.Context
import android.content.Intent
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
import com.example.hotelautomtionproject.presentation.presentation.WebViewActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class NormalLogInFragment : Fragment() {
    private lateinit var binding: FragmentNormalLoginBinding

    @Inject
    lateinit var apiService: APIService

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
            startWebView()
        }

        binding.tvSignIn.setOnClickListener {
            startWebView()

        }
    }

    private fun startWebView() {
        lifecycleScope.launch() {
            try {
                var user = apiService.getUserName(binding.editText.text.toString())[0]
                if (user.password == binding.editText2.text.toString()) {
                    val sharedPreference =
                        activity?.getSharedPreferences(
                            getString(R.string.webview_link),
                            Context.MODE_PRIVATE
                        )
                    var editor = sharedPreference?.edit()
                    editor?.putString(getString(R.string.webview_link_url), user.url)
                    editor?.apply()

                    activity?.let {
                        val intent = Intent(context, WebViewActivity::class.java)
                        it.startActivity(intent)
                    }
                }

            } catch (e: Exception) {
                Toast.makeText(context, "User or password is incorrect.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }



}