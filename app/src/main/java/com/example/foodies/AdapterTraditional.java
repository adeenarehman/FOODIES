package com.example.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterTraditional extends RecyclerView.Adapter<AdapterTraditional.TraditionalViewHolder>

{
    private Context context;
    private List<ModelTraditional> TraditionalList;

    public AdapterTraditional(Context context, List<ModelTraditional> TraditionalList) {

        this.context = context;
        this.TraditionalList = TraditionalList;
    }

    @NonNull
    @Override

    public TraditionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.single_item_layout,parent,false);
        TraditionalViewHolder holder = new TraditionalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TraditionalViewHolder holder, int position) {

        ModelTraditional model = TraditionalList.get(position);
        holder.item_name.setText(model.getName());
        holder.item_description.setText(model.getDescription());
        holder.item_price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return TraditionalList.size();
    }

    class TraditionalViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_name,item_description, item_price;
        TraditionalViewHolder(@NonNull View itemView) {

            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
            item_price = itemView.findViewById(R.id.item_price);

        }
    }
}

