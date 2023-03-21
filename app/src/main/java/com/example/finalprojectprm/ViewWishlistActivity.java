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
import Adapter.PostAdapter_Wishlist;
import Model.MyApplication;
import Model.PostList;
import Model.StatusResponse;
import Model.Wish;
import Model.WishRequest;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewWishlistActivity extends AppCompatActivity {

    private RecyclerView rcvPost;
    private PostAdapter_Wishlist postAdapter;
    private JsonPlaceHolder apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wishlist);
        Intent i = getIntent();
        if (i.hasExtra("remove_wish_id")){
            remove_wishlist(i.getStringExtra("remove_wish_id"));
        }
        rcvPost = findViewById(R.id.rcv_post);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rcvPost.setLayoutManager(linearLayoutManager);

        postAdapter = new PostAdapter_Wishlist(this);
        postAdapter.setPostData(getListPost());
//        rcvPost.setAdapter(postAdapter);
//        postAdapter.notifyDataSetChanged();

        rcvPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();

    }

    private void remove_wishlist(String post_id) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.deleteWish(WishRequest.builder().post_id(post_id).user_id(((MyApplication) this.getApplication()).getUser_id()).build()).enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        StatusResponse d = response.body();
                        if (d.getStatus()==0){

                            Toast.makeText( ViewWishlistActivity.this, "Removed from wishlist", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ViewWishlistActivity.this, ViewWishlistActivity.class);
                            startActivity(i);
                        }


                    } else {
                        Toast.makeText(ViewWishlistActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ViewWishlistActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(ViewWishlistActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
                                            .description(d.getPost().getDescription())
                                            .category_name(d.getPost().getCategory_name())
                                    .price(d.getPost().getPrice())
                                            .id(d.getPost().getId())
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