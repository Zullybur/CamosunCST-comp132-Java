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
     * Method increases the amount of red in every pixel of this image by two.
     */
    public void increaseRed() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;

        // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray) {
            // get the red value of the current pixel
            value = pixelObj.getRed();
            // increase the red value by 200%
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
            // ****** decrease the red value by percentage ********
            value = (int) (value + (percentage * value));
            // set the red value of the current pixel
            pixelObj.setRed(value);
        }
    }
    
    /**
     * Method decreases the amount of green in every pixel of this image by half.
     */
    public void decreaseGreen() {
        Pixel[] pixelArray = this.getPixels();
        int value;
        int i = 0;
        Pixel pixelObj;

        // loop through all the pixels in the array
        while (i < pixelArray.length) {
            // get the green value of the current pixel
            pixelObj = pixelArray[i];
            value = pixelObj.getGreen();
            // decrease the green value by 50%
            value = value / 2;
            // set the green value of the current pixel to the new value
            pixelObj.setGreen(value);
            i++;
        }
    }

    /**
     * Method increases the amount of green in every pixel of this image by two.
     */
    public void increaseGreen() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        int i = 0;
        Pixel pixelObj;

        // loop through all the pixels in the array
        while (i < pixelArray.length) {
            // get the green value of the current pixel
            pixelObj = pixelArray[i];
            value = pixelObj.getGreen();
            // increase the green value by 200%
            value = value * 2;
            // set the green value of the current pixel to the new value
            pixelObj.setGreen(value);
            i++;
        }
    }

    /**
     * Method changes the amount of green in every pixel by a percentage
     *
     * @param percentage The percentage by which to decrease the green, expressed
     * as a number from 0-1.
     */
    public void changeGreen(double percentage) {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        int i = 0;
        Pixel pixelObj;

        // loop through all the pixels in the array
        while (i < pixelArray.length) {
            // get the green value of the current pixel
            pixelObj = pixelArray[i];
            value = pixelObj.getGreen();
            // ****** decrease the green value by percentage ********
            value = (int) (value + (percentage * value));
            // set the green value of the current pixel
            pixelObj.setGreen(value);
            i++;
        }
    }
    
    /**
     * Method decreases the amount of blue in every pixel of this image by half.
     */
    public void decreaseBlue() {
        Pixel[] pixelArray = this.getPixels();
        int value;
        Pixel pixelObj;

        // loop through all the pixels in the array
        for (int i = 0; i < pixelArray.length; i++) {
            // get the blue value of the current pixel
            pixelObj = pixelArray[i];
            value = pixelObj.getBlue();
            // decrease the blue value by 50%
            value = value / 2;
            // set the blue value of the current pixel to the new value
            pixelObj.setBlue(value);
        }
    }

    /**
     * Method increases the amount of blue in every pixel of this image by two.
     */
    public void increaseBlue() {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        Pixel pixelObj;

        // loop through all the pixels in the array
        for (int i = 0; i < pixelArray.length; i++) {
            // get the blue value of the current pixel
            pixelObj = pixelArray[i];
            value = pixelObj.getBlue();
            // increase the blue value by 200%
            value = value * 2;
            // set the blue value of the current pixel to the new value
            pixelObj.setBlue(value);
        }
    }

    /**
     * Method changes the amount of blue in every pixel by a percentage
     *
     * @param percentage The percentage by which to decrease the blue, expressed
     * as a number from 0-1.
     */
    public void changeBlue(double percentage) {
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
        Pixel pixelObj;

        // loop through all the pixels in the array
        for (int i = 0; i < pixelArray.length; i++) {
            // get the blue value of the current pixel
            pixelObj = pixelArray[i];
            value = pixelObj.getBlue();
            // ****** decrease the blue value by percentage ********
            value = (int) (value + (percentage * value));
            // set the blue value of the current pixel
            pixelObj.setBlue(value);
        }
    }
    
    /**
     * Method adjusts the rgb values of all pixels in the image by a percentage
     * provided by the user.
     * 
     * @param r The percentage to change each red pixel by
     * @param g The percentage to change each green pixel by
     * @param b The percentage to change each blue pixel by
     */
    public void changeColours(double r, double g, double b) {
        if (Math.abs(r) > 1 || Math.abs(g) > 1 || Math.abs(b) > 1) {
            System.out.println("Invalid parameter passed to changeColours");
            return;
        }
        Pixel[] pixelArray = this.getPixels();
        int value;
        
        // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray) {
            // get and alter the red value of the current pixel
            value = pixelObj.getRed();
            value = (int)(value * (r + 1));
            pixelObj.setRed(value);
            // get and alter the green value of the current pixel
            value = pixelObj.getGreen();
            value = (int)(value * (g + 1));
            pixelObj.setGreen(value);
            // get and alter the blue value of the current pixel
            value = pixelObj.getBlue();
            value = (int)(value * (b + 1));
            pixelObj.setBlue(value);
        }
    }

    /**
     * Accepts x, y coordinates and width, height parameters of a box within
     * the user's image, then converts all pixels to white
     * @param cX is the x coordinate where the box will start
     * @param cY is the y coordinate where the box will start
     * @param width how far to the right the box extends
     * @param height how far up the box extends
     */
    public void changeInnerSquare(int cX, int cY, int width, int height) {
        Pixel pixel;
        Color color = new Color(255, 255, 255);
        // Adjust to bottom-left coordinate system
        cY = this.getHeight() - cY;
        // Modify the pixels in the target area to pure white
        for (int j = cY; j > (cY - height); j--) {
            for (int i = cX; i < (cX + width); i++) {
                pixel = this.getPixel(i, j);
                pixel.setColor(color);
            }
        }
    }
} // end of class Picture, put all new methods before this

