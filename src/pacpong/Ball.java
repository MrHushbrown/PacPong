/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import environment.Velocity;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author asus pc
 */


public class Ball {
    public Ball (int x, int y, int radius, int minX, int maxX, int minY, int maxY) {
        this.x = x; 
        this.y = y;
        this.width = radius;
        this.height = radius;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        velocity = new Velocity(0, 0);
    }
    
    
    public void draw (Graphics graphics) {
        graphics.setColor(Color.magenta);
        graphics.fillOval(getX(), getY(), width, height);
    }
    
    private int speed = 15;
    
    public void move () {
        x += velocity.x;
        y += velocity.y;
        
        if (y <= minY) {
            y = minY;
            velocity.y *= -1;
        }
        if (y + height >= maxY) {
            y = maxY - height;
            velocity.y *= -1;
        }


//        if (x < minX) {
//                x = minX;
//                kill();
//            } else if (x > maxX) {
//                x = maxX - 27;
//                kill();}
//                if (y < minY) {
//                    y = minY;
//                    kill();
//                }
//                if (y > maxY) {
//                    y = maxY;
//                    kill();
//                }

    }
    
  
//<editor-fold defaultstate="collapsed" desc="properties">
    
    private int x, y;
    private int width, height;
    private int minX, maxX;
    private int minY, maxY;
    private Velocity velocity; 

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the x
     */
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

    /**
     * @return the velocity
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
//</editor-fold>
    
}
