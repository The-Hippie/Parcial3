package com.example.disneyplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private List<Comic> comics;
    private Context context;

    public ComicAdapter(List<Comic> comics, Context context) {
        this.comics = comics;
        this.context = context;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_comic, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        Comic comic = comics.get(position);
        holder.tvTitle.setText(comic.getTitle());
        holder.tvDescription.setText(comic.getDescription());
        Picasso.get().load(comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension()).into(holder.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDescription;
        public ImageView ivThumbnail;

        public ComicViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
        }
    }
}