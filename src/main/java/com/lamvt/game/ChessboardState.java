package com.lamvt.game;

import com.lamvt.Main;

public class ChessboardState {
    public int[][] eBoard;
    public int[][] posBoard;

    public ChessboardState(Chessboard board)
    {
        eBoard = new int[board.row][board.col];
        posBoard = new int[board.row][board.col];
    }

    private void resetBoard(int[][] board){
        for (int i = 0; i < Main.CHESSBOARD_ROW; i++) {
            for (int j = 0; j < Main.CHESSBOARD_COL; j++) {
                board[i][j] = 0;
            }
        }
    }
    public void resetEBoard(){
        this.resetBoard(eBoard);
    }
    public void resetPosBoard(){
        this.resetBoard(posBoard);
    }

    public int[][] clonePosBoard(){
        int[][] clone = new int[Main.CHESSBOARD_ROW][Main.CHESSBOARD_COL];
        for (int i = 0; i < Main.CHESSBOARD_ROW; i++) {
            System.arraycopy(posBoard[i], 0, clone[i], 0, Main.CHESSBOARD_COL);
        }
        return clone;
    }

    public int gameOver(int x, int y){
        int row = 0, col = 0;
        int i;
        boolean human, pc;

        //check hang ngang
        while (col < Main.CHESSBOARD_COL - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (posBoard[x][col + i] != 1) {
                    human = false;
                }
                if (posBoard[x][col + i] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            col++;
        }

        //check hang doc
        while (row < Main.CHESSBOARD_ROW - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (posBoard[row + i][y] != 1) {
                    human = false;
                }
                if (posBoard[row + i][y] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            row++;
        }

        //check cheo chinh
        row = y;
        col = x;
        while (row > 0 && col > 0) {
            row--;
            col--;
        }
        while (row <= Main.CHESSBOARD_ROW - 5 && col <= Main.CHESSBOARD_COL - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (posBoard[col + i][row + i] != 1) {
                    human = false;
                }
                if (posBoard[col + i][row + i] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            row++;
            col++;
        }

        //check cheo phu
        row = y;
        col = x;
        while (row < Main.CHESSBOARD_ROW - 1 && col > 0) {
            row++;
            col--;
        }
        while (row >= 4 && col <= Main.CHESSBOARD_COL - 5) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (posBoard[row - i][col + i] != 1) {
                    human = false;
                }
                if (posBoard[row - i][col + i] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            row--;
            col++;
        }
        return 0;
    }
}
