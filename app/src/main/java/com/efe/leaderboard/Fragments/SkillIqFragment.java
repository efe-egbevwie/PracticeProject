package com.efe.leaderboard.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.efe.leaderboard.Adapters.SkillIqAdapter;
import com.efe.leaderboard.CustomClasses.SkillIqObject;
import com.efe.leaderboard.R;
import com.efe.leaderboard.Utils.ApiInterface;
import com.efe.leaderboard.Utils.RetroFitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillIqFragment extends Fragment {
    private RecyclerView recyclerView;
    private SkillIqAdapter skillIqAdapter;

    ArrayList<SkillIqObject> skillIqObject = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_iq, container, false);
        recyclerView = view.findViewById(R.id.skillIqRecyclerView);
        getUserData();

        return view;
    }

    private void getUserData (){
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        ApiInterface apiInterface = RetroFitClient.getDataInstance().create(ApiInterface.class);
        Call<List<SkillIqObject>> call = apiInterface.getSkillData();

        call.enqueue(new Callback<List<SkillIqObject>>() {
            @Override
            public void onResponse(Call<List<SkillIqObject>> call, Response<List<SkillIqObject>> response) {
                Log.d("responseGET", response.body().get(0).getSkillIqname());
                progressDialog.dismiss();
                skillIqObject = (ArrayList<SkillIqObject>) response.body();
                setDataInRecyclerView();

            }

            @Override
            public void onFailure(Call<List<SkillIqObject>> call, Throwable t) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss(); //dismiss progress dialog

            }
        });

    }

    private void setDataInRecyclerView () {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of Adapter to send the reference and data to Adapter
        SkillIqAdapter skillIqAdapter = new SkillIqAdapter(skillIqObject);
        recyclerView.setAdapter(skillIqAdapter);// set the Adapter to RecyclerView
    }
}