package com.example.smartjawi.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.smartjawi.Eja.EjaActivity;
import com.example.smartjawi.Game.Cw.FirstCW;
import com.example.smartjawi.Game.Cw.Intro_Cw;
import com.example.smartjawi.Game.DD.FirstDD;
import com.example.smartjawi.Game.DD.Intro_DD;
import com.example.smartjawi.Game.MG.FirstMG;
import com.example.smartjawi.Game.MG.Intro_MG;
import com.example.smartjawi.Game.VG.BetulSalahWarna1;
import com.example.smartjawi.Game.VG.FirstVG;
import com.example.smartjawi.Game.VG.Intro_VG;
import com.example.smartjawi.R;

public class GameFragment extends Fragment {

    Activity context;
    RelativeLayout btn1, btn2, btn3, btn4, btn5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        btn1 = view.findViewById(R.id.dua);
        btn2 = view.findViewById(R.id.satu);
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
                Intent intent = new Intent(getActivity(), Intro_Cw.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Intro_MG.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Intro_DD.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EjaActivity.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Intro_VG.class);
                startActivity(intent);
            }
        });

        return view;  // Moved this line to the correct position
    }
}
