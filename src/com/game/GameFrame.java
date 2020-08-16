package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameFrame extends JFrame {
    public static GamePanel gamePanel;
    public JDesktopPane mainPane;
    public static JInternalFrame InternalFrame;
    public boolean inGame;

    public GameFrame() throws IOException {
        mainPane = new JDesktopPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        setResizable(false);
        setTitle("Platformermieo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        start();
        /*while(inGame){
            GamePanel panelarray[] = {panel_1, panel_2, panel_3, panel_4};
            boolean temp = true;
            while (temp){
                for(GamePanel panel: panelarray){
                    panel.checkWin();
                    if(panel.win){
                        System.out.println("Player" + panel.getPlayer() + "won, congrats!");
                        temp = false;
                    }
                }
            }*/

        /*for(GamePanel panel: panelarray){
            panel.checkWin();
            if(panel.win){
                System.out.println("Player" + panel.getPlayer() + "won, congrats!");
                inGame = false;
            }*/
        }
        
    public void start() throws IOException {
        pack();
        inGame = false;
        setVisible(true);
        setLocationRelativeTo(null);
        keyEvent(this);
        createGamePanel();
    }


    public void createGamePanel() throws IOException {
        InternalFrame = new JInternalFrame();
        InternalFrame.setVisible(true);
        InternalFrame.setSize(350,350);
        InternalFrame.setLocation(0,0);
        iFrameProps(InternalFrame, InternalFrame.getX(), InternalFrame.getY());
        mainPane.add(InternalFrame);
        gamePanel = new GamePanel(1);
        InternalFrame.add(gamePanel);
        add(mainPane);
    }

    public void iFrameProps(JInternalFrame frame, int x, int y){
        frame.setClosable(false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); //quita logo
        //frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
            private void formComponentMoved(ComponentEvent evt) {
                // TODO Auto-generated method stub
                frame.setLocation(x, y);
            }
        });

    }

    public void keyEvent(JFrame frame){
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){ //W1
                    gamePanel.moveUp();
                } else if(e.getKeyCode() == KeyEvent.VK_S){//S1
                    gamePanel.moveDown();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){ //W1
                    gamePanel.shipStop();
                } else if(e.getKeyCode() == KeyEvent.VK_S){//S1
                    gamePanel.shipStop();
                }
            }
        });
    }
}

