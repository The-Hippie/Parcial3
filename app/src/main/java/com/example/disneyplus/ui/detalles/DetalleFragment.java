package com.example.disneyplus.ui.detalles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.disneyplus.R;

public class DetalleFragment extends Fragment {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView realNameTextView;
        private TextView teamTextView;
        private TextView firstAppearanceTextView;
        private TextView publisherTextView;
        private TextView bioTextView;
        private TextView createdByTextView;


        @Override
        public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                                  Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_detalle, container, false);

            imageView = view.findViewById(R.id.image_view);
            nameTextView = view.findViewById(R.id.name_view);
            realNameTextView = view.findViewById(R.id.real_name_view);
            teamTextView = view.findViewById(R.id.team_view);
            firstAppearanceTextView = view.findViewById(R.id.first_appearance_view);
            publisherTextView = view.findViewById(R.id.publisher_view);
            bioTextView = view.findViewById(R.id.bio_view);
            createdByTextView = view.findViewById(R.id.created_by_view);

            // Retrieve the data from the Bundle
            Bundle bundle = getArguments();
            if (bundle != null) {
                String name = bundle.getString("name");
                String realName = bundle.getString("realname");
                String team = bundle.getString("team");
                String firstAppearance = bundle.getString("firstappearance");
                String createdBy = bundle.getString("createdby");
                String publisher = bundle.getString("publisher");
                String imageUrl = bundle.getString("imageurl");
                String bio = bundle.getString("bio");

                Glide.with(this)
                        .load(imageUrl)
                        .into(imageView);

                nameTextView.setText(name);
                realNameTextView.setText(realName);
                teamTextView.setText(team);
                firstAppearanceTextView.setText(firstAppearance);
                publisherTextView.setText(publisher);
                bioTextView.setText(bio);
                createdByTextView.setText(createdBy);
            }

            return view;
        }
    }