package com.project.appchinese.models;

import androidx.appcompat.app.AppCompatActivity;

public class Exo
{
	private String title;
	private Class<? extends AppCompatActivity> activity;

	public Exo(String title, Class<? extends AppCompatActivity> activity)
	{
		this.title = title;
		this.activity = activity;
	}

	public String getTitle() {
		return title;
	}

	public Class<? extends AppCompatActivity> getActivity() {
		return activity;
	}
}
