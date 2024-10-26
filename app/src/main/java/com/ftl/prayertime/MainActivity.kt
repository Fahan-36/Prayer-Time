package com.ftl.prayertime

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ftl.prayertime.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var db : PrayerTimeDatabaseHelper
    private lateinit var prayerTimesAdapter: PrayerTimesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = PrayerTimeDatabaseHelper(this)
        prayerTimesAdapter= PrayerTimesAdapter(db.getAllPrayerTime(),this)

        binding.prayerTimeRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.prayerTimeRecyclerView.adapter = prayerTimesAdapter

        binding.addButton.setOnClickListener {
            val intent = Intent(this,AddPrayerTimeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        prayerTimesAdapter.refreshData(db.getAllPrayerTime())
    }
}