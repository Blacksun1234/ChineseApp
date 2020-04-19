package com.project.appchinese.activity.exercises;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.project.appchinese.R;
import com.project.appchinese.Utils;
import com.project.appchinese.models.Choice;
import com.project.appchinese.models.Theme;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.mateware.snacky.Snacky;

public class GapTextActivity extends AppCompatActivity
{
	private MultiStateToggleButton buttons;
	private Button next;
	private TextView textView;

	private Theme theme;
	private Choice choice;

	private int correctAnswers = 0;
	private int max = 3;
	private int count = 0;

	private List<Choice> choices;

	private Snackbar snackbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gap_text);

		theme = (Theme) getIntent().getExtras().getSerializable("theme");

		List<Choice> copy = theme.getChoices();
		Collections.shuffle(copy);
		if(copy.size() < max) {
			choices = copy;
		}
		else {
			choices = copy.subList(0, max);
		}

		textView = findViewById(R.id.sentence);
		buttons = findViewById(R.id.choices);
		next = findViewById(R.id.next);

		updateView();
	}

	private void updateView()
	{
		choice = choices.get(count);
		Log.d(Utils.TAG, "Answer : " + choice.getCorrect());
		textView.setText(choice.getHanzi());
		List<String> copy = choice.getChoices();
		Collections.shuffle(copy);
		buttons.setElements(copy);
	}

	public void onClickNext(View view)
	{
		if(choices.size() == count) {
			finish();
			return;
		}

		count++;

		int index = buttons.getValue();

		if(index == -1) {
			return;
		}

		if(choice.getChoices().get(index).equals(choice.getCorrect()))
		{
			snackbar = Snacky.builder()
					.setActivity(this)
					.success()
					.setText("Bravo, c'est la bonne réponse !\n" + count + "/" + max)
					.setDuration(BaseTransientBottomBar.LENGTH_LONG);
			snackbar.show();
		}
		else
		{
			snackbar = Snacky.builder()
					.setActivity(this)
					.error()
					.setText("Réponse incorrecte !\nVoici la bonne réponse : " + choice.getCorrect() +
							"\n" + count + "/" + max)
					.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
			snackbar.show();
		}

		if(choices.size() == count) {
			next.setText(R.string.end);
		}
		else {
			updateView();
		}
	}
}
