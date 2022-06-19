package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPage extends JFrame{

    final int X_COORDINATE = 500;
    final int Y_COORDINATE = 300;
    final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = 500;
    final int GRID_ROWS = 8;
    final int GRID_COLUMNS = 1;
    final int VERTICAL_GAP = 10;
    final int HORIZONTAL_GAP = 2;

    JLabel questionText = new JLabel();
    JLabel score = new JLabel();
    JButton[] options = new JButton[4];
    JButton restartButton = new JButton("Start again");
    String name;
    ArrayList<String> questionArray = new ArrayList<>();
    ArrayList<String[]> optionArray = new ArrayList<>();
    ArrayList<String> correctAnswers = new ArrayList<>();
    int index = 0;
    int correctGuesses = 0;

    public UserPage(String name) {

        super("Quiz");
        super.setBounds(X_COORDINATE, Y_COORDINATE, FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));

        container.add(questionText);

        for(int i = 0; i < 4; i++) {
            options[i] = new JButton();

            container.add(options[i]);
            options[i].addActionListener(new UserPage.ButtonEventManager());
        }

        container.add(new JLabel("Your current score:"));
        container.add(score);
        container.add(restartButton);

        restartButton.addActionListener(new UserPage.ButtonEventManager());

        this.name = name;
    }

    public void takeQuiz(ArrayList<String> questions, ArrayList<String[]> options, ArrayList<String> correctAns) {
        this.questionArray = questions;
        this.optionArray = options;
        this.correctAnswers = correctAns;

        nextQuestion();
    }

    public void nextQuestion() {

        String currentScore = correctGuesses + "/" + questionArray.size();

        if(index < questionArray.size()) {

            questionText.setText(questionArray.get(index));
            for(int i = 0; i < 4; i++) {
                options[i].setText(optionArray.get(index)[i]);
            }

            score.setText(currentScore);

        } else {
            int percentage = Math.round(correctGuesses * 100 / questionArray.size());
            JOptionPane.showMessageDialog(null,   name + ", your score is " + currentScore + "\n" + percentage + "%");

            for(int i = 0; i < 4; i++) {
                options[i].setEnabled(false);
            }
        }

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for(int i = 0; i < 4; i++) {
                if(e.getSource() == options[i]) {
                    if(options[i].getText().equals(correctAnswers.get(index))) {
                        correctGuesses++;
                    }
                    index++;
                    nextQuestion();
                }
            }

            if(e.getSource() == restartButton) {
                for(int i = 0; i < 4; i++) {
                    options[i].setEnabled(true);
                }
                index = 0;
                correctGuesses = 0;
                nextQuestion();
            }

        }

    }

}
