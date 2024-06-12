package com.lamvt.frame;

import com.lamvt.Main;
import com.lamvt.constant.AppConstant;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author lamvt03
 */
public class StartMenu extends JFrame {

    private Help help;
    private Level level;
    private About about;

    private int depth;

    private JButton btAbout;
    private JButton btExit;
    private JButton btHelp;
    private JButton btNewGame;
    private JButton btOption;
    private JLabel jLabel1;
    private JPanel jPanel1;

    public StartMenu() {
        initComponents();
        jPanel1.requestFocusInWindow();
        setTitle(AppConstant.APP_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(AppConstant.APP_ICON);

        help = new Help();
        level = new Level();
        about = new About();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        btHelp = new JButton();
        btAbout = new JButton();
        btExit = new JButton();
        btNewGame = new JButton();
        btOption = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(AppConstant.APP_BACKGROUND_COLOR);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/game-co-caro.png")));

        btHelp.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btHelp.setIcon(new ImageIcon(getClass().getResource("/img/help.png")));
        btHelp.setBorderPainted(false);
        btHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHelpActionPerformed(evt);
            }
        });

        btAbout.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/about.png"))); // NOI18N
        btAbout.setBorderPainted(false);
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });

        btExit.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btExit.setBorderPainted(false);// NOI18N
        btExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btExit.setFocusable(false);
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btNewGame.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/newGame.png")));//
        btNewGame.setBorderPainted(false);// NOI18N
        btNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewGameActionPerformed(evt);
            }
        });

        btOption.setBackground(AppConstant.APP_BACKGROUND_COLOR);
        btOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/option.png"))); // NOI18N
        btOption.setBorderPainted(false);
        btOption.setToolTipText("");
        btOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btOption, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addGap(23, 23, 23)
                                .addComponent(btNewGame)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btOption)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btHelp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAbout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExit)
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btOptionActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.level == null) {
            this.level = new Level();
        }
        this.level.setVisible(true);
    }

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btNewGameActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Match(depth).setVisible(true);
    }

    private void btHelpActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.help == null) {
            this.help = new Help();
        }
        this.help.setVisible(true);
    }

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.about == null) {
            this.about = new About();
        }
        this.about.setVisible(true);
    }

    public void setDepth(int depth){
        this.depth = depth;
    }
}

