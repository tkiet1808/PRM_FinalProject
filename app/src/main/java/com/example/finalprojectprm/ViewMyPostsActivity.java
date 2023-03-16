package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



//import APIServices.JsonPlaceHolder;

//import RetroFitInstance.RetrofitInstance;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class ViewMyPostsActivity extends AppCompatActivity {

    private RecyclerView rcvPost;
    private PostAdapter postAdapter;
//    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_my_posts);
        rcvPost = findViewById(R.id.rcvPost);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPost.setLayoutManager(linearLayoutManager);

        postAdapter = new PostAdapter(this);
        postAdapter.setPostData(getListPost());
        rcvPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
    }

    //GetData API Function//
    private List<PostRequest> getListPost() {
        List<PostRequest> list = new ArrayList<>();
//        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
//        apiInterface.getListDeposit().enqueue(new Callback<List<DepositRequest>>() {
//            @Override
//            public void onResponse(Call<List<DepositRequest>> call, Response<List<DepositRequest>> response) {
//                if (response.isSuccessful()) {
//
//                    if (response.body() != null) {
//
//                        for (DepositRequest d : response.body()) {
//                            list.add(d);
//                        }
//                    } else {
//                        Toast.makeText(ViewDepositHistoryActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(ViewDepositHistoryActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<List<DepositRequest>> call, Throwable t) {
//                Toast.makeText(ViewDepositHistoryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


        PostRequest postRequest1 = new PostRequest(UUID.randomUUID(), "s", "//", "Good", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("500.00"), new BigDecimal("500.00"), 1);


//        PostRequest postRequest1 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("500.00"), 1);
//        PostRequest postRequest2 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("1000.00"), 2);
//        PostRequest postRequest3 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("250.50"), 3);
//        PostRequest postRequest4 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("750.75"), 2);
//        PostRequest postRequest5 = new PostRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("1500.00"), 1);

        list.add(postRequest1);
//        list.add(postRequest2);
//        list.add(postRequest3);
//        list.add(postRequest4);
//        list.add(postRequest5);


        return list;
    }
}
