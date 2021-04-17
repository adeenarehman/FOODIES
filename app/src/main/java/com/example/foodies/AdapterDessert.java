package com.example.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterDessert extends RecyclerView.Adapter<AdapterDessert.DessertViewHolder>

{
    private Context context;
    private List<ModelDesserts> DessertList;

    public AdapterDessert(Context context, List<ModelDesserts> DessertList) {

        this.context = context;
        this.DessertList = DessertList;
    }

    @NonNull
    @Override

    public DessertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.single_item_layout,parent,false);
        DessertViewHolder holder = new DessertViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DessertViewHolder holder, int position) {

        ModelDesserts model = DessertList.get(position);
        holder.item_name.setText(model.getName());
        holder.item_description.setText(model.getDescription());
        holder.item_price.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return DessertList.size();
    }

    class DessertViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_name,item_description,item_price;
        DessertViewHolder(@NonNull View itemView) {

            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
            item_price = itemView.findViewById(R.id.item_price);
        }
    }
}

