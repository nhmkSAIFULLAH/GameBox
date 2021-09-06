package com.domesoft.gameboxlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.domesoft.gamebox.lazyquizer.LazyQuizer;
import com.domesoft.gamebox.Quiz;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvQ;
    TextView tvO1, tvO2, tvO3, tvO4;
    ProgressBar progressBar;
    TextView tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQ = findViewById(R.id.tvQ);
        tvO1 = findViewById(R.id.tvO1);
        tvO2 = findViewById(R.id.tvO2);
        tvO3 = findViewById(R.id.tvO3);
        tvO4 = findViewById(R.id.tvO4);
        progressBar = findViewById(R.id.progressBar);
        tvScore = findViewById(R.id.tvScore);


        String text = "what is the meaning of Abide ";
        String text1 = "what is the meaning of";
        int ind = text.indexOf("Abide");

        List<Quiz> myQuiz = new ArrayList<>();

        myQuiz.add(new Quiz("what is the meaning of A","A","2","3","4","A"));
        myQuiz.add(new Quiz("what is the meaning of B","B","2","3","4","B"));
        myQuiz.add(new Quiz("what is the meaning of C","C","2","3","4","C"));
        myQuiz.add(new Quiz("what is the meaning of D","D","2","3","4","D"));
        myQuiz.add(new Quiz("what is the meaning of E","E","2","3","4","E"));
        myQuiz.add(new Quiz("what is the meaning of F","F","2","3","4","F"));

        LazyQuizer lazyQuizer = new LazyQuizer(this).setPrimaryElement(tvQ,tvO1,tvO2,tvO3,tvO4).setQuizList(myQuiz).setOptionRandomly();
        lazyQuizer.setProgressBar(progressBar);

        lazyQuizer.setOnSuccessListener(currentPosition ->

                        Toast.makeText(MainActivity.this,String.valueOf(ind), Toast.LENGTH_SHORT).show()
        )

                .setOnFailureListener(currentPosition ->
                        Toast.makeText(MainActivity.this, "Correct answer is "+ myQuiz.get(currentPosition).getAnswer(), Toast.LENGTH_SHORT).show())
                .setOnFinishedListener(finalScore ->
                        Toast.makeText(MainActivity.this, "Your score is "+String.valueOf(finalScore), Toast.LENGTH_SHORT).show());
        int score = 10;
        lazyQuizer.setScore(score,10,tvScore).setSpannable("#FF03DAC5", 23);
        lazyQuizer.create();

    }
}