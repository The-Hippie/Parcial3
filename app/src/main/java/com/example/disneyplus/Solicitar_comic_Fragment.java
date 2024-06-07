package com.example.disneyplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Solicitar_comic_Fragment extends Fragment {

    private Spinner spinnerComics;
    private Button btnSolicitar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_solicitar_comic_, container, false);

        spinnerComics = view.findViewById(R.id.spinner_comics);
        btnSolicitar = view.findViewById(R.id.btn_solicitar);

        // Llamada a la API de Marvel para obtener los comics


        btnSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar que se seleccione un comic
                if (spinnerComics.getSelectedItem()!= null) {
                    // Lógica para solicitar el comic seleccionado
                } else {
                    Toast.makeText(getContext(), "Seleccione un comic", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


}