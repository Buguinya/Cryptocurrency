package com.example.user.coins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private CoinsAdapter coinsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        coinsAdapter = new CoinsAdapter();
        recyclerView.setAdapter(coinsAdapter);


        loadData();


    }

    private void loadData() {

        App.getCoinApi().ticker().enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                Log.d("MainActivity", "onResponse: ");
                List<Coin> coins = response.body();
                coinsAdapter.setCoins(coins);
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t);
            }
        });
    }
}
