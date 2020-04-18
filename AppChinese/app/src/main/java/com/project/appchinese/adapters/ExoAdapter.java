package com.project.appchinese.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.appchinese.R;
import com.project.appchinese.activity.ExercisesActivity;
import com.project.appchinese.models.Theme;
import com.project.appchinese.models.Word;

import java.util.List;
import java.util.Random;

public class ExoAdapter extends RecyclerView.Adapter<ExoAdapter.ViewHolder>
{
	private Activity activity;
	private List<Theme> themes;

	public class ViewHolder extends RecyclerView.ViewHolder
	{
		private Theme theme;
		private Button button;

		public ViewHolder(View view)
		{
			super(view);
			button = view.findViewById(R.id.button);
		}

		public void setView(final Theme theme)
		{
			this.theme = theme;
			button.setText(theme.getTheme());
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent = new Intent(activity, ExercisesActivity.class);
					intent.putExtra("theme", theme);
					activity.startActivity(intent);
				}
			});
		}
	}

	public ExoAdapter(Activity activity, List<Theme> themes)
	{
		this.activity = activity;
		this.themes = themes;
	}

	@Override
	public ExoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		Context context = parent.getContext();
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.exo_list_item, parent, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position)
	{
		holder.setView(themes.get(position));
	}

	@Override
	public int getItemCount()
	{
		return themes.size();
	}

}
