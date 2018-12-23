package com.example.user.coins;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private final String BASE_URL = "https://api.coinmarketcap.com/v1/";

    private static CoinApi coinApi;
    private Retrofit retrofit;

    public static CoinApi getCoinApi() {
        return coinApi;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        coinApi = retrofit.create(CoinApi.class);


    }
}
