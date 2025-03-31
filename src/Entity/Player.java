package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends entity{

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValuves();
        getPlayerImage();

    }

    public void setDefaultValuves() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "right";

    }

    public void getPlayerImage(){

        try {

            up1 = ImageIO.read(getClass().getResource("/Entity/boy/back a.png"));
            up2 = ImageIO.read(getClass().getResource("/Entity/boy/back b.png"));
            down1 = ImageIO.read(getClass().getResource("/Entity/boy/front A.png"));
            down2 = ImageIO.read(getClass().getResource("/Entity/boy/front B.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

//        if (keyH.upPressed == true || keyH.downPressed == true ||
//                keyH.leftPressed == true || keyH.rightPressed == true) {} // if want stop draining

        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        }
        else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }

        spriteCounter++;
        if (spriteCounter > 30) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }
    public void draw(Graphics g2) {
//        g2.setColor(Color.WHITE);
//
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage Image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    Image = up1;
                }
                if (spriteNum == 2) {
                    Image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    Image = up2;
                }
                if (spriteNum == 2) {
                    Image = up1;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    Image = down1;
                }
                if (spriteNum == 2) {
                    Image = down2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    Image = down2;
                }
                if (spriteNum == 2) {
                    Image = down1;
                }
                break;
        }
        g2.drawImage(Image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
