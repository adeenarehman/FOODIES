package com.example.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterFastFood extends RecyclerView.Adapter<AdapterFastFood.FastFoodViewHolder>

{
    private Context context;
    private List<ModelFastFood> FastfoodList;

    public AdapterFastFood(Context context, List<ModelFastFood> DrinksList) {

        this.context = context;
        this.FastfoodList = DrinksList;
    }

    @NonNull
    @Override

    public FastFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.single_item_layout,parent,false);
        FastFoodViewHolder holder = new FastFoodViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FastFoodViewHolder holder, int position) {

        ModelFastFood model = FastfoodList.get(position);
        holder.item_name.setText(model.getName());
        holder.item_description.setText(model.getDescription());
        holder.item_price.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return FastfoodList.size();
    }

    class FastFoodViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_name,item_description, item_price;
        FastFoodViewHolder(@NonNull View itemView) {

            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
            item_price = itemView.findViewById(R.id.item_price);
        }
    }
}

