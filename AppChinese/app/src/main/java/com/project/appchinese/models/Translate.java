package com.project.appchinese.models;

import java.io.Serializable;

public class Translate implements Serializable
{
	private String fr;
	private String hanzi;
	private String pinyin;

	public Translate(String fr, String hanzi, String pinyin)
	{
		this.fr = fr;
		this.hanzi = hanzi;
		this.pinyin = pinyin;
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
}
