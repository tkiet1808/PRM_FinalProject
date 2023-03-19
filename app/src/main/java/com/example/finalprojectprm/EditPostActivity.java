package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import API_URL.JsonPlaceHolder;
import Model.MyApplication;
import Model.Post;
import Model.User;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPostActivity extends AppCompatActivity {


    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            getPostData(intent.getStringExtra("id"));
        }

    }


    private void getPostData(String post_id) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getPostDetails(post_id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        Post post = response.body();

                        TextView product = findViewById(R.id.productNameEditText);
                        TextView image = findViewById(R.id.propertiesEditText);
                        TextView des = findViewById(R.id.descriptionEditText);
                        TextView price = findViewById(R.id.priceEditText);

                        product.setText(post.getName());
                        image.setText(post.getImage());
                        des.setText(post.getDescription());
                        price.setText(post.getPrice().toString());

                    } else {
                        Toast.makeText(EditPostActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditPostActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(EditPostActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void edit_post_event(View view) {

    }
    public void cancel_edit_post_event(View view) {
        Toast.makeText(EditPostActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(EditPostActivity.this, ViewMyPostsActivity.class);
        startActivity(i);
    }
}