package com.cindy.projectuts.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cindy.projectuts.R;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // Bind views
        ImageView profileImage = root.findViewById(R.id.profile_image);
        TextView profileName = root.findViewById(R.id.profile_name);
        Button detailButton = root.findViewById(R.id.detail_button);

        // Set default data
        profileName.setText("Anne Smith");
        profileImage.setImageResource(R.drawable.ic_place_holder);

        // Add button click listener
        detailButton.setOnClickListener(v -> {
            // Perform action on button click
        });
        return root;
    }
}

