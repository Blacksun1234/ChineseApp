package com.project.appchinese.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.appchinese.R;

public class ExercisesActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercises);
	}

	public void onClickExo1(View view)
	{
		Intent intent = new Intent(this, Exo1Activity.class);
		intent.putExtra("theme", getIntent().getSerializableExtra("theme"));
		startActivityForResult(intent, 0);
	}

	public void onClickExo2(View view)
	{
		Intent intent = new Intent(this, Exo1Activity.class);
		intent.putExtra("theme", getIntent().getSerializableExtra("theme"));
		startActivityForResult(intent, 0);
	}

	public void onClickExo3(View view)
	{
		Intent intent = new Intent(this, Exo3Activity.class);
		//intent.putExtra("theme", getIntent().getSerializableExtra("theme"));
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		finish();
	}
}
