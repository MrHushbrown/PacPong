/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author asus pc
 */


public class Ball {
    //<editor-fold defaultstate="collapsed" desc="properties">
    
    private int x, y;
    private int width, height;
    private int minX, maxX;
    private int minY, maxY;
//</editor-fold>
    
    public Ball (int x, int y, int width, int height, int minX, int maxX, int minY, int maxY) {
        this.x = x; 
        this.y = y;
        this.width = width;
        this.height = height;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        
    }
    
    public void draw (Graphics graphics) {
        graphics.setColor(Color.magenta);
        graphics.fillOval(400, 400, 10, 10);
        
    }
    
    int speed = 15;
    
    public void move () {
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
    
  
}
