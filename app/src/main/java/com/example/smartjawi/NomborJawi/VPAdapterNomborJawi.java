package com.example.smartjawi.NomborJawi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartjawi.R;

import java.util.ArrayList;

public class VPAdapterNomborJawi extends RecyclerView.Adapter<VPAdapterNomborJawi.ViewHolder> {

    ArrayList<VPItemNomborJawi> vpItemNomborJawiArrayList;
    public VPAdapterNomborJawi(ArrayList<VPItemNomborJawi> vpItemNomborJawiArrayList) {
        this.vpItemNomborJawiArrayList = vpItemNomborJawiArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_nombor_jawi, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VPItemNomborJawi vpItemNomborJawi = vpItemNomborJawiArrayList.get(position);
        holder.imgJawiNum.setImageResource(vpItemNomborJawi.imgJawiNum);
        holder.nomborHeading.setText(vpItemNomborJawi.nomborHeading);
    }

    @Override
    public int getItemCount() {
        return vpItemNomborJawiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgJawiNum;
        TextView nomborHeading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgJawiNum = itemView.findViewById(R.id.Nombor_img);
            nomborHeading = itemView.findViewById(R.id.nomborHeading);
        }
    }

}
