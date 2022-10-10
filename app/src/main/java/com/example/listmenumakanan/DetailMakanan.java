package com.example.listmenumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMakanan extends AppCompatActivity {

    TextView txtNamaMakanan, txtDescMakanan, txtHargaMakanan;
    ImageView imgMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        txtNamaMakanan = findViewById(R.id.txtNamaMakanan);
        txtDescMakanan = findViewById(R.id.txtDescMakanan);
        txtHargaMakanan = findViewById(R.id.txtHargaMakanan);
        imgMakanan = findViewById(R.id.imgMakanan);

        String name = "";
        String desc = "";
        String price = "";
        int image = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            name = extras.getString("name");
            desc = extras.getString("desc");
            price = extras.getString("price");
            image = extras.getInt("image");
        }

        txtNamaMakanan.setText(name);
        txtDescMakanan.setText(desc);
        txtHargaMakanan.setText(price);
        imgMakanan.setImageResource(image);
    }
}