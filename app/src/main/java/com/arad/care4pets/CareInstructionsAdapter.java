package com.arad.care4pets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CareInstructionsAdapter extends RecyclerView.Adapter<CareInstructionsAdapter.CareViewHolder> {
    private List<String> instructions;

    public CareInstructionsAdapter(List<String> instructions){
        this.instructions = instructions;
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
        notifyItemInserted(instructions.size() - 1);
    }

    @NonNull
    @Override
    public CareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_care_instruction, parent, false);
        return  new CareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CareViewHolder holder, int position){
        String instruction = instructions.get(position);
        holder.tvInstruction.setText(instruction);
    }

    @Override
    public int getItemCount(){
        return instructions.size();
    }

    static class CareViewHolder extends RecyclerView.ViewHolder{
        TextView tvInstruction;

        public CareViewHolder(@NonNull View itemView){
            super(itemView);
            tvInstruction = itemView.findViewById(R.id.tvInstruction);
        }
    }
}
