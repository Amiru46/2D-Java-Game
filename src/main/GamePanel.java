package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;  //16*16

    final int scale = 3;

    final int tileSize = originalTileSize * scale;      //48*48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;  //768 pix
    final int screenHeight = tileSize * maxScreenRow;  //576 pix

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;


    int playerX = 100;
    int playerY = 100;
    int PlayerSpeed = 4;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;

        while (gameThread != null) {


            update();


            repaint();

//            System.out.println("Hi Sri Lanka");
        }
    }

        public void update() {

            if (keyH.upPressed == true) {
                playerY -= PlayerSpeed;
            }
            else if (keyH.downPressed == true) {
                playerY += PlayerSpeed;
            }
            else if (keyH.leftPressed == true) {
                playerX -= PlayerSpeed;
            }
            else if (keyH.rightPressed == true) {
                playerX += PlayerSpeed;
            }

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.WHITE);

            g2.fillRect(playerX, playerY, tileSize, tileSize);

            g2.dispose();
        }


}
