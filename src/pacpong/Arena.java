/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//todo
//fix screen**
//get paddles moving and respect boundaries**
//  change pacman mouth direction**
//get ball moving
//        -bounce off paddles using trig class**
//        -collide with pacman to kill him**     
//        -pacman moves faster moving left and up
// "raindrop class" code for items and powerups
//            -how to randomize and trigger powerups,hitbox?
//            -how to make custom colors
//            -how to make ice effect on screen
//            -effects of powerups (can be reduced if needed for time)
//            -nuke ends game
//              -randomize angles for ball when bouncing off edges
//game over/start screen
//          -restart game
//          -maybe start and loading screen
//        
package pacpong;

import audio.AudioPlayer;
import environment.Environment;
import environment.Velocity;
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
    private Ball ball;

    private int width = 80;
    private int widthChange = -1;

    private static final int MIN_X = 400;
    private static final int MAX_X = 1500;
    private static final int MIN_Y = 150;
    private static final int MAX_Y = 850;

    private static final int BOUNDARY_TOP = 100;
    private static final int BOUNDARY_LEFT = 50;
    private static final int BOUNDARY_HEIGHT = 650;
    private static final int BOUNDARY_WIDTH = 1450;

    private static final int PADDLE_REGION_WIDTH = 125;

    public Arena() {
        this.setBackground(Color.black);
//        this.setBackground(ResourceTools.loadImageFromResource(TOOL_TIP_TEXT_KEY))

        paddleOne = new Paddle(BOUNDARY_LEFT + (PADDLE_REGION_WIDTH / 2), BOUNDARY_HEIGHT / 4, PADDLE_REGION_WIDTH / 4, BOUNDARY_HEIGHT / 8, Color.BLUE, BOUNDARY_TOP, BOUNDARY_TOP + BOUNDARY_HEIGHT);
        paddleTwo = new Paddle(BOUNDARY_LEFT + BOUNDARY_WIDTH - (PADDLE_REGION_WIDTH * 3 / 4), BOUNDARY_HEIGHT / 4, PADDLE_REGION_WIDTH / 4, BOUNDARY_HEIGHT / 8, Color.RED, BOUNDARY_TOP, BOUNDARY_TOP + BOUNDARY_HEIGHT);
        playerone = new Pacman(Direction.RIGHT);

//        paddleOne = new Paddle(Direction.DOWN);
        playerone = getPacman();
        ball = new Ball(BOUNDARY_LEFT + PADDLE_REGION_WIDTH, BOUNDARY_TOP + (BOUNDARY_HEIGHT / 2), 35, BOUNDARY_LEFT + PADDLE_REGION_WIDTH, BOUNDARY_LEFT + BOUNDARY_WIDTH - PADDLE_REGION_WIDTH, BOUNDARY_TOP, BOUNDARY_TOP + BOUNDARY_HEIGHT);

       

//<editor-fold defaultstate="collapsed" desc="items">
//        items = new ArrayList<>();
//        items.add(FoodItem.getRandomFoodItem(420, 175, 50, 50));
//        items.add(FoodItem.getRandomFoodItem(520, 175, 50, 50));
//        items.add(FoodItem.getRandomFoodItem(620, 175, 50, 50));
//        
//        items.add(FoodItem.getFoodItem(420, 250, 50, 50, FoodItem.BEER_FOOD_ITEM));
//        items.add(FoodItem.getFoodItem(520, 250, 50, 50, FoodItem.BURGER_FOOD_ITEM));
//        items.add(FoodItem.getFoodItem(620, 250, 50, 50, FoodItem.CHICKEN_FOOD_ITEM));
//        items.add(FoodItem.getFoodItem(720, 250, 50, 50, FoodItem.COKE_FOOD_ITEM));
//        
//        items.add(PowerUpItem.getRandomPowerUpItem(420, 325, 50, 50));
//        items.add(PowerUpItem.getRandomPowerUpItem(520, 325, 50, 50));
//        items.add(PowerUpItem.getRandomPowerUpItem(620, 325, 50, 50));
//        items.add(PowerUpItem.getRandomPowerUpItem(720, 325, 50, 50));
//        
//        items.add(PowerUpItem.getPowerUpItem(420, 400, 50, 50, PowerUpItem.COIN_POWERUP_ITEM));
//        items.add(PowerUpItem.getPowerUpItem(520, 400, 50, 50, PowerUpItem.FLASH_POWERUP_ITEM));
//        items.add(PowerUpItem.getPowerUpItem(620, 400, 50, 50, PowerUpItem.POWERUPBOX_POWERUP_ITEM));
//        items.add(PowerUpItem.getPowerUpItem(720, 400, 50, 50, PowerUpItem.SNOWFLAKE_POWERUP_ITEM));
//        items.add(PowerUpItem.getPowerUpItem(820, 400, 50, 50, PowerUpItem.TACTICALNUKE_POWERUP_ITEM));
//</editor-fold>

    }

    private Pacman getPacman() {
        return new Pacman(BOUNDARY_LEFT + (BOUNDARY_WIDTH / 2), BOUNDARY_TOP + (BOUNDARY_HEIGHT / 2), 30, 30, BOUNDARY_LEFT + PADDLE_REGION_WIDTH, BOUNDARY_LEFT + BOUNDARY_WIDTH - PADDLE_REGION_WIDTH, BOUNDARY_TOP, BOUNDARY_TOP + BOUNDARY_HEIGHT);
    }

    @Override
    public void initializeEnvironment() {
    }

    int moveDelayPlayerOne = 0;
    int moveDelayPaddle01 = 0;
    int moveDelayPaddle02 = 0;
    int moveDelayLimit = 1;

    int counter;

    @Override
    public void timerTaskHandler() {
//<editor-fold defaultstate="collapsed" desc="move pacman">
        if (playerone != null) {
            if (moveDelayPlayerOne >= moveDelayLimit) {
                moveDelayPlayerOne = moveDelayLimit;
                playerone.move();
            } else {

                moveDelayPlayerOne++;
            }
        }
        //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="move paddleOne">
        if (paddleOne != null) {
            if (moveDelayPaddle01 >= moveDelayLimit) {
                moveDelayPaddle01 = 0;
                paddleOne.move();
            } else {
                moveDelayPaddle01++;
            }
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="move paddleTwo">
        if (paddleTwo != null) {
            if (moveDelayPaddle02 >= moveDelayLimit) {
                moveDelayPaddle02 = 0;
                paddleTwo.move();
            } else {
                moveDelayPaddle02++;
            }
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Pacman animation">
        if (playerone != null) {
            if (playerone.isDead()) {
                playerone.setMouthWidth(width = 45);
            } else {
                if (width <= 0) {
                    widthChange = +17;
                } else if (width >= 80) {
                    widthChange = -17;
                }

                width = width + widthChange;
                playerone.setMouthWidth(width);
            }

        }
//        if (playerone != null) {
//            playerone.setMouthWidth(width);
//        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ball bounce">
        if (ball != null) {
            ball.move();

            if (ball.getHitBox().intersects(paddleOne.getHitBox())) {
                ball.getVelocity().x *= -1;
                ball.setX(paddleOne.getRightX());
                ball.getVelocity().x++;
            }

            if (ball.getHitBox().intersects(paddleTwo.getHitBox())) {
                ball.getVelocity().x *= -1;
                ball.setX(paddleTwo.getLeftX() - ball.getWidth());
                ball.getVelocity().x++;
            }

            if (ball.getX() <= BOUNDARY_LEFT) {
                scoretwo++;
                ball.setX(BOUNDARY_LEFT + BOUNDARY_WIDTH - PADDLE_REGION_WIDTH - ball.getWidth());
                ball.setY(BOUNDARY_TOP + (BOUNDARY_HEIGHT / 2));
                ball.setVelocity(new Velocity(-10, -7));
            } else if (ball.getX() >= BOUNDARY_LEFT + BOUNDARY_WIDTH - ball.getWidth()) {
                scoreone++;
                ball.setX(BOUNDARY_LEFT + PADDLE_REGION_WIDTH);
                ball.setY(BOUNDARY_TOP + (BOUNDARY_HEIGHT / 2));
                ball.setVelocity(new Velocity(10, -3));
            }
            
            if (ball.getHitBox().intersects(playerone.getHitBox())){
                playerone.kill();
            }
        }

//</editor-fold>
    }

    private void checkIntersection() {
        if (items != null) {
            for (Item item : items) {
                if (item.getHitBox().intersects(playerone.getHitBox())) {

                }
            }
        }
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
                playerone = getPacman();
            }
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="paddle controls">
        if (e.getKeyCode() == KeyEvent.VK_A) {
            paddleOne.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_Z) {
            paddleOne.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            paddleTwo.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            paddleTwo.setDirection(Direction.DOWN);
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Sounds">
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            AudioPlayer.play("/pacpong/bomb_siren.wav");
//        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            AudioPlayer.play("/pacpong/Atomic_Bomb-Sound_Explorer-897730679.wav");
        }
//</editor-fold>

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            ball.setVelocity(new Velocity(10, 8));
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
//<editor-fold defaultstate="collapsed" desc="draw players">

        if (playerone != null) {
            playerone.draw(graphics);
        }
        if (ball != null) {
            ball.draw(graphics);
        }

        if (paddleOne != null) {
            paddleOne.draw(graphics);
        }

        if (paddleTwo != null) {
            paddleTwo.draw(graphics);
        }
//</editor-fold>

        //draw playing surface
//<editor-fold defaultstate="collapsed" desc="arena boundaries">
        graphics.setColor(Color.magenta);
        graphics.drawRect(BOUNDARY_LEFT, BOUNDARY_TOP, BOUNDARY_WIDTH, BOUNDARY_HEIGHT);

        graphics.setColor(Color.yellow);
        graphics.drawRect(BOUNDARY_LEFT + PADDLE_REGION_WIDTH, BOUNDARY_TOP, BOUNDARY_WIDTH - (2 * PADDLE_REGION_WIDTH), BOUNDARY_HEIGHT);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="playerone hitbox">
        if (playerone.getHitBox() != null) {
//            graphics.drawRect(x, y, width, height);
//            graphics.drawRect(int x, int y, width, height);

        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="score">
        graphics.setColor(Color.blue);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 35));
        graphics.drawString("Score " + scoreone, BOUNDARY_LEFT, 90);

        graphics.setColor(Color.red);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 35));
        graphics.drawString("Score " + scoretwo, BOUNDARY_LEFT + BOUNDARY_WIDTH - PADDLE_REGION_WIDTH, 90);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="timer">
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 35));
        graphics.drawString("Time: " + time, BOUNDARY_LEFT + (BOUNDARY_WIDTH / 2), 90);
//</editor-fold>
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
//    if (grid != null) {
//            grid.paintComponent(graphics);
//        }
//</editor-fold>
}
