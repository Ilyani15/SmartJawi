package com.example.smartjawi.Eja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.Game.Cw.Cw_buahan;
import com.example.smartjawi.Game.Cw.Cw_haiwan;
import com.example.smartjawi.Game.Cw.Cw_nombor;
import com.example.smartjawi.Game.Cw.Cw_warna;
import com.example.smartjawi.R;

public class FirstEja extends AppCompatActivity {

    LinearLayout btn1;
    RelativeLayout btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_eja);

        ImageView close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.smartjawi.Eja.FirstEja.this, EjaActivity.class);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.satu);
        btn2 = findViewById(R.id.dua);
        btn3 = findViewById(R.id.tiga);
        btn4 = findViewById(R.id.empat);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.smartjawi.Eja.FirstEja.this, QuestionEjaActivity.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.smartjawi.Eja.FirstEja.this, QuestionEjaActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.smartjawi.Eja.FirstEja.this, QuestionEjaActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.smartjawi.Eja.FirstEja.this, QuestionEjaActivity.class);
                startActivity(intent);
            }
        });

    }
}