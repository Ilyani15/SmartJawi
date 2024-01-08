package com.example.smartjawi.Game.VG;

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

public class ResultVG extends AppCompatActivity {

    TextView textResult, name;
    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_result_vg);

        textResult = findViewById(R.id.textResult);
        name = findViewById(R.id.name);
        textResult.setText("You Answered " + getIntent().getIntExtra("RA", 0) + " / 5");

        TextView close = findViewById(R.id.yay);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the game result to Firestore
                saveGameResultToFirestore(getIntent().getIntExtra("RA", 0));

                Intent intent = new Intent(ResultVG.this, FirstVG.class);
                startActivity(intent);
                finish();
            }
        });

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firestore = FirebaseFirestore.getInstance();

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

    private void saveGameResultToFirestore(int result) {
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            CollectionReference collectionReference = firestore.collection("users")
                    .document(userId)
                    .collection("Vote Game"); // Adjust this path as needed

            // Reference to the game_data document
            DocumentReference gameDataRef = collectionReference.document("Betul atau Salah");

            // Save the attempt count and game result
            Map<String, Object> data = new HashMap<>();
            data.put("attempts", 1); // Set attempt count to 1
            data.put("result", result); // Save the game result

            // Use set to overwrite the existing document or create a new one
            gameDataRef.set(data)
                    .addOnSuccessListener(aVoid -> {
                        // Game result and attempt count saved successfully
                        Toast.makeText(ResultVG.this, "Game result and attempt count saved successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(ResultVG.this, "Failed to save game result and attempt count", Toast.LENGTH_SHORT).show();
                    });
        }
    }
}
