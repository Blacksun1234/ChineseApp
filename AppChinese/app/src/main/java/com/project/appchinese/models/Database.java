package com.project.appchinese.models;

import java.util.ArrayList;
import java.util.List;

public class Database
{
	private static Database instance = new Database();

	private List<Integer> grades;

	private Database()
	{
		this.grades = new ArrayList<>();
	}

	public static Database getInstance()
	{
		return instance;
	}

	public void addGrade(int grade)
	{
		grades.add(grade);
	}

	public List<Integer> getGrades() {
		return grades;
	}
}
