package com.lamvt.game;

import com.lamvt.Main;
import com.lamvt.frame.Match;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatchOperator {

    public Image imageO = new ImageIcon(getClass().getResource("/img/o.png")).getImage();
    public Image imageX = new ImageIcon(getClass().getResource("/img/x.png")).getImage();
    public Image imageWin = new ImageIcon(getClass().getResource("/img/winner.png")).getImage();
    public Image imageLose = new ImageIcon(getClass().getResource("/img/lose.png")).getImage();

    public final int INT_MAX = Integer.MAX_VALUE;
    public final int MAX_MOVE = 3;

    private final int BLANK_FLAG = 0;
    private final int HUMAN_FLAG = 1;
    private final int PC_FLAG = 2;

    public final Chessboard chessboard;
    public final ChessboardState state;
    public final ChessboardEvaluator evaluator;

    private final Random random;

    public boolean start;
    private int x, y;
    private int playerFlag;
    private int fEnd;
    private List<Point> undoList;

    private int maxDepth;

    public MatchOperator(int depth) {
        this.chessboard = new Chessboard(Main.CHESSBOARD_ROW, Main.CHESSBOARD_COL);
        this.state = new ChessboardState(chessboard);
        this.evaluator = new ChessboardEvaluator();

        this.random = new Random();
        this.maxDepth = depth;
    }

    public void startMatch(Graphics grs) {
        start = true;
        undoList = new ArrayList<>();
//        chessboard.drawChessboard(grs);

        //máy đi trước
        x = random.nextInt(3);
        y = random.nextInt(3);
        int ranX = x + 7;
        int ranY = y + 7;
        state.posBoard[ranX][ranY] = 2;
        undoList.add(new Point(ranX, ranY));
        chessboard.drawChessman(grs, ranX * Chessboard.CHESSMAN_SIZE, ranY * Chessboard.CHESSMAN_SIZE, imageO);
        playerFlag = HUMAN_FLAG;
        fEnd = 0;
    }

    public void repaintChessman(Graphics g) {
        for (Point point : undoList) {
            if (state.posBoard[point.x][point.y] == 1) {
                chessboard.drawChessman(g, point.x * 25, point.y * 25, imageX);
            } else if (state.posBoard[point.x][point.y] == 2) {
                chessboard.drawChessman(g, point.x * 25, point.y * 25, imageO);
            }
        }
    }

    public boolean hitChess(int mouseX, int mouseY, Graphics grs) {
        if(fEnd == 0 && playerFlag == HUMAN_FLAG) {
            if (mouseX % Chessboard.CHESSMAN_SIZE == 0 || mouseY % Chessboard.CHESSMAN_SIZE == 0) {
                return false;
            }

            // lấy tọa độ ô cờ trong ma trận
            int x = mouseX / Chessboard.CHESSMAN_SIZE;
            int y = mouseY / Chessboard.CHESSMAN_SIZE;

            // kiểm tra ô đó đã được đánh chưa
            if (state.posBoard[x][y] != 0) {
                return false;
            }

            // đánh cờ
            state.posBoard[x][y] = HUMAN_FLAG;
            undoList.add(new Point(x, y));
            chessboard.drawChessman(grs, x * Chessboard.CHESSMAN_SIZE, y * Chessboard.CHESSMAN_SIZE, imageX);
            if(state.gameOver(x, y) == HUMAN_FLAG){
                Match.timer.stop();
                grs.drawImage(imageWin, 0, 0, null);
                fEnd = 1;
                return true;
            }

            //luot may
//            evaluator.evaluate(2, state);
            Point move = findMoveOfCom();
            x = move.x;
            y = move.y;
            state.posBoard[x][y] = PC_FLAG;
            undoList.add(new Point(x, y));
            chessboard.drawChessman(grs, x * Chessboard.CHESSMAN_SIZE, y * Chessboard.CHESSMAN_SIZE, imageO);
            if(state.gameOver(x, y) == PC_FLAG){
                Match.timer.stop();
                grs.drawImage(imageLose, 100, 100, null);
                fEnd = 2;
                return true;
            }
            return true;
        }
        return false;
    }

    public Point findMoveOfCom() {
        int[][] b = state.clonePosBoard();
        evaluator.evaluate(PC_FLAG, state);
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < MAX_MOVE; i++) {
            list.add(getMaxPoint());
        }
        int max = -INT_MAX;
        List<Point> chooseList = new ArrayList<>();
        for (Point point : list) {
            b[point.x][point.y] = playerFlag;
            int t = minVal(state, -INT_MAX, INT_MAX, 0);
            if (max < t) {
                max = t;
                chooseList.clear();
                chooseList.add(point);
            } else if (max == t) {
                chooseList.add(point);
            }
            b[point.x][point.y] = BLANK_FLAG;
        }
        int x = random.nextInt(chooseList.size());
        return chooseList.get(x);
    }
    private Point getMaxPoint() {
        List<Point> list = new ArrayList<>();
        int t = -INT_MAX;
        for (int i = 0; i < Main.CHESSBOARD_ROW; i++) {
            for (int j = 0; j < Main.CHESSBOARD_COL; j++) {
                if (t < state.eBoard[i][j]) {
                    t = state.eBoard[i][j];
                    list.clear();
                    list.add(new Point(i, j));
                } else if (t == state.eBoard[i][j]) {
                    list.add(new Point(i, j));
                }
            }
        }
        for (Point point : list) {
            state.eBoard[point.x][point.y] = BLANK_FLAG;
        }
        int x = random.nextInt(list.size());
        return list.get(x);
    }
    private int minVal(ChessboardState state, int alpha, int beta, int depth) {
        int val = evaluator.evaluate(state);
        if (depth >= maxDepth || Math.abs(val) > 5000) {
            return val;
        }
        evaluator.evaluate(1, state);
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < MAX_MOVE; i++) {
            list.add(getMaxPoint());
        }
        for (Point point : list) {
            state.posBoard[point.x][point.y] = HUMAN_FLAG;
            beta = Math.min(beta, maxVal(state, alpha, beta, depth + 1));
            state.posBoard[point.x][point.y] = BLANK_FLAG;
            if (alpha >= beta) {
                break;
            }
        }
        return beta;
    }

    private int maxVal(ChessboardState state, int alpha, int beta, int depth) {
        int val = evaluator.evaluate(state);
        if (depth >= maxDepth || Math.abs(val) > 5000) {
            return val;
        }
        evaluator.evaluate(PC_FLAG, state);
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < MAX_MOVE; i++) {
            list.add(getMaxPoint());
        }

        for (Point point : list) {
            state.posBoard[point.x][point.y] = PC_FLAG;
            alpha = Math.max(alpha, minVal(state, alpha, beta, depth + 1));
            state.posBoard[point.x][point.y] = BLANK_FLAG;
            if (alpha > beta) {
                break;
            }
        }
        return alpha;
    }

    public void newGame(Graphics g) {
        start = true;

        undoList.clear();

        state.resetPosBoard();


        if (fEnd == HUMAN_FLAG) {
            playerFlag = PC_FLAG;
        } else {
            playerFlag = HUMAN_FLAG;
        }

        if (playerFlag == PC_FLAG) {
            x = random.nextInt(3);
            y = random.nextInt(3);
            state.posBoard[x + 7][y + 7] = PC_FLAG;
            undoList.add(new Point(x + 7, y + 7));
            chessboard.drawChessman(g, (x + 7) * Chessboard.CHESSMAN_SIZE, (y + 7) * Chessboard.CHESSMAN_SIZE, imageO);
            playerFlag = HUMAN_FLAG;
        }
        fEnd = 0;
    }

    public void undo(Graphics g) {
        int leg = undoList.size();
        if (leg > 1) {
            Point p = undoList.get(leg - 1);
            undoList.remove(undoList.size() - 1);
            state.posBoard[p.x][p.y] = BLANK_FLAG;
            repaintChessman(g);
            if (!undoList.isEmpty()) {
                p = undoList.get(undoList.size() - 1);
                undoList.remove(undoList.size() - 1);
                state.posBoard[p.x][p.y] = BLANK_FLAG;
                repaintChessman(g);
            }
            fEnd = 0;
        }
    }
}
