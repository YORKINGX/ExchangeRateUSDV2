package com.administrador.ratechangeusd.activities.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrador.ratechangeusd.R;
import com.administrador.ratechangeusd.activities.model.RateCoinsBase;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Administrador on 27/07/2017.
 */

public class RatesCoinAdapter extends RecyclerView.Adapter <RatesCoinAdapter.RatesCoinAvilableViewHolder>{

    Context mContext;
    ArrayList<RateCoinsBase> mLocalRatesCoin;

    public RatesCoinAdapter() {
    }

    public RatesCoinAdapter(Context mContext, ArrayList<RateCoinsBase> mLocalRatesCoin) {
        this.mContext = mContext;
        this.mLocalRatesCoin = mLocalRatesCoin;
    }

    @Override
    public RatesCoinAvilableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view_rates = LayoutInflater.from(parent.getContext()).inflate(R.layout.iten_coin_layout,parent,false);
        RatesCoinAdapter.RatesCoinAvilableViewHolder vh_coin = new RatesCoinAdapter.RatesCoinAvilableViewHolder(view_rates);
        return vh_coin;
    }

    @Override
    public void onBindViewHolder(RatesCoinAvilableViewHolder holder, int position) {
        Bundle bundle =new Bundle();

        //String value = String.valueOf(mLocalRatesCoin.get(position).getRateCoin());
        DecimalFormat df = new DecimalFormat("#.####");
        String outRate = df.format(mLocalRatesCoin.get(position).getRateCoin());
        holder.coinRatechange.setText(outRate);
        holder.flagCoin.setImageResource(mLocalRatesCoin.get(position).getIdImagen());
        holder.coinBase.setText(mLocalRatesCoin.get(position).getSimbolCoin());
        holder.desCoin.setText(mLocalRatesCoin.get(position).getDesCoin());




        //bundle.putString("flagCoin",String.valueOf(mLocalRatesCoin. );
        //  bundle.putString("inputRatechange",String.valueOf(mLocalRatesCoin.get(position).getGBP()));
       // bundle.putString("coinBase",peopleModelArrayList.get(position).getName());
       // bundle.putString("viewLn",peopleModelArrayList.get(position).getApellido());
       // bundle.putString("detalGraphic",peopleModelArrayList.get(position).getFecha_nacimiento());




    }

    @Override
    public int getItemCount() {
        return mLocalRatesCoin.size();
    }


    View itemView;
    public class RatesCoinAvilableViewHolder extends RecyclerView.ViewHolder{


        ImageView flagCoin;
        TextView coinBase;
        TextView coinRatechange;
        TextView desCoin;
        TextView changeCoin;

        ImageButton detalGraphic;



        public RatesCoinAvilableViewHolder(View itemView) {
            super(itemView);

            flagCoin = (ImageView)  itemView.findViewById(R.id.flagCoin);
            coinBase = (TextView) itemView.findViewById(R.id.simbolCoin);
            coinRatechange = (TextView) itemView.findViewById(R.id.changeCoin);
            desCoin = (TextView) itemView.findViewById(R.id.descCoin);
            changeCoin = (TextView) itemView.findViewById(R.id.changeCoin);
            detalGraphic = (ImageButton) itemView.findViewById(R.id.graphicCoin);


        }
    }

}
