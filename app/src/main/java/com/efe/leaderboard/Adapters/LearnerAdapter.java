package com.efe.leaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.efe.leaderboard.CustomClasses.LearnerObject;
import com.efe.leaderboard.R;

import java.util.ArrayList;


public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.MyViewHolder> {
    private ArrayList<LearnerObject> learnerObjectArrayList;
    Context context;

    public LearnerAdapter(ArrayList learnerObject) { this.learnerObjectArrayList = learnerObject;}


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.leaderboard_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LearnerObject learnerObject = learnerObjectArrayList.get(position);
        holder.bindLearnerObject(learnerObject,position);

    }



    @Override
    public int getItemCount() {
        return learnerObjectArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView learnerBadge;
        TextView learnersName;
        TextView learnersHours;
        TextView learningHoursText;
        TextView learnersLocation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            learnerBadge = itemView.findViewById(R.id.learnersBadge);
            learnersName = itemView.findViewById(R.id.learner_name);
            learnersHours = itemView.findViewById(R.id.learning_hours);
            learningHoursText = itemView.findViewById(R.id.learning_hours_text);
            learnersLocation = itemView.findViewById(R.id.learner_location);


        }

        public void bindLearnerObject (LearnerObject learnerObject, int position) {
            learnersName.setText(learnerObjectArrayList.get(position).getLearnerName());
            learnersHours.setText(learnerObjectArrayList.get(position).getLearningHours());
            learningHoursText.setText(R.string.learning_hours_text);
            learnersLocation.setText(learnerObjectArrayList.get(position).getLearnerLocation());

        }

    }

}