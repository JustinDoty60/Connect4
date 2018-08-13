/**
 * @author Justin Doty
 * GUI class for the game
 */
package connect4client;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameGUI extends javax.swing.JFrame {

    private LobbyGUI lobbyGUI;
    private Connect4Client client;
    private JLabel[] columns = new JLabel[7];
    private JButton[][] board;
    private String playerChip;
    private String opponentChip;
    private Media songFile;
    private MediaPlayer tinkPlayer;
    private MediaPlayer invalidPlayer;
    private MediaPlayer cheerPlayer;
    private MediaPlayer losePlayer;
    private MediaPlayer backgroundPlayer;
    private Point mouseLocation;
    private Rectangle bounds;
    private Thread chipAnimation;
    
    public GameGUI() {
        initComponents();
    }
    
    public GameGUI(Connect4Client client, LobbyGUI lobbyGUI) {
        initComponents();
        initGamePlayGUI();
        initSong();
        this.lobbyGUI = lobbyGUI;
        this.client = client;
    }
    
    private void initGamePlayGUI() {
        columns[0] = Column1;
        columns[1] = Column2;
        columns[2] = Column3;
        columns[3] = Column4;
        columns[4] = Column5;
        columns[5] = Column6;
        columns[6] = Column7;
        
        JButton[][] b = {{pos00, pos01, pos02, pos03, pos04, pos05, pos06},
                         {pos10, pos11, pos12, pos13, pos14, pos15, pos16},
                         {pos20, pos21, pos22, pos23, pos24, pos25, pos26},
                         {pos30, pos31, pos32, pos33, pos34, pos35, pos36},
                         {pos40, pos41, pos42, pos43, pos44, pos45, pos46},
                         {pos50, pos51, pos52, pos53, pos54, pos55, pos56}};
        
        board = b;
    }
    
    private void initSong() {
        songFile = new Media(new File("src\\audio\\game.mp3").toURI().toString());
        backgroundPlayer = new MediaPlayer(songFile);
        backgroundPlayer.setVolume(.1);
        backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundPlayer.play();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainContainer = new javax.swing.JLayeredPane();
        TimeOutPopup = new javax.swing.JLayeredPane();
        TimeOutAcceptButton = new javax.swing.JButton();
        TimeOutOpponentText = new javax.swing.JLabel();
        TimeOutStatusText = new javax.swing.JLabel();
        EndGamePopup = new javax.swing.JLayeredPane();
        AcceptButton = new javax.swing.JButton();
        DeclineButton = new javax.swing.JButton();
        OpponentText = new javax.swing.JLabel();
        StatusText = new javax.swing.JLabel();
        Board = new javax.swing.JLabel();
        BoardBoundaries = new javax.swing.JLayeredPane();
        Chip = new javax.swing.JLabel();
        Column7 = new javax.swing.JLabel();
        Column6 = new javax.swing.JLabel();
        Column5 = new javax.swing.JLabel();
        Column4 = new javax.swing.JLabel();
        Column3 = new javax.swing.JLabel();
        Column2 = new javax.swing.JLabel();
        Column1 = new javax.swing.JLabel();
        ResultText = new javax.swing.JLabel();
        Chips = new javax.swing.JPanel();
        pos00 = new javax.swing.JButton();
        pos01 = new javax.swing.JButton();
        pos02 = new javax.swing.JButton();
        pos03 = new javax.swing.JButton();
        pos04 = new javax.swing.JButton();
        pos05 = new javax.swing.JButton();
        pos06 = new javax.swing.JButton();
        pos10 = new javax.swing.JButton();
        pos11 = new javax.swing.JButton();
        pos12 = new javax.swing.JButton();
        pos13 = new javax.swing.JButton();
        pos14 = new javax.swing.JButton();
        pos15 = new javax.swing.JButton();
        pos16 = new javax.swing.JButton();
        pos20 = new javax.swing.JButton();
        pos21 = new javax.swing.JButton();
        pos22 = new javax.swing.JButton();
        pos23 = new javax.swing.JButton();
        pos24 = new javax.swing.JButton();
        pos25 = new javax.swing.JButton();
        pos26 = new javax.swing.JButton();
        pos30 = new javax.swing.JButton();
        pos31 = new javax.swing.JButton();
        pos32 = new javax.swing.JButton();
        pos33 = new javax.swing.JButton();
        pos34 = new javax.swing.JButton();
        pos35 = new javax.swing.JButton();
        pos36 = new javax.swing.JButton();
        pos40 = new javax.swing.JButton();
        pos41 = new javax.swing.JButton();
        pos42 = new javax.swing.JButton();
        pos43 = new javax.swing.JButton();
        pos44 = new javax.swing.JButton();
        pos45 = new javax.swing.JButton();
        pos46 = new javax.swing.JButton();
        pos50 = new javax.swing.JButton();
        pos51 = new javax.swing.JButton();
        pos52 = new javax.swing.JButton();
        pos53 = new javax.swing.JButton();
        pos54 = new javax.swing.JButton();
        pos55 = new javax.swing.JButton();
        pos56 = new javax.swing.JButton();
        OpponentName = new javax.swing.JLabel();
        OpponentTurn = new javax.swing.JLabel();
        PlayerTurn = new javax.swing.JLabel();
        PlayerName = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        TimeOutPopup.setVisible(false);
        TimeOutPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TimeOutAcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptIdle.png"))); // NOI18N
        TimeOutAcceptButton.setBorderPainted(false);
        TimeOutAcceptButton.setContentAreaFilled(false);
        TimeOutAcceptButton.setFocusPainted(false);
        TimeOutAcceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimeOutAcceptButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TimeOutAcceptButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TimeOutAcceptButtonMouseExited(evt);
            }
        });
        TimeOutPopup.add(TimeOutAcceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 130, 60));

        TimeOutOpponentText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        TimeOutOpponentText.setForeground(new java.awt.Color(255, 255, 255));
        TimeOutOpponentText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeOutOpponentText.setToolTipText("");
        TimeOutPopup.add(TimeOutOpponentText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 50));

        TimeOutStatusText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        TimeOutStatusText.setForeground(new java.awt.Color(255, 255, 255));
        TimeOutStatusText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeOutStatusText.setToolTipText("");
        TimeOutPopup.add(TimeOutStatusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 50));

        MainContainer.add(TimeOutPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 220, 240));

        EndGamePopup.setVisible(false);
        EndGamePopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        EndGamePopup.add(AcceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 130, 60));

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
        EndGamePopup.add(DeclineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, 60));

        OpponentText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        OpponentText.setForeground(new java.awt.Color(255, 255, 255));
        OpponentText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OpponentText.setToolTipText("");
        EndGamePopup.add(OpponentText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 50));

        StatusText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        StatusText.setForeground(new java.awt.Color(255, 255, 255));
        StatusText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StatusText.setText("Rematch?");
        StatusText.setToolTipText("");
        EndGamePopup.add(StatusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 50));

        MainContainer.add(EndGamePopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 170, 240));

        Board.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/board.png"))); // NOI18N
        MainContainer.add(Board, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 90, -1, -1));

        Chip.setVisible(false);
        Chip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Chip.setMaximumSize(new java.awt.Dimension(90, 90));
        Chip.setMinimumSize(new java.awt.Dimension(90, 90));
        Chip.setPreferredSize(new java.awt.Dimension(90, 90));
        BoardBoundaries.add(Chip);
        Chip.setBounds(0, 0, 90, 80);

        Column7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column7MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column7);
        Column7.setBounds(540, 0, 90, 630);

        Column6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column6MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column6);
        Column6.setBounds(450, 0, 90, 630);

        Column5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column5MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column5);
        Column5.setBounds(360, 0, 90, 630);

        Column4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column4MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column4);
        Column4.setBounds(270, 0, 90, 630);

        Column3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column3MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column3);
        Column3.setBounds(180, 0, 90, 630);

        Column2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column2MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column2);
        Column2.setBounds(90, 0, 90, 630);

        Column1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Column1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Column1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Column1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Column1MouseExited(evt);
            }
        });
        BoardBoundaries.add(Column1);
        Column1.setBounds(0, 0, 90, 630);

        ResultText.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        ResultText.setForeground(new java.awt.Color(255, 255, 255));
        ResultText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultText.setToolTipText("");
        BoardBoundaries.add(ResultText);
        ResultText.setBounds(30, 0, 570, 80);

        MainContainer.add(BoardBoundaries, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 10, 630, 620));

        Chips.setMinimumSize(new java.awt.Dimension(630, 540));
        Chips.setOpaque(false);
        Chips.setPreferredSize(new java.awt.Dimension(630, 540));
        Chips.setLayout(new java.awt.GridLayout(6, 7));

        pos00.setAlignmentY(0.0F);
        pos00.setBorderPainted(false);
        pos00.setContentAreaFilled(false);
        pos00.setMaximumSize(new java.awt.Dimension(90, 90));
        pos00.setMinimumSize(new java.awt.Dimension(90, 90));
        pos00.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos00);

        pos01.setAlignmentY(0.0F);
        pos01.setBorderPainted(false);
        pos01.setContentAreaFilled(false);
        pos01.setMaximumSize(new java.awt.Dimension(90, 90));
        pos01.setMinimumSize(new java.awt.Dimension(90, 90));
        pos01.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos01);

        pos02.setAlignmentY(0.0F);
        pos02.setBorderPainted(false);
        pos02.setContentAreaFilled(false);
        pos02.setMaximumSize(new java.awt.Dimension(90, 90));
        pos02.setMinimumSize(new java.awt.Dimension(90, 90));
        pos02.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos02);

        pos03.setAlignmentY(0.0F);
        pos03.setBorderPainted(false);
        pos03.setContentAreaFilled(false);
        pos03.setMaximumSize(new java.awt.Dimension(90, 90));
        pos03.setMinimumSize(new java.awt.Dimension(90, 90));
        pos03.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos03);

        pos04.setAlignmentY(0.0F);
        pos04.setBorderPainted(false);
        pos04.setContentAreaFilled(false);
        pos04.setMaximumSize(new java.awt.Dimension(90, 90));
        pos04.setMinimumSize(new java.awt.Dimension(90, 90));
        pos04.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos04);

        pos05.setAlignmentY(0.0F);
        pos05.setBorderPainted(false);
        pos05.setContentAreaFilled(false);
        pos05.setMaximumSize(new java.awt.Dimension(90, 90));
        pos05.setMinimumSize(new java.awt.Dimension(90, 90));
        pos05.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos05);

        pos06.setAlignmentY(0.0F);
        pos06.setBorderPainted(false);
        pos06.setContentAreaFilled(false);
        pos06.setMaximumSize(new java.awt.Dimension(90, 90));
        pos06.setMinimumSize(new java.awt.Dimension(90, 90));
        pos06.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos06);

        pos10.setAlignmentY(0.0F);
        pos10.setBorderPainted(false);
        pos10.setContentAreaFilled(false);
        pos10.setMaximumSize(new java.awt.Dimension(90, 90));
        pos10.setMinimumSize(new java.awt.Dimension(90, 90));
        pos10.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos10);

        pos11.setAlignmentY(0.0F);
        pos11.setBorderPainted(false);
        pos11.setContentAreaFilled(false);
        pos11.setMaximumSize(new java.awt.Dimension(90, 90));
        pos11.setMinimumSize(new java.awt.Dimension(90, 90));
        pos11.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos11);

        pos12.setAlignmentY(0.0F);
        pos12.setBorderPainted(false);
        pos12.setContentAreaFilled(false);
        pos12.setMaximumSize(new java.awt.Dimension(90, 90));
        pos12.setMinimumSize(new java.awt.Dimension(90, 90));
        pos12.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos12);

        pos13.setAlignmentY(0.0F);
        pos13.setBorderPainted(false);
        pos13.setContentAreaFilled(false);
        pos13.setMaximumSize(new java.awt.Dimension(90, 90));
        pos13.setMinimumSize(new java.awt.Dimension(90, 90));
        pos13.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos13);

        pos14.setAlignmentY(0.0F);
        pos14.setBorderPainted(false);
        pos14.setContentAreaFilled(false);
        pos14.setMaximumSize(new java.awt.Dimension(90, 90));
        pos14.setMinimumSize(new java.awt.Dimension(90, 90));
        pos14.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos14);

        pos15.setAlignmentY(0.0F);
        pos15.setBorderPainted(false);
        pos15.setContentAreaFilled(false);
        pos15.setMaximumSize(new java.awt.Dimension(90, 90));
        pos15.setMinimumSize(new java.awt.Dimension(90, 90));
        pos15.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos15);

        pos16.setAlignmentY(0.0F);
        pos16.setBorderPainted(false);
        pos16.setContentAreaFilled(false);
        pos16.setMaximumSize(new java.awt.Dimension(90, 90));
        pos16.setMinimumSize(new java.awt.Dimension(90, 90));
        pos16.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos16);

        pos20.setAlignmentY(0.0F);
        pos20.setBorderPainted(false);
        pos20.setContentAreaFilled(false);
        pos20.setMaximumSize(new java.awt.Dimension(90, 90));
        pos20.setMinimumSize(new java.awt.Dimension(90, 90));
        pos20.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos20);

        pos21.setAlignmentY(0.0F);
        pos21.setBorderPainted(false);
        pos21.setContentAreaFilled(false);
        pos21.setMaximumSize(new java.awt.Dimension(90, 90));
        pos21.setMinimumSize(new java.awt.Dimension(90, 90));
        pos21.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos21);

        pos22.setAlignmentY(0.0F);
        pos22.setBorderPainted(false);
        pos22.setContentAreaFilled(false);
        pos22.setMaximumSize(new java.awt.Dimension(90, 90));
        pos22.setMinimumSize(new java.awt.Dimension(90, 90));
        pos22.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos22);

        pos23.setAlignmentY(0.0F);
        pos23.setBorderPainted(false);
        pos23.setContentAreaFilled(false);
        pos23.setMaximumSize(new java.awt.Dimension(90, 90));
        pos23.setMinimumSize(new java.awt.Dimension(90, 90));
        pos23.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos23);

        pos24.setAlignmentY(0.0F);
        pos24.setBorderPainted(false);
        pos24.setContentAreaFilled(false);
        pos24.setMaximumSize(new java.awt.Dimension(90, 90));
        pos24.setMinimumSize(new java.awt.Dimension(90, 90));
        pos24.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos24);

        pos25.setAlignmentY(0.0F);
        pos25.setBorderPainted(false);
        pos25.setContentAreaFilled(false);
        pos25.setMaximumSize(new java.awt.Dimension(90, 90));
        pos25.setMinimumSize(new java.awt.Dimension(90, 90));
        pos25.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos25);

        pos26.setAlignmentY(0.0F);
        pos26.setBorderPainted(false);
        pos26.setContentAreaFilled(false);
        pos26.setMaximumSize(new java.awt.Dimension(90, 90));
        pos26.setMinimumSize(new java.awt.Dimension(90, 90));
        pos26.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos26);

        pos30.setAlignmentY(0.0F);
        pos30.setBorderPainted(false);
        pos30.setContentAreaFilled(false);
        pos30.setMaximumSize(new java.awt.Dimension(90, 90));
        pos30.setMinimumSize(new java.awt.Dimension(90, 90));
        pos30.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos30);

        pos31.setAlignmentY(0.0F);
        pos31.setBorderPainted(false);
        pos31.setContentAreaFilled(false);
        pos31.setMaximumSize(new java.awt.Dimension(90, 90));
        pos31.setMinimumSize(new java.awt.Dimension(90, 90));
        pos31.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos31);

        pos32.setAlignmentY(0.0F);
        pos32.setBorderPainted(false);
        pos32.setContentAreaFilled(false);
        pos32.setMaximumSize(new java.awt.Dimension(90, 90));
        pos32.setMinimumSize(new java.awt.Dimension(90, 90));
        pos32.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos32);

        pos33.setAlignmentY(0.0F);
        pos33.setBorderPainted(false);
        pos33.setContentAreaFilled(false);
        pos33.setMaximumSize(new java.awt.Dimension(90, 90));
        pos33.setMinimumSize(new java.awt.Dimension(90, 90));
        pos33.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos33);

        pos34.setAlignmentY(0.0F);
        pos34.setBorderPainted(false);
        pos34.setContentAreaFilled(false);
        pos34.setMaximumSize(new java.awt.Dimension(90, 90));
        pos34.setMinimumSize(new java.awt.Dimension(90, 90));
        pos34.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos34);

        pos35.setAlignmentY(0.0F);
        pos35.setBorderPainted(false);
        pos35.setContentAreaFilled(false);
        pos35.setMaximumSize(new java.awt.Dimension(90, 90));
        pos35.setMinimumSize(new java.awt.Dimension(90, 90));
        pos35.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos35);

        pos36.setAlignmentY(0.0F);
        pos36.setBorderPainted(false);
        pos36.setContentAreaFilled(false);
        pos36.setMaximumSize(new java.awt.Dimension(90, 90));
        pos36.setMinimumSize(new java.awt.Dimension(90, 90));
        pos36.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos36);

        pos40.setAlignmentY(0.0F);
        pos40.setBorderPainted(false);
        pos40.setContentAreaFilled(false);
        pos40.setMaximumSize(new java.awt.Dimension(90, 90));
        pos40.setMinimumSize(new java.awt.Dimension(90, 90));
        pos40.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos40);

        pos41.setAlignmentY(0.0F);
        pos41.setBorderPainted(false);
        pos41.setContentAreaFilled(false);
        pos41.setMaximumSize(new java.awt.Dimension(90, 90));
        pos41.setMinimumSize(new java.awt.Dimension(90, 90));
        pos41.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos41);

        pos42.setAlignmentY(0.0F);
        pos42.setBorderPainted(false);
        pos42.setContentAreaFilled(false);
        pos42.setMaximumSize(new java.awt.Dimension(90, 90));
        pos42.setMinimumSize(new java.awt.Dimension(90, 90));
        pos42.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos42);

        pos43.setAlignmentY(0.0F);
        pos43.setBorderPainted(false);
        pos43.setContentAreaFilled(false);
        pos43.setMaximumSize(new java.awt.Dimension(90, 90));
        pos43.setMinimumSize(new java.awt.Dimension(90, 90));
        pos43.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos43);

        pos44.setAlignmentY(0.0F);
        pos44.setBorderPainted(false);
        pos44.setContentAreaFilled(false);
        pos44.setMaximumSize(new java.awt.Dimension(90, 90));
        pos44.setMinimumSize(new java.awt.Dimension(90, 90));
        pos44.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos44);

        pos45.setAlignmentY(0.0F);
        pos45.setBorderPainted(false);
        pos45.setContentAreaFilled(false);
        pos45.setMaximumSize(new java.awt.Dimension(90, 90));
        pos45.setMinimumSize(new java.awt.Dimension(90, 90));
        pos45.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos45);

        pos46.setAlignmentY(0.0F);
        pos46.setBorderPainted(false);
        pos46.setContentAreaFilled(false);
        pos46.setMaximumSize(new java.awt.Dimension(90, 90));
        pos46.setMinimumSize(new java.awt.Dimension(90, 90));
        pos46.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos46);

        pos50.setAlignmentY(0.0F);
        pos50.setBorderPainted(false);
        pos50.setContentAreaFilled(false);
        pos50.setMaximumSize(new java.awt.Dimension(90, 90));
        pos50.setMinimumSize(new java.awt.Dimension(90, 90));
        pos50.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos50);

        pos51.setAlignmentY(0.0F);
        pos51.setBorderPainted(false);
        pos51.setContentAreaFilled(false);
        pos51.setMaximumSize(new java.awt.Dimension(90, 90));
        pos51.setMinimumSize(new java.awt.Dimension(90, 90));
        pos51.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos51);

        pos52.setAlignmentY(0.0F);
        pos52.setBorderPainted(false);
        pos52.setContentAreaFilled(false);
        pos52.setMaximumSize(new java.awt.Dimension(90, 90));
        pos52.setMinimumSize(new java.awt.Dimension(90, 90));
        pos52.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos52);

        pos53.setAlignmentY(0.0F);
        pos53.setBorderPainted(false);
        pos53.setContentAreaFilled(false);
        pos53.setMaximumSize(new java.awt.Dimension(90, 90));
        pos53.setMinimumSize(new java.awt.Dimension(90, 90));
        pos53.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos53);

        pos54.setAlignmentY(0.0F);
        pos54.setBorderPainted(false);
        pos54.setContentAreaFilled(false);
        pos54.setMaximumSize(new java.awt.Dimension(90, 90));
        pos54.setMinimumSize(new java.awt.Dimension(90, 90));
        pos54.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos54);

        pos55.setAlignmentY(0.0F);
        pos55.setBorderPainted(false);
        pos55.setContentAreaFilled(false);
        pos55.setMaximumSize(new java.awt.Dimension(90, 90));
        pos55.setMinimumSize(new java.awt.Dimension(90, 90));
        pos55.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos55);

        pos56.setAlignmentY(0.0F);
        pos56.setBorderPainted(false);
        pos56.setContentAreaFilled(false);
        pos56.setMaximumSize(new java.awt.Dimension(90, 90));
        pos56.setMinimumSize(new java.awt.Dimension(90, 90));
        pos56.setPreferredSize(new java.awt.Dimension(90, 90));
        Chips.add(pos56);

        MainContainer.add(Chips, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 90, 630, 540));

        OpponentName.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        OpponentName.setForeground(new java.awt.Color(51, 51, 51));
        OpponentName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        OpponentName.setToolTipText("");
        MainContainer.add(OpponentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 220, 50));

        OpponentTurn.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        OpponentTurn.setForeground(new java.awt.Color(51, 51, 51));
        OpponentTurn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        OpponentTurn.setToolTipText("");
        MainContainer.add(OpponentTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 190, 50));

        PlayerTurn.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        PlayerTurn.setForeground(new java.awt.Color(51, 51, 51));
        PlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PlayerTurn.setToolTipText("");
        MainContainer.add(PlayerTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 50));

        PlayerName.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        PlayerName.setForeground(new java.awt.Color(51, 51, 51));
        PlayerName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PlayerName.setToolTipText("");
        MainContainer.add(PlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 50));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpg"))); // NOI18N
        MainContainer.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(MainContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sendMessage("TIMED_OUT");
        sendMessage("LEAVE");
    }//GEN-LAST:event_formWindowClosing

    private void Column1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column1MouseClicked
        sendTurn(0);
    }//GEN-LAST:event_Column1MouseClicked

    private void Column2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column2MouseClicked
        sendTurn(1);
    }//GEN-LAST:event_Column2MouseClicked

    private void Column3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column3MouseClicked
        sendTurn(2);
    }//GEN-LAST:event_Column3MouseClicked

    private void Column4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column4MouseClicked
        sendTurn(3);
    }//GEN-LAST:event_Column4MouseClicked

    private void Column5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column5MouseClicked
        sendTurn(4);
    }//GEN-LAST:event_Column5MouseClicked

    private void Column6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column6MouseClicked
        sendTurn(5);
    }//GEN-LAST:event_Column6MouseClicked

    private void Column7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column7MouseClicked
        sendTurn(6);
    }//GEN-LAST:event_Column7MouseClicked
   
    private void Column1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column1MouseEntered
        displayChip(0);
    }//GEN-LAST:event_Column1MouseEntered

    private void Column2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column2MouseEntered
        displayChip(1);
    }//GEN-LAST:event_Column2MouseEntered

    private void Column3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column3MouseEntered
        displayChip(2);
    }//GEN-LAST:event_Column3MouseEntered

    private void Column4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column4MouseEntered
        displayChip(3);
    }//GEN-LAST:event_Column4MouseEntered

    private void Column5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column5MouseEntered
        displayChip(4);
    }//GEN-LAST:event_Column5MouseEntered

    private void Column6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column6MouseEntered
        displayChip(5);
    }//GEN-LAST:event_Column6MouseEntered

    private void Column7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column7MouseEntered
        displayChip(6);
    }//GEN-LAST:event_Column7MouseEntered
    
    private void Column1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column1MouseExited
        removeChip(0);
    }//GEN-LAST:event_Column1MouseExited

    private void Column2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column2MouseExited
        removeChip(1);
    }//GEN-LAST:event_Column2MouseExited

    private void Column3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column3MouseExited
        removeChip(2);
    }//GEN-LAST:event_Column3MouseExited

    private void Column4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column4MouseExited
        removeChip(3);
    }//GEN-LAST:event_Column4MouseExited

    private void Column5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column5MouseExited
        removeChip(4);
    }//GEN-LAST:event_Column5MouseExited

    private void Column6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column6MouseExited
        removeChip(5);
    }//GEN-LAST:event_Column6MouseExited

    private void Column7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Column7MouseExited
        removeChip(6);
    }//GEN-LAST:event_Column7MouseExited
    
    private void AcceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptButtonMouseClicked
        if(AcceptButton.isEnabled()) { 
            sendMessage("REMATCH");

            AcceptButton.setEnabled(false);
            OpponentText.setText("Awaiting");
            StatusText.setText("Response");
            //TODO
        }
    }//GEN-LAST:event_AcceptButtonMouseClicked

    private void AcceptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptButtonMouseEntered
        setAcceptButtonIcon("/img/buttonAcceptHover.png");
    }//GEN-LAST:event_AcceptButtonMouseEntered

    private void AcceptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptButtonMouseExited
        setAcceptButtonIcon("/img/buttonAcceptIdle.png");
    }//GEN-LAST:event_AcceptButtonMouseExited
    
    private void setAcceptButtonIcon(String icon) {
        if(AcceptButton.isEnabled())
            AcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(icon)));
    }
    
    private void DeclineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineButtonMouseClicked
        sendDeclinedRematch();
    }//GEN-LAST:event_DeclineButtonMouseClicked
  
    private void DeclineButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineButtonMouseEntered
        DeclineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDeclineHover.png")));
    }//GEN-LAST:event_DeclineButtonMouseEntered

    private void DeclineButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineButtonMouseExited
        DeclineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDeclineIdle.png")));
    }//GEN-LAST:event_DeclineButtonMouseExited
    
    private void TimeOutAcceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeOutAcceptButtonMouseClicked
        sendDeclinedRematch();
    }//GEN-LAST:event_TimeOutAcceptButtonMouseClicked

    private void sendDeclinedRematch() {
        putUpGameGUI();
        lobbyGUI.setVisible(true);
            
        sendMessage("DECLINE_REMATCH");
    }
    
    private void TimeOutAcceptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeOutAcceptButtonMouseEntered
        TimeOutAcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptHover.png")));
    }//GEN-LAST:event_TimeOutAcceptButtonMouseEntered

    private void TimeOutAcceptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeOutAcceptButtonMouseExited
        TimeOutAcceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAcceptIdle.png")));
    }//GEN-LAST:event_TimeOutAcceptButtonMouseExited
    
    private void sendTurn(int column) {
        if(PlayerTurn.getText().equals("Your Turn"))
            sendMessage("MOVE" + column);
    }
    
    private void displayChip(int column) {
        if(PlayerTurn.getText().equals("Your Turn"))
            columns[column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + playerChip)));
    }
    
    private void removeChip(int column) {
        columns[column].setIcon(null);
    }
    
    protected void setTurnText(boolean turnText) {
        if(turnText) {
            PlayerTurn.setText("Your Turn");
            OpponentTurn.setText("");
        } else {
            OpponentTurn.setText("Opponent's Turn");
            PlayerTurn.setText("");
        }
    }
    
    protected boolean isMouseWithinComponent(Component c) {
        mouseLocation = MouseInfo.getPointerInfo().getLocation();
        bounds = c.getBounds();
        bounds.setLocation(c.getLocationOnScreen());
        return bounds.contains(mouseLocation);
    }
    
    protected void startResultTextColor(String chip) {
        Thread resultTextColor = new Thread(){
            @Override
            public void run() {
                try {
                    changeTextColor(chip, ResultText);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        };
        resultTextColor.start();
    }
    
    protected void chipAnimation(int x, int endRow, String chip) throws InterruptedException {
        chipAnimation = new Thread(){
            @Override
            public void run() {
                int endY = (endRow * 90) + 95;
                
                Chip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + chip)));
                Chip.setLocation(x, 0);
                Chip.setVisible(true);
                
                for(int i = 0; i <= endY; i++) {
                    Chip.setLocation(x, i);
                    try {
                        if(i % 2 == 0)
                            Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                Chip.setVisible(false);
            }  
        };
        chipAnimation.start();
        chipAnimation.join(); 
        tinkSound();
    }
    
    protected Thread turnPlayerTextColor = new Thread(){
        @Override
        public void run() {
            try {
                changeTextColor(playerChip, PlayerTurn);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    };
    
    protected Thread turnOpponentTextColor = new Thread(){
        @Override
        public void run() {
            try {
                changeTextColor(opponentChip, OpponentTurn);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    };
    
    private void changeTextColor(String chipName, JLabel chipLabel) throws InterruptedException {

        int red, green, blue;
        int redTemp, greenTemp, blueTemp;
        
        red = 190; green = 0; blue = 35;

        if(chipName.equals("pieceYellow.png")) {
            red = 255; green = 250; blue = 92;
        }

        redTemp = red; greenTemp = green; blueTemp = blue;

        while(true){
            for(int i = 0; i < 220; i++) {
                Thread.sleep(7);
                if(redTemp < 220)
                    chipLabel.setForeground(new Color(redTemp+=i,greenTemp,blueTemp));
                if(greenTemp < 220)
                    chipLabel.setForeground(new Color(redTemp,greenTemp+=i,blueTemp));
                if(blueTemp < 220)
                    chipLabel.setForeground(new Color(redTemp,greenTemp,blueTemp+=i));
            }
            for(int i = 0; i < 220; i++) {
                Thread.sleep(7);
                if(redTemp > red)
                    chipLabel.setForeground(new Color(redTemp-=i,greenTemp,blueTemp));
                if(greenTemp > green)
                    chipLabel.setForeground(new Color(redTemp,greenTemp-=i,blueTemp));
                if(blueTemp > blue)
                    chipLabel.setForeground(new Color(redTemp,greenTemp,blueTemp-=i));
            }
        }
    }
   
    private void tinkSound() {
        Thread tinkSound = new Thread(){
        @Override
        public void run() {
            songFile = new Media(new File("src\\audio\\tink.mp3").toURI().toString());
            tinkPlayer = new MediaPlayer(songFile);
            tinkPlayer.setVolume(.7);
            tinkPlayer.play();
        }};
        tinkSound.start();
    }
    
    protected void invalidSound() {
        Thread invalidSound = new Thread(){
        @Override
        public void run() {
            songFile = new Media(new File("src\\audio\\invalid.mp3").toURI().toString());
            invalidPlayer = new MediaPlayer(songFile);
            invalidPlayer.setVolume(.7);
            invalidPlayer.play();
        }};
        invalidSound.start();
    }
    
    protected void cheerSound() {
        Thread cheerSound = new Thread(){
        @Override
        public void run() {
            songFile = new Media(new File("src\\audio\\cheer.mp3").toURI().toString());
            cheerPlayer = new MediaPlayer(songFile);
            cheerPlayer.setVolume(.7);
            cheerPlayer.play();
        }};
        cheerSound.start();
    }
    
    protected void loseSound() {
        Thread loseSound = new Thread(){
        @Override
        public void run() {
            songFile = new Media(new File("src\\audio\\lose.mp3").toURI().toString());
            losePlayer = new MediaPlayer(songFile);
            losePlayer.setVolume(1);
            losePlayer.play();
        }};
        loseSound.start();
    }
    
    protected void initGame(boolean turn, String playerName, String opponentName) {
        setPieceColors(turn);
        initPlayerInfoText(playerName, opponentName);
        initBoard();
    }
    
    protected void setPieceColors(boolean turn) {
        if(turn) {
            playerChip = "pieceRed.png";
            opponentChip = "pieceYellow.png";
            setTurnText(true);
        }else if(turn == false){
            playerChip = "pieceYellow.png";
            opponentChip = "pieceRed.png";
            setTurnText(false);
        }
    }
    
    private void initPlayerInfoText(String playerName, String opponentName) {
        turnPlayerTextColor.start();
        turnOpponentTextColor.start();

        OpponentName.setText(opponentName);
        PlayerName.setText(playerName);
        
        PlayerTurn.setVisible(true);
        OpponentTurn.setVisible(true);
    }
    
    private void initBoard() {
        for(JButton[] jl: board) {
            for(JButton jb: jl)
                jb.setIcon(null);
        }
    }
        
    protected void playPlayerChip(int row, int column) throws InterruptedException {
        setTurnText(false);
        
        columns[column].setIcon(null);

        chipAnimation(columns[column].getX(), row, playerChip);

        chipAnimation.join();

        board[row][column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + playerChip)));

    }
    
    protected void playeOpponentChip(int row, int column) throws InterruptedException {
        setTurnText(true);
        
        chipAnimation(columns[column].getX(), row, opponentChip);

        chipAnimation.join();

        board[row][column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + opponentChip)));

        makeMousePositionChipVisible();
        
    }
    
    private void makeMousePositionChipVisible() {
        for(JLabel jl: columns) {
            if(isMouseWithinComponent(jl))
                jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + playerChip)));
        }
    }
    
    protected void playInvalidSound() {
        invalidSound();
    }
    
    protected void playCheerSound() {
        cheerSound();
    }
    
    protected void playLoseSound() {
        loseSound();
    }
    
    protected void displayWinResult(int row, int column) throws InterruptedException {
        ResultText.setText("You Win!");
        columns[column].setIcon(null);

        chipAnimation(columns[column].getX(), row, playerChip);

        chipAnimation.join();

        board[row][column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + playerChip)));
        startResultTextColor(playerChip);
    }
    
    protected void displayLoseResult(int row, int column) throws InterruptedException {
        ResultText.setText("You Lose!");

        chipAnimation(columns[column].getX(), row, opponentChip);

        chipAnimation.join();

        board[row][column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + opponentChip)));
        startResultTextColor(opponentChip);
    }
    
    protected void displayEndGameOptions() {
        endGameTurn();
        ResultText.setVisible(true);
        EndGamePopup.setVisible(true);

        OpponentText.setText("");
        StatusText.setText("Rematch?");

        AcceptButton.setEnabled(true);
    }
    
    protected void displayTieResultPlayer(int row, int column) {
        board[row][column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + playerChip)));
        columns[column].setIcon(null);
    }
    
    protected void displayTieResultOpponent(int row, int column) {
        board[row][column].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + opponentChip)));
    }
    
    protected void displayTieText() {
        startResultTextColor(playerChip);
        ResultText.setText("Tie!");
    }
    
    protected void displayTimeOutPopup() {
        endGameTurn();
        EndGamePopup.setVisible(false);
        TimeOutPopup.setVisible(true);

        TimeOutOpponentText.setText("Opponent");
        TimeOutStatusText.setText("Timed Out!");
    }
    
    private void endGameTurn() {
        PlayerTurn.setText("");
        PlayerTurn.setVisible(false);
        OpponentTurn.setVisible(false);
    }
    
    protected void resetPlayerPiece() {
        for(JLabel jl: columns)
            jl.setIcon(null);
    }
    
    protected void putUpGameGUI() {
        backgroundPlayer.dispose();
        dispose();
    }
    
    protected void displayDeclinedText() {
        OpponentText.setText("Opponent");
        StatusText.setText("Declined!");

        AcceptButton.setEnabled(false);
    }
    
    protected void sendMessage(Object message) {
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
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton AcceptButton;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Board;
    private javax.swing.JLayeredPane BoardBoundaries;
    protected javax.swing.JLabel Chip;
    private javax.swing.JPanel Chips;
    private javax.swing.JLabel Column1;
    private javax.swing.JLabel Column2;
    private javax.swing.JLabel Column3;
    private javax.swing.JLabel Column4;
    private javax.swing.JLabel Column5;
    private javax.swing.JLabel Column6;
    private javax.swing.JLabel Column7;
    private javax.swing.JButton DeclineButton;
    protected javax.swing.JLayeredPane EndGamePopup;
    private javax.swing.JLayeredPane MainContainer;
    protected javax.swing.JLabel OpponentName;
    protected javax.swing.JLabel OpponentText;
    protected javax.swing.JLabel OpponentTurn;
    protected javax.swing.JLabel PlayerName;
    protected javax.swing.JLabel PlayerTurn;
    protected javax.swing.JLabel ResultText;
    protected javax.swing.JLabel StatusText;
    private javax.swing.JButton TimeOutAcceptButton;
    protected javax.swing.JLabel TimeOutOpponentText;
    protected javax.swing.JLayeredPane TimeOutPopup;
    protected javax.swing.JLabel TimeOutStatusText;
    private javax.swing.JButton pos00;
    private javax.swing.JButton pos01;
    private javax.swing.JButton pos02;
    private javax.swing.JButton pos03;
    private javax.swing.JButton pos04;
    private javax.swing.JButton pos05;
    private javax.swing.JButton pos06;
    private javax.swing.JButton pos10;
    private javax.swing.JButton pos11;
    private javax.swing.JButton pos12;
    private javax.swing.JButton pos13;
    private javax.swing.JButton pos14;
    private javax.swing.JButton pos15;
    private javax.swing.JButton pos16;
    private javax.swing.JButton pos20;
    private javax.swing.JButton pos21;
    private javax.swing.JButton pos22;
    private javax.swing.JButton pos23;
    private javax.swing.JButton pos24;
    private javax.swing.JButton pos25;
    private javax.swing.JButton pos26;
    private javax.swing.JButton pos30;
    private javax.swing.JButton pos31;
    private javax.swing.JButton pos32;
    private javax.swing.JButton pos33;
    private javax.swing.JButton pos34;
    private javax.swing.JButton pos35;
    private javax.swing.JButton pos36;
    private javax.swing.JButton pos40;
    private javax.swing.JButton pos41;
    private javax.swing.JButton pos42;
    private javax.swing.JButton pos43;
    private javax.swing.JButton pos44;
    private javax.swing.JButton pos45;
    private javax.swing.JButton pos46;
    private javax.swing.JButton pos50;
    private javax.swing.JButton pos51;
    private javax.swing.JButton pos52;
    private javax.swing.JButton pos53;
    private javax.swing.JButton pos54;
    private javax.swing.JButton pos55;
    private javax.swing.JButton pos56;
    // End of variables declaration//GEN-END:variables
}