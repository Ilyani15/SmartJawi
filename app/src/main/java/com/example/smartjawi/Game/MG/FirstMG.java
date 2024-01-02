package com.example.smartjawi.Game.MG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.Game.DD.DD_Game_Buah1;
import com.example.smartjawi.Game.DD.DD_Game_Haiwan1;
import com.example.smartjawi.Game.DD.DD_Game_Nombor1;
import com.example.smartjawi.Game.DD.DD_Game_Warna1;
import com.example.smartjawi.R;

public class FirstMG extends AppCompatActivity {

    LinearLayout btn1;
    RelativeLayout btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_mg);

        ImageView close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMG.this, GameFragment.class);
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
                Intent intent = new Intent(FirstMG.this, DD_Game_Haiwan1.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMG.this, DD_Game_Buah1.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMG.this, DD_Game_Warna1.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMG.this, DD_Game_Nombor1.class);
                startActivity(intent);
            }
        });
    }
}