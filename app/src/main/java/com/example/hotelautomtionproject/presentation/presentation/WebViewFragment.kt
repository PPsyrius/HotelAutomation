package com.example.hotelautomtionproject.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.hotelautomtionproject.R
import com.example.hotelautomtionproject.databinding.FragmentWebViewBinding
import com.google.android.material.snackbar.Snackbar

class WebViewFragment : Fragment() {
    private lateinit var fragmentWebViewBinding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentWebViewBinding = FragmentWebViewBinding.bind(view)

// * in case using navigation component

//        val args : WebViewFragmentArgs by navArgs()
//        val someData = args.selectedData             // selected data come from the argument that added by nav graph

        fragmentWebViewBinding.wvInfo.apply {
            webViewClient = WebViewClient()
//            if(someData.url!=null) {
//                loadUrl(someData.url)
//            }
        }
    }
}

