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
public class FoodItem extends Item {

    public static final String BEER_FOOD_ITEM = "BEER";
    public static final String BURGER_FOOD_ITEM = "BURGER";
    public static final String CHICKEN_FOOD_ITEM = "CHICKEN";
    public static final String COKE_FOOD_ITEM = "COKE";
    public static final String MILKSHAKE_FOOD_ITEM = "MILKSHAKE";
    public static final String TACO_FOOD_ITEM = "TACO";
    public static final String WATERMELON_FOOD_ITEM = "WATERMELON";

    public static FoodItem getRandomFoodItem(int x, int y, int width, int height) {
        String type = BEER_FOOD_ITEM;
        double rand = Math.random();
        
        if (rand < .1) {
            type = BEER_FOOD_ITEM;
        } else if (rand < .2) {
            type = CHICKEN_FOOD_ITEM;
        } else if (rand < .3) {
            type = BURGER_FOOD_ITEM;
        } else if (rand < .3) {
            type = COKE_FOOD_ITEM;
        } else if (rand < .4) {
            type = MILKSHAKE_FOOD_ITEM;
        } else if (rand < .5) {
            type = TACO_FOOD_ITEM;
        } else if (rand < .6) {
            type = WATERMELON_FOOD_ITEM;
        }
        
        return getFoodItem(x, y, width, height, type);
    }
    
    public static FoodItem getFoodItem(int x, int y, int width, int height, String type) {
        Image image;
        if (type.equals(BEER_FOOD_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/beer.png");
        } else if (type.equals(BURGER_FOOD_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/burger.png");
        } else if (type.equals(CHICKEN_FOOD_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/chicken.png");
        } else if (type.equals(MILKSHAKE_FOOD_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/milkshake.png");
        } else if (type.equals(TACO_FOOD_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/taco.png");
        } else if (type.equals(WATERMELON_FOOD_ITEM)) {
            image = ResourceTools.loadImageFromResource("pacpong/watermelon.png");
        } else {
            image = ResourceTools.loadImageFromResource("pacpong/coke.png");
        }

        return new FoodItem(x, y, width, height, image, type);
    }

    public FoodItem(int x, int y, int width, int height, Image image, String type) {
        super(x, y, width, height, image, type);
    }

}
