package com.bignerdranch.android.clickerquestions.structs;

//5 answer multiple choice question
public class MC5Question {
    private String question;
    private String[] answers;
    private int correctIdx;
    public MC5Question(String question, String[] answers, int correctIdx) {
        this.question = question;
        this.answers = answers;
        this.correctIdx = correctIdx;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectIdx() {
        return correctIdx;
    }
}
