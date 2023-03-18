package com.example.finalprojectprm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import API_URL.JsonPlaceHolder;
import Model.EditUserModel;
import Model.LoginRequest;
import Model.MyApplication;
import Model.StatusResponse;
import Model.User;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    Button googleBtn;
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tx = (TextView)findViewById(R.id.clickToSignUp);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


//        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        gsc = GoogleSignIn.getClient(this,gso);
//
//        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//        if(acct != null){
//            navigateToSecondActivity();
//        }

//        Intent intent = getIntent();
//        if (intent.hasExtra("registerSuccess")) {
//            //??????
//        }
    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }


    public void login_event(View view){
        TextInputEditText phone = findViewById(R.id.phone_number);
        TextInputEditText password = findViewById(R.id.password);
        if (!phone.getText().equals("")&&!password.getText().equals("")){
//            loginUser(new LoginRequest(phone.getText().toString(),password.getText().toString()));
            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
        } else Toast.makeText(LoginActivity.this, "Please fill in data!", Toast.LENGTH_SHORT).show();
    }

    private void loginUser(LoginRequest loginRequest) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.login(loginRequest).enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        StatusResponse loginResponse = response.body();
                        if (loginResponse.getStatus()==0){
                            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                            // set
                            ((MyApplication)getApplication()).setUser_id("???");
                            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else
                            Toast.makeText(LoginActivity.this, "Login Fail!", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(LoginActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Login fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void register_event(View view){
        Toast.makeText(LoginActivity.this, "Register", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }
}