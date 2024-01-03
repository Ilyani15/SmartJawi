package com.example.smartjawi.Belajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.R;

public class WarnaJawi extends AppCompatActivity {

    LinearLayout btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warna_jawi);

        btn1 = findViewById(R.id.kuning);
        btn2 = findViewById(R.id.emas);
        btn3 = findViewById(R.id.hijau);
        btn4 = findViewById(R.id.purple);
        btn5 = findViewById(R.id.pink);
        btn6 = findViewById(R.id.hitam);
        btn7 = findViewById(R.id.putih);
        btn8 = findViewById(R.id.merah);
        btn9 = findViewById(R.id.biru);
        btn10 = findViewById(R.id.koko);
        btn11 = findViewById(R.id.orange);
        btn12 = findViewById(R.id.kelabu);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(WarnaJawi.this, HaiwanJawi.class);
                startActivity(intent);
            }
        });
    }
}
