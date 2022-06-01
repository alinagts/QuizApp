package com.myapp;

import javax.swing.*;
import java.awt.*;

public class UserPage extends JFrame{

    JLabel questionText, score;
    JButton option1, option2, option3, option4;
    JLabel scoreText = new JLabel("Your current score:");

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

    }

}
