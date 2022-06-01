package com.myapp;

import javax.swing.*;
import java.awt.*;

public class AdminPage extends JFrame{

    JLabel questionText = new JLabel("Question text");
    JTextField question = new JTextField();
    JLabel optionText = new JLabel("options");
    JTextField option1 = new JTextField();
    JTextField option2 = new JTextField();
    JTextField option3 = new JTextField();
    JTextField option4 = new JTextField();
    JButton add = new JButton("Add question");
    JButton clear = new JButton("Clear all questions");
    JButton done = new JButton("Done");

    public AdminPage() {
        super("Admin Mode");
        super.setBounds(500, 300, 600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(10, 1, 2, 10));

        container.add(questionText);
        container.add(question);
        container.add(optionText);
        container.add(option1);
        container.add(option2);
        container.add(option3);
        container.add(option4);
        container.add(add);
        container.add(clear);
        container.add(done);

    }

}
