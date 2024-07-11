package org.example.Repository;

public interface Management {
    public default void registerUser(String name, String role, String password){}
    public default String validateUser(String userId, String password){
        return null;
    }
    public default void addQuestion(String q, String a, String b, String c, String d, String ans, String diff){}
    public default void deleteQuestion(int n){}
    public default void viewQuestion(int num){}
    public default void setUpTest(String userId, int noOfQuestions, int noOfTestsToBeOmitted){}
}