package com.ftl.prayertime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ftl.prayertime.databinding.ActivityUpdatePrayertimeBinding

class UpdatePrayerTimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdatePrayertimeBinding
    private lateinit var db:PrayerTimeDatabaseHelper
    private var prayerTimeId : Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdatePrayertimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = PrayerTimeDatabaseHelper(this)

        prayerTimeId = intent.getIntExtra("prayerTime_id",-1)
        if (prayerTimeId==-1){
            finish()
            return
        }

      val prayerTime = db.getPrayerTimeByID(prayerTimeId)
      binding.updatePrayerNameEditText.setText(prayerTime.name)
      binding.updatePrayerTimeEditText.setText(prayerTime.time)

        binding.updateButton.setOnClickListener{
            val newPrayerName = binding.updatePrayerNameEditText.text.toString()
            val newPrayerTime = binding.updatePrayerTimeEditText.text.toString()
            val updatedPrayerTime = PrayerTime(prayerTimeId,newPrayerName,newPrayerTime)
            db.updatePrayerTime(updatedPrayerTime)
            finish()
            Toast.makeText(this,"Changes Saved",Toast.LENGTH_SHORT).show()
        }

    }
}