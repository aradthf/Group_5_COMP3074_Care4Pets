package com.arad.care4pets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DashboardReminderAdapter extends RecyclerView.Adapter<DashboardReminderAdapter.DashboardReminderViewHolder> {

    private List<Reminder> reminders;

    public DashboardReminderAdapter(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DashboardReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard_reminder, parent, false);
        return new DashboardReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardReminderViewHolder holder, int position) {
        Reminder reminder = reminders.get(position);
        holder.tvReminderTitle.setText(reminder.getTitle());
        holder.tvReminderSubtitle.setText(reminder.getType());
        holder.tvReminderTime.setText(reminder.getDate());

    }

    @Override
    public int getItemCount() {
        return reminders != null ? reminders.size() : 0;
    }

    public static class DashboardReminderViewHolder extends RecyclerView.ViewHolder {
        ImageView ivReminderIcon;
        TextView tvReminderTitle;
        TextView tvReminderSubtitle;
        TextView tvReminderTime;

        public DashboardReminderViewHolder(@NonNull View itemView) {
            super(itemView);
            ivReminderIcon = itemView.findViewById(R.id.ivReminderIcon);
            tvReminderTitle = itemView.findViewById(R.id.tvReminderTitle);
            tvReminderSubtitle = itemView.findViewById(R.id.tvReminderSubtitle);
            tvReminderTime = itemView.findViewById(R.id.tvReminderTime);
        }
    }
}
