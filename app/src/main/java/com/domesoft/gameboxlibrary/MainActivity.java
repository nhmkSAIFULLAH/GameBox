package com.domesoft.gameboxlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.domesoft.gamebox.interfaces.SetOnFailureListener;
import com.domesoft.gamebox.interfaces.SetOnFinishedListener;
import com.domesoft.gamebox.interfaces.SetOnSuccessListener;
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


        List<Quiz> myQuiz = new ArrayList<>();
        myQuiz.add(new Quiz("what is the meaning of 1","1","2","3","4","1"));
        myQuiz.add(new Quiz("what is the meaning of 2","1","2","3","4","2"));
        myQuiz.add(new Quiz("what is the meaning of 3","1","2","3","4","3"));
        myQuiz.add(new Quiz("what is the meaning of 4","1","2","3","4","4"));
        myQuiz.add(new Quiz("what is the meaning of 5","1","2","5","4","5"));
        myQuiz.add(new Quiz("what is the meaning of 6","6","2","5","4","6"));

        LazyQuizer lazyQuizer = new LazyQuizer(this).setPrimaryElement(tvQ,tvO1,tvO2,tvO3,tvO4).setQuizList(myQuiz);
        lazyQuizer.setProgressBar(progressBar);

        lazyQuizer.setOnSuccessListener(currentPosition ->

                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show())

                .setOnFailureListener(currentPosition ->
                        Toast.makeText(MainActivity.this, "Correct answer is "+ myQuiz.get(currentPosition).getAnswer(), Toast.LENGTH_SHORT).show())
                .setOnFinishedListener(finalScore ->
                        Toast.makeText(MainActivity.this, "Your score is "+String.valueOf(finalScore), Toast.LENGTH_SHORT).show());
        int score = 10;
        lazyQuizer.setScore(score,10,tvScore);
        lazyQuizer.create();




    }
}