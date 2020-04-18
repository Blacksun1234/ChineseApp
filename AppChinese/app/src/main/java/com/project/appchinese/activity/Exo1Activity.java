package com.project.appchinese.activity;

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
import com.project.appchinese.models.Theme;
import com.project.appchinese.models.Word;

import java.util.Collections;
import java.util.List;

import de.mateware.snacky.Snacky;

public class Exo1Activity extends AppCompatActivity
{
    private TextView textView;
    private EditText editText;
    private Button next;

    private Theme theme;

    private int count = 0;
    private int max = 3;
    private List<Word> words;

    private int correctAnswers = 0;
    private boolean replied = false;
    private boolean clickNext = true;

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo1);

        theme = (Theme) getIntent().getExtras().getSerializable("theme");

        List<Word> copy = theme.getWords();
        Collections.shuffle(copy);
        if(copy.size() < 3) {
            words = copy;
        }
        else {
            words = copy.subList(0, max);
        }

        textView = findViewById(R.id.word);
        editText = findViewById(R.id.answer);
        next = findViewById(R.id.next);
        updateView();
    }

    private void updateView()
    {
        Log.d(Utils.TAG, "Answer : " + words.get(count).getFr());
        clickNext = false;
        textView.setText(words.get(count).getHanzi());
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
        correctAnswers++;

        Word word = words.get(count);
        count++;

        if(answer.toLowerCase().equals(word.getFr().toLowerCase())) {
            snackbar = Snacky.builder()
                    .setActivity(this)
                    .success()
                    .setText("Bravo, c'est la bonne réponse !\n" + count + "/" + max)
                    .setDuration(BaseTransientBottomBar.LENGTH_LONG);
            snackbar.show();

            //Toasty.success(this, "Bravo, c'est la bonne réponse !", Toast.LENGTH_SHORT, true).show();
            next();
        }
        else {
            snackbar = Snacky.builder()
                    .setActivity(this)
                    .error()
                    .setText("Réponse incorrecte !\nVoici la bonne réponse : " + word.getFr() +
                            "\n" + count + "/" + max)
                    .setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
            snackbar.show();

            //Toasty.error(this, "Cette réponse est incorrecte !", Toast.LENGTH_LONG, true).show();

            if(words.size() == count) {
                next.setText(R.string.end);
            }
            next.setVisibility(View.VISIBLE);
        }
    }

    public void next()
    {
        replied = false;
        if(words.size() == count) {
            next.setText(R.string.end);
            next.setVisibility(View.VISIBLE);
            if(clickNext) {
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
