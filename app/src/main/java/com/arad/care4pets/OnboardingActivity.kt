package com.arad.care4pets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var btnSkip: Button
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)
        tabLayout = findViewById(R.id.tabLayout)

        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        btnNext.setOnClickListener {
            if (viewPager.currentItem < 2) {
                viewPager.currentItem += 1
            } else {
                navigateToLogin()
            }
        }

        btnSkip.setOnClickListener {
            navigateToLogin()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    btnNext.text = "Get Started"
                    btnNext.background = getDrawable(R.drawable.bg_button_onboarding3)
                    btnSkip.visibility = Button.INVISIBLE
                } else {
                    btnNext.text = "Next"
                    btnNext.background = if (position == 0) getDrawable(R.drawable.bg_button_onboarding1) else getDrawable(R.drawable.bg_button_onboarding2)
                    btnSkip.visibility = Button.VISIBLE
                }
            }
        })
    }

    private fun navigateToLogin() {
        val prefs = getSharedPreferences("care4pets_prefs", MODE_PRIVATE)
        prefs.edit().putBoolean("first_time", false).apply()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
