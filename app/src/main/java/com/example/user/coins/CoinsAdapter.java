package com.example.user.coins;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinViewHolder> {

    private List<Coin> coins = Collections.emptyList();

    private static Random random = new Random();
    private static Context context;

    private static int[] colors = {
            0xFF4A148C,
            0xFF311B92,
            0xFF004D40,
            0xFF43A047,
            0xFFE65100,
            0xFF212121,
            0xFFFF3D00,
    };


    public void setCoins(List<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }

    @Override
    public CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_item, parent, false);
        return new CoinViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(CoinViewHolder holder, int position) {
        holder.bind(coins.get(position));
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    public static class CoinViewHolder extends RecyclerView.ViewHolder {

        private TextView symbol;
        private TextView name;
        private TextView priceUsd;
        private TextView percentChange;

        public CoinViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            symbol = itemView.findViewById(R.id.symbol);
            name = itemView.findViewById(R.id.name);
            priceUsd = itemView.findViewById(R.id.priceUsd);
            percentChange = itemView.findViewById(R.id.percentChange);


        }

        @SuppressLint("SetTextI18n")
        public void bind(Coin coin){
            symbol.setText(coin.symbol);

            Drawable background = symbol.getBackground();
            Drawable wrapper = DrawableCompat.wrap(background);
            DrawableCompat.setTint(wrapper, colors[random.nextInt(colors.length)]);


            name.setText(coin.name);


            priceUsd.setText(context.getString(R.string.price_usd, coin.priceUsd));


            percentChange.setText(context.getString(R.string.percent_change, coin.percentChange));
        }
    }
}
