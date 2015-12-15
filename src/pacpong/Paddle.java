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

    public Paddle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fill3DRect(x, y, width, height, true);
    }

    int speed = 4;

    public void move() {
        if (getDirection() == Direction.DOWN) {
            y += speed;
        } else if (getDirection() == Direction.UP) {
            y -= speed;
        }
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;
    private int width;
    private int height;
    
    private Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
//</editor-fold>
}
