package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import API_URL.JsonPlaceHolder;
import Model.DepositRequest;
import Model.MyApplication;
import Model.User;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProfileActivity extends AppCompatActivity {
    private JsonPlaceHolder apiInterface;
private User resUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        getUser(((MyApplication)this.getApplication()).getUser_id());

        Button editPf = findViewById(R.id.edit_profile_button);
        editPf.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Edit Profile", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ViewProfileActivity.this,EditProfileActivity.class);
                i.putExtra("fullname", resUser.getName());
                i.putExtra("email", resUser.getEmail());
                i.putExtra("phone", resUser.getPhone());
                i.putExtra("address", resUser.getAddress());
                startActivity(i);
            }
        });
    }
    private void getUser(String user_id) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getUser(user_id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        resUser = response.body();

                        TextView fullname = findViewById(R.id.fullname);
                        TextView email = findViewById(R.id.email);
                        TextView phone = findViewById(R.id.phone);
                        TextView address = findViewById(R.id.address);
                        TextView balance = findViewById(R.id.balance);

                        fullname.setText(resUser.getName());
                        email.setText(resUser.getEmail());
                        phone.setText(resUser.getPhone());
                        address.setText(resUser.getAddress());
                        if (resUser.getBalance()!=null){
                            balance.setText(resUser.getBalance().toString());
                        } else {
                            balance.setText("0");
                        }

                    } else {
                        Toast.makeText(ViewProfileActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ViewProfileActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(ViewProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}