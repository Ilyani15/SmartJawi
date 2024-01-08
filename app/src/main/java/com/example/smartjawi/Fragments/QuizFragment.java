package com.example.smartjawi.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.smartjawi.Quiz.Quiz_Buah1;
import com.example.smartjawi.Quiz.Quiz_Haiwan1;
import com.example.smartjawi.Quiz.Quiz_Nombor1;
import com.example.smartjawi.Quiz.Quiz_Warna1;
import com.example.smartjawi.R;

public class QuizFragment extends Fragment {

    Activity context;
    RelativeLayout btn1,btn3, btn4;
    LinearLayout btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);


        btn1 = view.findViewById(R.id.dua);  // Corrected line

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz_Warna1.class);
                startActivity(intent);
            }
        });

        btn2 = view.findViewById(R.id.satu);  // Corrected line

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz_Nombor1.class);
                startActivity(intent);
            }
        });
        btn3 = view.findViewById(R.id.tiga);  // Corrected line

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz_Haiwan1.class);
                startActivity(intent);
            }
        });
        btn4 = view.findViewById(R.id.empat);  // Corrected line

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quiz_Buah1.class);
                startActivity(intent);
            }
        });

        return view;

    }
}