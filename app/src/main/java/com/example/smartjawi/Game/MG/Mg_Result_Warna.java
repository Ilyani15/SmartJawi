package com.example.smartjawi.Game.MG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Mg_Result_Warna extends AppCompatActivity {

    private TextView textResult;
    private FirebaseUser firebaseUser;
    private FirebaseFirestore firestore;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_result_warna);

        textResult = findViewById(R.id.textResult);

        int resultValue = getIntent().getIntExtra("RA", 0);
        textResult.setText("You Answered " + resultValue + " / 100");

        firestore = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        TextView close = findViewById(R.id.yay);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveGameResultToFirestore(resultValue);
                goToGameFragment();
            }
        });
    }

    private void saveGameResultToFirestore(int result) {
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            CollectionReference collectionReference = firestore.collection("users")
                    .document(userId)
                    .collection("Memory Game");  // Adjust this path as needed

            // Reference to the game_data document
            DocumentReference gameDataRef = collectionReference.document("Kad Memori");

            // Save the attempt count and game result
            Map<String, Object> data = new HashMap<>();
            data.put("attempts", 1); // Set attempt count to 1
            data.put("result", result); // Save the game result

            // Use set to overwrite the existing document or create a new one
            gameDataRef.set(data)
                    .addOnSuccessListener(aVoid -> {
                        // Game result and attempt count saved successfully
                        Toast.makeText(Mg_Result_Warna.this, "Game result and attempt count saved successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(Mg_Result_Warna.this, "Failed to save game result and attempt count", Toast.LENGTH_SHORT).show();
                    });
        }
    }

    private void goToGameFragment() {
        Intent intent = new Intent(Mg_Result_Warna.this, GameFragment.class);
        startActivity(intent);
        finish();
    }
}
