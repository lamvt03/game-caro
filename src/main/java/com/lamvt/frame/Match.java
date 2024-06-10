package com.lamvt.frame;

import com.lamvt.constant.AppConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lamvt03
 */
public class Match extends JFrame {

//    private CaroChess caRoChess;
    private Graphics grs;
    public static Timer timer;
    public Integer second, minute;

    public Match(int depth) {
        initComponents();
        setTitle(AppConstant.APP_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(AppConstant.APP_ICON);

//        caRoChess = new CaroChess(depth);
        grs = pnBoard.getGraphics();
//        caRoChess.playerVsCom(grs);
        timePlay();
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        caRoChess.drawChessBoard(grs);
//        caRoChess.repaintChessMan(grs);
    }

    public void timePlay() {
        lbTime.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 18));
        lbTime.setForeground(Color.RED);
        second = 0;
        minute = 0;
        timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String temp = minute.toString();
                String temp1 = second.toString();
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                if (temp1.length() == 1) {
                    temp1 = "0" + temp1;
                }
                if (second == 59) {
                    lbTime.setText("Time: " + temp + ":" + temp1);
                    minute++;
                    second = 0;
                } else {
                    lbTime.setText("Time: " + temp + ":" + temp1);
                    second++;
                }
            }
        });
    }

    private void initComponents() {
        pnBackGround = new JPanel();
        pnBoard = new JPanel();
        leftPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource("/img/left.png"));
                Image image = icon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        lbTime = new JLabel();
        btNewGame = new JButton();
        jPanel2 = new JPanel();

        btUndo = new JButton();
        btBack = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnBackGround.setBackground(AppConstant.BOARD_BACKGROUND_COLOR);

        pnBoard.setBackground(Color.WHITE);
        pnBoard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnBoardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnBoardLayout = new javax.swing.GroupLayout(pnBoard);
        pnBoard.setLayout(pnBoardLayout);
        pnBoardLayout.setHorizontalGroup(
                pnBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 504, Short.MAX_VALUE)
        );
        pnBoardLayout.setVerticalGroup(
                pnBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 504, Short.MAX_VALUE)
        );

        //timer text
        lbTime.setFont(new java.awt.Font("Times New Roman", 3, 18));
        lbTime.setText("Time: ");
        lbTime.setForeground(Color.WHITE);



        //btn new game
        btNewGame.setFont(new java.awt.Font("Consolas", 1, 14));
        btNewGame.setText("Chơi lại");
        btNewGame.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btNewGame.setForeground(Color.RED);
        btNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewGameActionPerformed(evt);
            }
        });

        //btn undo
        btUndo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btUndo.setText("Hoàn tác");
        btUndo.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btUndo.setForeground(Color.RED);
        btUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUndoActionPerformed(evt);
            }
        });

        //btn back
        btBack.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btBack.setText("Menu");
        btBack.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btBack.setForeground(Color.RED);
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        GroupLayout leftPanelLayout = new GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(2, 2, 2))
                                )
                        )
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbTime)
                                .addGap(132, 132, 132)
                                .addGroup(leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout pnBackGroundLayout = new javax.swing.GroupLayout(pnBackGround);
        pnBackGround.setLayout(pnBackGroundLayout);
        pnBackGroundLayout.setHorizontalGroup(
                pnBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnBackGroundLayout.createSequentialGroup()
                                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBackGroundLayout.setVerticalGroup(
                pnBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBackGroundLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void pnBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBoardMouseClicked
//        if (!caRoChess.isStart()) {
//            return;
//        }
//        caRoChess.playChess(evt.getX(), evt.getY(), grs);
    }

    private void btNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewGameActionPerformed
//        timePlay();
//        timer.stop();
//        timer.start();
//        caRoChess.newGame(grs);
//        repaint();
    }

    private void btUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUndoActionPerformed
//        caRoChess.undoGame(grs);
//        repaint();
    }

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
//        setVisible(false);
//        StartMenu menu = new StartMenu(StartMenu.maxDepth);
//        menu.setVisible(true);
    }

    private javax.swing.JButton btBack;
    private javax.swing.JButton btNewGame;
    private javax.swing.JButton btUndo;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbTime;
    private javax.swing.JPanel pnBackGround;
    private javax.swing.JPanel pnBoard;

}
