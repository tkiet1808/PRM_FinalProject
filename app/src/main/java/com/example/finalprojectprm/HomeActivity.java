package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import API_URL.JsonPlaceHolder;
import Adapter.PostAdapter;
import Model.PostList;
import Model.Tag;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rcvPost;
    private PostAdapter postAdapter;
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rcvPost = findViewById(R.id.rcv_post);

        postAdapter = new PostAdapter(this);
        postAdapter.setPostData(getListPost());

        rcvPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
    }
//    private List<PostList> getSamplePost() {
//        List<PostList> list = new ArrayList<>();
//        list.add(new PostList(UUID.randomUUID(), "1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaVBHl3QCN-g-R1YnYSdpluWn_Vix5kDlb05Fnr7Oq&s", BigDecimal.ONE, new ArrayList<>()));
//        list.add(new PostList(UUID.randomUUID(), "2", "myimage", BigDecimal.ONE, new ArrayList<>()));
//        list.add(new PostList(UUID.randomUUID(), "3", "myimage", BigDecimal.ONE, new ArrayList<>()));
//        list.add(new PostList(UUID.randomUUID(), "4", "myimage", BigDecimal.ONE, new ArrayList<>()));
//        return list;
//    }
    //GetData API Function//
    private List<PostList> getListPost() {
        List<PostList> list = new ArrayList<>();
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getListPost().enqueue(new Callback<List<PostList>>() {
            @Override
            public void onResponse(Call<List<PostList>> call, Response<List<PostList>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        for (PostList d : response.body()) {
                            list.add(d);
                            postAdapter.notifyDataSetChanged();
                        }
                    } else {
                        Toast.makeText(HomeActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(HomeActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<PostList>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return list;
    }

    public void viewProfile_event(View view){
        Toast.makeText( HomeActivity.this, "View Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(HomeActivity.this, ViewProfileActivity.class);
        startActivity(i);
    }
    public void WishList_event(View view){
        Toast.makeText( HomeActivity.this, "Wishlist", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(HomeActivity.this, ViewWishlistActivity.class);
        startActivity(i);
    }
}