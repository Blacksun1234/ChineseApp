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

import java.util.List;

public class ExoAdapter extends RecyclerView.Adapter<ExoAdapter.ViewHolder>
{
	private Activity activity;
	private List<Exo> exos;

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
			button.setText(exo.getTitle());
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent = new Intent(activity, exo.getActivity());
					activity.startActivity(intent);
				}
			});
		}
	}

	public ExoAdapter(Activity activity, List<Exo> exos)
	{
		this.activity = activity;
		this.exos = exos;
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
		Exo exo = exos.get(position);
		holder.setView(exo);
	}

	@Override
	public int getItemCount()
	{
		return exos.size();
	}

}
