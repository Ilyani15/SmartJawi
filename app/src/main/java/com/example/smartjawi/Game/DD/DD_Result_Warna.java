package com.example.smartjawi.Game.DD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.R;

public class DD_Result_Warna extends AppCompatActivity {

    TextView textResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_result_buah);

        textResult = findViewById(R.id.textResult);

        textResult.setText("You Answered "+ getIntent().getIntExtra("RA", 0)+ " / 5");

        TextView close = findViewById(R.id.yay);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DD_Result_Warna.this, GameFragment.class);
                startActivity(intent);
                finish();
            }
        });

    }
}