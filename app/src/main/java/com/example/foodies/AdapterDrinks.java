package com.example.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterDrinks extends RecyclerView.Adapter<AdapterDrinks.DrinksViewHolder>

{
    private Context context;
    private List<ModelDrinks> DrinksList;

    public AdapterDrinks(Context context, List<ModelDrinks> DrinksList) {

        this.context = context;
        this.DrinksList = DrinksList;
    }

    @NonNull
    @Override

    public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.single_item_layout,parent,false);
        DrinksViewHolder holder = new DrinksViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksViewHolder holder, int position) {

        ModelDrinks model = DrinksList.get(position);
        holder.item_name.setText(model.getName());
        holder.item_description.setText(model.getDescription());
        holder.item_price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return DrinksList.size();
    }

    class DrinksViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_name,item_description, item_price;

        DrinksViewHolder(@NonNull View itemView) {

            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
            item_price = itemView.findViewById(R.id.item_price);

        }
    }
}

