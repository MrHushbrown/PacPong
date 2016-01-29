/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author asus pc
 */
public class Paddle {
    
    public Paddle(Direction direction) {
        this.direction = direction;
    }
    
    private Direction direction = Direction.RIGHT;
    private Color color = Color.BLUE;
    
    public Paddle(int x, int y, int width, int height, Color color, int minY, int maxY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.minY = minY;
        this.maxY = maxY;
        
    }
    
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fill3DRect(getX(), getY(), width, height, true);
    }
    
    int speed = 12;

//<editor-fold defaultstate="collapsed" desc="movement">
    public void move() {
        if (getDirection() == Direction.DOWN) {
            setY(getY() + speed);
        } else if (getDirection() == Direction.UP) {
            setY(getY() - speed);
        }
        if (getY() < minY) {
            setY(minY);
        } else if (getY() + height > maxY) {
            setY(maxY - height);
        }
    }

    public void stop() {
        this.speed = 0;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="health">
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int Health) {
        this.health = Health;
    }
    
    public boolean isAlive() {
        return (health > 0);
    }
    
    public boolean isDead() {
        return (health <= 0);
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;
    private int width;
    private int height;
    private int health;
    private int minY;
    private int maxY;
    
    private Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="getters n setters">

    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public int getLeftX() {
        return x;
    }
    
    public int getRightX() {
        return x + width;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="hitbox">

    public Rectangle getHitBox() {
        return new Rectangle(getX(), getY(), width, height);
    }
//</editor-fold>
}
