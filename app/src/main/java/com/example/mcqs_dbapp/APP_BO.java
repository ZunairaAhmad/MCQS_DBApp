package com.example.mcqs_dbapp;

public class APP_BO {
    private int question;
    private int score;
    private boolean answer;

    public APP_BO(int question, String score, String answer) {
        this.question = question;
        this.score = score;
        this.answer = answer;
    }

    public int getQuestion()    {
        return question;
    }

    public void setQuestion(int quest){
        this.question = quest;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int sco){
        this.score = sco;
    }

    public boolean getAnswer(){
        return answer;
    }

    public void setAnswer(boolean ans){
        answer = ans;
    }

    @Override
    public String toString() {
        return "APP_BO {question=" + question + ", score=" + score + ", answer=" + answer + "]";
    }
}
