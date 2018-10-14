package com.example.lynn.quiz;

import java.util.ArrayList;
import java.util.Random;

public class QuestionRepository {
    private ArrayList<Question> questionSets = new ArrayList<Question>();

    public QuestionRepository () {
        questionSets.add(new Question("Which disease devastated livestock across the UK during 2001?",
                "Hand-and-foot","Foot-in-mouth","Hand-to-mouth","Foot-and-mouth",
                "Foot-and-mouth"));
        questionSets.add(new Question("Which of these kills its victims by constriction?",
                "Andalucia","Anaconda","Andypandy","Annerobinson",
                "Anaconda"));
        questionSets.add(new Question("Which of these might be used in underwater naval operations?",
                "Frogmen","Newtmen","Toadmen","Tadpolemen",
                "Frogmen"));
    }

    public Question randomQuestion() {
        Random rand = new Random();

        int randNo = rand.nextInt(3);

        return questionSets.get(randNo);
    }





}
