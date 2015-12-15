/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacpong;

import environment.ApplicationStarter;
import java.awt.Dimension;

/**
 *
 * @author asus pc
 */
public class PacPong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ApplicationStarter.run("PacPong Run", new Arena());
        ApplicationStarter.run(new String[0], "PacPong", new Dimension(1920, 1000), new Arena());
        
        
        
    }

}
