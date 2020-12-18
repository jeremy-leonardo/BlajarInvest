package com.mobileprog.blajarinvest;

public class Quiz {

    private long id;
    private String question;
    private String answer;
    private int isCompleted;

    public Quiz() {

    }

    public Quiz(long id, String question, String answer, int isCompleted) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.isCompleted = isCompleted;
    }

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isCompleted = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

}
