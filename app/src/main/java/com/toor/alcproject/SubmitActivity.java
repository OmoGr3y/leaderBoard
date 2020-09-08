package com.toor.alcproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit = builder.build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        final EditText firstName = (EditText) findViewById(R.id.first_name);
        final EditText lastName = (EditText) findViewById(R.id.last_name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText project = (EditText) findViewById(R.id.project);

        findViewById(R.id.btn_execute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeSendFeedbackForm(
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        email.getText().toString(),
                        project.getText().toString()
                );
            }
        });





    }

    private void executeSendFeedbackForm(String firstname, String lastname, String email, String project) {

        UserClient userClient = retrofit.create(UserClient.class);
        Call<ResponseBody> call =  userClient.sendUserFeedback(
                firstname, lastname, email, project
        );

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
              openDialog();

                
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(SubmitActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openDialog() {


        Intent intent = new Intent(this, ProceedActivity.class);
        startActivity(intent);
        finish();
    }
}