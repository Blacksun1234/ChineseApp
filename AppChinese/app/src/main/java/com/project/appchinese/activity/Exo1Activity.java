package com.project.appchinese.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.project.appchinese.R;
import com.project.appchinese.Utils;
import com.project.appchinese.models.Word;

import de.mateware.snacky.Snacky;
import es.dmoral.toasty.Toasty;

public class Exo1Activity extends AppCompatActivity
{
    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo1);

        word = (Word) getIntent().getExtras().getSerializable("word");

        Log.d(Utils.TAG, "Réponse : " + word.getFr());

        TextView textView = findViewById(R.id.word);
        textView.setText(word.getHanzi());
    }

    public void onClickAnswer(View view)
    {
        EditText editText = findViewById(R.id.answer);
        String answer = editText.getText().toString();

        if(answer.toLowerCase().equals(word.getFr().toLowerCase())) {
            Snacky.builder()
                    .setActivity(this)
                    .success()
                    .setText("Bravo, c'est la bonne réponse !")
                    .setDuration(BaseTransientBottomBar.LENGTH_LONG).show();
            //Toasty.success(this, "Bravo, c'est la bonne réponse !", Toast.LENGTH_SHORT, true).show();
        }
        else {
            Snacky.builder()
                    .setActivity(this)
                    .error()
                    .setText("Réponse incorrecte !\nVoici la bonne réponse : " + word.getFr())
                    .setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE).show();
            //Toasty.error(this, "Cette réponse est incorrecte !", Toast.LENGTH_LONG, true).show();
        }
    }
}
