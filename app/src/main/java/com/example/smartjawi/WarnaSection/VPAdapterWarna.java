package com.example.smartjawi.WarnaSection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartjawi.HijaiyahSection.VPAdapterHijaiyah;
import com.example.smartjawi.HijaiyahSection.VPItemHijaiyah;
import com.example.smartjawi.R;

import java.util.ArrayList;

public class VPAdapterWarna extends RecyclerView.Adapter<com.example.smartjawi.WarnaSection.VPAdapterWarna.ViewHolder> {

    ArrayList<VPItemWarna> viewPagerItemWarnaArrayList;
    public VPAdapterWarna(ArrayList<VPItemWarna> viewPagerItemHijaiyahArrayList) {
        this.viewPagerItemWarnaArrayList = viewPagerItemHijaiyahArrayList;
    }

    @NonNull
    @Override
    public com.example.smartjawi.WarnaSection.VPAdapterWarna.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_warna, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.smartjawi.WarnaSection.VPAdapterWarna.ViewHolder holder, int position) {
        VPItemWarna viewPagerItemWarna = viewPagerItemWarnaArrayList.get(position);
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
