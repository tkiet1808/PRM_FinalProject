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

        TextView fullname = findViewById(R.id.fullname);
        TextView email = findViewById(R.id.email);
        TextView phone = findViewById(R.id.phone);
        TextView address = findViewById(R.id.address);
        TextView balance = findViewById(R.id.moneyNumber);

        Intent intent = getIntent();
        if (intent.hasExtra("fullname")) {
            if (!intent.getStringExtra("fullname").equals(""))
                fullname.setText(intent.getStringExtra("fullname"));
        } else
            fullname.setText("");
        if (intent.hasExtra("email")) {
            if (!intent.getStringExtra("email").equals(""))
                email.setText(intent.getStringExtra("email"));
        } else
            email.setText("");
        if (intent.hasExtra("phone")) {
            if (!intent.getStringExtra("phone").equals(""))
                phone.setText(intent.getStringExtra("phone"));
        } else
            phone.setText("");
        if (intent.hasExtra("address")) {
            if (!intent.getStringExtra("address").equals(""))
                address.setText(intent.getStringExtra("address"));
        } else
            address.setText("");
        if (intent.hasExtra("balance")) {
            if (!intent.getStringExtra("balance").equals(""))
                balance.setText(intent.getStringExtra("balance"));
        } else
            balance.setText("0");

    }

    private void updateUser(EditUserModel user) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.updateUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        Toast.makeText(EditProfileActivity.this, "Edit Successfully!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(EditProfileActivity.this, ViewProfileActivity.class);
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

    public void update_user_event(View view) {
        EditText fullname = findViewById(R.id.fullname);
        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);
        EditText address = findViewById(R.id.address);

        EditUserModel user = new EditUserModel();
        user.setId((UUID.fromString(((MyApplication) this.getApplication()).getUser_id())));
        user.setName(fullname.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setAddress(address.getText().toString());
//        Toast.makeText(EditProfileActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
        updateUser(user);
    }
    public void cancel_event(View view){
        Toast.makeText(EditProfileActivity.this, "Cancel!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(EditProfileActivity.this, ViewProfileActivity.class);
        startActivity(i);
    }

}