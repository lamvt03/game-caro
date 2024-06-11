package com.lamvt.game;

import java.awt.*;

public class Chessboard {
    public int row;
    public int col;

    public static final int CHESSMAN_SIZE = 25;

    public Chessboard() {
        this.row = 0;
        this.col = 0;
    }

    public Chessboard(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Ve ban co
    public void drawChessboard(Graphics g) {
        for (int i = 0; i <= row; i++) {
            g.drawLine(i * CHESSMAN_SIZE, 0, i * CHESSMAN_SIZE, row * CHESSMAN_SIZE);
        }
        for (int j = 0; j <= col; j++) {
            g.drawLine(0, j * CHESSMAN_SIZE, col * CHESSMAN_SIZE, j * CHESSMAN_SIZE);
        }
    }

    // Ve quan co
    public void drawChessman(Graphics g, int row, int col, Image image) {
        g.drawImage(image, row, col, CHESSMAN_SIZE, CHESSMAN_SIZE, null);
    }
}
