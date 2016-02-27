/*
 * Flip a picture on the horizontal axis and add image effects
 */
package lab7;

import media.*;
import java.util.Scanner;

/**
 * Created: Feb 26 2016.
 * @author Matthew Casiro
 */
public class Lab7{


    public static void main(String[] args) {
        String fileSource = "/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab7/src/Beach.jpg";
        String fileTarget = "/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab7/src/Flip.jpg";

        Picture source = new Picture(fileSource);
        Picture target = new Picture(source.getWidth(), source.getHeight());
        
        source.show();

        target.flipHorizontal(source);
        target.repaint();
        
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Press enter to add pixelation to source image.");
        input = scan.nextLine();
        target.hide();
        System.out.println("Running pixelation...");
        source.runEffect1();
        source.repaint();
        System.out.println("Done.");
        System.out.println("Press enter to add offset rows to source image.");
        input = scan.nextLine();
        source.runEffect2();
        source.repaint();
        
//        boolean userChoice;
//        while (true) {
//            input = scan.nextLine();
//            if (input == "y" || input == "Y" || input == "yes" || input == "Yes" || input == "YES") {
//                userChoice = true;
//                break;
//            } else if (input == "n" || input == "N" || input == "no" || input == "No" || input == "NO") {
//                userChoice = false;
//                break;
//            }
//        }
//        if (userChoice) {
//            
//        }
        
        
        
        //target.repaint();




    }
}
