package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoginForm extends JFrame {

    final int X_COORDINATE = 500;
    final int Y_COORDINATE = 300;
    final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = 500;
    final int GRID_ROWS = 6;
    final int GRID_COLUMNS = 1;
    final int VERTICAL_GAP = 10;
    final int HORIZONTAL_GAP = 2;

    JTextField login = new JTextField();
    JTextField password = new JTextField();
    JButton button = new JButton("Login");
    ArrayList<String> questionArray = new ArrayList<>();
    ArrayList<String[]> optionArray = new ArrayList<>();
    ArrayList<String> correctAnswers = new ArrayList<>();

    public LoginForm() {
        super("Quiz Game");
        super.setBounds(X_COORDINATE, Y_COORDINATE, FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));

        container.add(new JLabel("QUIZ-GAME"));
        container.add(new JLabel("Enter your login"));
        container.add(login);
        container.add(new JLabel("Enter your password"));
        container.add(password);
        container.add(button);

        button.addActionListener(new ButtonEventManager());
    }

    public void setData(ArrayList<String> questions, ArrayList<String[]> options, ArrayList<String> correctAns) {

        this.questionArray = questions;
        this.optionArray = options;
        this.correctAnswers = correctAns;

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(login.getText().equals("John") && password.getText().equals("password")) {
                AdminPage adminPage = new AdminPage();
                adminPage.setVisible(true);
                dispose();
            } else if (questionArray.size() != 0 && optionArray.size() != 0 && correctAnswers.size() != 0 ) {
                Results.userNames.add(login.getText());
                UserPage userPage = new UserPage(login.getText());
                userPage.setVisible(true);
                userPage.takeQuiz(questionArray, optionArray, correctAnswers);
            } else {
                JOptionPane.showMessageDialog(null, "There are no questions yet. Wait for admin to add some");
            }

        }
    }
}
