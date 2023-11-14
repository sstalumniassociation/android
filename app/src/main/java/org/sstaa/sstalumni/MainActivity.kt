package org.sstaa.sstalumni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.main_bottom_nav)
        val fragments: HashMap<Int, Fragment> = hashMapOf(
            R.id.nav_home to HomeFragment(),
            R.id.nav_services to ServicesFragment(),
            R.id.nav_events to EventsFragment(),
            R.id.nav_profile to UserProfileFragment()
        )
        bottomNav.setOnItemSelectedListener { item ->
            val selectedFragment = fragments[item.itemId] ?: throw Exception("Fragment not found")

            supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container, selectedFragment).commit()
            true
        }
    }
}