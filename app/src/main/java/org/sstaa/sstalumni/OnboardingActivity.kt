package org.sstaa.sstalumni

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

val content: Array<HashMap<String, Any>> = arrayOf(
    hashMapOf(
        "title" to "SST Alumni",
        "description" to "Access alumni services, a security pass, and more!",
        "image" to R.drawable.logo_sstalumni
    ),
    hashMapOf(
        "title" to "Virtual Security Pass",
        "description" to "Visiting SST? Prove your identity as an alumnus to security.",
        "image" to R.drawable.baseline_badge_24
    ),
    hashMapOf(
        "title" to "Hear about SST Alumni events",
        "description" to "Be the first to find out about SST alumni events.",
        "image" to R.drawable.baseline_campaign_24
    ),
    hashMapOf(
        "title" to "Loan Venues",
        "description" to "Need some space for a badminton match? Book venues within the school!",
        "image" to R.drawable.baseline_meeting_room_24
    )
)

class OnboardingActivity : FragmentActivity() {
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.onboarding_viewpager)
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
    }

    private inner class ScreenSlidePagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment = OnboardingFragment.newInstance(
            content[position]["title"] as String,
            content[position]["description"] as String,
            content[position]["image"] as Int
        )
    }
}