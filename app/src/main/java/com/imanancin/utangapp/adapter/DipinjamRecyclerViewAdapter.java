package com.imanancin.utangapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imanancin.utangapp.R;
import com.imanancin.utangapp.activity.DipinjamDetailActivity;
import com.imanancin.utangapp.model.DataModel;

import java.util.ArrayList;

/**
 * Adapter digunakan sebagai penghubung antara data dan view
 * DATA DARI DATABASE/API DLL -> ADAPTER -> UI / VIEW / XML
 */
public class DipinjamRecyclerViewAdapter extends RecyclerView.Adapter<DipinjamRecyclerViewAdapter.DipinjamViewHolder> {

    ArrayList<DataModel> arrayListDataModel;

    // data dimasukkan lewat konstruktor sini
    public DipinjamRecyclerViewAdapter(ArrayList<DataModel> data){
        this.arrayListDataModel = data;
    }

    @NonNull
    @Override
    public DipinjamRecyclerViewAdapter.DipinjamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dipinjam, parent, false);
        // inner class di bawah
        return new DipinjamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DipinjamRecyclerViewAdapter.DipinjamViewHolder holder, int position) {
        final DataModel dataModel = arrayListDataModel.get(position);

        holder.customer_name.setText(dataModel.getCustomer_name());
        holder.total.setText(String.valueOf(dataModel.getTotal()));
        holder.date.setText(dataModel.getDate());

        // action apabila diklik di list item recycler viewnya
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ke detail activity
                Intent intent = new Intent(holder.itemView.getContext(), DipinjamDetailActivity.class);
                intent.putExtra("DATA", dataModel);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListDataModel.size();
    }


    // class mengaikan id dan datanya
    public class DipinjamViewHolder extends RecyclerView.ViewHolder {
        TextView customer_name, date, total;
        public DipinjamViewHolder(@NonNull View itemView) {
            super(itemView);

            // mereferensikan id ke xmlnya
            customer_name = itemView.findViewById(R.id.customer_name);
            date = itemView.findViewById(R.id.date);
            total = itemView.findViewById(R.id.total);
        }
    }
}
