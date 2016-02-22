
package lab6;
import media.*;
import java.util.Scanner;



public class Lab6 {

    public static void main(String[] args) {
        Picture pic = new Picture (FileChooser.pickAFile());
        pic.show();
        Picture pic2 = new Picture (pic);
        pic2.show();
        
        userContinue();
        pic.decreaseRed();
        pic.repaint();
        System.out.println("Output is Decrease Red.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.increaseRed();
        pic.repaint();
        System.out.println("Output is Increase Red.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.changeRed(.75);
        pic.repaint();
        System.out.println("Output is Change Red.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.decreaseGreen();
        pic.repaint();
        System.out.println("Output is Decrease Green.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.increaseGreen();
        pic.repaint();
        System.out.println("Output is Increase Green.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.changeGreen(-.25);
        pic.repaint();
        System.out.println("Output is Change Green.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.decreaseBlue();
        pic.repaint();
        System.out.println("Output is Decrease Blue.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.increaseBlue();
        pic.repaint();
        System.out.println("Output is Increase Blue.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.changeBlue(.10);
        pic.repaint();
        System.out.println("Output is Change Blue.");
        // TODO: TEST
        userContinue();
        System.out.println("Resetting picture...");
        pic = new Picture (pic2);
        pic.repaint();
        pic.changeColours(.15, -.15, .15);
        pic.repaint();
        System.out.println("Output is Change All.");
        // TODO: TEST
        
        System.out.println("Enter 'q' to exit program.");
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            input = scan.nextLine();
        } while (!input.contentEquals("q") && !input.contentEquals("Q"));

        System.exit(0);
    }
    
    private static void userContinue() {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter 'y' to continue:");
            input = scan.nextLine();
        } while(!input.contentEquals("y") && !input.contentEquals("Y"));
    }
}
