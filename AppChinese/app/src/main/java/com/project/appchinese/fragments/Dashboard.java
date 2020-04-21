package com.project.appchinese.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.appchinese.R;
import com.project.appchinese.activity.MainActivity;
import com.project.appchinese.activity.MenuActivity;
import com.project.appchinese.activity.exercises.StatsActivity;
import com.project.appchinese.adapters.ExoAdapter;

import java.util.ArrayList;

public class Dashboard extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(view == null)
        {
            view = inflater.inflate(R.layout.dashboard,container,false);

            Button stats = view.findViewById(R.id.stats);
            stats.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), StatsActivity.class);
                    startActivity(intent);
                }
            });
        }
        return view;
    }
}
