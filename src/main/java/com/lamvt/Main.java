package com.lamvt;

import com.lamvt.frame.StartMenu;

import javax.swing.*;

public class Main {
    public static final int CHESSBOARD_ROW = 20;
    public static final int CHESSBOARD_COL = 20;
    public static final StartMenu menu = new StartMenu();

    public static void main(String[] args) {
//        custom look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ignored) {
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
//         start app
       menu.setVisible(true);
    }
}