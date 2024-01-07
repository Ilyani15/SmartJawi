package com.example.smartjawi.Quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.QuizFragment;
import com.example.smartjawi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Quiz_ResultHaiwan extends AppCompatActivity {

    TextView textResult, name;
    FirebaseUser firebaseUser;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_result_buah);

        textResult = findViewById(R.id.textResult);
        name = findViewById(R.id.name);


        textResult.setText("You Answered "+ getIntent().getIntExtra("RA", 0)+ " / 5");

        TextView close = findViewById(R.id.yay);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz_ResultHaiwan.this, QuizFragment.class);
                startActivity(intent);
                finish();
            }
        });
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        if (firebaseUser != null) {
            // The user is authenticated, you can access user information
            String username = firebaseUser.getDisplayName();

            // Check if the username is available
            if (username != null && !username.isEmpty()) {
                name.setText(username);
            } else {
                // If the username is not available, you can use the user's email or UID
                // For example:
                // String userEmail = firebaseUser.getEmail();
                // String uid = firebaseUser.getUid();
                // name.setText("Hello, " + userEmail + "!"); // or name.setText("Hello, " + uid + "!");
            }


        }
    }
}