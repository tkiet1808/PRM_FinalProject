package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

         ImageView copyImage = findViewById(R.id.copy_icon);
         copyImage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                 ClipData clipData = ClipData.newPlainText("bankAccount","10112331125");
                 clipboardManager.setPrimaryClip(clipData);

                 Toast.makeText(DepositActivity.this,"Copied",Toast.LENGTH_SHORT).show();
             }
         });
    }
}