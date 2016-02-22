/*
* A project that draws a chess board onto a Canvas 
* in a JFrame
*/
package ChessPanel;

import java.util.Scanner;
import javax.swing.JFrame;

/**
*
* @author scarruthers
*/
public class Lab5 {
    //width of the panel
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    /**
     * This method creates a JFrame, adds a panel to it
     * then asks the user to enter the size of the chessboard to draw
     * The ChessPanel is responsible for drawing the chessboard
     * @param arg 
     * DO NOT ALTER THIS METHOD
     */
    public static void main(String arg[]){

        JFrame frame = new JFrame("ChessPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        Scanner scan = new Scanner (System.in);
        System.out.println ("Welcome to my chess-drawing program!");
        System.out.println ();
        
        int squareSize;   
        squareSize = getNumFromUser(scan);
        ChessPanel panel = new ChessPanel(squareSize);

        // Make the panel object the content pane of the JFrame.
        // This puts it into the drawable area of frame, and now
        // we do all our drawing to panel, using paint() in ChessPanel.
        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
    /**
     * Uses recursion to get valid input from the user
     * assumes integer input 
     * @param scan
     * @return returns a valid number between 0 and 400
     * DO NOT CHANGE THIS METHOD
     */
    private static int getNumFromUser(Scanner scan){
        
        int squareSize;
        
        //ask user to enter a positive number less than 400
        System.out.print ("How big a chess board do you want (less than 400) ?\n");
        squareSize = scan.nextInt(); //get the integer value from user
        scan.nextLine();    // read over to the end of line
        
        if(squareSize < 1 || squareSize >=400){
            //if user enters incorrect value, give them some feedback, then try again
            System.out.println("Sorry, that is not a valid size \n");
            squareSize = getNumFromUser(scan);
        }
        return squareSize;
    }
}
