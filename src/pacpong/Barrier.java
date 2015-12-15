/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import java.awt.Color;
import java.awt.Graphics;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author asus pc
 */
public class Barrier {

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fill3DRect(cellData.getSystemCoordX(x, y), cellData.getSystemCoordY(x, y), cellData.getCellWidth(), cellData.getCellHeight(), true);
    }

    public Barrier(int x, int y, Color color, CellDataProviderIntf cellData, boolean breakable) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.cellData = cellData;
    }

    private int x, y;
    private Color color; 
    
    private boolean breakable = false;
    private CellDataProviderIntf cellData;
}