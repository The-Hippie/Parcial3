package com.example.disneyplus;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.disneyplus.databinding.FragmentHomeBinding;
import com.example.disneyplus.databinding.FragmentSolicitarBinding;
import com.example.disneyplus.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class SolicitarFragment extends Fragment {
    private RecyclerView rvSuperheroes;
    private EditText etBuscar;
    private SuperheroAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_solicitar, container, false);

        rvSuperheroes = view.findViewById(R.id.rv_superheroes);
        etBuscar = view.findViewById(R.id.et_buscar);

        adapter = new SuperheroAdapter(new ArrayList<>());
        rvSuperheroes.setAdapter(adapter);
        rvSuperheroes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Llamada a la API de Marvel para obtener los superhéroes
        obtenerSuperheroes();

        return view;
    }

    private void obtenerSuperheroes() {
        // Aquí va la lógica para obtener los superhéroes de la API de Marvel
        // Por ahora, solo creamos una lista vacía
        List<Superhero> superheroes = new ArrayList<>();

        adapter.updateData(superheroes);
    }
}