package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import API_URL.JsonPlaceHolder;
import Adapter.CategoryAdapter;
import Model.Category;
import Model.MyApplication;
import Model.Post;
import Model.PostFormRequest;
import Model.StatusResponse;
import Model.User;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPostActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            getPostData(intent.getStringExtra("id"));
        }
        rcvCategory = findViewById(R.id.rcv_category);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter = new CategoryAdapter(this);
        categoryAdapter.setCategoryList(getListCate());

        rcvCategory.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

    }


    private void getPostData(String post_id) {
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getPostDetails(post_id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        Post post = response.body();
                        TextView product = findViewById(R.id.edit_post_productNameEditText);
                        TextView image = findViewById(R.id.edit_post_propertiesEditText);
                        TextView des = findViewById(R.id.edit_post_descriptionEditText);
                        TextView price = findViewById(R.id.edit_post_priceEditText);
                        TextView cateId = findViewById(R.id.edit_post_category_id);
                        TextView postId = findViewById(R.id.edit_post_post_id);
                        ImageView img = findViewById(R.id.edit_post_image);

                        product.setText(post.getName());
                        image.setText(post.getImage());
                        des.setText(post.getDescription());
                        price.setText(post.getPrice().toString());
                        cateId.setText(post.getCategory_id());
                        postId.setText(post.getId().toString());
                        Picasso.get().load(post.getImage()).placeholder(R.drawable.noimage).error(R.drawable.noimage).into(img);


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

    private List<Category> getListCate() {
        List<Category> list = new ArrayList<>();
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        for (Category d : response.body()) {
                            list.add(d);
                            categoryAdapter.notifyDataSetChanged();
                        }
                    } else {
                        Toast.makeText(EditPostActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditPostActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(EditPostActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return list;
    }

    private List<Category> getSampleList() {
        List<Category> list = new ArrayList<>();
        list.add(Category.builder().id(1).name("Laptops").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(2).name("Smartphones").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(3).name("RAM").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(4).name("CPU").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(5).name("SSD").description("asdf").fee(BigDecimal.TEN).build());
        return list;
    }


    public void edit_post_event(View view) {
        TextView product = findViewById(R.id.edit_post_productNameEditText);
        TextView image = findViewById(R.id.edit_post_propertiesEditText);
        TextView des = findViewById(R.id.edit_post_descriptionEditText);
        TextView price = findViewById(R.id.edit_post_priceEditText);
        TextView cateId = findViewById(R.id.edit_post_category_id);
        TextView postId = findViewById(R.id.edit_post_post_id);

        PostFormRequest postFormRequest = PostFormRequest.builder()
                .user_id(((MyApplication) this.getApplication()).getUser_id())
                .image(image.getText().toString())
                .description(des.getText().toString())
                .price(new BigDecimal(price.getText().toString()))
                .category_id(Integer.valueOf(cateId.getText().toString()))
                .name(product.getText().toString())
                .id(postId.getText().toString())
                .build();

        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.updatePost(postFormRequest).enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        StatusResponse d = response.body();
                        if (d.getStatus()==0){

                            Toast.makeText(EditPostActivity.this, "Edit Successfully!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(EditPostActivity.this, ViewMyPostsActivity.class);
                            startActivity(i);
                        }


                    } else {
                        Toast.makeText(EditPostActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditPostActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(EditPostActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void cancel_edit_post_event(View view) {
        Toast.makeText(EditPostActivity.this, "My Post!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(EditPostActivity.this, ViewMyPostsActivity.class);
        startActivity(i);
    }
}