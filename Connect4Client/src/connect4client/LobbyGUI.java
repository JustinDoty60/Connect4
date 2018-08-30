/**
 * @author Justin Doty
 * GUI class for the lobby
 */
package connect4client;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;

public class LobbyGUI extends javax.swing.JFrame {

    private JButton[] playerButtons = new JButton[8];
    private Connect4Client client;
    private Media songFile;
    private MediaPlayer backgroundPlayer;
    private int currEmptyButton = 0;
    
    public LobbyGUI() {
        initComponents();
    }
    
    public LobbyGUI(Connect4Client client) {
        this.client = client;
        initJavaFX();
        initSong();
        initComponents();
        initLobbyGUI();
    }
    
    private void initLobbyGUI() {
        playerButtons[0] = Player1;
        playerButtons[1] = Player2;
        playerButtons[2] = Player3;
        playerButtons[3] = Player4;
        playerButtons[4] = Player5;
        playerButtons[5] = Player6;
        playerButtons[6] = Player7;
        playerButtons[7] = Player8;
        
        emptyButton.start();
        waiting.start();
    }
    
    private void initJavaFX() {
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {}
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainContainer = new javax.swing.JLayeredPane();
        SignupPopup = new javax.swing.JLayeredPane();
        LobbyText1 = new javax.swing.JLabel();
        SignupTextField = new javax.swing.JTextField();
        SignupAcceptButton = new javax.swing.JButton();
        SignupInfoText = new javax.swing.JLabel();
        SignupPopupBackground = new javax.swing.JLabel();
        BusyPopup = new javax.swing.JLayeredPane();
        BusyBackButton = new javax.swing.JButton();
        BusyText = new javax.swing.JLabel();
        BusyPopupBackground = new javax.swing.JLabel();
        WaitingPopup = new javax.swing.JLayeredPane();
        WaitingText1 = new javax.swing.JLabel();
        WaitingText2 = new javax.swing.JLabel();
        WaitingBackButton = new javax.swing.JButton();
        WaitingDots = new javax.swing.JLabel();
        WaitingPopupBackground = new javax.swing.JLabel();
        RequestPopup = new javax.swing.JLayeredPane();
        RequestText = new javax.swing.JLabel();
        AcceptButton = new javax.swing.JButton();
        DeclineButton = new javax.swing.JButton();
        RequestPopupBackground = new javax.swing.JLabel();
        PlayerButtons = new javax.swing.JLayeredPane();
        LobbyText = new javax.swing.JLabel();
        Player8 = new javax.swing.JButton();
        Player7 = new javax.swing.JButton();
        Player6 = new javax.swing.JButton();
        Player5 = new javax.swing.JButton();
        Player4 = new javax.swing.JButton();
        Player3 = new javax.swing.JButton();
        Player2 = new javax.swing.JButton();
        Player1 = new javax.swing.JButton();
        PlayerName = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainContainer.setMaximumSize(new java.awt.Dimension(1080, 650));
        MainContainer.setMinimumSize(new java.awt.Dimension(1080, 650));
        MainContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RequestPopup.setVisible(false);
        SignupPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LobbyText1.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        LobbyText1.setForeground(new java.awt.Color(51, 51, 51));
        LobbyText1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LobbyText1.setText("Name");
        LobbyText1.setToolTipText("");
        SignupPopup.add(LobbyText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 150, 70));

        SignupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        SignupTextField.setForeground(new java.awt.Color(0, 0, 0));
        SignupTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SignupTextField.setOpaque(false);
        SignupPopup.add(SignupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 290, 60));

        SignupAcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptIdle.png"))); // NOI18N
        SignupAcceptButton.setBorderPainted(false);
        SignupAcceptButton.setContentAreaFilled(false);
        SignupAcceptButton.setFocusPainted(false);
        SignupAcceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignupAcceptButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignupAcceptButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignupAcceptButtonMouseExited(evt);
            }
        });
        SignupPopup.add(SignupAcceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 130, 60));

        SignupInfoText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        SignupInfoText.setForeground(new java.awt.Color(255, 255, 255));
        SignupInfoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignupInfoText.setText("8 or less characters");
        SignupInfoText.setToolTipText("");
        SignupPopup.add(SignupInfoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 230, 30));

        SignupPopupBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/popupLarge.png"))); // NOI18N
        SignupPopup.add(SignupPopupBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 400));

        MainContainer.add(SignupPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 640, 420));

        BusyPopup.setVisible(false);
        BusyPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BusyBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBackIdle.png"))); // NOI18N
        BusyBackButton.setBorderPainted(false);
        BusyBackButton.setContentAreaFilled(false);
        BusyBackButton.setFocusPainted(false);
        BusyBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BusyBackButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BusyBackButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BusyBackButtonMouseExited(evt);
            }
        });
        BusyPopup.add(BusyBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 130, 60));

        BusyText.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        BusyText.setForeground(new java.awt.Color(255, 255, 255));
        BusyText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BusyText.setToolTipText("");
        BusyPopup.add(BusyText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 560, 80));

        BusyPopupBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/popupLarge.png"))); // NOI18N
        BusyPopup.add(BusyPopupBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 400));

        MainContainer.add(BusyPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 640, 420));

        WaitingPopup.setVisible(false);
        WaitingPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WaitingText1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        WaitingText1.setForeground(new java.awt.Color(255, 255, 255));
        WaitingText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WaitingText1.setToolTipText("");
        WaitingPopup.add(WaitingText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 560, 40));

        WaitingText2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        WaitingText2.setForeground(new java.awt.Color(255, 255, 255));
        WaitingText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WaitingText2.setToolTipText("");
        WaitingPopup.add(WaitingText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 560, 40));

        WaitingBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBackIdle.png"))); // NOI18N
        WaitingBackButton.setBorderPainted(false);
        WaitingBackButton.setContentAreaFilled(false);
        WaitingBackButton.setFocusPainted(false);
        WaitingBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WaitingBackButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                WaitingBackButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                WaitingBackButtonMouseExited(evt);
            }
        });
        WaitingPopup.add(WaitingBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 140, 60));

        WaitingDots.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        WaitingDots.setForeground(new java.awt.Color(255, 255, 255));
        WaitingDots.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        WaitingDots.setText(".    .    .    .");
        WaitingDots.setToolTipText("");
        WaitingPopup.add(WaitingDots, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 180, 30));

        WaitingPopupBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/popupLarge.png"))); // NOI18N
        WaitingPopup.add(WaitingPopupBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 400));

        MainContainer.add(WaitingPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 640, 420));

        RequestPopup.setVisible(false);
        RequestPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RequestText.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        RequestText.setForeground(new java.awt.Color(255, 255, 255));
        RequestText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RequestText.setToolTipText("");
        RequestPopup.add(RequestText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 560, 80));

        AcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptIdle.png"))); // NOI18N
        AcceptButton.setBorderPainted(false);
        AcceptButton.setContentAreaFilled(false);
        AcceptButton.setFocusPainted(false);
        AcceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcceptButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AcceptButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AcceptButtonMouseExited(evt);
            }
        });
        RequestPopup.add(AcceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 130, 60));

        DeclineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDeclineIdle.png"))); // NOI18N
        DeclineButton.setBorderPainted(false);
        DeclineButton.setContentAreaFilled(false);
        DeclineButton.setFocusPainted(false);
        DeclineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeclineButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeclineButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeclineButtonMouseExited(evt);
            }
        });
        RequestPopup.add(DeclineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 130, 60));

        RequestPopupBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/popupLarge.png"))); // NOI18N
        RequestPopup.add(RequestPopupBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 400));

        MainContainer.add(RequestPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 640, 420));

        PlayerButtons.setVisible(false);
        PlayerButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LobbyText.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        LobbyText.setForeground(new java.awt.Color(51, 51, 51));
        LobbyText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LobbyText.setText("Lobby");
        LobbyText.setToolTipText("");
        PlayerButtons.add(LobbyText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 180, 70));

        Player8.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player8.setForeground(new java.awt.Color(255, 255, 255));
        Player8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player8.setBorderPainted(false);
        Player8.setContentAreaFilled(false);
        Player8.setFocusPainted(false);
        Player8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player8MouseExited(evt);
            }
        });
        PlayerButtons.add(Player8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 130, 60));

        Player7.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player7.setForeground(new java.awt.Color(255, 255, 255));
        Player7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player7.setBorderPainted(false);
        Player7.setContentAreaFilled(false);
        Player7.setFocusPainted(false);
        Player7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player7MouseExited(evt);
            }
        });
        PlayerButtons.add(Player7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 130, 60));

        Player6.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player6.setForeground(new java.awt.Color(255, 255, 255));
        Player6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player6.setBorderPainted(false);
        Player6.setContentAreaFilled(false);
        Player6.setFocusPainted(false);
        Player6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player6MouseExited(evt);
            }
        });
        PlayerButtons.add(Player6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 130, 60));

        Player5.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player5.setForeground(new java.awt.Color(255, 255, 255));
        Player5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player5.setBorderPainted(false);
        Player5.setContentAreaFilled(false);
        Player5.setFocusPainted(false);
        Player5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player5MouseExited(evt);
            }
        });
        PlayerButtons.add(Player5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 130, 60));

        Player4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player4.setForeground(new java.awt.Color(255, 255, 255));
        Player4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player4.setBorderPainted(false);
        Player4.setContentAreaFilled(false);
        Player4.setFocusPainted(false);
        Player4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player4MouseExited(evt);
            }
        });
        PlayerButtons.add(Player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 130, 60));

        Player3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player3.setForeground(new java.awt.Color(255, 255, 255));
        Player3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player3.setBorderPainted(false);
        Player3.setContentAreaFilled(false);
        Player3.setFocusPainted(false);
        Player3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player3MouseExited(evt);
            }
        });
        PlayerButtons.add(Player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 130, 60));

        Player2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player2.setForeground(new java.awt.Color(255, 255, 255));
        Player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player2.setBorderPainted(false);
        Player2.setContentAreaFilled(false);
        Player2.setFocusPainted(false);
        Player2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player2MouseExited(evt);
            }
        });
        PlayerButtons.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 130, 60));

        Player1.setBackground(new java.awt.Color(255, 255, 255));
        Player1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Player1.setForeground(new java.awt.Color(255, 255, 255));
        Player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png"))); // NOI18N
        Player1.setBorderPainted(false);
        Player1.setContentAreaFilled(false);
        Player1.setFocusPainted(false);
        Player1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Player1MouseExited(evt);
            }
        });
        PlayerButtons.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 130, 60));

        MainContainer.add(PlayerButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1080, 650));

        PlayerName.setVisible(false);
        PlayerName.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        PlayerName.setForeground(new java.awt.Color(51, 51, 51));
        PlayerName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PlayerName.setToolTipText("");
        MainContainer.add(PlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 450, 70));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpg"))); // NOI18N
        MainContainer.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(MainContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sendMessage("LEAVE");
    }//GEN-LAST:event_formWindowClosing

    private void Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player1MouseEntered
        enterPlayerButton(Player1);
    }//GEN-LAST:event_Player1MouseEntered

    private void Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player1MouseExited
        exitPlayerButton(Player1);
    }//GEN-LAST:event_Player1MouseExited

    private void Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player2MouseEntered
        enterPlayerButton(Player2);
    }//GEN-LAST:event_Player2MouseEntered

    private void Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player2MouseExited
        exitPlayerButton(Player2);
    }//GEN-LAST:event_Player2MouseExited

    private void Player3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player3MouseEntered
        enterPlayerButton(Player3);
    }//GEN-LAST:event_Player3MouseEntered

    private void Player3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player3MouseExited
        exitPlayerButton(Player3);
    }//GEN-LAST:event_Player3MouseExited

    private void Player4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player4MouseEntered
        enterPlayerButton(Player4);
    }//GEN-LAST:event_Player4MouseEntered

    private void Player4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player4MouseExited
        exitPlayerButton(Player4);
    }//GEN-LAST:event_Player4MouseExited

    private void Player5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player5MouseEntered
        enterPlayerButton(Player5);
    }//GEN-LAST:event_Player5MouseEntered

    private void Player5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player5MouseExited
        exitPlayerButton(Player5);
    }//GEN-LAST:event_Player5MouseExited

    private void Player6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player6MouseEntered
        enterPlayerButton(Player6);
    }//GEN-LAST:event_Player6MouseEntered

    private void Player6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player6MouseExited
        exitPlayerButton(Player6);
    }//GEN-LAST:event_Player6MouseExited

    private void Player7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player7MouseEntered
        enterPlayerButton(Player7);
    }//GEN-LAST:event_Player7MouseEntered

    private void Player7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player7MouseExited
        exitPlayerButton(Player7);
    }//GEN-LAST:event_Player7MouseExited
    
    private void enterPlayerButton(JButton playerButton) {
        if(!playerButton.getIcon().toString().equals(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png")).toString()))
            playerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonHover.png")));
    }
    
    private void exitPlayerButton(JButton playerButton) {
        if(!playerButton.getIcon().toString().equals(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png")).toString()))
            playerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonIdle.png")));
    }

    private void Player1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player1MouseClicked
        playerButtonAction(Player1);
    }//GEN-LAST:event_Player1MouseClicked

    private void Player2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player2MouseClicked
        playerButtonAction(Player2);
    }//GEN-LAST:event_Player2MouseClicked

    private void Player3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player3MouseClicked
        playerButtonAction(Player3);
    }//GEN-LAST:event_Player3MouseClicked

    private void Player4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player4MouseClicked
        playerButtonAction(Player4);
    }//GEN-LAST:event_Player4MouseClicked

    private void Player5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player5MouseClicked
        playerButtonAction(Player5);
    }//GEN-LAST:event_Player5MouseClicked

    private void Player6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player6MouseClicked
        playerButtonAction(Player6);
    }//GEN-LAST:event_Player6MouseClicked

    private void Player7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player7MouseClicked
        playerButtonAction(Player7);
    }//GEN-LAST:event_Player7MouseClicked
    
    private void playerButtonAction(JButton playerButton) {
        if(!playerButton.getIcon().toString().equals(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png")).toString())) {
            sendRequest(playerButton.getText());
            
            WaitingPopup.setVisible(true);
            PlayerButtons.setVisible(false);
            WaitingText1.setText("Waiting for " + playerButton.getText() + "'s");
            WaitingText2.setText("response");
        }
    }
    
    private void AcceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptButtonMouseClicked
        client.initGameGUI();
        
        sendMessage("ACCEPT_REQUEST" + client.getPossibleOpponent());
    }//GEN-LAST:event_AcceptButtonMouseClicked

    private void AcceptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptButtonMouseEntered
        AcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptHover.png")));
    }//GEN-LAST:event_AcceptButtonMouseEntered

    private void AcceptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptButtonMouseExited
        AcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptIdle.png")));
    }//GEN-LAST:event_AcceptButtonMouseExited
    
    private void DeclineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineButtonMouseClicked
        sendMessage("CANCEL_REQUEST" + client.getPossibleOpponent());
        
        makePlayerButtonsVisible();
    }//GEN-LAST:event_DeclineButtonMouseClicked

    
    private void DeclineButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineButtonMouseEntered
        DeclineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDeclineHover.png")));
    }//GEN-LAST:event_DeclineButtonMouseEntered

    private void DeclineButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineButtonMouseExited
        DeclineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDeclineIdle.png")));
    }//GEN-LAST:event_DeclineButtonMouseExited
    
    private void WaitingBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitingBackButtonMouseClicked
        sendMessage("CANCEL_REQUEST" + client.getPossibleOpponent());

        makePlayerButtonsVisible();
    }//GEN-LAST:event_WaitingBackButtonMouseClicked

    private void WaitingBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitingBackButtonMouseEntered
        WaitingBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBackHover.png")));
    }//GEN-LAST:event_WaitingBackButtonMouseEntered

    private void WaitingBackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitingBackButtonMouseExited
        WaitingBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBackIdle.png")));
    }//GEN-LAST:event_WaitingBackButtonMouseExited
    
    private void BusyBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusyBackButtonMouseClicked
        makePlayerButtonsVisible();
    }//GEN-LAST:event_BusyBackButtonMouseClicked

    private void BusyBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusyBackButtonMouseEntered
        BusyBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBackHover.png")));
    }//GEN-LAST:event_BusyBackButtonMouseEntered

    private void BusyBackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusyBackButtonMouseExited
        BusyBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBackIdle.png")));
    }//GEN-LAST:event_BusyBackButtonMouseExited
    
    private void Player8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player8MouseExited
        exitPlayerButton(Player8);
    }//GEN-LAST:event_Player8MouseExited

    private void Player8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player8MouseEntered
        enterPlayerButton(Player8);
    }//GEN-LAST:event_Player8MouseEntered

    private void Player8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player8MouseClicked
        playerButtonAction(Player8);
    }//GEN-LAST:event_Player8MouseClicked
    
    private void SignupAcceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupAcceptButtonMouseClicked
        sendMessage("SET_NAME" + SignupTextField.getText());
    }//GEN-LAST:event_SignupAcceptButtonMouseClicked

    private void SignupAcceptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupAcceptButtonMouseEntered
        SignupAcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptHover.png")));
    }//GEN-LAST:event_SignupAcceptButtonMouseEntered

    private void SignupAcceptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupAcceptButtonMouseExited
        SignupAcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptIdle.png")));
    }//GEN-LAST:event_SignupAcceptButtonMouseExited
    
    private void sendRequest(String playerName) {
        client.setPossibleOpponent(playerName);
        sendMessage("REQUEST" + playerName);
    }
    
    private Thread emptyButton = new Thread(){
        @Override
        public void run() {
            try {
                String text = ".";
                while(true) {
                    setIdleButtonText(text);
                    for(int i = 0; i < 3; i++) {
                        Thread.sleep(750);
                        setIdleButtonText(text+=".");
                    }
                    text = ".";
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
    }}; 
    
    private void setIdleButtonText(String text) {
        for(int i = 0; i < playerButtons.length; i++) {
            if(playerButtons[i].getIcon().toString().equals(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDisabled.png")).toString())) {
                playerButtons[i].setText(text);
            }
        }
    }
    private Thread waiting = new Thread(){
        @Override
        public void run() {
            try {
                while(true) {
                    WaitingDots.setText(".");
                    for(int i = 0; i < 4; i++) {
                        Thread.sleep(750);
                        WaitingDots.setText(WaitingDots.getText() + "    .");
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
    }}; 
    
    private void initSong() {
        songFile = new Media(new File("src\\audio\\lobby.mp3").toURI().toString());
        backgroundPlayer = new MediaPlayer(songFile);
        backgroundPlayer.setVolume(.1);
        backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundPlayer.play();
    }
    
    protected void updatePlayerButtons(HashMap<Integer, String> playerList, String playerName) {
        currEmptyButton = 0;

        updateOccupiedButtons(playerList, playerName);
        updateEmptyButtons(playerList);
    }
    
    private void updateOccupiedButtons(HashMap<Integer, String> playerList, String playerName) {
        for(int key: playerList.keySet()) {
            if(key != client.getPlayerID()) {
                updateButton(playerList.get(key), "/img/buttonIdle.png");
                currEmptyButton++;
            }
        }
    }
    
    private void updateEmptyButtons(HashMap<Integer, String> playerList) {
        for(int i = 0; i < playerButtons.length - playerList.size() + 1; i++)
            updateButton("", "/img/buttonDisabled.png");
    }
    
    private void updateButton(String text, String icon) {
        playerButtons[currEmptyButton].setText(text);
        playerButtons[currEmptyButton].setIcon(new javax.swing.ImageIcon(getClass().getResource(icon)));
    }
    
    protected void updatePlayerName(String playerName) {
        PlayerName.setText(playerName);
        SignupPopup.setVisible(false);
        PlayerButtons.setVisible(true);
        PlayerName.setVisible(true);
    }
    
    protected void showRequestPopup(String possibleOpponent) {
        PlayerButtons.setVisible(false);
        BusyPopup.setVisible(false);
        RequestPopup.setVisible(true);
        RequestText.setText(possibleOpponent + " wants to play!");
    }
    
    protected void putUpLobbyGUI() {
        makePlayerButtonsVisible();
        
        backgroundPlayer.stop();
        dispose();
    }
    
    protected void makePlayerButtonsVisible() {
        PlayerButtons.setVisible(true);
        RequestPopup.setVisible(false);
        WaitingPopup.setVisible(false);
        BusyPopup.setVisible(false);
    }
    
    protected void makeBusyPopupVisible(String busyPlayer) {
        WaitingPopup.setVisible(false);
        RequestPopup.setVisible(false);
        PlayerButtons.setVisible(false);
        BusyPopup.setVisible(true);

        BusyText.setText(busyPlayer + " is busy!");
    }
    
    @Override
    public void setVisible(boolean vis) {
        super.setVisible(vis);
        
        if(vis)
            backgroundPlayer.play();
    }
    
    private void sendMessage(String message) {
        try {
            client.sendMessage(message);
        } catch (IOException ex) {
            Logger.getLogger(LobbyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        //Auto-Generated Code
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LobbyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LobbyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LobbyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LobbyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LobbyGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton;
    private javax.swing.JLabel Background;
    private javax.swing.JButton BusyBackButton;
    protected javax.swing.JLayeredPane BusyPopup;
    private javax.swing.JLabel BusyPopupBackground;
    protected javax.swing.JLabel BusyText;
    private javax.swing.JButton DeclineButton;
    protected javax.swing.JLabel LobbyText;
    protected javax.swing.JLabel LobbyText1;
    private javax.swing.JLayeredPane MainContainer;
    private javax.swing.JButton Player1;
    private javax.swing.JButton Player2;
    private javax.swing.JButton Player3;
    private javax.swing.JButton Player4;
    private javax.swing.JButton Player5;
    private javax.swing.JButton Player6;
    private javax.swing.JButton Player7;
    private javax.swing.JButton Player8;
    protected javax.swing.JLayeredPane PlayerButtons;
    protected javax.swing.JLabel PlayerName;
    protected javax.swing.JLayeredPane RequestPopup;
    private javax.swing.JLabel RequestPopupBackground;
    protected javax.swing.JLabel RequestText;
    private javax.swing.JButton SignupAcceptButton;
    protected javax.swing.JLabel SignupInfoText;
    protected javax.swing.JLayeredPane SignupPopup;
    private javax.swing.JLabel SignupPopupBackground;
    private javax.swing.JTextField SignupTextField;
    private javax.swing.JButton WaitingBackButton;
    protected javax.swing.JLabel WaitingDots;
    protected javax.swing.JLayeredPane WaitingPopup;
    private javax.swing.JLabel WaitingPopupBackground;
    protected javax.swing.JLabel WaitingText1;
    protected javax.swing.JLabel WaitingText2;
    // End of variables declaration//GEN-END:variables
}