package com.project.appchinese.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.project.appchinese.fragments.Dashboard;
import com.project.appchinese.fragments.Learn;
import com.project.appchinese.fragments.Me;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends FragmentStatePagerAdapter
{
	private List<Fragment> fragments;

	public MenuAdapter(@NonNull FragmentManager fm)
	{
		super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

		fragments = new ArrayList<>();
		fragments.add(new Learn());
		fragments.add(new Dashboard());
		fragments.add(new Me());
	}

	@NonNull
	@Override
	public Fragment getItem(int position)
	{
		return fragments.get(position);
	}

	@Override
	public int getCount()
	{
		return fragments.size();
	}
}
