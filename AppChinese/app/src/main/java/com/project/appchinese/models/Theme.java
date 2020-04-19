package com.project.appchinese.models;

import java.io.Serializable;
import java.util.List;

public class Theme implements Serializable
{
	private String theme;
	private List<Word> words;
	private List<Choice> choices;

	public Theme(String theme, List<Word> words, List<Choice> choices)
	{
		this.theme = theme;
		this.words = words;
		this.choices = choices;
	}

	public String getTheme() {
		return theme;
	}

	public List<Word> getWords() {
		return words;
	}

	public List<Choice> getChoices() {
		return choices;
	}
}
