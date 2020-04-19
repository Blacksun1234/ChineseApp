package com.project.appchinese.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.appchinese.R;
import com.project.appchinese.activity.exercises.GapTextActivity;
import com.project.appchinese.activity.exercises.TranslateActivity;
import com.project.appchinese.models.Theme;

public class ExercisesActivity extends AppCompatActivity
{
	private Theme theme;

	private Button exo1;
	private Button exo2;
	private Button exo3;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercises);

		theme = (Theme) getIntent().getSerializableExtra("theme");

		exo1 = findViewById(R.id.exo1);
		exo2 = findViewById(R.id.exo2);
		exo3 = findViewById(R.id.exo3);

		if(theme.getWords().isEmpty()) {
			exo1.setEnabled(false);
		}

		if(theme.getChoices().isEmpty()) {
			exo3.setEnabled(false);
		}
	}

	public void onClickExo1(View view)
	{
		Intent intent = new Intent(this, TranslateActivity.class);
		intent.putExtra("theme", theme);
		startActivityForResult(intent, 0);
	}

	public void onClickExo2(View view)
	{
		Intent intent = new Intent(this, TranslateActivity.class);
		intent.putExtra("theme", theme);
		startActivityForResult(intent, 0);
	}

	public void onClickExo3(View view)
	{
		Intent intent = new Intent(this, GapTextActivity.class);
		intent.putExtra("theme", theme);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		finish();
	}
}
