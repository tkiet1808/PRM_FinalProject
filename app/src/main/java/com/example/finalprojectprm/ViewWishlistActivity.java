package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ViewWishlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wishlist);
    }

    public void backToHome_event(View v){
        Toast.makeText(v.getContext(), "back to home!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewWishlistActivity.this,HomeActivity.class);
        startActivity(i);
    }
    public void viewProfile_event(View v){
        Toast.makeText(v.getContext(), "View Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewWishlistActivity.this,ViewProfileActivity.class);
        startActivity(i);
    }
}