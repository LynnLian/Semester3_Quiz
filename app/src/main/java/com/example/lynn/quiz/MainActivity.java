package com.example.lynn.quiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//TODO: setup github repository

public class MainActivity extends AppCompatActivity {
    QuestionRepository questionSet = new QuestionRepository();
    Question showedQuestion;
    String[] answers = new String[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuestionSet();

    }

    public class MyOnClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Button button = (Button) v;

            String clickedAnswer = (String) button.getText();

            String correctAnswer = showedQuestion.getCorrectAnswer();

            if (clickedAnswer != correctAnswer) {
                button.setEnabled(false);
            } else {
                button.setBackgroundColor(Color.GREEN);

                setToast();

                // TODO: Ask professer what is the solution to displayQuestionSet after the toast disappears

                displayQuestionSet();


            }
        }
    }

    public void displayQuestionSet() {

        showedQuestion = questionSet.randomQuestion();

//       Test to get random Question
//        Log.d("Q",showedQuestion.getQuestion());
//        Log.d("A",showedQuestion.getAnswer1());
//        Log.d("A",showedQuestion.getAnswer2());
//        Log.d("A",showedQuestion.getAnswer3());
//        Log.d("A",showedQuestion.getAnswer4());

        answers = showedQuestion.getAllAnswers();

//        System.out.println("newAnswer" + Arrays.toString(answers));

        TextView question = (TextView) findViewById(R.id.question);
        question.setText(showedQuestion.getQuestion());

        Button btnAnswer1 = (Button) findViewById((R.id.btnAnswer1));
        buttonSetting(btnAnswer1, 1);

        Button btnAnswer2 = (Button) findViewById((R.id.btnAnswer2));
        buttonSetting(btnAnswer2, 2);

        Button btnAnswer3 = (Button) findViewById((R.id.btnAnswer3));
        buttonSetting(btnAnswer3, 3);

        Button btnAnswer4 = (Button) findViewById((R.id.btnAnswer4));
        buttonSetting(btnAnswer4, 4);


        MyOnClickListener myOnClickListener1 = new MyOnClickListener();
        btnAnswer1.setOnClickListener(myOnClickListener1);

        MyOnClickListener myOnClickListener2 = new MyOnClickListener();
        btnAnswer2.setOnClickListener(myOnClickListener2);

        MyOnClickListener myOnClickListener3 = new MyOnClickListener();
        btnAnswer3.setOnClickListener(myOnClickListener3);

        MyOnClickListener myOnClickListener4 = new MyOnClickListener();
        btnAnswer4.setOnClickListener(myOnClickListener4);


    }

    public void buttonSetting(Button b, int btnNo) {

        {
            b.setText(answers[btnNo - 1]);
            b.setEnabled(true);
            b.setBackgroundResource(android.R.drawable.btn_default);

        }
    }

    public void setToast() {
        LayoutInflater inflater = getLayoutInflater();

        View toastLayout = inflater.inflate(R.layout.my_toast, (ViewGroup) findViewById(R.id.toast_root_view));

        TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
        header.setText("Correct!");

        TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
        body.setText("Let's try one more!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastLayout);
        toast.show();
    }


}
