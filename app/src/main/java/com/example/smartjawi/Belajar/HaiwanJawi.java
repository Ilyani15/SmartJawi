package com.example.smartjawi.Belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartjawi.Fragments.BelajarFragment;
import com.example.smartjawi.R;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HaiwanJawi extends AppCompatActivity {

    LinearLayout btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haiwan_jawi);

        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);
        btn10 = findViewById(R.id.ten);

        ImageView close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HaiwanJawi.this, BelajarFragment.class);
                startActivity(intent);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, WarnaJawi.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HaiwanJawi.this, NomborJ.class);
                startActivity(intent);
            }
        });
    }
}
