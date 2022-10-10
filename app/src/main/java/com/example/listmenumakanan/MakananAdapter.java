package com.example.listmenumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listmenumakanan.Makanan;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    private ArrayList<Makanan> listMakanan;
    private RecyclerViewClickListener listener;

    public MakananAdapter(ArrayList<Makanan> listMakanan, RecyclerViewClickListener listener) {
        this.listMakanan = listMakanan;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MakananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_makanan, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.ViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        holder.txtNama.setText(makanan.getNama());
        holder.txtDesc.setText(makanan.getDeskripsi());
        holder.txtHarga.setText(makanan.getHarga());
        holder.imgMakanan.setImageResource(makanan.getId_gambar());



    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtNama, txtDesc, txtHarga;
        public ImageView imgMakanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            txtHarga = (TextView) itemView.findViewById(R.id.txtHarga);
            imgMakanan = (ImageView) itemView.findViewById(R.id.imgMakanan);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}