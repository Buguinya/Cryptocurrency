package com.example.user.coins;

import com.google.gson.annotations.SerializedName;

class Coin {
    public String id;
    public String name;
    public String symbol;
    @SerializedName("percent_change_1h")
    public Double percentChange;
    @SerializedName("price_usd")
    public Double priceUsd;
}
