package com.example.smartjawi.Quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.QuizFragment;
import com.example.smartjawi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Quiz_ResultWarna extends AppCompatActivity {

    TextView textResult, name;
    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;
    String id = "Warna";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_result_warna);

        textResult = findViewById(R.id.textResult);
        name = findViewById(R.id.name);
        textResult.setText("You Answered " + getIntent().getIntExtra("RA", 0) + " / 5");

        TextView close = findViewById(R.id.yay);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the quiz result to Firestore
                saveQuizResult(getIntent().getIntExtra("RA", 0));

                Intent intent = new Intent(Quiz_ResultWarna.this, QuizFragment.class);
                startActivity(intent);
                finish();
            }
        });

        firestore = FirebaseFirestore.getInstance();
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

    private void saveQuizResult(int result) {
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            CollectionReference collectionReference = firestore.collection("users").document(userId).collection("quiz").document(id).collection("attempts");

            // Reference to the attempt_data document
            DocumentReference attemptDataRef = collectionReference.document("attempt_data");

            // Save the attempt count and quiz result
            Map<String, Object> data = new HashMap<>();
            data.put("attempts", 1); // Set attempt count to 1
            data.put("result", result); // Save the quiz result

            // Use set to overwrite the existing document or create a new one
            attemptDataRef.set(data)
                    .addOnSuccessListener(aVoid -> {
                        // Quiz result and attempt count saved successfully
                        Toast.makeText(Quiz_ResultWarna.this, "Quiz result and attempt count saved successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(Quiz_ResultWarna.this, "Failed to save quiz result and attempt count", Toast.LENGTH_SHORT).show();
                    });
        }
    }



}
