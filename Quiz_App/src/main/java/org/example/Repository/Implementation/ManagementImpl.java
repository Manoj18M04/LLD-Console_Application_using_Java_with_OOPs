package org.example.Repository.Implementation;

import org.example.Model.Questions;
import org.example.Model.User;
import org.example.Repository.Management;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ManagementImpl implements Management {

    static int adminId = 0;
    static int trainerId = 0;
    static int studentId = 0;
    static int questionNo = 0;
    static int ongoingTest = 0;
    HashMap<String, User> userDetails = new HashMap<>();
    HashMap<Integer, Questions> questionList = new HashMap<>();
    HashMap<String, Questions> test = new HashMap<>();

    @Override
    public void registerUser(String role, String name, String password) {
        String id = switch (role) {
            case "Admin" -> 'A' + String.valueOf(++adminId);
            case "Trainer" -> 'T' + String.valueOf(++trainerId);
            case "Student" -> 'S' + String.valueOf(++studentId);
            default -> null;
        };
        User user = new User(id,  role, name, password);
        userDetails.put(id, user);
        System.out.println("Registered Successfully");
        System.out.println("Your user id for further login will be - " + id);
    }

    @Override
    public String validateUser(String userId, String password) {
        User temp = userDetails.getOrDefault(userId, null);
        if(temp != null && Objects.equals(temp.getPassword(), password)){
            return userId;
        }
        return null;
    }

    @Override
    public void addQuestion(String q, String a, String b, String c, String d, String ans, String diff) {
        Questions ques = new Questions(q, a, b, c, d, ans,diff);
        questionList.put(++questionNo, ques);
    }

    @Override
    public void deleteQuestion(int n) {
        Questions temp = questionList.getOrDefault(n, null);
        Scanner sc = new Scanner(System.in);
        if(temp == null){
            System.out.println("Incorrect Question Number");
            return;
        }
        else{
            System.out.println(temp.getQuestion());
            System.out.println("Is this the question you want to delete");
            System.out.println("1 - Yes, 2 - No");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    questionList.remove(n, temp);
                case 2:
                    System.out.println("Enter the correct Question Number");
                    return;
            }
        }
    }

    @Override
    public void viewQuestion(int choice) {
        Scanner sc = new Scanner(System.in);
        if(choice == 2){
            System.out.println("Enter the Question Number to view");
            int num = sc.nextInt();
            Questions temp = questionList.getOrDefault(num, null);
            if(temp == null){
                System.out.println("Incorrect Question Number");
                return;
            }
            else{
                System.out.println(temp.getQuestion());
                System.out.println(temp.getOptionA());
                System.out.println(temp.getOptionB());
                System.out.println(temp.getOptionC());
                System.out.println(temp.getOptionD());
                System.out.println(temp.getAnswer());
                System.out.println(temp.getComplexity());
            }
        }
        else if(choice == 1){
            for(Map.Entry<Integer, Questions> e : questionList.entrySet()){
                System.out.println("Question No - " + e.getKey());
                System.out.println(e.getValue().getQuestion());
                System.out.println(e.getValue().getOptionA());
                System.out.println(e.getValue().getOptionB());
                System.out.println(e.getValue().getOptionC());
                System.out.println(e.getValue().getOptionD());
                System.out.println(e.getValue().getAnswer());
                System.out.println(e.getValue().getComplexity());
            }
        }
        else{
            return;
        }
    }

    @Override
    public void setUpTest(String userId, int noOfQuestions, int noOfTestsToBeOmitted) {
        ongoingTest = ongoingTest + 1;
        System.out.println(ongoingTest);
        System.out.println(questionList.get(0));
        for(Map.Entry<Integer, Questions> e : questionList.entrySet()){
            System.out.println("Inside a loop - 1");
            if(noOfQuestions > 0){
                System.out.println("Inside if - 1");
                if(noOfTestsToBeOmitted >= ongoingTest - 1){
                    String TestId = userId + "-Test0" + ongoingTest;
                    test.put(TestId, e.getValue());
                    e.getValue().setLastTest(ongoingTest);
                    System.out.println("ok");
                }
                else if(e.getValue().getLastTest() >= ongoingTest - noOfTestsToBeOmitted){
                    String TestId = userId + "-Test0" + ongoingTest;
                    test.put(TestId, e.getValue());
                    e.getValue().setLastTest(ongoingTest);
                    System.out.println("ok else if");
                }
                noOfQuestions = noOfQuestions - 1;
            }
            else{
                System.out.println("The test can't be conducted with 0 questions");
                return;
            }
        }
        for(Map.Entry<String, Questions> t : test.entrySet()){
            System.out.println("Entering 2nd loop");
            System.out.println(t.getKey());
            System.out.println(t.getValue());
        }
        System.out.println("out of loop in setUpTest method");
    }
}