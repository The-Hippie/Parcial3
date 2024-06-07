package com.example.disneyplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.ViewHolder> {

    private List<Superhero> superheroes;

    public SuperheroAdapter(List<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_marvel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Superhero superhero = superheroes.get(position);
        holder.tvNombre.setText(superhero.getName());
    }

    @Override
    public int getItemCount() {
        return superheroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNombre;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tv_nombre);
        }
    }

    public void updateData(List<Superhero> superheroes) {
        this.superheroes = superheroes;
        notifyDataSetChanged();
    }
}

