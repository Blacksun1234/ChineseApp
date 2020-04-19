package com.project.appchinese.models;

import java.io.Serializable;
import java.util.List;

public class Choice implements Serializable
{
	private String fr;
	private String hanzi;
	private String pinyin;
	private String correct;
	private List<String> choices;

	public Choice(String fr, String hanzi, String pinyin, String correct, List<String> choices)
	{
		this.fr = fr;
		this.hanzi = hanzi;
		this.pinyin = pinyin;
		this.correct = correct;
		this.choices = choices;
	}

	public String getFr() {
		return fr;
	}

	public String getHanzi() {
		return hanzi;
	}

	public String getPinyin() {
		return pinyin;
	}

	public String getCorrect() {
		return correct;
	}

	public List<String> getChoices() {
		return choices;
	}
}
