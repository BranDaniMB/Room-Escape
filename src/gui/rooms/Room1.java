/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.rooms;

import files.PropertiesConfig;
import game.GameRoom;
import java.awt.Image;
import static java.lang.Thread.sleep;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jermy
 */
public class Room1 extends Rooms{

    /**
     * Creates new form Room1
     */
    public Room1(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
        initComponents();
        hideTracks();
        chrono = new Chrono();
        chrono.start();
        background();
    }

    public Room1() {
    }

    public void background() {
        ImageIcon image = new ImageIcon(getClass().getResource("/images/room_1.jpg"));
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_AREA_AVERAGING));
        background.setIcon(icon);
        ImageIcon imagePadlock = new ImageIcon(getClass().getResource("/images/padlock.png"));
        Icon iconPadlock = new ImageIcon(imagePadlock.getImage().getScaledInstance(padlock1.getWidth(), padlock1.getHeight(), Image.SCALE_AREA_AVERAGING));
        padlock1.setIcon(iconPadlock);
        padlock2.setIcon(iconPadlock);
        padlock3.setIcon(iconPadlock);
        padlock4.setIcon(iconPadlock);
    }

    @Override
    public void update(String msj) {
        showInfo.append(msj);
    }

    private void showSimpleTrack(int padlock, int track) {
        JOptionPane.showMessageDialog(null, gameRoom.getTrackSimple(padlock, track));
    }

    private void showTrackUnlock(int padlock) {
        JOptionPane.showMessageDialog(null, gameRoom.getUnlockTrack(padlock));
    }

    private void tryOpenPadlock(int padlock) {
        try {
            gameRoom.tryUnlockPadlock(JOptionPane.showInputDialog(gameRoom.getPadlockQuestion(padlock)), padlock);
        } catch (NullPointerException e) {
            System.err.println("No ingreso nada");
        }
    }

    private void tryOpenTrack(int padlock) {
        try {
            gameRoom.tryUnlockTrack(JOptionPane.showInputDialog(gameRoom.getLockedTrackQuestion(padlock)), padlock);
        } catch (NullPointerException e) {
            System.err.println("No ingreso nada");
        }
    }

    @Override
    public void updatePadlock(int padlock) {
        switch (padlock) {
            case 0:
                padlock1.setEnabled(false);
                break;
            case 1:
                padlock2.setEnabled(false);
                break;
            case 2:
                padlock3.setEnabled(false);
                break;
            case 3:
                padlock4.setEnabled(false);
                break;
        }
    }

    @Override
    public void unlockTrackLocked(int padlock) {
        switch (padlock) {
            case 0:
                trackLockP1.setVisible(false);
                trackThreeP1.setVisible(true);
                break;
            case 1:
                trackLockP2.setVisible(false);
                trackThreeP2.setVisible(true);
                break;
            case 2:
                trackLockP3.setVisible(false);
                trackThreeP3.setVisible(true);
                break;
            case 3:
                trackLockP4.setVisible(false);
                trackThreeP4.setVisible(true);
                break;
        }
    }

    private void hideTracks() {
        trackThreeP1.setVisible(false);
        trackThreeP2.setVisible(false);
        trackThreeP3.setVisible(false);
        trackThreeP4.setVisible(false);
    }

    @Override
    public void showMessageWin(String msg) {
        chrono.setStop(true);
        JOptionPane.showMessageDialog(null, msg);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chronoLabel = new javax.swing.JLabel();
        trackOneP1 = new javax.swing.JButton();
        trackTwoP1 = new javax.swing.JButton();
        trackLockP1 = new javax.swing.JButton();
        trackThreeP1 = new javax.swing.JButton();
        trackOneP2 = new javax.swing.JButton();
        trackTwoP2 = new javax.swing.JButton();
        trackLockP2 = new javax.swing.JButton();
        trackThreeP2 = new javax.swing.JButton();
        trackOneP3 = new javax.swing.JButton();
        trackTwoP3 = new javax.swing.JButton();
        trackLockP3 = new javax.swing.JButton();
        trackThreeP3 = new javax.swing.JButton();
        trackOneP4 = new javax.swing.JButton();
        trackTwoP4 = new javax.swing.JButton();
        trackLockP4 = new javax.swing.JButton();
        trackThreeP4 = new javax.swing.JButton();
        padlock1 = new javax.swing.JButton();
        padlock2 = new javax.swing.JButton();
        padlock3 = new javax.swing.JButton();
        padlock4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showInfo = new javax.swing.JTextArea();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chronoLabel.setBackground(new java.awt.Color(255, 255, 255));
        chronoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chronoLabel.setForeground(new java.awt.Color(255, 0, 0));
        chronoLabel.setText("30:00");
        getContentPane().add(chronoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 70, 20));

        trackOneP1.setBorder(null);
        trackOneP1.setBorderPainted(false);
        trackOneP1.setContentAreaFilled(false);
        trackOneP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackOneP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackOneP1ActionPerformed(evt);
            }
        });
        getContentPane().add(trackOneP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 20, 20));

        trackTwoP1.setBorder(null);
        trackTwoP1.setBorderPainted(false);
        trackTwoP1.setContentAreaFilled(false);
        trackTwoP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackTwoP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackTwoP1ActionPerformed(evt);
            }
        });
        getContentPane().add(trackTwoP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 20, 20));

        trackLockP1.setBackground(new java.awt.Color(255, 255, 255));
        trackLockP1.setBorder(null);
        trackLockP1.setBorderPainted(false);
        trackLockP1.setContentAreaFilled(false);
        trackLockP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackLockP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackLockP1ActionPerformed(evt);
            }
        });
        getContentPane().add(trackLockP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 20, 20));

        trackThreeP1.setBorder(null);
        trackThreeP1.setBorderPainted(false);
        trackThreeP1.setContentAreaFilled(false);
        trackThreeP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackThreeP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackThreeP1ActionPerformed(evt);
            }
        });
        getContentPane().add(trackThreeP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 20, 20));

        trackOneP2.setBorder(null);
        trackOneP2.setBorderPainted(false);
        trackOneP2.setContentAreaFilled(false);
        trackOneP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackOneP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackOneP2ActionPerformed(evt);
            }
        });
        getContentPane().add(trackOneP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 20, 20));

        trackTwoP2.setBorder(null);
        trackTwoP2.setBorderPainted(false);
        trackTwoP2.setContentAreaFilled(false);
        trackTwoP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackTwoP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackTwoP2ActionPerformed(evt);
            }
        });
        getContentPane().add(trackTwoP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 20, 20));

        trackLockP2.setBackground(new java.awt.Color(255, 255, 255));
        trackLockP2.setBorder(null);
        trackLockP2.setBorderPainted(false);
        trackLockP2.setContentAreaFilled(false);
        trackLockP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackLockP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackLockP2ActionPerformed(evt);
            }
        });
        getContentPane().add(trackLockP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 20, 20));

        trackThreeP2.setBorder(null);
        trackThreeP2.setBorderPainted(false);
        trackThreeP2.setContentAreaFilled(false);
        trackThreeP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackThreeP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackThreeP2ActionPerformed(evt);
            }
        });
        getContentPane().add(trackThreeP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 20, 20));

        trackOneP3.setBorder(null);
        trackOneP3.setBorderPainted(false);
        trackOneP3.setContentAreaFilled(false);
        trackOneP3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackOneP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackOneP3ActionPerformed(evt);
            }
        });
        getContentPane().add(trackOneP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 20, 20));

        trackTwoP3.setBorder(null);
        trackTwoP3.setBorderPainted(false);
        trackTwoP3.setContentAreaFilled(false);
        trackTwoP3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackTwoP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackTwoP3ActionPerformed(evt);
            }
        });
        getContentPane().add(trackTwoP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 20, 20));

        trackLockP3.setBackground(new java.awt.Color(255, 255, 255));
        trackLockP3.setBorder(null);
        trackLockP3.setBorderPainted(false);
        trackLockP3.setContentAreaFilled(false);
        trackLockP3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackLockP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackLockP3ActionPerformed(evt);
            }
        });
        getContentPane().add(trackLockP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 20, 20));

        trackThreeP3.setBorder(null);
        trackThreeP3.setBorderPainted(false);
        trackThreeP3.setContentAreaFilled(false);
        trackThreeP3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackThreeP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackThreeP3ActionPerformed(evt);
            }
        });
        getContentPane().add(trackThreeP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 20, 20));

        trackOneP4.setBorder(null);
        trackOneP4.setBorderPainted(false);
        trackOneP4.setContentAreaFilled(false);
        trackOneP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackOneP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackOneP4ActionPerformed(evt);
            }
        });
        getContentPane().add(trackOneP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 20, 20));

        trackTwoP4.setBorder(null);
        trackTwoP4.setBorderPainted(false);
        trackTwoP4.setContentAreaFilled(false);
        trackTwoP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackTwoP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackTwoP4ActionPerformed(evt);
            }
        });
        getContentPane().add(trackTwoP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 20, 20));

        trackLockP4.setBackground(new java.awt.Color(255, 255, 255));
        trackLockP4.setBorder(null);
        trackLockP4.setBorderPainted(false);
        trackLockP4.setContentAreaFilled(false);
        trackLockP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackLockP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackLockP4ActionPerformed(evt);
            }
        });
        getContentPane().add(trackLockP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 20, 20));

        trackThreeP4.setBorder(null);
        trackThreeP4.setBorderPainted(false);
        trackThreeP4.setContentAreaFilled(false);
        trackThreeP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackThreeP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackThreeP4ActionPerformed(evt);
            }
        });
        getContentPane().add(trackThreeP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 20, 20));

        padlock1.setBackground(new java.awt.Color(51, 51, 51));
        padlock1.setForeground(new java.awt.Color(255, 255, 255));
        padlock1.setBorder(null);
        padlock1.setBorderPainted(false);
        padlock1.setContentAreaFilled(false);
        padlock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padlock1ActionPerformed(evt);
            }
        });
        getContentPane().add(padlock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 60, 40));

        padlock2.setForeground(new java.awt.Color(255, 255, 255));
        padlock2.setBorder(null);
        padlock2.setBorderPainted(false);
        padlock2.setContentAreaFilled(false);
        padlock2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padlock2ActionPerformed(evt);
            }
        });
        getContentPane().add(padlock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 60, 40));

        padlock3.setForeground(new java.awt.Color(255, 255, 255));
        padlock3.setBorder(null);
        padlock3.setBorderPainted(false);
        padlock3.setContentAreaFilled(false);
        padlock3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padlock3ActionPerformed(evt);
            }
        });
        getContentPane().add(padlock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 60, 40));

        padlock4.setForeground(new java.awt.Color(255, 255, 255));
        padlock4.setBorder(null);
        padlock4.setBorderPainted(false);
        padlock4.setContentAreaFilled(false);
        padlock4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padlock4ActionPerformed(evt);
            }
        });
        getContentPane().add(padlock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 60, 40));

        showInfo.setEditable(false);
        showInfo.setColumns(20);
        showInfo.setRows(5);
        jScrollPane1.setViewportView(showInfo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 290, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/room_1.jpg"))); // NOI18N
        background.setOpaque(true);
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void padlock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padlock1ActionPerformed
        // TODO add your handling code here:
        tryOpenPadlock(PADLOCK_NUM1);
    }//GEN-LAST:event_padlock1ActionPerformed

    private void trackOneP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackOneP3ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM3, PADLOCK_NUM1);
    }//GEN-LAST:event_trackOneP3ActionPerformed

    private void trackOneP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackOneP4ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM4, PADLOCK_NUM1);
    }//GEN-LAST:event_trackOneP4ActionPerformed

    private void trackThreeP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackThreeP4ActionPerformed
        // TODO add your handling code here:
        showTrackUnlock(PADLOCK_NUM4);
    }//GEN-LAST:event_trackThreeP4ActionPerformed

    private void trackTwoP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackTwoP1ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM1, PADLOCK_NUM2);
    }//GEN-LAST:event_trackTwoP1ActionPerformed

    private void trackThreeP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackThreeP3ActionPerformed
        // TODO add your handling code here:
        showTrackUnlock(PADLOCK_NUM3);
    }//GEN-LAST:event_trackThreeP3ActionPerformed

    private void trackOneP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackOneP1ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM1, PADLOCK_NUM1);
    }//GEN-LAST:event_trackOneP1ActionPerformed

    private void trackTwoP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackTwoP3ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM3, PADLOCK_NUM2);
    }//GEN-LAST:event_trackTwoP3ActionPerformed

    private void trackTwoP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackTwoP4ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM4, PADLOCK_NUM2);
    }//GEN-LAST:event_trackTwoP4ActionPerformed

    private void trackLockP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackLockP1ActionPerformed
        // TODO add your handling code here:
        tryOpenTrack(PADLOCK_NUM1);
    }//GEN-LAST:event_trackLockP1ActionPerformed

    private void trackLockP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackLockP2ActionPerformed
        // TODO add your handling code here:
        tryOpenTrack(PADLOCK_NUM2);
    }//GEN-LAST:event_trackLockP2ActionPerformed

    private void trackOneP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackOneP2ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM1, PADLOCK_NUM2);
    }//GEN-LAST:event_trackOneP2ActionPerformed

    private void padlock2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padlock2ActionPerformed
        // TODO add your handling code here:
        tryOpenPadlock(PADLOCK_NUM2);
    }//GEN-LAST:event_padlock2ActionPerformed

    private void padlock3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padlock3ActionPerformed
        // TODO add your handling code here:
        tryOpenPadlock(PADLOCK_NUM3);
    }//GEN-LAST:event_padlock3ActionPerformed

    private void padlock4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padlock4ActionPerformed
        // TODO add your handling code here:
        tryOpenPadlock(PADLOCK_NUM4);
    }//GEN-LAST:event_padlock4ActionPerformed

    private void trackThreeP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackThreeP1ActionPerformed
        // TODO add your handling code here:
        showTrackUnlock(PADLOCK_NUM1);
    }//GEN-LAST:event_trackThreeP1ActionPerformed

    private void trackTwoP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackTwoP2ActionPerformed
        // TODO add your handling code here:
        showSimpleTrack(PADLOCK_NUM2, PADLOCK_NUM2);
    }//GEN-LAST:event_trackTwoP2ActionPerformed

    private void trackThreeP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackThreeP2ActionPerformed
        // TODO add your handling code here:
        showTrackUnlock(PADLOCK_NUM2);
    }//GEN-LAST:event_trackThreeP2ActionPerformed

    private void trackLockP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackLockP3ActionPerformed
        // TODO add your handling code here:
        tryOpenTrack(PADLOCK_NUM3);
    }//GEN-LAST:event_trackLockP3ActionPerformed

    private void trackLockP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackLockP4ActionPerformed
        // TODO add your handling code here:
        tryOpenTrack(PADLOCK_NUM4);
    }//GEN-LAST:event_trackLockP4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel chronoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton padlock1;
    private javax.swing.JButton padlock2;
    private javax.swing.JButton padlock3;
    private javax.swing.JButton padlock4;
    private javax.swing.JTextArea showInfo;
    private javax.swing.JButton trackLockP1;
    private javax.swing.JButton trackLockP2;
    private javax.swing.JButton trackLockP3;
    private javax.swing.JButton trackLockP4;
    private javax.swing.JButton trackOneP1;
    private javax.swing.JButton trackOneP2;
    private javax.swing.JButton trackOneP3;
    private javax.swing.JButton trackOneP4;
    private javax.swing.JButton trackThreeP1;
    private javax.swing.JButton trackThreeP2;
    private javax.swing.JButton trackThreeP3;
    private javax.swing.JButton trackThreeP4;
    private javax.swing.JButton trackTwoP1;
    private javax.swing.JButton trackTwoP2;
    private javax.swing.JButton trackTwoP3;
    private javax.swing.JButton trackTwoP4;
    // End of variables declaration//GEN-END:variables
    private final int PADLOCK_NUM1 = 0;
    private final int PADLOCK_NUM2 = 1;
    private final int PADLOCK_NUM3 = 2;
    private final int PADLOCK_NUM4 = 3;
    private GameRoom gameRoom;
    private Chrono chrono;

    private class Chrono extends Thread {

        private int minut;
        private int second;
        private boolean stop;

        public Chrono() {
            minut = 0;
            second = 0;
            stop = false;
        }

        @Override
        public String toString() {
            return minut + " : " + second + " s";
        }

        public boolean isStop() {
            return stop;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        @Override
        public void run() {
            for (int i = 0; i < PropertiesConfig.getInstance().getProperties("timeLimit") && !stop; i++) {
                second++;
                if (second == 60) {
                    minut++;
                    second = 0;
                }
                chronoLabel.setText(toString());
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            if (minut == 30) {
                JOptionPane.showMessageDialog(null, "El juego terminó\n Perdió");
                dispose();
            }
        }
    }
}
