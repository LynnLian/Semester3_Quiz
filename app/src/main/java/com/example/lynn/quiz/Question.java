package com.example.lynn.quiz;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Question {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public Question (String question,String answer1,String answer2, String answer3, String answer4, String correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() { return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String[] getAllAnswers() {
        String[] allAnswers = new String[4];

        allAnswers[0] = answer1;
        allAnswers[1] = answer2;
        allAnswers[2] = answer3;
        allAnswers[3] = answer4;


        return  randomAnswers(allAnswers);
    }


    public String[] randomAnswers (String[] allAnswers) {
        ArrayList<Integer> n = new ArrayList<Integer>();
        Random r = new Random();
        String[] newAnswers = new String[4];


        while (n.size() < 4) {
            int randNo = r.nextInt(4);
            if (!n.contains(randNo)) {

                newAnswers[n.size()] = allAnswers[randNo];

                n.add(randNo);

            }
        }
//      To test the random number
//        for(Integer d:n) {
//            Log.d("A1",""+d);
//        }


        return newAnswers;

    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
