package com.project.appchinese.models;

import java.io.Serializable;
import java.util.List;

public class Theme implements Serializable
{
	private String theme;
	private List<Translate> words;
	private List<Translate> sentences;
	private List<Choice> choices;

	public Theme(String theme, List<Translate> words, List<Translate> sentences, List<Choice> choices)
	{
		this.theme = theme;
		this.words = words;
		this.sentences = sentences;
		this.choices = choices;
	}

	public String getTheme() {
		return theme;
	}

	public List<Translate> getWords() {
		return words;
	}

	public List<Translate> getSentences() {
		return sentences;
	}

	public List<Choice> getChoices() {
		return choices;
	}
}
