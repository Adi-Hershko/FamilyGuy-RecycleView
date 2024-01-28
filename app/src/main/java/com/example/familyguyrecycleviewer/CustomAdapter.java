package com.example.familyguyrecycleviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.familyguyrecycleviewer.DataModel;
import com.example.familyguyrecycleviewer.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<DataModel> dataset;
    public CustomAdapter(ArrayList<DataModel> dataSet) {
        this.dataset = dataSet;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewDesc;
        ImageView imageView;

        public MyViewHolder (View itemView){
            super(itemView);
            textViewName = itemView.findViewById(R.id.charName);
            textViewDesc = itemView.findViewById(R.id.desc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout , parent , false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewDesc = holder.textViewDesc;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataset.get(position).getName());
        textViewDesc.setText((dataset.get(position).getDesc()));
        imageView.setImageResource(dataset.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
