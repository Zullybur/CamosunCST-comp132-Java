package media;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param width the width of the desired picture
     * @param height the height of the desired picture
     */
    public Picture(int width, int height) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method decreases the amount of red in every pixel of this image by half.
     */
    public void decreaseRed() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray) {
            // get the red value of the current pixel
            value = pixelObj.getRed();
            // decrease the red value by 50%
            value = value / 2;
            // set the red value of the current pixel to the new value
            pixelObj.setRed(value);
        }
    }

    /**
     * Method increases the amount of red in every pixel of this image by half.
     */
    public void increaseRed() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray) {
            // get the red value of the current pixel
            value = pixelObj.getRed();
            // decrease the red value by 50%
            value = value * 2;
            // set the red value of the current pixel to the new value
            pixelObj.setRed(value);
        }
    }

    /**
     * Method changes the amount of red in every pixel by a percentage
     *
     * @param percentage The percentage by which to decrease the red, expressed
     * as a number from 0-1.
     */
    public void changeRed(double percentage) {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray) {
            // get the red value of the current pixel
            value = pixelObj.getRed();
            // ****** decrease the red value by 30% ********
            value = (int) (value + (percentage * value));
            // set the red value of the current pixel
            pixelObj.setRed(value);
        }
    }

    /**
     * Method decreases the amount of green in every pixel of this image by
     * half.
     */
    public void decreaseGreen() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        int count = 0;

        // loop through all the pixels in the array
        while (count < pixelArray.length) {
            value = pixelArray[count].getGreen();
            value = value / 2;
            pixelArray[count].setGreen(value);
            count++;
        }
    }

    /**
     * Method increases the amount of green in every pixel of this image by
     * half.
     */
    public void increaseGreen() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        int count = 0;

        while (count < pixelArray.length) {
            value = pixelArray[count].getGreen();
            value = value * 2;
            pixelArray[count].setGreen(value);
            count++;
        }
    }

    /**
     * Method changes the amount of green in every pixel by a percentage
     *
     * @param percentage The percentage by which to decrease the green,
     * expressed as a number from 0-1.
     */
    public void changeGreen(double percentage) {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        int count = 0;

        while (count < pixelArray.length) {
            value = pixelArray[count].getGreen();
            value = (int) (value + (percentage * value));
            pixelArray[count].setGreen(value);
            count++;
        }
    }

    /**
     * Method decreases the amount of Blue in every pixel of this image by half.
     */
    public void decreaseBlue() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        // loop through all the pixels in the array
        for (int count = 0; count < pixelArray.length; count++) {
            value = pixelArray[count].getBlue();
            value = value / 2;
            pixelArray[count].setBlue(value);
        }
    }

    /**
     * Method increases the amount of Blue in every pixel of this image by half.
     */
    public void increaseBlue() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        for (int count = 0; count < pixelArray.length; count++) {
            value = pixelArray[count].getBlue();
            value = value * 2;
            pixelArray[count].setBlue(value);
        }
    }

    /**
     * Method changes the amount of BlueBlue in every pixel by a percentage
     *
     * @param percentage The percentage by which to decrease the green,
     * expressed as a number from 0-1.
     */
    public void changeBlue(double percentage) {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        for (int count = 0; count < pixelArray.length; count++) {
            value = pixelArray[count].getBlue();
            value = (int) (value + (percentage * value));
            pixelArray[count].setBlue(value);
        }
    }

    public void changeColours(double r, double g, double b) {

        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray) {
            // get the red value of the current pixel
            value = pixelObj.getRed();
            value = (int) (value + (r * value));
            pixelObj.setRed(value);

            // get the green value of the current pixel
            value = pixelObj.getGreen();
            value = (int) (value + (g * value));
            pixelObj.setGreen(value);

            // get the blue value of the current pixel
            value = pixelObj.getBlue();
            value = (int) (value + (b * value));
            pixelObj.setBlue(value);
        }

    }

    /**
     * copyPicture copies the source picture into this picture (the target)
     *
     * @param Picture source the picture to copy from
     */
    public void copyPicture(Picture sourcePicture) {
        Pixel sourcePixel, targetPixel;

        //loop through both pictures simultaenously
        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) {
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++) {
                //get the source pixel from the source image
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                //get the target pixel from the target image (this)
                targetPixel = this.getPixel(targetX, targetY);
                //set the color of the target pixel to the 
                // color of the source pixel
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }

    public void copyPictureOffset(Picture sourcePicture) {
        Pixel sourcePixel, targetPixel;
        int startX = 100, startY = 100;

        //loop through both pictures simultaenously
        for (int sourceX = 0, targetX = startX; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) {
            for (int sourceY = 0, targetY = startY; sourceY < sourcePicture.getHeight(); sourceY++, targetY++) {
                //get the source pixel from the source image
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                //get the target pixel from the target image (this)
                targetPixel = this.getPixel(targetX, targetY);
                //set the color of the target pixel to the 
                // color of the source pixel
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }
    /**
     * Flip a give source picture horizontally and output to a target frame.
     * @param source is the picture to be flipped
     */
    public void flipHorizontal(Picture source) {
        Pixel sourcePixel, targetPixel;
        int startY = source.getHeight()-1;
        
        for(int sy = 0, ty = startY; sy < source.getHeight() && ty >=0; sy++, ty--){
//            System.out.println("sy: " + sy + " ty: " + ty);
            for(int sx = 0, tx = 0; sx < source.getWidth() && tx < this.getWidth(); sx++, tx++){
//                System.out.println("sx: " + sx + " tx: " + tx);
//                System.out.println("Get Source");
                sourcePixel = source.getPixel(sx, sy);
//                System.out.println("Get Target");
                targetPixel = this.getPixel(tx, ty);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }
    /**
     * Pixelate the image.
     */
    public void pixellate() {
        int arrayLoc, red, green, blue, i, j;
        int pixelation = 5;
        int square = pixelation * pixelation;
        Pixel[] pixelSet = new Pixel[square];
        
        for (int cY = 0; cY < this.getHeight(); cY+=pixelation) {
            for (int cX = 0; cX < this.getWidth(); cX+=pixelation) {
                arrayLoc = red = green = blue = 0;
                // Get colours from pixels in a block
                for (i = 0; i < pixelation; i++) {
                    for (j = 0; j < pixelation; j++, arrayLoc++) {
                        pixelSet[arrayLoc] = this.getPixel(cX + i, cY + j);
                        red += pixelSet[arrayLoc].getRed();
                        green += pixelSet[arrayLoc].getGreen();
                        blue += pixelSet[arrayLoc].getBlue();
                    }
                }
                // Set all pixels in the block to the avg for each colour
                arrayLoc = 0;
                red /= square;
                green /= square;
                blue /= square;
                for (i = 0; i < pixelation; i++) {
                    for (j = 0; j < pixelation; j++, arrayLoc++) {
                        pixelSet[arrayLoc] = this.getPixel(cX + i, cY + j);
                        pixelSet[arrayLoc].setRed(red);
                        pixelSet[arrayLoc].setGreen(green);
                        pixelSet[arrayLoc].setBlue(blue);
                    }
                }
                // Prevent x overflow
                if (cX + pixelation < this.getWidth() && cX + (pixelation * 2) > this.getWidth()) {
                    cX = this.getWidth() - (pixelation * 2);
                }
            }
            // Prevent y overflow
            if (cY + pixelation < this.getHeight() && cY + (pixelation * 2) > this.getHeight()) {
                cY = this.getHeight() - (pixelation * 2);
            }
        }
    }
    /**
     * Skew pixels to the right by a given amount, increasing by double the
     * original skew amount every 'num' rows. Wrap pixels around image.
     * 
     * @param source original picture to use for conversion
     */
    public void offsetPixels(Picture source) {
        Picture tmp = new Picture(source);
        int shift = 0, split = 10;
        int offset = this.getWidth() / split;
        int incShift = this.getHeight() / split;
        Pixel tmpPix, origPix;
        // Iterate through all pixels and copy from tmp to original
        for (int cY = 0; cY < this.getHeight(); cY++) {
            // Shift the offset every 'increment' rows
            shift += (cY > 0 && cY % incShift == 0) ? offset : 0;
            for (int cX = 0; cX < this.getWidth(); cX++) {
                tmpPix = tmp.getPixel(cX, cY);
                // Wrap pixels if over the canvas edge
                if (cX + shift >= this.getWidth()) {
                    origPix = this.getPixel(cX + shift - this.getWidth(), cY);
                } else {
                    origPix = this.getPixel(cX + shift, cY);
                }
                origPix.setColor(tmpPix.getColor());
            }
        }
    }
    /**
     * Create a mirrored effect on a supplied image at the given horizontal
     * line on the picture.
     * 
     * @param source is the picture to work from
     * @param num is the horizontal line on which to mirror
     */
    public void mirrorHorizontal(Picture source, int num) {
        Pixel src, tgt;
        System.out.println("This: "+this.getWidth()+", Source: "+source.getWidth());
        for (int i = 0; i < this.getWidth(); i++) {
            for (int k = 0; num + k < this.getHeight() && k < num; k++) {
                tgt = this.getPixel(i, num + k);
                src = source.getPixel(i, num - k);
                tgt.setColor(src.getColor());
            }
        }
    }
    
   public void makeCollage(Picture[] pics) {
       
   }
} // end of class Picture, put all new methods before this

