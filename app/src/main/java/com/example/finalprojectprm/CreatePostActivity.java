package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import API_URL.JsonPlaceHolder;
import Adapter.CategoryAdapter;
import Model.Category;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Callback;

public class CreatePostActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        rcvCategory = findViewById(R.id.rcv_category);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter = new CategoryAdapter(this);
        categoryAdapter.setCategoryList(getSampleList());

        rcvCategory.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
//    private List<Category> getCategoryList() {
//        List<Category> list = new ArrayList<>();
//        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
//        apiInterface.getCategories().enqueue(new Callback<List<Category>>() {
//
//        });
//        return list;
//    }

    private List<Category> getSampleList() {
        List<Category> list = new ArrayList<>();
        list.add(Category.builder().id(1).name("Laptops").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(2).name("Smartphones").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(3).name("RAM").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(4).name("CPU").description("asdf").fee(BigDecimal.TEN).build());
        list.add(Category.builder().id(5).name("SSD").description("asdf").fee(BigDecimal.TEN).build());
        return list;
    }
}