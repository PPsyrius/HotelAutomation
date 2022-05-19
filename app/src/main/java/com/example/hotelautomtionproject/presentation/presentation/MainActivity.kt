package com.example.hotelautomtionproject.presentation.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.viewpager.widget.ViewPager
import com.example.hotelautomtionproject.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewPagerAdapter()
        setBottomNavigation()
        setViewPagerListener()
    }



    private fun setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener {

            viewPager.currentItem =  when (it.itemId){
                R.id.scanMenuId ->  0
                R.id.recentScannedMenuId ->  1
                else -> 0
            }
            return@setOnNavigationItemSelectedListener true

        }
    }

    private fun setViewPagerAdapter() {
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)
    }

    private fun setViewPagerListener() {
        viewPager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

             bottomNavigationView.selectedItemId = when (position){
                 0 -> R.id.scanMenuId
                 1 -> R.id.recentScannedMenuId

                 else -> R.id.scanMenuId

             }             }

            override fun onPageScrollStateChanged(state: Int) {
            }


        })
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Please confirm.")
            setMessage("Are you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                // if user press yes, then finish the current activity
                super.onBackPressed()
                finishAffinity()
                System.exit(0);
            }

            setNegativeButton("No"){_, _ ->
                // if user press no, then return the activity
            }

            setCancelable(true)
        }.create().show()
    }
}