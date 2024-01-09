package com.example.smartjawi.Game.DD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DD_Result_Warna extends AppCompatActivity {

    TextView textResult;
    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_result_buah);

        textResult = findViewById(R.id.textResult);

        textResult.setText("You Answered " + getIntent().getIntExtra("RA", 0) + " / 4");

        TextView close = findViewById(R.id.yay);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveResultToFirestore(getIntent().getIntExtra("RA", 0));
                Intent intent = new Intent(DD_Result_Warna.this, GameFragment.class);
                startActivity(intent);
                finish();
            }
        });

        firestore = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void saveResultToFirestore(int result) {
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            CollectionReference collectionReference = firestore.collection("users").document(userId).collection("drag_drop").document("Suai Padan").collection("attempts");

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
                        Toast.makeText(DD_Result_Warna.this, "Quiz result and attempt count saved successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(DD_Result_Warna.this, "Failed to save quiz result and attempt count", Toast.LENGTH_SHORT).show();
                    });
        }
    }

}
