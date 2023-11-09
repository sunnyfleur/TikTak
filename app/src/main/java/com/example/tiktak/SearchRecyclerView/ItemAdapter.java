package com.example.tiktak.SearchRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tiktak.HomeActivity;
import com.example.tiktak.Models.MediaData;
import com.example.tiktak.Models.MediaObject;
import com.example.tiktak.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> itemList;
    private Context context;
    private ArrayList<MediaObject> mediaObjects;

    public ItemAdapter(List<Item> itemList,Context context) {

        this.itemList = itemList;
        this.context = context;
    }
    public void setFilteredList(List<Item> filteredList){
        this.itemList = filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_search, parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemNameTV.setText(item.getItemName());
        RequestOptions requestOptions = RequestOptions.bitmapTransform(new RoundedCorners(20));

        Glide.with(context)
                .load(item.getItemLink())
                .apply(requestOptions)
                .into(holder.itemImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                String mediaUrl = getVideoUrlByImageUrl(mediaObjects,itemList.get(position).getItemLink());

                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                intent.putExtra("mediaUrl",mediaUrl);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView itemNameTV;
        private ImageView itemImageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemNameTV = itemView.findViewById(R.id.itemTxt);
            itemImageView = itemView.findViewById(R.id.itemImg);
        }
    }
    private String getVideoUrlByImageUrl(ArrayList<MediaObject>mediaObjects, String imageUrl) {
        mediaObjects = MediaData.generateMediaData();
        for (MediaObject media : mediaObjects) {
            if (media.getThumbnail().equals(imageUrl)) {
                return media.getMedia_url();
            }
        }
        return null;
    }
}
