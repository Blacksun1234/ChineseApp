package com.project.appchinese.models;

import androidx.appcompat.app.AppCompatActivity;

public class Exo
{
	private Theme theme;
	private Class<? extends AppCompatActivity> activity;

	public Exo(Theme theme, Class<? extends AppCompatActivity> activity)
	{
		this.theme = theme;
		this.activity = activity;
	}

	public String getTitle() {
		return theme.getTheme();
	}

	public Theme getTheme() {
		return theme;
	}

	public Class<? extends AppCompatActivity> getActivity() {
		return activity;
	}
}
