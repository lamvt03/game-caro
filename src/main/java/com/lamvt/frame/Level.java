package com.lamvt.frame;

import com.lamvt.Main;
import com.lamvt.constant.AppConstant;
import com.lamvt.constant.LevelConstant;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author lamvt03
 */
public class Level extends JFrame {

    private JButton btEasy;
    private JButton btHard;
    private JButton btMedium;
    private JPanel jPanel1;

    public Level() {
        initComponents();
        setTitle("Cấp độ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(AppConstant.APP_ICON);
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource("/img/level-bg.png"));
                Image image = icon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        btEasy = new javax.swing.JButton();
        btMedium = new javax.swing.JButton();
        btHard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        btEasy.setFont(new java.awt.Font("Consolas", 1, 18));
        btEasy.setForeground(new java.awt.Color(255, 0, 0));
        btEasy.setText("Dễ");
        btEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEasyActionPerformed(evt);
            }
        });

        btMedium.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btMedium.setForeground(new java.awt.Color(255, 0, 0));
        btMedium.setText("Trung bình");
        btMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMediumActionPerformed(evt);
            }
        });

        btHard.setFont(new java.awt.Font("Consolas", 1, 18));
        btHard.setForeground(new java.awt.Color(255, 0, 0));
        btHard.setText("Khó");
        btHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btMedium)
                                                        .addComponent(btEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btHard))))
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btEasy, btHard, btMedium});

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btMedium)
                                .addGap(29, 29, 29)
                                .addComponent(btHard)
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btEasy, btHard, btMedium});

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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

    private void btEasyActionPerformed(java.awt.event.ActionEvent evt) {
        Main.menu.setDepth(LevelConstant.DEPTH_EASY);
        setVisible(false);
    }

    private void btMediumActionPerformed(java.awt.event.ActionEvent evt) {
        Main.menu.setDepth(LevelConstant.DEPTH_MEDIUM);
        setVisible(false);
    }

    private void btHardActionPerformed(java.awt.event.ActionEvent evt) {
        Main.menu.setDepth(LevelConstant.DEPTH_HARD);
        setVisible(false);
    }
}

