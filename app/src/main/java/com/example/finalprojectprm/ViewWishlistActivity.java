package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import API_URL.JsonPlaceHolder;
import Model.MyApplication;
import Model.PostList;
import Model.Wish;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewWishlistActivity extends AppCompatActivity {

    private RecyclerView rcvPost;
    private Adapter.PostAdapter postAdapter;
    private JsonPlaceHolder apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wishlist);

        rcvPost = findViewById(R.id.rcv_post);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPost.setLayoutManager(linearLayoutManager);

        postAdapter = new Adapter.PostAdapter(this);
        postAdapter.setPostData(getListPost());
//        rcvPost.setAdapter(postAdapter);
//        postAdapter.notifyDataSetChanged();

        rcvPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();

    }

    //GetData API Function//
    private List<PostList> getListPost() {
        List<PostList> list = new ArrayList<>();
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getWishList(((MyApplication) this.getApplication()).getUser_id()).enqueue(new Callback<List<Wish>>() {
            @Override
            public void onResponse(Call<List<Wish>> call, Response<List<Wish>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        for (Wish d : response.body()) {
                            list.add(PostList.builder().id(d.getPost().getId())
                                    .image(d.getPost().getImage())
                                    .name(d.getPost().getName())
                                    .price(d.getPost().getPrice())
                                    .build());
                            postAdapter.notifyDataSetChanged();
                        }
                    } else {
                        Toast.makeText(ViewWishlistActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ViewWishlistActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Wish>> call, Throwable t) {
                Toast.makeText(ViewWishlistActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    return list;
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