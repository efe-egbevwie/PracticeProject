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


import com.efe.leaderboard.Adapters.LearnerAdapter;
import com.efe.leaderboard.CustomClasses.LearnerObject;
import com.efe.leaderboard.R;
import com.efe.leaderboard.Utils.ApiInterface;
import com.efe.leaderboard.Utils.RetroFitClient;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LeaderBoardFragment extends Fragment {
    private RecyclerView   recyclerView;
    private LearnerAdapter learnerAdapter;

    ArrayList<LearnerObject> learnerObject = new ArrayList<LearnerObject>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leader_board, container, false);
        recyclerView = view.findViewById(R.id.leaderBoardrecyclerView);
        getUserData();



        return view;
    }


    private void getUserData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        ApiInterface apiInterface = RetroFitClient.getDataInstance().create(ApiInterface.class);
        Call<List<LearnerObject>> call = apiInterface.getData();
        call.enqueue(new Callback<List<LearnerObject>>() {
            @Override
            public void onResponse(Call<List<LearnerObject>> call, Response<List<LearnerObject>> response) {
                Log.d("responseGET", response.body().get(0).getLearnerName());
                progressDialog.dismiss(); //dismiss progress dialog
                learnerObject = (ArrayList<LearnerObject>) response.body();
                setDataInRecyclerView();

            }

            @Override
            public void onFailure(Call<List<LearnerObject>> call, Throwable t) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss(); //dismiss progress dialog

            }

        });
    }

    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of Adapter to send the reference and data to Adapter
        LearnerAdapter learnerAdapter = new LearnerAdapter(learnerObject);
        recyclerView.setAdapter(learnerAdapter); // set the Adapter to RecyclerView
    }

}


