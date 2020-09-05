package com.efe.leaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.efe.leaderboard.CustomClasses.SkillIqObject;
import com.efe.leaderboard.R;

import java.util.ArrayList;

public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.MyViewHolder> {
    private ArrayList<SkillIqObject> skillIqObjectArrayList;
    Context context;

    public SkillIqAdapter(ArrayList skillIqObject) { this.skillIqObjectArrayList = skillIqObject;}


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.skill_iq_item, parent, false);
        SkillIqAdapter.MyViewHolder myViewHolder = new SkillIqAdapter.MyViewHolder(v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SkillIqObject skillIqObject = skillIqObjectArrayList.get(position);
        holder.bindSkillIqObject(skillIqObject, position);
    }



    @Override
    public int getItemCount() {
        return skillIqObjectArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView skillIqBadge;
        TextView  skillIqName;
        TextView  skillIqScore;
        TextView  skillIqText;
        TextView  skillIqCountry;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            skillIqBadge = itemView.findViewById(R.id.skill_iq_Badge);
            skillIqName = itemView.findViewById(R.id.skill_iq_name);
            skillIqScore = itemView.findViewById(R.id.skill_iq_score);
            skillIqText = itemView.findViewById(R.id.skill_iq_score_text);
            skillIqCountry = itemView.findViewById(R.id.skill_iq_location);


        }

        public void bindSkillIqObject (SkillIqObject skillIqObject, int position) {
            skillIqName.setText(skillIqObjectArrayList.get(position).getSkillIqname());
            skillIqScore.setText(skillIqObjectArrayList.get(position).getScore());
            skillIqText.setText(R.string.skiil_iq_score_text);
            skillIqCountry.setText(skillIqObjectArrayList.get(position).getCountry());

        }

    }
}
