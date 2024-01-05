package com.example.smartjawi.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.QuizFragment;
import com.example.smartjawi.R;

public class Quiz_Haiwan3 extends AppCompatActivity {

    ImageView questionImage;
    TextView btnOp1, btnOp2, btnOp3, btnOp4;
    int great1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_haiwan3);


        questionImage = findViewById(R.id.questionImage);

        btnOp1 = findViewById(R.id.kuda);
        btnOp2 = findViewById(R.id.arnab);
        btnOp3 = findViewById(R.id.kucing);
        btnOp4 = findViewById(R.id.monyet);

        Intent intent = getIntent();
        int receivedData = intent.getIntExtra("RA", great1);

        btnOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOp1.setBackgroundResource(R.drawable.closebg);
                btnOp3.setBackgroundResource(R.drawable.rightanswer);

                great1 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Quiz_Haiwan3.this, Quiz_Haiwan4.class);
                        intent.putExtra("RA", great1);
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


                great1 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Quiz_Haiwan3.this, Quiz_Haiwan4.class);
                        intent.putExtra("RA", great1);
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

                great1 = receivedData + 1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Quiz_Haiwan3.this, Quiz_Haiwan4.class);
                        intent.putExtra("RA", great1);
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

                great1 = receivedData + 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Quiz_Haiwan3.this, Quiz_Haiwan4.class);
                        intent.putExtra("RA", great1);
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
                Intent intent = new Intent(Quiz_Haiwan3.this, QuizFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}