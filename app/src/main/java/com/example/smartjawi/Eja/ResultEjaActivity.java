package com.example.smartjawi.Eja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.smartjawi.R;


public class ResultEjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_eja);

        TextView textResult = (TextView) findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        textResult.setText(getString(R.string.score_eja)+ " " + score);

        ImageButton b1 = (ImageButton) findViewById(R.id.replay_eja_btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultEjaActivity.this, EjaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void playagain(View o) {
        Intent intent = new Intent(this, QuestionEjaActivity.class);
        startActivity(intent);
    }

}