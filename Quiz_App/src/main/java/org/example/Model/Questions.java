package org.example.Model;

public class Questions {
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    String complexity;
    int lastTest;

    public Questions(String question, String optionA, String optionB, String optionC, String optionD, String answer, String complexity) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.complexity = complexity;
    }
    public void setLastTest(int lastTest) {
        this.lastTest = lastTest;
    }
    public String getQuestion() {
        return question;
    }
    public String getOptionA() {
        return optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public String getOptionC() {
        return optionC;
    }
    public String getOptionD() {
        return optionD;
    }
    public String getAnswer() {
        return answer;
    }
    public String getComplexity() {
        return complexity;
    }
    public int getLastTest() {
        return lastTest;
    }
}