package org.example.Service;

public interface Administration {
    public default void register(){
    }
    public default String login(){
        return null;
    }
    public default void addQuestions(){}
    public default void deleteQuestions(){}
    public default void viewQuestions(){}
    public default void setUpTest(String userId){}
}