package com.lamvt.game;

import com.lamvt.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessboardEvaluator {

    public int[] DScore = new int[]{0, 1, 9, 81, 729};
    public int[] AScore = new int[]{0, 2, 18, 162, 1458};

    public String[] caseX = {"11", "101", "1112", "2111", "1011", "1101", "111", "11011", "10111", "11101", "11112", "21111", "1111", "11111"};
    public String[] caseO = {"22", "202", "2221", "1222", "2022", "2202", "222", "22022", "20222", "22202", "22221", "12222", "2222", "22222"};
    public int[] pointArr = {5, 5, 10, 10, 500, 500, 500, 600, 600, 600, 600, 600, 5000, 5000};


    public void evaluate(int player, ChessboardState state) {
        int rw, cl, ePC, eHuman;
        state.resetEBoard();

        //Danh gia theo hang
        for (rw = 0; rw < Main.CHESSBOARD_ROW; rw++) {
            for (cl = 0; cl < Main.CHESSBOARD_COL - 4; cl++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (state.posBoard[rw][cl + i] == 1) {
                        eHuman++;
                    }
                    if (state.posBoard[rw][cl + i] == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (state.posBoard[rw][cl + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    state.eBoard[rw][cl + i] += DScore[ePC];
                                } else {
                                    state.eBoard[rw][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    state.eBoard[rw][cl + i] += DScore[eHuman];
                                } else {
                                    state.eBoard[rw][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                state.eBoard[rw][cl + i] *= 2;
                            }
                        }
                    }
                }
            }
        }

        //Danh gia theo cot
        for (cl = 0; cl < Main.CHESSBOARD_COL; cl++) {
            for (rw = 0; rw < Main.CHESSBOARD_ROW - 4; rw++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (state.posBoard[rw + i][cl] == 1) {
                        eHuman++;
                    }
                    if (state.posBoard[rw + i][cl] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (state.posBoard[rw + i][cl] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    state.eBoard[rw + i][cl] += DScore[ePC];
                                } else {
                                    state.eBoard[rw + i][cl] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    state.eBoard[rw + i][cl] += DScore[eHuman];
                                } else {
                                    state.eBoard[rw + i][cl] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                state.eBoard[rw + i][cl] *= 2;
                            }
                        }
                    }

                }
            }
        }

        //Danh gia duong cheo chinh
        for (cl = 0; cl < Main.CHESSBOARD_COL - 4; cl++) {
            for (rw = 0; rw < Main.CHESSBOARD_ROW - 4; rw++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (state.posBoard[rw + i][cl + i] == 1) {
                        eHuman++;
                    }
                    if (state.posBoard[rw + i][cl + i] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (state.posBoard[rw + i][cl + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    state.eBoard[rw + i][cl + i] += DScore[ePC];
                                } else {
                                    state.eBoard[rw + i][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    state.eBoard[rw + i][cl + i] += DScore[eHuman];
                                } else {
                                    state.eBoard[rw + i][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                state.eBoard[rw + i][cl + i] *= 2;
                            }
                        }
                    }
                }
            }
        }

        //Danh gia duong cheo nguoc
        for (rw = 4; rw < Main.CHESSBOARD_ROW; rw++) {
            for (cl = 0; cl < Main.CHESSBOARD_COL - 4; cl++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (state.posBoard[rw - i][cl + i] == 1) {
                        eHuman++;
                    }
                    if (state.posBoard[rw - i][cl + i] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (state.posBoard[rw - i][cl + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    state.eBoard[rw - i][cl + i] += DScore[ePC];
                                } else {
                                    state.eBoard[rw - i][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    state.eBoard[rw - i][cl + i] += DScore[eHuman];
                                } else {
                                    state.eBoard[rw - i][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                state.eBoard[rw - i][cl + i] *= 2;
                            }
                        }
                    }

                }
            }
        }
    }

    public int evaluate(ChessboardState state) {
        int n = Main.CHESSBOARD_ROW;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(state.posBoard[i][j]);
            }
            s.append(";");
            for (int j = 0; j < n; j++) {
                s.append(state.posBoard[j][i]);
            }
            s.append(";");

        }
        for (int i = 0; i < n - 4; i++) {
            for (int j = 0; j < n - i; j++) {
                s.append(state.posBoard[j][i + j]);
            }
            s.append(";");
        }
        for (int i = n - 5; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                s.append(state.posBoard[i + j][j]);
            }
            s.append(";");
        }
        for (int i = 4; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                s.append(state.posBoard[i - j][j]);
            }
            s.append(";");
        }
        for (int i = n - 5; i > 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                s.append(state.posBoard[j][i + n - j - 1]);
            }
            s.append(";\n");
        }
        Pattern pattern1, pattern2;
        int score = 0;
        for (int i = 0; i < caseO.length; i++) {
            pattern1 = Pattern.compile(caseX[i]);
            pattern2 = Pattern.compile(caseO[i]);
            Matcher m1 = pattern1.matcher(s.toString());
            Matcher m2 = pattern2.matcher(s.toString());
            int count1 = 0;
            int count2 = 0;
            while (m1.find()) {
                count1++;
            }
            while (m2.find()) {
                count2++;
            }
            score += pointArr[i] * count2;
            score -= pointArr[i] * count1;
        }
        System.out.println("Score: " + score);
        return score;
    }
}