package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoginForm extends JFrame {

    JLabel title = new JLabel("QUIZ-GAME");
    JLabel loginText = new JLabel("Enter your login");
    JTextField login = new JTextField();
    JLabel passwordText = new JLabel("Enter your password");
    JTextField password = new JTextField();
    JButton button = new JButton("Login");
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String[]> options = new ArrayList<>();
    ArrayList<String> correctAns = new ArrayList<>();

    public LoginForm() {
        super("Quiz Game");
        super.setBounds(500, 300, 600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(6, 1, 2, 10));

        title.setHorizontalAlignment(JTextField.CENTER);

        container.add(title);
        container.add(loginText);
        container.add(login);
        container.add(passwordText);
        container.add(password);
        container.add(button);

        button.addActionListener(new ButtonEventManager());
    }

    public LoginForm(ArrayList<String> questions, ArrayList<String[]> options, ArrayList<String> correctAns) {
        super("Quiz Game");
        super.setBounds(500, 300, 600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(6, 1, 2, 10));

        title.setHorizontalAlignment(JTextField.CENTER);

        container.add(title);
        container.add(loginText);
        container.add(login);
        container.add(passwordText);
        container.add(password);
        container.add(button);

        button.addActionListener(new ButtonEventManager());

        this. questions = questions;
        this.options = options;
        this.correctAns = correctAns;
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(login.getText().equals("John") && password.getText().equals("password")) {
                AdminPage adminPage = new AdminPage();
                adminPage.setVisible(true);
                dispose();
            } else if (questions.size() != 0 && options.size() != 0 && correctAns.size() != 0 ){
                UserPage userPage = new UserPage(login.getText());
                userPage.setVisible(true);
                userPage.takeQuiz(questions, options, correctAns);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "There are no questions yet. Wait for admin to add some");
            }

        }
    }
}
