package com.example.listmenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recMakanan;
    private ArrayList<Makanan> listMakanan;
    private MakananAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMakanan = findViewById(R.id.rec_makanan);
        initData();

        setOnClickListener();
        recMakanan.setAdapter(new MakananAdapter(listMakanan, listener));
        recMakanan.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setOnClickListener() {
        listener = new MakananAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailMakanan.class);
                intent.putExtra("name", listMakanan.get(position).getNama());
                intent.putExtra("desc", listMakanan.get(position).getDeskripsi());
                intent.putExtra("price", listMakanan.get(position).getHarga());
                intent.putExtra("image", listMakanan.get(position).getId_gambar());
                startActivity(intent);
            }
        };
    }

    private void initData(){
        this.listMakanan = new ArrayList<>();
        listMakanan.add(new Makanan("Gilgeori Toast", "Korean Sandwich\ndengan isian telur, keju, bacon", "45.000", R.drawable.gilgeori_toast));
        listMakanan.add(new Makanan("Japanase Scrambled Egg", "Scrambled Egg khas Jepang\nyang dituangkan pada nasi\ndan ditaburi nori", "35.000", R.drawable.japanese_scrambled_egg));
        listMakanan.add(new Makanan("Mie Gacoan", "Mie Pedas\ndengan banyak isian di dalamnya", "30.000", R.drawable.mie_gacoan));
        listMakanan.add(new Makanan("Waffle", "Waffle manis dengan vanilla ice cream\ndan strawberry sebagai topping", "25.000", R.drawable.waffle));
    }
}