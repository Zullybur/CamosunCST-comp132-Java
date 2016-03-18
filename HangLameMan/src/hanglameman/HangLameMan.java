/**
 * Main class for the lamest hangman game I've ever conceived
 * @author Matthew Casiro
 * Created: March 15 2016
 */
package hanglameman;

import javax.swing.JFrame;

public class HangLameMan {
    /**
     * Request next turn from game driver until user exits
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Prep JFrame, board (canvas) and game (driver)
        int size = 700;
        JFrame lameFrame = new JFrame();
        lameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lameFrame.setSize(size, size);
        LameBoard lameBoard = new LameBoard(size);
        LameGame lameGame = new LameGame(lameBoard);
        lameFrame.getContentPane().add(lameBoard);
        lameFrame.pack();
        lameFrame.setVisible(true);
        
        // Request next turn until user exits
        do {
            lameGame.takeTurn();
        } while(lameGame.gameIsOn());
        
        System.exit(0);
    }
}