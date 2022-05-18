package com.example.hotelautomtionproject.presentation.presentation.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.hotelautomtionproject.R
import kotlinx.android.synthetic.main.fragment_qr_scanner.view.*
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView


class QRScannerFragment : Fragment(), ZBarScannerView.ResultHandler {

    companion object {

        fun newInstance(): QRScannerFragment {
            return QRScannerFragment()
        }
    }

    private lateinit var mView: View

    lateinit var scannerView: ZBarScannerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_qr_scanner, container, false)
        initViews()
        onClicks()
        return mView.rootView
    }


    private fun initViews() {
        initializeQRCamera()
    }

    private fun initializeQRCamera() {
        scannerView = ZBarScannerView(context)
        scannerView.setResultHandler(this)
        scannerView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorTranslucent))
        scannerView.setBorderColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
        scannerView.setLaserColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
        scannerView.setBorderStrokeWidth(10)
        scannerView.setSquareViewFinder(true)
        scannerView.setupScanner()
        scannerView.setAutoFocus(true)
        startQRCamera()
        mView.containerScanner.addView(scannerView)
    }


    override fun handleResult(rawResult: Result?) {
        onQrResult(rawResult?.contents)
    }

    private fun onQrResult(contents: String?) {
        if (contents.isNullOrEmpty())
            showToast("Empty Qr Result")
        else {
            showToast(contents)
            val sharedPreference =
                activity?.getSharedPreferences(
                    getString(R.string.webview_link),
                    Context.MODE_PRIVATE
                )
            var editor = sharedPreference?.edit()
            editor?.putString(getString(R.string.webview_link_url), contents)
            editor?.apply()
        }
        scannerView.resumeCameraPreview(this)
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    private fun startQRCamera() {
        scannerView.startCamera()
    }


    private fun onClicks() {
        mView.flashToggle.setOnClickListener {
            if (mView.flashToggle.isSelected) {
                offFlashLight()
            } else {
                onFlashLight()
            }
        }
    }

    private fun onFlashLight() {
        mView.flashToggle.isSelected = true
        scannerView.flash = true
    }

    private fun offFlashLight() {
        mView.flashToggle.isSelected = false
        scannerView.flash = false
    }

    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        scannerView.stopCamera()
    }

    override fun onDestroy() {
        super.onDestroy()
        scannerView.stopCamera()
    }


}
