package com.project.appchinese.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.appchinese.R;
import com.project.appchinese.activity.Exo1;
import com.project.appchinese.adapters.ExoAdapter;
import com.project.appchinese.models.Exo;

import java.util.ArrayList;
import java.util.List;

public class Learn extends Fragment
{
    private ExoAdapter adapter;
    private RecyclerView recyclerView;
    private List<Exo> exercises = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.learn,container,false);
        recyclerView = view.findViewById(R.id.exos);

        exercises.add(new Exo("Base I", Exo1.class));
        exercises.add(new Exo("Base II", Exo1.class));
        exercises.add(new Exo("Base III", Exo1.class));
        exercises.add(new Exo("Base IV", Exo1.class));
        exercises.add(new Exo("Base V", Exo1.class));
        exercises.add(new Exo("Base VI", Exo1.class));

        adapter = new ExoAdapter(getActivity(), exercises);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
