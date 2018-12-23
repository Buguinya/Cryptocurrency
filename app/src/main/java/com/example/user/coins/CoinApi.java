package com.example.user.coins;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinApi {

    @GET("ticker")
    Call<List<Coin>> ticker();
}
