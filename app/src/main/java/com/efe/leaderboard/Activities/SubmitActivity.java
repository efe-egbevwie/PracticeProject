package com.efe.leaderboard.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.efe.leaderboard.CustomClasses.SubmitData;
import com.efe.leaderboard.R;
import com.efe.leaderboard.Utils.ApiInterface;
import com.efe.leaderboard.Utils.RetrofitClient2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    Button sumbmitButton;
    Button yesButton;
    ImageButton cancelDialog;

    EditText editFirstName;
    EditText editLastName;
    EditText editEmail;
    EditText editGitLink;

    SubmitData submitData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        sumbmitButton = findViewById(R.id.submit_button);
        sumbmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDialog();
              }
        });

        editFirstName = findViewById(R.id.submit__first_name);
        editLastName = findViewById(R.id.submit_last_name);
        editEmail = findViewById(R.id.submit_email_address);
        editGitLink = findViewById(R.id.submit_github);




    }

    private void submitDialog () {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialog = LayoutInflater.from(this).inflate(R.layout.confirm_dialog, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialog);
        final AlertDialog alertDialog = builder.create();

        yesButton = dialog.findViewById(R.id.yes_button);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                submit();

            }
        });


        cancelDialog = dialog.findViewById(R.id.cancel_dialog);
        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void successDialog () {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialog = LayoutInflater.from(this).inflate(R.layout.submission_succesfull_dialog, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialog);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    private void errorDialog () {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialog = LayoutInflater.from(this).inflate(R.layout.submission_failure_dialog, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialog);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void submit() {

        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        String gitLink = editGitLink.getText().toString();

        ApiInterface apiInterface = RetrofitClient2.getDataInstance().create(ApiInterface.class);
        Call<SubmitData> call = apiInterface.submit(email,firstName,lastName,gitLink);
        call.enqueue(new Callback<SubmitData>() {
            @Override
            public void onResponse(Call<SubmitData> call, Response<SubmitData> response) {
                submitData = response.body();
                Log.d("TAG",response.code()+"");
                Toast.makeText(SubmitActivity.this, "post success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SubmitData> call, Throwable t) {
                //Toast.makeText(SubmitActivity.this, "post failed", Toast.LENGTH_SHORT).show();
                Log.d("Post failed",t.toString(),t);
                Toast.makeText(SubmitActivity.this, t.toString(), Toast.LENGTH_LONG).show();


            }
        });
    }

}