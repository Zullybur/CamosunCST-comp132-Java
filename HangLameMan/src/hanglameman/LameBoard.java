/**
 * Canvas functionality class for the lamest hangman game I've ever conceived
 * @author Matthew Casiro
 * Created: March 15 2016
 */
package hanglameman;

import java.awt.*;

/**
 * Initialize a canvas to draw the game on
 */
public class LameBoard extends Canvas {
    private int wrong, state = 0;
    private char[] progress, guessed;
    private String[] rules;

    LameBoard(int size) {
        setSize(size, size);
        state = 0;
        wrong = 0;
    }
    /**
     * Set game state value
     * @param n represents the new game state
     */
    public void setState(int n) {
        if(n > 0 && n < 4) {
            state = n;
        }
    }
    /**
     * Set word progress to display
     * @param s is a char array of underscores and letters depending what letters have been guessed
     */
    public void setProgress(char[] s) {
        progress = new char[s.length * 2];
        for(int i = 0, j = 0; i < progress.length; i+=2, j++) {
            progress[i] = s[j];
            progress[i+1] = ' ';
        }
    }
    /**
     * Update the char array containing all guessed characters
     * @param guessed is a char array containing all guessed characters
     */
    public void setGuess(char[] guessed) {
        this.guessed = guessed;
    }
    /**
     * Update the string array containing output for the rules page
     * @param rules is a string array containing everything to display
     */
    public void setRules(String[] rules) {
        this.rules = rules;
    }
    /**
     * Update the number of wrong guesses
     * @param n is the new number of wrong guesses
     */
    public void setWrong(int n) {
        wrong = n;
    }
    /**
     * Overrides paint method to draw hangman canvas as per game state
     * @param g is a generic graphics object
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Helvetica", Font.PLAIN, 18));
        if (state > 1) {
            drawBackground(g);
            drawBody(g, wrong);
            drawWord(g);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.WHITE);
            for(int i = 0; i < rules.length; i++) {
                g.drawString(rules[i], 50, (50 * (i + 1)) + 50);
            }
        }
    }
    /**
     * Display white background with gallows
     * @param g is a generic graphics object
     */
    private void drawBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(new Color(92, 50, 16));
        g.fillRect(450, 650, 200, 10);  // Base
        g.fillRect(550, 200, 10, 450);  // Pole
        g.fillRect(300, 200, 250, 10);  // Limb
        g.fillRect(300, 200, 10, 50);   // Rope
    }
    /**
     * Draw elements of the hanged-man's body
     * @param g is a generic graphics object
     * @param wrong is the number of wrong guesses which defines the body parts to draw
     */
    private void drawBody(Graphics g, int wrong) {
        g.setColor(new Color(236, 130, 93));
        switch(wrong) {
            case 6:
                g.drawString("X      X", 285, 300); // Body6-LeftEye
                g.fillRect(329, 510, 6, 80);        // Body6-RightLeg
            case 5:
                g.fillRect(275, 510, 6, 80);        // Body5-LeftLeg
            case 4:
                g.fillRect(326, 380, 6, 60);        // Body4-RightArm
            case 3:
                g.fillRect(280, 380, 6, 60);        // Body3-LeftArm
            case 2:
                g.fillRect(302, 360, 6, 150);       // Body2-Torso
                g.fillRect(275, 510, 60, 6);        // Body2-Waist
                g.fillRect(280, 380, 50, 6);        // Body2-Shoulders
            case 1:
                g.drawOval(255, 250, 100, 110);     // Body1-Head
            case 0:
                break;
            default:
                System.out.println("Fatal Error - drawBody switch");
        }
    }
    /**
     * Draw text elements of the game board
     * @param g is a generic graphics object
     */
    private void drawWord(Graphics g) {
        g.setColor(Color.BLACK);
        String output = "";
        for(int i = 0; i < progress.length; i++){
            output += progress[i] + " ";
        }
        String guesses = "";
        if(guessed != null){
            for(int i = 0; i < guessed.length; i++) {
            guesses += guessed[i] + "  ";
        }
        }
        g.drawString("Progress: "+output, 50, 50);
        g.drawString("Guesses: "+guesses, 50, 100);
        g.drawString("Please enter a guess!", 50, 150);
    }
}