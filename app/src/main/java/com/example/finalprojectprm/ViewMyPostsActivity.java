package com.example.finalprojectprm;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewMyPostsActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private MyPostAdapter myPostAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_my_posts);
//
//        // Set up toolbar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        // Set up RecyclerView
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//        myPostAdapter = new MyPostAdapter(this);
//        recyclerView.setAdapter(myPostAdapter);
//
//        // Load posts from database
//        loadPosts();
//    }
//
//    private void loadPosts() {
//        // TODO: Load posts from database and pass them to myPostAdapter
//        // Sample data
//        ArrayList<MyPost> myPosts = new ArrayList<>();
//        myPosts.add(new MyPost("Title 1", R.drawable.image1, "Description 1", "Condition 1", "Brand 1", "Warranty Status 1"));
//        myPosts.add(new MyPost("Title 2", R.drawable.image2, "Description 2", "Condition 2", "Brand 2", "Warranty Status 2"));
//        myPosts.add(new MyPost("Title 3", R.drawable.image3, "Description 3", "Condition 3", "Brand 3", "Warranty Status 3"));
//        myPostAdapter.setMyPosts(myPosts);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == android.R.id.home) {
//            onBackPressed();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
