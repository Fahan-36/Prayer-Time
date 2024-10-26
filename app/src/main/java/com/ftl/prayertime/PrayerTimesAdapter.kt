package com.ftl.prayertime

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PrayerTimesAdapter(private var prayerTimes: List<PrayerTime>, context: Context):
    RecyclerView.Adapter<PrayerTimesAdapter.PrayerTimeViewHolder>() {

        private val db: PrayerTimeDatabaseHelper= PrayerTimeDatabaseHelper(context)

    class PrayerTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val payerNameTextView: TextView = itemView.findViewById(R.id.payerNameTextView)
        val prayerTimeTextView: TextView = itemView.findViewById(R.id.prayerTimeTextView)
        val updateButton : ImageView = itemView.findViewById(R.id.updateButton)
        val deleteButton : ImageView = itemView.findViewById(R.id.deleteButton)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayerTimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prayertime_item,parent,false)
        return PrayerTimeViewHolder(view)
    }

    override fun getItemCount(): Int = prayerTimes.size

    override fun onBindViewHolder(holder: PrayerTimeViewHolder, position: Int) {
       val prayerTime= prayerTimes[position]
        holder.payerNameTextView.text= prayerTime.name
        holder.prayerTimeTextView.text= prayerTime.time

        holder.updateButton.setOnClickListener{
            val intent= Intent(holder.itemView.context,UpdatePrayerTimeActivity::class.java).apply {
                putExtra("prayerTime_id",prayerTime.id)
            }
            holder.itemView.context.startActivity(intent)
            }

        holder.deleteButton.setOnClickListener{
            db.deletePrayerTime(prayerTime.id)
            refreshData(db.getAllPrayerTime())
            Toast.makeText(holder.itemView.context,"Prayer Time Deleted",Toast.LENGTH_SHORT).show()
        }
        }

    fun refreshData(newPrayerTimes: List<PrayerTime>){
        prayerTimes = newPrayerTimes
        notifyDataSetChanged()
    }

}