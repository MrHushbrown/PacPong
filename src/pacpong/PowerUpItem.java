/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import images.ResourceTools;
import java.awt.Image;

/**
 *
 * @author asus pc
 */
public class PowerUpItem extends Item {

    public static final String COIN_POWERUP_ITEM = "COIN"; 
    public static final String FLASH_POWERUP_ITEM = "FLASH";
    public static final String POWERUPBOX_POWERUP_ITEM = "POWERUPBOX"; 
    public static final String SNOWFLAKE_POWERUP_ITEM = "SNOWFLAKE"; 
    public static final String TACTICALNUKE_POWERUP_ITEM = "TACTICALNUKE"; 

    public PowerUpItem(int x, int y, int width, int height, Image image, String type) {
        super(x, y, width, height, image, type);
    }
    
    public static PowerUpItem getRandomPowerUpItem(int x, int y, int width, int height) {
        String type = COIN_POWERUP_ITEM;
        double rand = Math.random();
        
        if (rand < .1) {
            type = FLASH_POWERUP_ITEM;
        } else if (rand < .2) {
            type = POWERUPBOX_POWERUP_ITEM;
        } else if (rand < .3) {
            type = SNOWFLAKE_POWERUP_ITEM;
        } else if (rand < .4) {
            type = TACTICALNUKE_POWERUP_ITEM;
        }
        
        return getPowerUpItem(x, y, width, height, type);
    }
    
    public static PowerUpItem getPowerUpItem(int x, int y, int width, int height, String type) {
        Image image;
        if (type.equals(COIN_POWERUP_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/coin.png");
        } else if (type.equals(FLASH_POWERUP_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/flashII.png");
        } else if (type.equals(POWERUPBOX_POWERUP_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/powerupbox.png");
        } else if (type.equals(SNOWFLAKE_POWERUP_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/snowflake.png");
        } else if (type.equals(TACTICALNUKE_POWERUP_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/tacticalnukeII.png");
        } else {
            image = ResourceTools.loadImageFromResource("pacpong/coin.png");
        }

        return new PowerUpItem(x, y, width, height, image, type);
    }

    
    
                                            
}
