package com.domesoft.quizer;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Quizer {

    private int currentIndex = 0;
    private String currentQuestion, currentOption1,currentOption2,currentOption3,currentOption4;
    private TextView tvQuestion, tvOption1,tvOption2,tvOption3,tvOption4;
    private Button btnOption1,btnOption2,btnOption3,btnOption4;

    private List<Quiz> quizList;
    private Context context;

    public Quizer(Context applicationContext) {
        this.context = applicationContext;
    }

    public Quizer setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
        return this;
    }

    public Quizer setPrimaryElement(TextView tvQuestion, TextView tvOption1, TextView tvOption2, TextView tvOption3, TextView tvOption4) {

        this.tvQuestion = tvQuestion;
        this.tvOption1 = tvOption1;
        this.tvOption2 = tvOption2;
        this.tvOption3 = tvOption3;
        this.tvOption4 = tvOption4;
        return this;
    }

    public Quizer setPrimaryElement(TextView tvQuestion, Button btnOption1, Button btnOption2, Button btnOption3, Button btnOption4) {

        this.tvQuestion = tvQuestion;
        this.btnOption1 = btnOption1;
        this.btnOption2 = btnOption2;
        this.btnOption3 = btnOption3;
        this.btnOption4 = btnOption4;
        return this;
    }

    private void setQuiz(int currentIndex) {
        currentQuestion = quizList.get(currentIndex).getQuestion();
        currentOption1 = quizList.get(currentIndex).getOption1();
        currentOption2 = quizList.get(currentIndex).getOption2();
        currentOption3 = quizList.get(currentIndex).getOption3();
        currentOption4 = quizList.get(currentIndex).getOption4();

        if (tvQuestion!=null){
            tvQuestion.setText(currentQuestion);
        }

        if (tvOption1!=null && tvOption2!=null && tvOption3!=null && tvOption4!=null){
            tvOption1.setText(currentOption1);
            tvOption2.setText(currentOption2);
            tvOption3.setText(currentOption3);
            tvOption4.setText(currentOption4);
        }

        if (btnOption1!=null && btnOption2!=null && btnOption3!=null && btnOption4!=null){
            btnOption1.setText(currentOption1);
            btnOption2.setText(currentOption2);
            btnOption3.setText(currentOption3);
            btnOption4.setText(currentOption4);
        }

    }
    private void setOnClick(TextView tvOption) {

        tvOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(String.valueOf(tvOption.getText()));
            }
        });
    }

    private void checkAnswer(String userSelection) {
        String currentAnswer = quizList.get(currentIndex).getAnswer();

        if (userSelection.equals(currentAnswer)){
            Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
            updateQuestion();
        }

        else{
            Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private void updateQuestion() {

        currentIndex = (currentIndex+1)%quizList.size();
        setQuiz(currentIndex);

    }


    public Quizer create() {

        setQuiz(currentIndex);

        setOnClick(tvOption1);
        setOnClick(tvOption2);
        setOnClick(tvOption3);
        setOnClick(tvOption4);

        return this;
    }
}
