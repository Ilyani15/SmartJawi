package com.example.smartjawi.Game.VG;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartjawi.R;

public class VG_Sayur1 extends AppCompatActivity {

    ImageView questionImage;
    TextView btnOp1, btnOp2;
    int great7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vg_sayur1);

        questionImage = findViewById(R.id.questionImage);

        btnOp1 = findViewById(R.id.betul);
        btnOp2 = findViewById(R.id.salah);

        Intent intent = getIntent();
        int receivedData = intent.getIntExtra("RA", great7);

        btnOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp1.setBackgroundResource(R.drawable.closebg);
                btnOp2.setBackgroundResource(R.drawable.rightanswer);

                great7 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(VG_Sayur1.this, VG_Sayur2.class);
                        intent.putExtra("RA", great7);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });

        btnOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp2.setBackgroundResource(R.drawable.rightanswer);

                great7 = receivedData + 1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(VG_Sayur1.this, VG_Sayur2.class);
                        intent.putExtra("RA", great7);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });


        ImageView close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VG_Sayur1.this, FirstVG.class);
                startActivity(intent);
                finish();
            }
        });
    }
}