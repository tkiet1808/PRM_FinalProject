package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import API_URL.JsonPlaceHolder;
import Model.MyApplication;
import Model.PostList;
import RetroFitInstance.RetrofitInstance;



import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewMyPostsActivity extends AppCompatActivity {

    private RecyclerView rcvPost;
    private Adapter.PostAdapter_Edit postAdapter;
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_my_posts);
        rcvPost = findViewById(R.id.rcvPost);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPost.setLayoutManager(linearLayoutManager);

        postAdapter = new Adapter.PostAdapter_Edit(this);
        postAdapter.setPostData(getListPost());
//        rcvPost.setAdapter(postAdapter);
//        postAdapter.notifyDataSetChanged();

        rcvPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
    }
//    private List<PostList> getSamplePost() {
//
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
        apiInterface.getMyPost(((MyApplication) this.getApplication()).getUser_id()).enqueue(new Callback<List<PostList>>() {
            @Override
            public void onResponse(Call<List<PostList>> call, Response<List<PostList>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        for ( PostList d : response.body()) {
                            list.add(d);
                            postAdapter.notifyDataSetChanged();
                        }
                    } else {
                        Toast.makeText(ViewMyPostsActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ViewMyPostsActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<PostList>> call, Throwable t) {
                Toast.makeText(ViewMyPostsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        PostRequest postRequest1 = new PostRequest(UUID.randomUUID(), "s", "//", "Good", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("500.00"), new BigDecimal("500.00"), 1);


//        PostRequest postRequest1 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("500.00"), 1);
//        PostRequest postRequest2 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("1000.00"), 2);
//        PostRequest postRequest3 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("250.50"), 3);
//        PostRequest postRequest4 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("750.75"), 2);
//        PostRequest postRequest5 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("1500.00"), 1);

//        list.add(postRequest1);
//        list.add(postRequest2);
//        list.add(postRequest3);
//        list.add(postRequest4);
//        list.add(postRequest5);


        return list;
    }
    public void createPost_event(View view) {
        Toast.makeText(ViewMyPostsActivity.this, "Create Post!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewMyPostsActivity.this, CreatePostActivity.class);
        startActivity(i);
    }
    public void detailPost_event(View view) {
        Toast.makeText(ViewMyPostsActivity.this, "Create Post!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewMyPostsActivity.this, ViewPostDetailsActivity.class);
        startActivity(i);
    }
    public void backToProfile_event(View view) {
        Toast.makeText(ViewMyPostsActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewMyPostsActivity.this, ViewProfileActivity.class);
        startActivity(i);
    }
}
