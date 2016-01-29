/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author asus pc
 */
public class Pacman {

    public Pacman(Direction direction) {
        this.direction = direction;

    }

    //<editor-fold defaultstate="collapsed" desc="properties">
    private Direction direction = Direction.RIGHT;
    private ArrayList<Point> body;
    private Color BodyColor = Color.GREEN;
    private int mouthWidth;

    private int x, y;
    private int minX, maxX;
    private int minY, maxY;
    private int width, height;
    private int startAngle;
    private int arcAngle;

    private int health = 100;

    private Color color;
//</editor-fold>

//    draw pacman
    public Pacman(int x, int y, int width, int height, int minX, int maxX, int minY, int maxY) {
        this.x = x;
        this.y = y;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;

        this.width = width;
        this.height = height;

        mouthWidth = 80;
        color = Color.YELLOW;
    }
    public void draw(Graphics graphics) {

//        start drawing here
        int baseAngle = 0;
        if (direction == Direction.RIGHT) {
            baseAngle = 0;
        } else if (direction == Direction.UP) {
            baseAngle = 90;
        } else if (direction == Direction.LEFT) {
            baseAngle = 180;
        } else if (direction == Direction.DOWN) {
            baseAngle = 270;
        } 
        
        
        graphics.setColor(color);
        graphics.fillArc(x, y, width, height, baseAngle + (mouthWidth / 2), 360 - (mouthWidth));
        
        graphics.setColor(color.MAGENTA);
        graphics.drawRect(getHitBox().x, getHitBox().y, getHitBox().width, getHitBox().height);

//        graphics.setColor(Color.red);
//        graphics.drawRect(getHitBox().x, getHitBox().y, getHitBox().width, getHitBox().height);
    }

    double speed = 11.25;

//<editor-fold defaultstate="collapsed" desc="movement">
    public void move() {
        
        if (isAlive()) {
            if (getDirection() == Direction.LEFT) {
                x -= speed;
            } else if (getDirection() == Direction.RIGHT) {
                x += speed;
            } else if (getDirection() == Direction.DOWN) {
                y += speed;
            } else if (getDirection() == Direction.UP) {
                y -= speed;
            }
            
            if (x < minX) {
                x = minX;
                kill();
            } else if (x > maxX - width) {
                x = maxX - width;
                kill();}
            if (y < minY) {
                y = minY;
                kill();
            }
            if (y > maxY - 27) {
                y = maxY - 27;
                kill();
            }
        }
        
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="hitbox">
    public Rectangle getHitBox() {
        return new Rectangle(x + (width / 4), y + (height / 4), width / 2, height / 2);
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="getters n setters">
    public int getMouthWidth() {
        return mouthWidth;
    }
    
    /**
     * @param mouthWidth the mouthWidth to set
     */
    public void setMouthWidth(int mouthWidth) {
        this.mouthWidth = mouthWidth;
    }
    
    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }
    
    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    /**
     * @param BodyColor the BodyColor to set
     */
    public void setBodyColor(Color BodyColor) {
        this.BodyColor = BodyColor;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="health">
    public int getHealth() {
        return health;
    }
    
     public void kill() {
        this.health = 0;
        color = Color.GRAY;
    }

    public void setHealth(int Health) {
        this.health = Health;
    }
    
    public void addHealth(int health) {
        this.health += health;
    }
    
    public boolean isAlive() {
        return (health > 0);
    }
    
    public boolean isDead() {
        return (health <= 0);
    }
//</editor-fold>
    
}
