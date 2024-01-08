package com.example.smartjawi.HijaiyahSection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartjawi.R;

import java.util.ArrayList;

public class VPAdapterHijaiyah extends RecyclerView.Adapter<VPAdapterHijaiyah.ViewHolder> {

    ArrayList<VPItemHijaiyah> viewPagerItemHijaiyahArrayList;
    public VPAdapterHijaiyah(ArrayList<VPItemHijaiyah> viewPagerItemHijaiyahArrayList) {
        this.viewPagerItemHijaiyahArrayList = viewPagerItemHijaiyahArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hijaiyah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VPItemHijaiyah viewPagerItemHijaiyah = viewPagerItemHijaiyahArrayList.get(position);
        holder.imgHijaiyah.setImageResource(viewPagerItemHijaiyah.imgHijaiyah);
        holder.hijaiyahHeading.setText(viewPagerItemHijaiyah.HijaiyahHeading);
    }

    @Override
    public int getItemCount() {
        return viewPagerItemHijaiyahArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgHijaiyah;
        TextView hijaiyahHeading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHijaiyah = itemView.findViewById(R.id.Huruf_img);
            hijaiyahHeading = itemView.findViewById(R.id.hijaiyahHeading);
        }
    }
}