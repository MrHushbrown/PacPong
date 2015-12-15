/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import audio.AudioPlayer;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import images.ResourceTools;
import java.awt.Image;

/**
 *
 * @author asus pc
 */
class Arena extends Environment {

    private ArrayList<Barrier> barriers;
    private ArrayList<Item> items;
    private Grid grid;
    private Pacman playerone;
    private Paddle paddleOne, paddleTwo;
    private int scoreone;
    private int scoretwo;
    private int time;

    private int width = 80;
    private int widthChange = -1;

    private static final int MIN_X = 400;
    private static final int MAX_X = 1500;
    private static final int MIN_Y = 150;
    private static final int MAX_Y = 850;

    private Image coin;

    public Arena() {
        this.setBackground(Color.black);
//        this.setBackground(ResourceTools.loadImageFromResource(TOOL_TIP_TEXT_KEY))

        paddleOne = new Paddle(130, 175, 60, 320, Color.BLUE);
        paddleTwo = new Paddle(1710, 175, 60, 320, Color.RED);
        playerone = new Pacman(Direction.RIGHT);

//        paddleOne = new Paddle(Direction.DOWN);
        playerone = new Pacman(900, 450, 30, 30, MIN_X, MAX_X, MIN_Y, MAX_Y);
//<editor-fold defaultstate="collapsed" desc="items">
        
        items = new ArrayList<>();
        items.add(FoodItem.getRandomFoodItem(420, 175, 50, 50));
        items.add(FoodItem.getRandomFoodItem(520, 175, 50, 50));
        items.add(FoodItem.getRandomFoodItem(620, 175, 50, 50));
        
        items.add(FoodItem.getFoodItem(420, 250, 50, 50, FoodItem.BEER_FOOD_ITEM));
        items.add(FoodItem.getFoodItem(520, 250, 50, 50, FoodItem.BURGER_FOOD_ITEM));
        items.add(FoodItem.getFoodItem(620, 250, 50, 50, FoodItem.CHICKEN_FOOD_ITEM));
        items.add(FoodItem.getFoodItem(720, 250, 50, 50, FoodItem.COKE_FOOD_ITEM));
        
        items.add(PowerUpItem.getRandomPowerUpItem(420, 325, 50, 50));
        items.add(PowerUpItem.getRandomPowerUpItem(520, 325, 50, 50));
        items.add(PowerUpItem.getRandomPowerUpItem(620, 325, 50, 50));
        items.add(PowerUpItem.getRandomPowerUpItem(720, 325, 50, 50));
        
        items.add(PowerUpItem.getPowerUpItem(420, 400, 50, 50, PowerUpItem.COIN_POWERUP_ITEM));
        items.add(PowerUpItem.getPowerUpItem(520, 400, 50, 50, PowerUpItem.FLASH_POWERUP_ITEM));
        items.add(PowerUpItem.getPowerUpItem(620, 400, 50, 50, PowerUpItem.POWERUPBOX_POWERUP_ITEM));
        items.add(PowerUpItem.getPowerUpItem(720, 400, 50, 50, PowerUpItem.SNOWFLAKE_POWERUP_ITEM));
        items.add(PowerUpItem.getPowerUpItem(820, 400, 50, 50, PowerUpItem.TACTICALNUKE_POWERUP_ITEM));
//</editor-fold>

    }

    @Override
    public void initializeEnvironment() {
    }

    int moveDelay = 0;
    int moveDelayLimit = 0;
    int counter;

    @Override
    public void timerTaskHandler() {
        //<editor-fold defaultstate="collapsed" desc="move pacman">
        if (playerone != null) {
            if (moveDelay >= moveDelayLimit) {
                moveDelay = moveDelayLimit;
                playerone.move();
            } else {

                moveDelay++;
            }
        }
        //</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="Pacman animation">
        if (playerone != null) {
            if (playerone.isDead()) {
                playerone.setMouthWidth(width = 0);
            }
            if (width <= 0) {
                widthChange = +17;
            } else if (width >= 80) {
                widthChange = -17;
            }
            width = width + widthChange;
            playerone.setMouthWidth(width);

        }
        if (playerone != null) {
            playerone.setMouthWidth(width);
        }
//</editor-fold>
        
        
//        if (playerone != null) {
//            playerone.move();
//        }
//        
//        if (playerone.getHitBox(){
//            
//        } 
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//<editor-fold defaultstate="collapsed" desc="playerone controls">
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            playerone.setDirection(Direction.UP);
//            System.out.println("up");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            playerone.setDirection(Direction.DOWN);
//            System.out.println("down");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            playerone.setDirection(Direction.LEFT);
//            System.out.println("left");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            playerone.setDirection(Direction.RIGHT);
//            System.out.println("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            if (playerone.isDead()) {
                playerone = new Pacman(900, 450, 30, 30, MIN_X, MAX_X, MIN_Y, MAX_Y);
            }
        }
//</editor-fold>
        if (e.getKeyCode() == KeyEvent.VK_A) {
            paddleOne.setDirection(Direction.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            paddleOne.setDirection(Direction.DOWN);
        }
        //<editor-fold defaultstate="collapsed" desc="Sounds">
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            AudioPlayer.play("/pacpong/BOMB_SIREN-BOMB_SIREN-247265934.wav");
        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            AudioPlayer.play("/pacpong/Atomic_Bomb-Sound_Explorer-897730679.wav");
        }
//</editor-fold>

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {

//        graphics.setColor(Color.blue);
//        graphics.fillRect(130, 175, 60, 320);
//
//        graphics.setColor(Color.red);
//        graphics.fillRect(1710, 175, 60, 320);
//        graphics.setColor(new Color(89, 189, 255, 40));
//        graphics.fillRect(MIN_X, MIN_Y, MAX_X - MIN_X, MAX_Y - MIN_Y);
        if (coin != null) {
        }

        if (paddleOne != null) {
            paddleOne.draw(graphics);
        }

        if (paddleTwo != null) {
            paddleTwo.draw(graphics);
        }
        graphics.setColor(Color.magenta);
        graphics.drawRect(50, 150, 1800, 700);

        graphics.setColor(Color.yellow);
        graphics.drawRect(MIN_X, MIN_Y, MAX_X - MIN_X, MAX_Y - MIN_Y);

        if (grid != null) {
            grid.paintComponent(graphics);
        }

        if (playerone != null) {
            playerone.draw(graphics);
        }

//<editor-fold defaultstate="collapsed" desc="playerone hitbox">
        if (playerone.getHitBox() != null) {
//            graphics.drawRect(x, y, width, height);
//            graphics.drawRect(int x, int y, width, height);

        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="score">
        graphics.setColor(Color.blue);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 35));
        graphics.drawString("Score " + scoreone, 100, 100);

        graphics.setColor(Color.red);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 35));
        graphics.drawString("Score " + scoretwo, 1700, 100);
//</editor-fold>
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 35));
        graphics.drawString("Time: " + time, 850, 100);

        if (items != null) {
            for (Item item : items) {
                item.draw(graphics);
            }
        }

    }

//<editor-fold defaultstate="collapsed" desc="useless grid code">
//    @Override
//    public int getSystemCoordX(int x, int y) {
//        return grid.getCellSystemCoordinate(x, y).x;
//    }
//
//    @Override
//    public int getSystemCoordY(int x, int y) {
//        return grid.getCellSystemCoordinate(x, y).y;
//
//    }
//
//    @Override
//    public int getCellWidth() {
//        return grid.getCellWidth();
//    }
//
//    @Override
//    public int getCellHeight() {
//        return grid.getCellHeight();
//    }
//</editor-fold>
}
