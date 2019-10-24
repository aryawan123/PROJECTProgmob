package com.example.project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.CRUDDosenAdminActivity;
import com.example.project.Model.Dosen;
import com.example.project.R;

import java.util.ArrayList;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {
    private  ArrayList<Dosen> dosenArrayList;
    private Context context;
    public DosenAdapter (ArrayList<Dosen>dosenArrayList){
        this.dosenArrayList=dosenArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.card_view_dosen,parent,false);
        context =parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageViewDosen.setImageResource(dosenArrayList.get(position).getFotoDosen());
        holder.txtNIDN.setText(dosenArrayList.get(position).getNIDN());
        holder.txtNamaDosen.setText(dosenArrayList.get(position).getNamaDosen());
        holder.txtGelarDosen.setText(dosenArrayList.get(position).getGelar());
        holder.txtEmailDosen.setText(dosenArrayList.get(position).getEmail());
        holder.txtAlamatDosen.setText(dosenArrayList.get(position).getAlamat());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context!=null){
                    Intent intent = new Intent(context, CRUDDosenAdminActivity.class);
                    context.startActivities(new Intent[]{intent});
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dosenArrayList !=null)?dosenArrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewDosen;
        private CardView cv;
        private TextView txtNIDN,txtNamaDosen,txtGelarDosen,txtEmailDosen,txtAlamatDosen;
        public ViewHolder(View view){
            super(view);
            imageViewDosen = view.findViewById(R.id.img_dosen);
            txtNIDN = view.findViewById(R.id.txtNIDN);
            txtNamaDosen = view.findViewById(R.id.txtNamaDosen);
            txtGelarDosen = view.findViewById(R.id.txtGelarDosen);
            txtEmailDosen = view.findViewById(R.id.txtEmailDosen);
            txtAlamatDosen = view.findViewById(R.id.txtAlamatDosen);
            cv=view.findViewById(R.id.cvDosen);
        }
}



}