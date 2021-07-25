package com.domesoft.quizerlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.domesoft.quizer.Quiz;
import com.domesoft.quizer.Quizer;

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

        Quizer quizer = new Quizer(this).setPrimaryElement(tvQ,tvO1,tvO2,tvO3,tvO4).setQuizList(myQuiz);
        quizer.setProgressBar(progressBar);

        quizer.setOnSuccessListener(new Quizer.SetOnSuccessListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        }).setOnFailureListener(new Quizer.SetOnFailureListener() {
            @Override
            public void onFailure(int currentPosition) {
                Toast.makeText(MainActivity.this, "Correct answer is "+ myQuiz.get(currentPosition).getAnswer(), Toast.LENGTH_SHORT).show();
            }
        }).setOnFinishedListener(new Quizer.SetOnFinishedListener() {
            @Override
            public void onFinished(int finalScore) {
                Toast.makeText(MainActivity.this, "Your score is "+String.valueOf(finalScore), Toast.LENGTH_SHORT).show();
            }
        });
        int score = 10;
        quizer.setScore(score,10,tvScore);
        quizer.create();







    }
}