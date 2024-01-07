package com.example.smartjawi.Quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.QuizFragment;
import com.example.smartjawi.R;

public class Quiz_Warna5 extends AppCompatActivity {

    ImageView questionImage;
    TextView btnOp1, btnOp2, btnOp3, btnOp4;
    int great2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_warna5);

        questionImage = findViewById(R.id.questionImage);

        btnOp1 = findViewById(R.id.biru);
        btnOp2 = findViewById(R.id.merah);
        btnOp3 = findViewById(R.id.ungu);
        btnOp4 = findViewById(R.id.hijau);

        Intent intent = getIntent();
        int receivedData = intent.getIntExtra("RA", great2);

        btnOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp1.setBackgroundResource(R.drawable.closebg);
                btnOp3.setBackgroundResource(R.drawable.rightanswer);

                great2 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer media = MediaPlayer.create(Quiz_Warna5.this, R.raw.wrong);
                        media.start();
                        Intent intent = new Intent(Quiz_Warna5.this, Quiz_ResultWarna.class);
                        intent.putExtra("RA", great2);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });

        btnOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp2.setBackgroundResource(R.drawable.closebg);
                btnOp3.setBackgroundResource(R.drawable.rightanswer);

                great2 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer media = MediaPlayer.create(Quiz_Warna5.this, R.raw.wrong);
                        media.start();
                        Intent intent = new Intent(Quiz_Warna5.this, Quiz_ResultWarna.class);
                        intent.putExtra("RA", great2);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });

        btnOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp3.setBackgroundResource(R.drawable.rightanswer);

                great2 = receivedData + 1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer media = MediaPlayer.create(Quiz_Warna5.this, R.raw.correct);
                        media.start();
                        Intent intent = new Intent(Quiz_Warna5.this, Quiz_ResultWarna.class);
                        intent.putExtra("RA", great2);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });

        btnOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp4.setBackgroundResource(R.drawable.closebg);
                btnOp3.setBackgroundResource(R.drawable.rightanswer);

                great2 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer media = MediaPlayer.create(Quiz_Warna5.this, R.raw.wrong);
                        media.start();
                        Intent intent = new Intent(Quiz_Warna5.this, Quiz_ResultWarna.class);
                        intent.putExtra("RA", great2);
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
                Intent intent = new Intent(Quiz_Warna5.this, QuizFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}