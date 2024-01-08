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
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Quiz_ResultNombor extends AppCompatActivity {
    TextView textResult, name;
    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;
    String id = "Nombor";

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

                Intent intent = new Intent(Quiz_ResultNombor.this, QuizFragment.class);
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

            // Retrieve existing attempt count
            collectionReference.document("attempt_data").get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            // Document exists, retrieve the attempt count
                            Integer currentAttempts = documentSnapshot.getLong("attempts").intValue();

                            // Increment the attempt count
                            int newAttempts = currentAttempts + 1;

                            // Update the document with the new attempt count
                            Map<String, Object> data = new HashMap<>();
                            data.put("attempts", newAttempts);

                            collectionReference.document("attempt_data").set(data)
                                    .addOnSuccessListener(aVoid -> {
                                        // Quiz result and attempt count saved successfully
                                        Toast.makeText(Quiz_ResultNombor.this, "Quiz result and attempt count saved successfully", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(Quiz_ResultNombor.this, "Failed to save attempt count", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            // Document does not exist, create a new one with attempt count set to 1
                            Map<String, Object> data = new HashMap<>();
                            data.put("attempts", 1);

                            collectionReference.document("attempt_data").set(data)
                                    .addOnSuccessListener(aVoid -> {
                                        // Quiz result and attempt count saved successfully
                                        Toast.makeText(Quiz_ResultNombor.this, "Quiz result and attempt count saved successfully", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(Quiz_ResultNombor.this, "Failed to save attempt count", Toast.LENGTH_SHORT).show();
                                    });
                        }
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(Quiz_ResultNombor.this, "Failed to retrieve attempt count", Toast.LENGTH_SHORT).show();
                    });

            // Save the quiz result as before
            Map<String, Object> quizResultData = new HashMap<>();
            quizResultData.put("result", result);
            collectionReference.add(quizResultData);
        }
    }
}