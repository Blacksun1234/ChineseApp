package com.project.appchinese.models;

import java.util.List;

public class Theme
{
	private String theme;
	private List<Word> words;

	public Theme(String theme, List<Word> words)
	{
		this.theme = theme;
		this.words = words;
	}

	public String getTheme() {
		return theme;
	}

	public List<Word> getWords() {
		return words;
	}
}
