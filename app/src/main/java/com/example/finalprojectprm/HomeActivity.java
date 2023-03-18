package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
    public void viewProfile_event(View view){
        Toast.makeText( HomeActivity.this, "View Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(HomeActivity.this, ViewProfileActivity.class);
        startActivity(i);
    }
    public void WishList_event(View view){
        Toast.makeText( HomeActivity.this, "View Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(HomeActivity.this, ViewWishlistActivity.class);
        startActivity(i);
    }
}