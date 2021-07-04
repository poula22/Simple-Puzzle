/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepuzzle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author george
 */
public class PuzzleImageSplitter {
    private PuzzleImage puzzleImage;
    private ArrayList<Image> images=new ArrayList<>(8);
    public PuzzleImageSplitter(PuzzleImage puzzleImage){
        this.puzzleImage=puzzleImage;
    }
    public ArrayList<Image> imageSplit(){
        Image img=puzzleImage.getImage();
        BufferedImage[] bf=getImages(img, 1, 3);
        BufferedImage[] bf0=getImages(bf[0], 3, 1);
        BufferedImage[] bf1=getImages(bf[1], 3, 1);
        BufferedImage[] bf2=getImages(bf[2], 3, 1);
        images.add(bf2[0].getScaledInstance(145, 95, BufferedImage.TYPE_INT_RGB));        
        images.add(bf2[1].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));        
        images.add(bf1[0].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));        
        images.add(bf0[0].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));       
        images.add(bf1[1].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));        
        images.add(bf0[1].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));       
        images.add(bf0[2].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));       
        images.add(bf1[2].getScaledInstance(148, 98, BufferedImage.TYPE_INT_RGB));
        Collections.shuffle(images);
        return images;

    }
    
    public static  BufferedImage[] getImages(Image img, int rows, int column) {
        BufferedImage[] splittedImages = new BufferedImage[rows * column];
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        int width = bi.getWidth();
        int height = bi.getHeight();
        int pos = 0;
        int swidth = width / column;
        int sheight = height / rows;
 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                BufferedImage bimg = bi.getSubimage(j * swidth, i * sheight, swidth, sheight);
                splittedImages[pos] = bimg;
                pos++;
            }
        }
 
        return splittedImages;
    }
    
}
