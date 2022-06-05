package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    JRadioButton r1 = new JRadioButton();
    JRadioButton r2 = new JRadioButton();
    JRadioButton r3 = new JRadioButton();
    JRadioButton r4 = new JRadioButton();
    ButtonGroup bg = new ButtonGroup();
    JLabel empty = new JLabel("");
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String[]> options = new ArrayList<>();
    ArrayList<String> correctAns = new ArrayList<>();

    public AdminPage() {

        super("Admin Mode");
        super.setBounds(500, 300, 600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(8, 2, 2, 10));


        container.add(questionText);
        container.add(question);
        container.add(optionText);
        container.add(empty);
        container.add(r1);
        container.add(option1);
        container.add(r2);
        container.add(option2);
        container.add(r3);
        container.add(option3);
        container.add(r4);
        container.add(option4);
        container.add(add);
        container.add(clear);
        container.add(done);

        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        add.addActionListener(new ButtonEventManager());
        clear.addActionListener(new ButtonEventManager());
        done.addActionListener(new ButtonEventManager());

    }

    public void addQuest(String quest, String[] opt) {

        this.questions.add(quest);
        this.options.add(opt);

        if(r1.isSelected())
            this.correctAns.add(option1.getText());
        if(r2.isSelected())
            this.correctAns.add(option2.getText());
        if(r3.isSelected())
            this.correctAns.add(option3.getText());
        if(r4.isSelected())
            this.correctAns.add(option4.getText());
    }

    public void clearList() {
        this.questions = new ArrayList<>();
        this.options = new ArrayList<>();
        this.correctAns = new ArrayList<>();
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == add) {

                String[] opts = {option1.getText(), option2.getText(), option3.getText(), option4.getText()};
                boolean isChecked = r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected();

                if(question.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter the question");
                } else if(isChecked) {
                    addQuest(question.getText(), opts);

                    question.setText("");
                    option1.setText("");
                    option2.setText("");
                    option3.setText("");
                    option4.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Choose a correct answer");
                }

            }

            if(e.getSource() == clear)
                clearList();

            if(e.getSource() == done) {
                LoginForm form = new LoginForm();
                form.setVisible(true);
                dispose();
            }

        }
    }

}
