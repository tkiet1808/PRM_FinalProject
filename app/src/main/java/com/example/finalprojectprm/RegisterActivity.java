package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import API_URL.JsonPlaceHolder;
import Model.MyApplication;
import Model.RegisterRequest;
import Model.StatusResponse;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView tx1 = (TextView) findViewById(R.id.clickToSignIn);
        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public void register_event(View view) {
        TextInputEditText phone = findViewById(R.id.phone);
        TextInputEditText password = findViewById(R.id.password);
        TextInputEditText name = findViewById(R.id.name);
        TextInputEditText address = findViewById(R.id.address);
        TextInputEditText email = findViewById(R.id.email);
        TextInputEditText confirm_password = findViewById(R.id.confirm_password);

        if (!phone.getText().equals("") && !password.getText().equals("")
                &&!name.getText().equals("") && !address.getText().equals("")
                &&!email.getText().equals("") && !confirm_password.getText().equals("")) {
            if (!confirm_password.getText().equals(password.getText()))
            register(new RegisterRequest(name.getText().toString(),address.getText().toString()
                    ,phone.getText().toString(),email.getText().toString()
                    ,password.getText().toString(),confirm_password.getText().toString()));
            else Toast.makeText(RegisterActivity.this, "password and confirm password are not match!", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(RegisterActivity.this, "Please fill in data!", Toast.LENGTH_SHORT).show();
    }

    private void register(RegisterRequest registerRequest) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.register(registerRequest).enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        StatusResponse loginResponse = response.body();
                        if (loginResponse.getStatus()==0){
                            Toast.makeText(RegisterActivity.this, "Register Successfully!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                            i.putExtra("registerSuccess","registerSuccess");
                            startActivity(i);
                        } else
                            Toast.makeText(RegisterActivity.this, "Register Fail!", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(RegisterActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Register fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}