package com.example.smartjawi.HaiwanSection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartjawi.R;
import com.example.smartjawi.WarnaSection.VPItemWarna;

import java.util.ArrayList;

public class VPAdapterHaiwan extends RecyclerView.Adapter<com.example.smartjawi.HaiwanSection.VPAdapterHaiwan.ViewHolder> {

    ArrayList<VPItemHaiwan> viewPagerItemWarnaArrayList;
    public VPAdapterHaiwan(ArrayList<VPItemHaiwan> viewPagerItemHijaiyahArrayList) {
        this.viewPagerItemWarnaArrayList = viewPagerItemHijaiyahArrayList;
    }

    @NonNull
    @Override
    public com.example.smartjawi.HaiwanSection.VPAdapterHaiwan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_warna, parent, false);
        return new com.example.smartjawi.HaiwanSection.VPAdapterHaiwan.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.smartjawi.HaiwanSection.VPAdapterHaiwan.ViewHolder holder, int position) {
        VPItemHaiwan viewPagerItemWarna = viewPagerItemWarnaArrayList.get(position);
        holder.imgHijaiyah.setImageResource(viewPagerItemWarna.imgHijaiyah);
        holder.hijaiyahHeading.setText(viewPagerItemWarna.HijaiyahHeading);
    }

    @Override
    public int getItemCount() {
        return viewPagerItemWarnaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgHijaiyah;
        TextView hijaiyahHeading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHijaiyah = itemView.findViewById(R.id.Huruf_img);
            hijaiyahHeading = itemView.findViewById(R.id.hijaiyahHeading);
        }
    }
}
