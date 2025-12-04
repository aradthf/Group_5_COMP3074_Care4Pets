package com.arad.care4pets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReminderAdapter(
    reminders: List<Reminder>
) : RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>() {

    var reminders: List<Reminder> = reminders
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ReminderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvReminderTitle)
        val tvDate: TextView = itemView.findViewById(R.id.tvReminderDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reminder, parent, false)
        return ReminderViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        val r = reminders[position]
        holder.tvTitle.text = r.title
        holder.tvDate.text = "${r.type} – ${r.date}"
    }

    override fun getItemCount(): Int = reminders.size
}
