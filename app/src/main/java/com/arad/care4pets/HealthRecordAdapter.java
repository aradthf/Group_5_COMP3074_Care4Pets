package com.arad.care4pets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HealthRecordAdapter extends RecyclerView.Adapter<HealthRecordAdapter.HealthRecordViewHolder> {
    public interface OnItemClickListener{
        void onItemClick(HealthRecord healthRecord);
    }

    private List<HealthRecord> records;

    private final OnItemClickListener onItemClickListener;

    public HealthRecordAdapter(List<HealthRecord> records, OnItemClickListener onItemClickListener){
        this.records = records;
        this.onItemClickListener = onItemClickListener;
    }
    public void setRecords(List<HealthRecord> records){
        this.records = records;
        notifyDataSetChanged();
    }

    public static class HealthRecordViewHolder extends RecyclerView.ViewHolder{
        TextView tvType;
        TextView tvDescription;

        public HealthRecordViewHolder(@NonNull View itemView){
            super(itemView);
            tvType = itemView.findViewById(R.id.etRecordTitle);
            tvDescription = itemView.findViewById(R.id.etRecordDescription);
        }
    }

    @NonNull
    @Override
    public HealthRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_health_record, parent, false);
        return new HealthRecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthRecordViewHolder holder, int position){
        HealthRecord record = records.get(position);
        holder.tvType.setText(record.getRecordType());
        holder.tvDescription.setText(record.getDescription());

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(record));
    }

    @Override
    public int getItemCount(){return records != null ? records.size() : 0;}
}
