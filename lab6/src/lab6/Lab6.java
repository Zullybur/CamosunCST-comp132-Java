
package lab6;
import media.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


/**
 * Given a selected picture file, make changes to the colour properties in 
 * the file, show the changes, and check that the change was made properly.
 * 
 * @author MattCasiro
 */
public class Lab6 {
    private static final double INCREASE = 1.0;
    private static final double DECREASE = -0.5;
    private static final double CHECK_PERCENT = 0.005;

    /**
     * Main method runs program
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Picture pic = new Picture (FileChooser.pickAFile());
        pic.show();
        Picture pic2 = new Picture (pic);
        
        // Halve, double, and manually adjust red colour values of every pixel
        userContinue();
        pic.decreaseRed();
        pic.repaint();
        System.out.println("Decreased red.");
        testChange(pic2, pic, DECREASE, 0, 0);
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.increaseRed();
        pic.repaint();
        System.out.println("Increased red.");
        testChange(pic2, pic, INCREASE, 0, 0);
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.changeRed(0.75);
        pic.repaint();
        System.out.println("Changed red.");
        testChange(pic2, pic, 0.75, 0, 0);
        // Halve, double, and manually adjust green colour values of every pixel
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.decreaseGreen();
        pic.repaint();
        System.out.println("Decreased green.");
        testChange(pic2, pic, 0, DECREASE, 0);
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.increaseGreen();
        pic.repaint();
        System.out.println("Increased green.");
        testChange(pic2, pic, 0, INCREASE, 0);
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.changeGreen(-0.25);
        pic.repaint();
        System.out.println("Changed green.");
        testChange(pic2, pic, 0, -0.25, 0);
        // Halve, double, and manually adjust blue colour values of every pixel
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.decreaseBlue();
        pic.repaint();
        System.out.println("Decreased blue.");
        testChange(pic2, pic, 0, 0, DECREASE);
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.increaseBlue();
        pic.repaint();
        System.out.println("Increase blue.");
        testChange(pic2, pic, 0, 0, INCREASE);
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.changeBlue(0.10);
        pic.repaint();
        System.out.println("Changed blue.");
        testChange(pic2, pic, 0, 0, 0.10);
        // Manually adjust all colour values of every pixel
        userContinue();
        System.out.println("Resetting picture...");
        pic.hide();
        pic = new Picture (pic2);
        pic.changeColours(0.15, -0.15, 0.15);
        pic.repaint();
        System.out.println("Changed all.");
        testChange(pic2, pic, 0.15, -0.15, 0.15);
    }

    /**
     * Prompt user to hit return to continue program.
     */
    private static void userContinue() {
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Press enter to continue:");
        input = scan.nextLine();
    }
    
    /**
     * Given two picture objects, and the RGB % adjustments expected between them,
     * evaluate a random set of pixels to determine if the change occurred accurately
     * 
     * @param original picture unaltered for comparison
     * @param altered picture to compare against original
     * @param r percentage change of red colour values (-1 to +1)
     * @param g percentage change of green colour values (-1 to +1)
     * @param b percentage change of blue colour values (-1 to +1)
     */
    private static void testChange(Picture original, Picture altered, 
            double r, double g, double b) {
        r += 1; g += 1; b += 1;
        Pixel[] origiPixs = original.getPixels();
        Pixel[] alterPixs = altered.getPixels();
        List<Integer> checkPixs = new ArrayList<>();
        int errors;
        int checkVal;
        int maxChecks = (int)(origiPixs.length * CHECK_PERCENT);
        
        // Randomly select index values of maxChecks pixels 
        for (int i = 0; i < maxChecks; i++) {
            checkPixs.add((int)(Math.random() * origiPixs.length));
        }
        System.out.println("Checking: " + checkPixs.size() + " pixels...");
        
        // If red changed, check maxChecks pixels to verify accurate change
        if (r != 1) {
            errors = 0;
            for (int i = 0; i < maxChecks; i++) {
                checkVal = getCheckVal(origiPixs[checkPixs.get(i)], r, "red");
                
                if (checkVal != alterPixs[checkPixs.get(i)].getRed()) {
                    errors++;
                }
            }
            if (errors == 0) {
                System.out.println("No errors in red pixel values.");
            } else {
                System.out.println("Found " + errors + " errors in red pixel values.");
            }
        }
        
        // If green changed, check maxChecks pixels to verify accurate change
        if (g != 1) {
            errors = 0;
            for (int i = 0; i < maxChecks; i++) {
                checkVal = getCheckVal(origiPixs[checkPixs.get(i)], g, "green");
                
                if (checkVal != alterPixs[checkPixs.get(i)].getGreen()) {
                    errors++;
                }
            }
            if (errors == 0) {
                System.out.println("No errors in green pixel values.");
            } else {
                System.out.println("Found " + errors + " errors in green pixel values.");
            }
        }
        
        // If blue changed, check maxChecks pixels to verify accurate change
        if (b != 1) {
            errors = 0;
            for (int i = 0; i < maxChecks; i++) {
                checkVal = getCheckVal(origiPixs[checkPixs.get(i)], b, "blue");
                
                if (checkVal != alterPixs[checkPixs.get(i)].getBlue()) {
                    errors++;
                }
            }
            if (errors == 0) {
                System.out.println("No errors in blue pixel values.");
            } else {
                System.out.println("Found " + errors + " errors in blue pixel values.");
            }
        }
    }
    
    /**
     * Given a pixel object, a colour ("red", "green" or "blue"), and a change %,
     * determine the actual value to check against (bounded between 0 and 255)
     * 
     * @param pixel object containing RGB colour values
     * @param delta percentage change of a given colour
     * @param colour as string "red", "green", or "blue"
     * @return the expected value to check against, or -1 if an error occurs
     */
    private static int getCheckVal(Pixel pixel, double delta, String colour) {
        int checkVal;
        switch(colour) {
            case "red":
                checkVal = (int)(pixel.getRed() * delta);
                if (checkVal < 0) {
                    return 0;
                }
                if (checkVal > 255) {
                    return 255;
                }
                return checkVal;
            case "green":
                checkVal = (int)(pixel.getGreen() * delta);
                if (checkVal < 0) {
                    return 0;
                }
                if (checkVal > 255) {
                    return 255;
                }
                return checkVal;
            case "blue":
                checkVal = (int)(pixel.getBlue() * delta);
                if (checkVal < 0) {
                    return 0;
                }
                if (checkVal > 255) {
                    return 255;
                }
                return checkVal;
            default:
                return -1;
        }
        
    }
}
