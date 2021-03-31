package com.sigma.jsonapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<JSONDataLists> dataLists;

    public MyAdapter(Context context, List<JSONDataLists> dataLists) {
        this.context = context;
        this.dataLists = dataLists;
    }

    public MyAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        JSONDataLists jsonDataLists = dataLists.get(position);

        holder.title.setText("Title: "+jsonDataLists.getTitle());
        holder.id.setText("ID: "+jsonDataLists.getId());
        Picasso.get().load(jsonDataLists.getThumbnailUrl()).into(holder.imageView);




        holder.cardView.setTranslationX(1000);
        holder.cardView.setAlpha(0f);
        holder.cardView.animate().translationX(0).alpha(1f).setDuration(1000).setStartDelay(100).start();

    }


    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView imageView;
        private TextView title, id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView_Id);
            imageView = itemView.findViewById(R.id.image_Id);
            title = itemView.findViewById(R.id.title_Id);
            id = itemView.findViewById(R.id.ID_id);


        }
    }
}
