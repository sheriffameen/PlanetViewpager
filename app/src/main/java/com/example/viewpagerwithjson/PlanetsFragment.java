package com.example.viewpagerwithjson;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class PlanetsFragment extends Fragment {
    private static final String PLANET_NAME_KEY = "param1";
    private static final String PLANET_IMAGE_KEY = "param2";
    private String planetName;
    private String planetImage;
    private TextView planetNameTextView;
    private ImageView planetImageView;


    public PlanetsFragment() {
        // Required empty public constructor
    }


    public static PlanetsFragment newInstance(String name, String image) {
        PlanetsFragment fragment = new PlanetsFragment();
        Bundle args = new Bundle();
        args.putString(PLANET_NAME_KEY, name);
        args.putString(PLANET_IMAGE_KEY, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            planetName = getArguments().getString(PLANET_NAME_KEY);
            planetImage = getArguments().getString(PLANET_IMAGE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planets, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        planetNameTextView = view.findViewById(R.id.planetName_textView);
        planetImageView = view.findViewById(R.id.planet_imageview);

        planetNameTextView.setText(planetName);
        Picasso.get().load(planetImage).into(planetImageView);
    }
}
