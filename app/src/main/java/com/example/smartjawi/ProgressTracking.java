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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ProgressTracking extends AppCompatActivity {

    TextView resultNombor, resultHaiwan, resultWarna, resultBuahan;
    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracking);

        resultNombor = findViewById(R.id.nomborjawi);
        resultHaiwan = findViewById(R.id.haiwanjawi);
        resultWarna = findViewById(R.id.warnajawi);
        resultBuahan = findViewById(R.id.tumbuhan);

        firestore = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            retrieveQuizResults();
        }

        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void retrieveQuizResults() {
        retrieveCategoryResult("Nombor", resultNombor);
        retrieveCategoryResult("Haiwan", resultHaiwan);
        retrieveCategoryResult("Warna", resultWarna);
        retrieveCategoryResult("Buahan", resultBuahan);
    }

    private void retrieveCategoryResult(String category, TextView resultTextView) {
        DocumentReference documentReference = firestore.collection("users")
                .document(userId)
                .collection("quiz")
                .document(category)
                .collection("attempts")
                .document("attempt_data");

        // Query to retrieve the latest quiz result
        documentReference.get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve the quiz result from the document
                        if (documentSnapshot.contains("result")) {
                            int quizResult = documentSnapshot.getLong("result").intValue();
                            // Display the quiz result in the corresponding TextView
                            resultTextView.setText(category + " Result: " + quizResult);
                        } else {
                            // If the document does not contain the "result" field
                            resultTextView.setText(category + " Result: Data structure is invalid");
                        }
                    } else {
                        // No quiz result found
                        resultTextView.setText(category + "0");
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ProgressTracking.this, "Failed to retrieve " + category + " result", Toast.LENGTH_SHORT).show();
                });
    }


}
