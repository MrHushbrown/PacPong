/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import java.awt.Image;

/**
 *
 * @author asus pc
 */
public class PowerUp extends Item {

    public static final String COIN_POWERUP_ITEM = "COIN"; 
    public static final String FLASH_POWERUP_ITEM = "FLASH";
    public static final String POWERUPBOX_POWERUP_ITEM = "POWERUPBOX"; 
    public static final String SNOWFLAKE_POWERUP_ITEM = "SNOWFLAKE"; 
    public static final String TACTICALNUKE_POWERUP_ITEM = "TACTICALNUKE"; 

    public PowerUp(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }
    
    
                                            
}
