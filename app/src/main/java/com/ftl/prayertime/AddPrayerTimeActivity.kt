package com.ftl.prayertime

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ftl.prayertime.databinding.ActivityAddPrayerTimeBinding

class AddPrayerTimeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddPrayerTimeBinding
    private lateinit var db: PrayerTimeDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPrayerTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= PrayerTimeDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val name = binding.prayerNameEditText.text.toString()
            val time = binding.prayerTimeEditText.text.toString()
            val prayerTime = PrayerTime(0,name,time)
            db.insertPrayerTime(prayerTime)
            finish()
            Toast.makeText(this,"Prayer Name And Time Saved",Toast.LENGTH_SHORT).show()
        }
    }
}