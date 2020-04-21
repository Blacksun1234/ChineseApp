package com.project.appchinese.activity.exercises;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.project.appchinese.R;
import com.project.appchinese.Utils;
import com.project.appchinese.models.Database;
import com.project.appchinese.models.Theme;
import com.project.appchinese.models.Translate;

import java.util.Collections;
import java.util.List;

import de.mateware.snacky.Snacky;

public class TranslateActivity extends AppCompatActivity
{
    private TextView textView;
    private EditText editText;
    private Button next;

    private Theme theme;

    private int count = 0;
    private int max = 3;
    private List<Translate> translates;
    boolean isWord = true;

    private int correctAnswers = 0;
    private boolean replied = false;
    private boolean clickNext = true;

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        theme = (Theme) getIntent().getExtras().getSerializable("theme");
        isWord = getIntent().getExtras().getBoolean("word");

        List<Translate> copy = isWord ? theme.getWords() : theme.getSentences();
        Collections.shuffle(copy);
        if(copy.size() < max) {
            translates = copy;
        }
        else {
            translates = copy.subList(0, max);
        }

        textView = findViewById(R.id.translate);
        editText = findViewById(R.id.answer);
        next = findViewById(R.id.next);
        updateView();

        editText.setHint(isWord ? "Word" : "Sentence");
    }

    private void updateView()
    {
        Log.d(Utils.TAG, "Answer : " + translates.get(count).getFr());
        clickNext = false;
        textView.setText(translates.get(count).getHanzi());
        editText.setText("");
        next.setVisibility(View.INVISIBLE);
    }

    public void onClickAnswer(View view)
    {
        if(replied) {
            return;
        }

        Utils.hideSoftKeyboard(this);
        String answer = editText.getText().toString();

        replied = true;

        Translate translate = translates.get(count);
        count++;

        if(answer.toLowerCase().equals(translate.getFr().toLowerCase())) {
            snackbar = Snacky.builder()
                    .setActivity(this)
                    .success()
                    .setText("Bravo, c'est la bonne réponse !\n" + count + "/" + max)
                    .setDuration(BaseTransientBottomBar.LENGTH_LONG);
            snackbar.show();
            correctAnswers++;
            next();
        }
        else {
            snackbar = Snacky.builder()
                    .setActivity(this)
                    .error()
                    .setText("Réponse incorrecte !\nVoici la bonne réponse : " + translate.getFr() +
                            "\n" + count + "/" + max)
                    .setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
            snackbar.show();

            if(translates.size() == count) {
                next.setText(R.string.end);
                view.setVisibility(View.INVISIBLE);
            }
            next.setVisibility(View.VISIBLE);
        }
    }

    public void next()
    {
        replied = false;
        if(translates.size() == count) {
            next.setText(R.string.end);
            next.setVisibility(View.VISIBLE);
            if(clickNext)
            {
                Database.getInstance().addGrade(correctAnswers);
                finish();
            }
        }
        else {
            updateView();
        }
    }

    public void onClickNext(View view)
    {
        clickNext = true;
        next();
    }
}
