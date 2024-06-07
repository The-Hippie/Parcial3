package com.example.disneyplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetallesFragment extends Fragment {

    private TextView tvNombre;
    private TextView tvDescripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);

        tvNombre = view.findViewById(R.id.tv_nombre);
        tvDescripcion = view.findViewById(R.id.tv_descripcion);

        // Obtener el superhéroe seleccionado desde el fragment anterior
        Superhero superhero = getArguments().getParcelable("superhero");

        tvNombre.setText(superhero.getName());
        tvDescripcion.setText(superhero.getBio());

        return view;
    }
}