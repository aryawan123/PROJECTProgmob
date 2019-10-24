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

import com.example.project.CRUDKrs;
import com.example.project.CRUDMhsActivity;
import com.example.project.Model.Mahasiswa;
import com.example.project.R;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    private Context context;

    public MahasiswaAdapter(ArrayList<Mahasiswa> mahasiswas) {
        this.mahasiswaArrayList = mahasiswas;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.card_view_mhs,parent,false);
        context =parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mahasiswaArrayList.get(position).getImgMhs());
        holder.txtNIM.setText(mahasiswaArrayList.get(position).getNIM());
        holder.txtNamaMhs.setText(mahasiswaArrayList.get(position).getNamaMhs());
        holder.txtEmailMhs.setText(mahasiswaArrayList.get(position).getEmailMhs());
        holder.txtAlamatMhs.setText(mahasiswaArrayList.get(position).getAlamaMhs());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context!=null){
                    Intent intent = new Intent(context, CRUDMhsActivity.class);
                    context.startActivities(new Intent[]{intent});
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mahasiswaArrayList !=null)?mahasiswaArrayList.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtNIM, txtNamaMhs,txtEmailMhs,txtAlamatMhs;
        private CardView cv;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imgMhs);
            txtNIM=view.findViewById(R.id.txtNIMAdmin);
            txtNamaMhs=view.findViewById(R.id.txtNamaMhsAdmin);
            txtEmailMhs=view.findViewById(R.id.txtEmailMhsAdmin);
            txtAlamatMhs=view.findViewById(R.id.txtAlamatMhsAdmin);
            cv=view.findViewById(R.id.cvMhs);
        }
    }
}
