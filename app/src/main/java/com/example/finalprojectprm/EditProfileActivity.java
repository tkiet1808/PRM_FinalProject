package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import API_URL.JsonPlaceHolder;
import Model.EditUserModel;
import Model.MyApplication;
import Model.User;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


    }

    private void updateUser(EditUserModel user) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.updateUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        Toast.makeText(EditProfileActivity.this, "Edit Successfully!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(EditProfileActivity.this,ViewProfileActivity.class);
                        startActivity(i);

                    } else {
                        Toast.makeText(EditProfileActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(EditProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void update_user_event(View view){
        EditText fullname = findViewById(R.id.fullname);
        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);
        EditText address = findViewById(R.id.address);

        EditUserModel user = new EditUserModel();
        user.setId((UUID.fromString(((MyApplication)this.getApplication()).getUser_id())));
        user.setName(fullname.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setAddress(address.getText().toString());

        updateUser(user);
    }
}