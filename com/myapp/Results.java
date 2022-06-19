package com.myapp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Results extends JFrame{

    final int X_COORDINATE = 500;
    final int Y_COORDINATE = 300;
    final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = Results.userNames.size() * 50;
    final int GRID_ROWS = 1 + Results.userNames.size();
    final int GRID_COLUMNS = 2;
    final int VERTICAL_GAP = 10;
    final int HORIZONTAL_GAP = 2;

    static ArrayList<String> userNames = new ArrayList<>();
    static ArrayList<Integer> userScores = new ArrayList<>();
    JLabel userName, userScore;

    public Results() {

        super("RESULT TABLE");
        super.setBounds(X_COORDINATE, Y_COORDINATE, FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));

        container.add(new JLabel("Name:"));
        container.add(new JLabel("Score"));

        for(int i = 0; i < Results.userNames.size(); i++) {
            userName = new JLabel(Results.userNames.get(i));
            userScore = new JLabel(String.valueOf(Results.userScores.get(i)));

            container.add(userName);
            container.add(userScore);
        }

    }
}