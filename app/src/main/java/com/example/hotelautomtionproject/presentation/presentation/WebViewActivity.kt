package com.example.hotelautomtionproject.presentation.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.hotelautomtionproject.R
import com.example.hotelautomtionproject.databinding.ActivityWebViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wvInfo.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = object: WebViewClient(){
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    url: String
                ): Boolean {
                    view?.loadUrl(url)
                    return false
                }
            }
            if(getUrlTest().isNotEmpty()) {
                loadUrl(getUrlTest())
            }
        binding.btnBackMenu.setOnClickListener{
            createLogOutDialog()
        }

        }

    }

    override fun onBackPressed() {
        createLogOutDialog()
    }

    private fun createLogOutDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("Log out")
            setMessage("You will be returned to the login screen")

            setPositiveButton("Log out") { _, _ ->
                super.onBackPressed()
                val i = Intent(context, MainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            }

            setNegativeButton("Cancel") { _, _ ->
            }

            setCancelable(true)
        }.create().show()
    }


    private fun getUrlTest(): String {
        val sharedPref =
            getSharedPreferences(getString(R.string.webview_link), Context.MODE_PRIVATE)
        val url = sharedPref?.getString(getString(R.string.webview_link_url),getString(R.string.webview_link_default))
        //TODO: Use url here to launch WebView
        return url.toString()
    }
}