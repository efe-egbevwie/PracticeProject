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
import com.efe.leaderboard.Utils.RetroFitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    Button submitButton;
    Button yesButton;
    ImageButton cancelDialogButton;

    EditText editFirstName;
    EditText editLastName;
    EditText editEmail;
    EditText editGitLink;

    SubmitData submitData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
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


        cancelDialogButton = dialog.findViewById(R.id.cancel_dialog_button);
        cancelDialogButton.setOnClickListener(new View.OnClickListener() {
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

        String firstName = editFirstName.getText().toString().trim();
        String lastName = editLastName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String gitLink = editGitLink.getText().toString().trim();

        ApiInterface apiInterface = RetroFitClient.postInstance().create(ApiInterface.class);
        Call<Void> call = apiInterface.submit(email,firstName,lastName,gitLink);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    successDialog();
                    Toast.makeText(SubmitActivity.this, "post success", Toast.LENGTH_SHORT).show();
                }
                Log.d("TAG",response.code()+"");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("POSTFAILED",t.toString());
                Toast.makeText(SubmitActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                errorDialog();


            }
        });
    }

}