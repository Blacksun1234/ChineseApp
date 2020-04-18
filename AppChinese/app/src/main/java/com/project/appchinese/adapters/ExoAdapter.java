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
import com.project.appchinese.models.Exo;
import com.project.appchinese.models.Word;

import java.util.List;
import java.util.Random;

public class ExoAdapter extends RecyclerView.Adapter<ExoAdapter.ViewHolder>
{
	private Activity activity;
	private List<Exo> exercises;

	public class ViewHolder extends RecyclerView.ViewHolder
	{
		private Exo exo;
		private Button button;

		public ViewHolder(View view)
		{
			super(view);
			button = view.findViewById(R.id.button);
		}

		public void setView(final Exo exo)
		{
			this.exo = exo;
			button.setText(exo.getTitle());
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent = new Intent(activity, exo.getActivity());
					intent.putExtra("word", randomWord());
					activity.startActivity(intent);
				}
			});
		}

		private Word randomWord()
		{
			Random random = new Random();
			int index = random.nextInt(exo.getTheme().getWords().size());
			return exo.getTheme().getWords().get(index);
		}
	}

	public ExoAdapter(Activity activity, List<Exo> exercises)
	{
		this.activity = activity;
		this.exercises = exercises;
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
		Exo exo = exercises.get(position);
		holder.setView(exo);
	}

	@Override
	public int getItemCount()
	{
		return exercises.size();
	}

}
