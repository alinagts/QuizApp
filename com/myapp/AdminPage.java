package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPage extends JFrame{

    final int X_COORDINATE = 500;
    final int Y_COORDINATE = 300;
    final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = 500;
    final int GRID_ROWS = 8;
    final int GRID_COLUMNS = 2;
    final int VERTICAL_GAP = 10;
    final int HORIZONTAL_GAP = 2;

    JLabel questLabel = new JLabel("Question text");
    JTextField question = new JTextField();
    JLabel optionLabel = new JLabel("options");
    JTextField[] options = new JTextField[4];
    JRadioButton[] radioButtons = new JRadioButton[4];
    JButton addButton = new JButton("Add question");
    JButton clearButton = new JButton("Clear all questions");
    JButton doneButton = new JButton("Done");
    ButtonGroup buttonGroup = new ButtonGroup();
    JLabel empty = new JLabel("");
    ArrayList<String> questionArray = new ArrayList<>();
    ArrayList<String[]> optionArray = new ArrayList<>();
    ArrayList<String> correctAnswers = new ArrayList<>();

    public AdminPage() {

        super("Admin Mode");
        super.setBounds(X_COORDINATE, Y_COORDINATE, FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));


        container.add(questLabel);
        container.add(question);
        container.add(optionLabel);
        container.add(empty);

        for(int i = 0; i < 4; i++) {
            options[i] = new JTextField();
            radioButtons[i] = new JRadioButton();

            container.add(radioButtons[i]);
            container.add(options[i]);
            buttonGroup.add(radioButtons[i]);
        }

        container.add(addButton);
        container.add(clearButton);
        container.add(doneButton);

        addButton.addActionListener(new ButtonEventManager());
        clearButton.addActionListener(new ButtonEventManager());
        doneButton.addActionListener(new ButtonEventManager());

    }

    public void addQuest(String quest, String[] opt) {

        this.questionArray.add(quest);
        this.optionArray.add(opt);

        for(int i = 0; i < 4; i++) {

            if(radioButtons[i].isSelected())
                this.correctAnswers.add(options[i].getText());

        }

    }

    public void clearList() {
        this.questionArray = new ArrayList<>();
        this.optionArray = new ArrayList<>();
        this.correctAnswers = new ArrayList<>();
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == addButton) {

                String[] opts = new String[4];
                boolean isChecked = false;

                for(int i = 0; i < 4; i++) {

                    opts[i] = options[i].getText();
                    if(radioButtons[i].isSelected())
                        isChecked = true;
                }

                if(question.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter the question");
                } else if(isChecked) {
                    addQuest(question.getText(), opts);

                    for(int i = 0; i < 4; i++) {
                        options[i].setText("");
                    }
                    question.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Choose a correct answer");
                }

            }

            if(e.getSource() == clearButton)
                clearList();

            if(e.getSource() == doneButton) {
                LoginForm form = new LoginForm(questionArray, optionArray, correctAnswers);
                form.setVisible(true);
                dispose();
            }

        }
    }

}
