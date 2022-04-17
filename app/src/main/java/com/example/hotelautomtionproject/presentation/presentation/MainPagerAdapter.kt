package com.example.hotelautomtionproject.presentation.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.hotelautomtionproject.presentation.presentation.login.QRScannerFragment
import com.example.hotelautomtionproject.presentation.presentation.login.NormalLogInFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                QRScannerFragment.newInstance()
            }

            1 -> {
                NormalLogInFragment.newInstance()
            }

            2 -> {
                NormalLogInFragment.newInstance()
            }

            else -> {
                QRScannerFragment.newInstance()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }
}