package com.example.ipremios.mainActivity;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ipremios.R;
import com.example.ipremios.detailsActivity.DetailsActivity;
import com.example.ipremios.model.listItem.ItensItem;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewJogadoresAd";

    private Context context;
    private List<ItensItem> itens;

    public ListAdapter(Context context, List<ItensItem> itens) {
        this.context = context;
        this.itens= itens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        String url = itens.get(position).getImageThumb();
        Glide.with(context)
                .asBitmap()
                .load(url)
                .into(holder.imageViewTumb);



       holder.textViewTitle.setText(itens.get(position).getTitle());
       holder.textViewDescription.setText(itens.get(position).getDescription().substring(0, 50) + "...");


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("itens", itens.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        TextView textViewDescription;

        ImageView imageViewTumb;
        MaterialCardView parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);

            imageViewTumb = itemView.findViewById(R.id.imageViewTumb);

            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }


}
