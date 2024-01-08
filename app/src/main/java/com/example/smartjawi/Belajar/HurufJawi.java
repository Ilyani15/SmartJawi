package com.example.smartjawi.Belajar;

import com.example.smartjawi.HijaiyahSection.HijaiyahActivity;
import com.example.smartjawi.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.BelajarFragment;

public class HurufJawi extends AppCompatActivity {

    LinearLayout btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,
            btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,btn31,btn32,btn33,btn34,btn35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf_jawi);

        btn1 = findViewById(R.id.hrfalif);
        btn2 = findViewById(R.id.hrfba);
        btn3 = findViewById(R.id.hrfta);
        btn4 = findViewById(R.id.hrftsa);
        btn5 = findViewById(R.id.hrfjim);
        btn6 = findViewById(R.id.hrfha);
        btn7 = findViewById(R.id.hrfkho);
        btn8 = findViewById(R.id.hrfca);
        btn9 = findViewById(R.id.hrfdal);
        btn10 = findViewById(R.id.hrfdzal);
        btn11 = findViewById(R.id.hrfro);
        btn12 = findViewById(R.id.hrfzai);
        btn13 = findViewById(R.id.hrfsin);
        btn14 = findViewById(R.id.hrfshin);
        btn15 = findViewById(R.id.hrfsod);
        btn16 = findViewById(R.id.hrfdhod);
        btn17 = findViewById(R.id.hrftho);
        btn18 = findViewById(R.id.hrfdzho);
        btn19 = findViewById(R.id.hrfain);
        btn20 = findViewById(R.id.hrfghin);
        btn21 = findViewById(R.id.hrfnga);
        btn22 = findViewById(R.id.hrffa);
        btn23 = findViewById(R.id.hrfpa);
        btn24 = findViewById(R.id.hrfqof);
        btn25 = findViewById(R.id.hrfkaf);
        btn26 = findViewById(R.id.hrfga);
        btn27 = findViewById(R.id.hrflam);
        btn28 = findViewById(R.id.hrfmim);
        btn29 = findViewById(R.id.hrfnun);
        btn30 = findViewById(R.id.hrfwau);
        btn31 = findViewById(R.id.hrfvi);
        btn32 = findViewById(R.id.hrfho);
        btn33 = findViewById(R.id.hrfhamzah);
        btn34 = findViewById(R.id.hrfya);
        btn35 = findViewById(R.id.hrfnya);

        ImageView close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HurufJawi.this, BelajarFragment.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity.class
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });
        btn35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HurufJawi.this, HijaiyahActivity.class);
                startActivity(intent);
            }
        });

    }
}