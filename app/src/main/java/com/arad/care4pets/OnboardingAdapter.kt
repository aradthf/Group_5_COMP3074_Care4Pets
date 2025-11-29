package com.arad.care4pets

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment.newInstance(R.layout.fragment_onboarding1)
            1 -> OnboardingFragment.newInstance(R.layout.fragment_onboarding2)
            else -> OnboardingFragment.newInstance(R.layout.fragment_onboarding3)
        }
    }
}
