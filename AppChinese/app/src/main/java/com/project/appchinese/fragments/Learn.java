package com.project.appchinese.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.appchinese.R;
import com.project.appchinese.Utils;
import com.project.appchinese.adapters.ExoAdapter;
import com.project.appchinese.models.Theme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Learn extends Fragment
{
    private ExoAdapter adapter;
    private RecyclerView recyclerView;

    private List<Theme> themes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.learn,container,false);
        recyclerView = view.findViewById(R.id.exos);

        themes = new ArrayList<>();

        loadData();

        adapter = new ExoAdapter(getActivity(), themes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private void loadData()
    {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Theme>>(){}.getType();
        themes = gson.fromJson(new BufferedReader(new InputStreamReader(getResources()
                .openRawResource(R.raw.data))), type);
    }
}
