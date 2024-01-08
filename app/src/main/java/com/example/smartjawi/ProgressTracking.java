package com.example.smartjawi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartjawi.Fragments.ProfileFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class ProgressTracking extends AppCompatActivity {

    TextView resultNombor;
    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;
    String userId;
    String id = "warna";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracking);

        resultNombor = findViewById(R.id.nomborjawi);
        firestore = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            retrieveQuizResult();
        }

        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void retrieveQuizResult() {
        CollectionReference collectionReference = firestore.collection("users").document(userId).collection("quiz").document(id).collection("attempts");

        // Query to retrieve the latest quiz result
        collectionReference.orderBy("timestamp", Query.Direction.DESCENDING).limit(1)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        // Retrieve the quiz result from the document
                        DocumentSnapshot documentSnapshot = queryDocumentSnapshots.getDocuments().get(0);
                        int quizResult = documentSnapshot.getLong("result").intValue();

                        // Display the quiz result in the TextView
                        resultNombor.setText("Quiz Result: " + quizResult);
                    } else {
                        // No quiz result found
                        resultNombor.setText("No quiz result available");
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ProgressTracking.this, "Failed to retrieve quiz result", Toast.LENGTH_SHORT).show();
                });
    }
}

