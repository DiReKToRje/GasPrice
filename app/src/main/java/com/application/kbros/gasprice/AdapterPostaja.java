package com.application.kbros.gasprice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mojLibPack.Podatki;
import com.mojLibPack.Postaja;



class AdapterPostaja extends RecyclerView.Adapter<AdapterPostaja.ViewHolder> {
    Podatki all;
    Activity ac;



    public AdapterPostaja(Podatki all, Activity ac) {
        super();
        this.all = all;
        this.ac = ac;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView iv;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            iv = (ImageView)v.findViewById(R.id.icon);
        }
    }

 /*   public void add(int position,Oglas item) {
        mDataset.dodaj().add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    */

      @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    private static void startDView(String lokacijaID, Activity ac) {
      //  System.out.println(name+":"+position);
        Intent i = new Intent(ac.getBaseContext(), ActivityPostaja.class);
        i.putExtra(Podatki.POSTAJA_ID,  lokacijaID);
        ac.startActivity(i);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Postaja trenutni = all.getPostaja(position);
        final String name = trenutni.getName();
        holder.txtHeader.setText(name);

        if (position%2==1) {
            holder.itemView.setBackgroundColor(Color.GRAY);
        }
        else{
            holder.itemView.setBackgroundColor(Color.BLACK);
        }
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterPostaja.startDView(trenutni.getId(),ac);
            }
        });
        holder.txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterPostaja.startDView(trenutni.getId(),ac);
            }
        });

        holder.txtFooter.setText("95: " + trenutni.getCena95() + " ; 98: " + trenutni.getCena98() + " ; 100: " + trenutni.getCena100() + " ; Diesel: " + trenutni.getCenaDiesel() + " ; Plin: " + trenutni.getCenaPlin());
    }


    @Override
    public int getItemCount() {
        return all.getPostajeSize();
    }
}
