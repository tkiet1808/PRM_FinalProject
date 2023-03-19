package com.example.finalprojectprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import API_URL.JsonPlaceHolder;
import Adapter.DepositAdapter;
import Model.DepositRequest;
import Model.MyApplication;
import RetroFitInstance.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDepositHistoryActivity extends AppCompatActivity {

    private RecyclerView rcvDeposit;
    private DepositAdapter depositAdapter;
    private JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_deposit_history);
        rcvDeposit = findViewById(R.id.rcvDeposit);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvDeposit.setLayoutManager(linearLayoutManager);

        depositAdapter = new DepositAdapter(this);
        depositAdapter.setDepositData(getListDeposit(((MyApplication)this.getApplication()).getUser_id()));

        rcvDeposit.setAdapter(depositAdapter);
        depositAdapter.notifyDataSetChanged();
    }

    //GetData API Function//
    private List<DepositRequest> getListDeposit(String user_id) {
        List<DepositRequest> list = new ArrayList<>();
        apiInterface = RetrofitInstance.getRetrofit().create(JsonPlaceHolder.class);
        apiInterface.getListDeposit(user_id).enqueue(new Callback<List<DepositRequest>>() {
            @Override
            public void onResponse(Call<List<DepositRequest>> call, Response<List<DepositRequest>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        for (DepositRequest d : response.body()) {
                            list.add(d);
                        }
                        depositAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ViewDepositHistoryActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ViewDepositHistoryActivity.this, "Connect fail!", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<DepositRequest>> call, Throwable t) {
                Toast.makeText(ViewDepositHistoryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return list;
    }
    public void profile_event(View v){
        Toast.makeText(v.getContext(), "My Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewDepositHistoryActivity.this,ViewProfileActivity.class);
        startActivity(i);
    }
    public void backToHome_event(View v){
        Toast.makeText(v.getContext(), "back to home!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewDepositHistoryActivity.this,HomeActivity.class);
        startActivity(i);
    }
    public void viewProfile_event(View v){
        Toast.makeText(v.getContext(), "View Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ViewDepositHistoryActivity.this,ViewProfileActivity.class);
        startActivity(i);
    }

}
