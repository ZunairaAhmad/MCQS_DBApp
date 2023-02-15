package com.example.mcqs_dbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPrime;
    Button btnComp;

    TextView textQ;
    TextView textAns;
    TextView textScore;
    TextView textQNum;

    int questCount=1;
    int score=0;
    int num=0;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQ=findViewById(R.id.textQuestions);
        textQNum = findViewById(R.id.QNo);
        textScore = findViewById(R.id.TotalScore);
        textAns = findViewById(R.id.Ans);

        btnPrime = findViewById(R.id.prime);
        btnPrime.setOnClickListener(this);
        btnComp = findViewById(R.id.composite);
        btnComp.setOnClickListener(this);

        RandomNumbersGeneration();
    }

    private void RandomNumbersGeneration(){

        Random randomNo= new Random();

        if(questCount<=20) {
            num = randomNo.nextInt(100) + 1;
            textQNum.setText("Question No: "+questCount);
            textQ.setText(num + " is Prime Number or Composite Number?");

            for (int i = 2; i <= num / 2; ++i) {
                // condition for nonprime number
                if (num % i == 0) {
                    flag = true;
                    break;
                }
                else{
                    flag = false;
                }
            }
        }
    }

    @Override
    public void onClick(View view){

        if (questCount <=20) {
            switch (view.getId()) {
                case R.id.prime:
                    if (flag == false) {
                        textAns.setText("Wohoo! Correct Answer!");
                        score++;
                        textScore.setText("Total Score: " + score);
                    } else {
                        textAns.setText("Ouch! Incorrect Answer!");
                    }
                    break;

                case R.id.composite:
                    if (flag == true) {
                        textAns.setText("Wohoo! Correct Answer!");
                        score++;
                        textScore.setText("Total Score: " + score);
                    } else {
                        textAns.setText("Ouch! Incorrect Answer!");
                    }
                    break;
            }questCount++;
            RandomNumbersGeneration();
        }

    }
}