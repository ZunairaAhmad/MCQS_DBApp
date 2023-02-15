package com.example.mcqs_dbapp;

public class APP_BO {
    private int question;
    private String score;
    private String answer;

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

    public String getScore(){
        return score;
    }

    public void setScore(String sco){
        this.score = sco;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String ans){
        answer = ans;
    }

    @Override
    public String toString() {
        return "{Question=" + question + ", Your input=" + score + ", Correct answer=" + answer + "}";
    }
}
