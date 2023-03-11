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

import APIServices.JsonPlaceHolder;
import Adapter.DepositAdapter;
import Model.DepositRequest;
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
        depositAdapter.setDepositData(getListDeposit());
        rcvDeposit.setAdapter(depositAdapter);
        depositAdapter.notifyDataSetChanged();
    }

    //GetData API Function//
    private List<DepositRequest> getListDeposit() {
        List<DepositRequest> list = new ArrayList<>();
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

        DepositRequest depositRequest1 = new DepositRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("500.00"), 1);
        DepositRequest depositRequest2 = new DepositRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("1000.00"), 2);
        DepositRequest depositRequest3 = new DepositRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("250.50"), 3);
        DepositRequest depositRequest4 = new DepositRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("750.75"), 2);
        DepositRequest depositRequest5 = new DepositRequest(UUID.randomUUID(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new BigDecimal("1500.00"), 1);

        list.add(depositRequest1);
        list.add(depositRequest2);
        list.add(depositRequest3);
        list.add(depositRequest4);
        list.add(depositRequest5);


        return list;
    }
}
