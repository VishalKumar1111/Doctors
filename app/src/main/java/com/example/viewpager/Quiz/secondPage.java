package com.example.viewpager.Quiz;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewpager.R;

import java.util.ArrayList;
import java.util.List;

public class secondPage extends AppCompatActivity {
    private List<QuestionModel>  questionList;
    private TextView tvQuestion,tvScore,tvQuestionNo,tvTimer;
    private RadioGroup radioGroup;
    RadioButton rb1,rb2,rb3,rb4;
    Button btnNext;
    int totalQuestion;
    int qcounter=0;
    int score;

    ColorStateList dfRbColor;
    Boolean answered;
    CountDownTimer countDownTimer;

    private QuestionModel currentQuestion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        tvQuestion=findViewById(R.id.text_question);
        tvScore=findViewById(R.id.text_score);
        tvQuestionNo=findViewById(R.id.text_questionNo);
        tvTimer=findViewById(R.id.text_timer);
        questionList=new ArrayList<>();

        radioGroup=findViewById(R.id.radio_group);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
        btnNext=findViewById(R.id.btn_next);
        dfRbColor=rb1.getTextColors();


        addQuestion();
        totalQuestion=questionList.size();
        showNextQuestion();
        btnNext.setOnClickListener(v -> {
            if (!answered){
                if (rb1.isChecked() ||rb2.isChecked()||rb3.isChecked()||rb4.isChecked()){
                    checkAnswer();
                    countDownTimer.cancel();
                }else {
                    Toast.makeText(secondPage.this, "please Select an Option", Toast.LENGTH_SHORT).show();
                }
            }else {
                showNextQuestion();
            }
        });
    }

    private void checkAnswer() {
        answered=true;
        RadioButton rbselect =findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo=radioGroup.indexOfChild(rbselect)+1;
        if (answerNo == currentQuestion.getCorrectAnsNO()) {
            score++;
            tvScore.setText("score: " + score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNO()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if (qcounter<totalQuestion){
            btnNext.setText("Next");
        }else {
            btnNext.setText("Finished");
        }

    }

    private void showNextQuestion() {
        radioGroup.clearCheck();

        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);

        if (qcounter<totalQuestion){
            timer();
            currentQuestion=questionList.get(qcounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            qcounter++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question "+qcounter+"/"+totalQuestion);
            answered=false;
        }else {
            finish();
        }

    }

    private void timer() {
        countDownTimer =new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                tvTimer.setText("00:" + l/1000);
            }

            @Override
            public void onFinish() {
              showNextQuestion();;
            }
        }.start();
    }

    private void addQuestion() {
        questionList.add(new QuestionModel("Skin Specialist is called as _____________","(a) Physician",
                "(b) Dermatologist",
                "(c) Ophthalmologist",
                "(d) Cardiologist" ,"(b) Dermatologist"));
        questionList.add(new QuestionModel("Women's doctor ","(a) Geriatrician",
                "(b) Oncologist",
                "(c) Gynaecologist",
                "(d) Dermatologist" ,"(c) Gynaecologist"));
        questionList.add(new QuestionModel("Eye Doctor ","(a) Optician",
                "(b) Optometrist",
                "(c) Otolaryngologist",
                "(d) Ophthalmologist","(d) Ophthalmologist"));
        questionList.add(new QuestionModel("Doctor for mental illness","(a) Psychiatrist","(b) Physiotherapist"
                ,"(c) Neurologist",
                "(d) Oncologist", "(a) Psychiatrist"));
        questionList.add(new QuestionModel( "Children's Doctor","(a)  Veterinarian",
                "(b)  Geriatrician","(c)  Pediatrician","(d)  Physician",
                "(c) Pediatrician"));
        questionList.add(new QuestionModel( "Doctor who treats cancer","(a) Dermatologist","(b) Oncologist"
                ,"(c) Ophthalmologist", "(d) Cardiologist",
                "Ans: (b) Oncologist"));
        questionList.add(new QuestionModel( "Heart specialist","(a) Dermatologist",
                "(b) Oncologist","(c) Opthalmologist","(d) Cardiologist",
                "Ans: (d) Cardiologist"));
        questionList.add(new QuestionModel(  "Doctor for old people","(a)  Veterinarian",
                "(b)  Geriatrician","(c)  Pediatrician","(d)  Physician",
                " (b) Geriatrician"));
        questionList.add(new QuestionModel(  "Doctor who treats our teeth and gums problems","(a) Dermatologist","(b) Dentist"
                ,"(c) Physician","(d) Surgeon","(b) Dentist"));
        questionList.add(new QuestionModel(  "Doctor for common diseases","(a) Physician","(b) Pediatrician",
                "(c) Surgeon","(d) Geriatrician", "Ans: (a) Physician"));


    }
}