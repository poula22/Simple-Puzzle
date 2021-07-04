/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepuzzle;

import java.awt.Image;
import java.awt.image.BufferedImage;



/**
 *
 * @author george
 */
public class PuzzleImage {
    private Image image;
    public PuzzleImage(BufferedImage image){
        this.image=image.getScaledInstance(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    public Image getImage(){
        return image;
    }
    
}
