package com.example.smartjawi.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.smartjawi.Belajar.HaiwanJawi;
import com.example.smartjawi.Belajar.HurufJawi;
import com.example.smartjawi.Belajar.NomborJawi;
import com.example.smartjawi.Belajar.WarnaJawi;
import com.example.smartjawi.Game.Cw.FirstCW;
import com.example.smartjawi.Game.DD.FirstDD;
import com.example.smartjawi.Game.MG.FirstMG;
import com.example.smartjawi.MainActivity;
import com.example.smartjawi.R;

public class BelajarFragment extends Fragment {

    Activity context;
    RelativeLayout btn1, btn2, btn3, btn4;
    LinearLayout  btn5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_belajar, container, false);

        btn1 = view.findViewById(R.id.satu);
        btn2 = view.findViewById(R.id.dua);
        btn3 = view.findViewById(R.id.tiga);
        btn4 = view.findViewById(R.id.empat);
        btn5 = view.findViewById(R.id.lima);

        ImageView close = view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HurufJawi.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WarnaJawi.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HaiwanJawi.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HaiwanJawi.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NomborJawi.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
