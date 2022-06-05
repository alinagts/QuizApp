package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPage extends JFrame{

    JLabel questionText, score;
    JButton option1, option2, option3, option4;
    JButton restart = new JButton("Start again");
    JLabel scoreText = new JLabel("Your current score:");
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String[]> options = new ArrayList<>();
    ArrayList<String> correctAns = new ArrayList<>();
    int index = 0;
    int correctGuesses = 0;

    public UserPage() {

        super("Quiz");
        super.setBounds(500, 300, 600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(7, 1, 2, 10));

        questionText = new JLabel("Question text");
        score = new JLabel("score");
        option1 = new JButton();
        option2 = new JButton();
        option3 = new JButton();
        option4 = new JButton();

        scoreText.setHorizontalAlignment(JTextField.CENTER);
        score.setHorizontalAlignment(JTextField.CENTER);


        container.add(questionText);
        container.add(option1);
        container.add(option2);
        container.add(option3);
        container.add(option4);
        container.add(scoreText);
        container.add(score);

        option1.addActionListener(new UserPage.ButtonEventManager());
        option2.addActionListener(new UserPage.ButtonEventManager());
        option3.addActionListener(new UserPage.ButtonEventManager());
        option4.addActionListener(new UserPage.ButtonEventManager());
        restart.addActionListener(new UserPage.ButtonEventManager());

    }

    public void takeQuiz(ArrayList<String> questions, ArrayList<String[]> options, ArrayList<String> correctAns) {
        this.questions = questions;
        this.options = options;
        this.correctAns = correctAns;

        nextQuestion();
    }

    public void nextQuestion() {

        if(index < questions.size()) {

            questionText.setText(questions.get(index));
            option1.setText(options.get(index)[0]);
            option2.setText(options.get(index)[1]);
            option3.setText(options.get(index)[2]);
            option4.setText(options.get(index)[3]);

            score.setText(correctGuesses + "/" + questions.size());

        } else {
            JOptionPane.showMessageDialog(null,   "Your score is " + correctGuesses + "/" + questions.size());

            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);
        }


    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            if(e.getSource() == option1) {
                if(option1.getText().equals(correctAns.get(index))) {
                    correctGuesses++;
                }
                index++;
                nextQuestion();
            }
            if(e.getSource() == option2) {
                if(option2.getText().equals(correctAns.get(index))) {
                    correctGuesses++;
                }
                index++;
                nextQuestion();
            }
            if(e.getSource() == option3) {
                if(option3.getText().equals(correctAns.get(index))) {
                    correctGuesses++;
                }
                index++;
                nextQuestion();
            }
            if(e.getSource() == option4) {
                if(option4.getText().equals(correctAns.get(index))) {
                    correctGuesses++;
                }
                index++;
                nextQuestion();
            }

            if(e.getSource() == restart) {
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);
                index = 0;
                correctGuesses = 0;
                nextQuestion();
            }

        }

    }

}
