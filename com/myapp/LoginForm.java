package com.myapp;

import javax.swing.*;
import java.awt.*;


public class LoginForm extends JFrame {

    JLabel title = new JLabel("QUIZ-GAME");
    JLabel loginText = new JLabel("Enter your login");
    JTextField login = new JTextField();
    JLabel passwordText = new JLabel("Enter your password");
    JTextField password = new JTextField();
    JButton button = new JButton("Login");

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

    }

}
